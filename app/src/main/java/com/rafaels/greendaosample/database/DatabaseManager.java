package com.rafaels.greendaosample.database;

import android.content.Context;
import android.support.v4.util.Pair;
import android.util.Log;

import org.greenrobot.greendao.database.Database;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Indogroup02 on 18/01/2018.
 */

public class DatabaseManager {

    private static  final String LOG_TAG = "DatabaseManagerSample";

    private static DatabaseManager instance;
    private DaoSession daoSession;
    private boolean isClearedDatabase;

    private ArrayList<Pair<Long, Data>> reloadDatas = new ArrayList<>();



    private DatabaseManager(Context context){
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(context, "ejemplo-bd");
        Database db = helper.getWritableDb();
        daoSession = new DaoMaster(db).newSession();
    }

    public static void init (Context context){
        instance = new DatabaseManager(context);
    }

    public static DatabaseManager getInstance(){
        return instance;
    }

    public List<Data> getAllDatas(){

        DataDao dataDao = daoSession.getDataDao();
        List<Data> datas = dataDao.queryBuilder()
                .orderDesc(DataDao.Properties.Id)
                .list();

        for (int i = 0; i != datas.size(); ++i){
            Data data = datas.get(i);

            Log.d(LOG_TAG, String.format("ID: %d, STRING: %s , STRING_DOS: %s"
                , data.getId()
                , data.getString()
                , data.getStringDos()));

        }
        return datas;
    }

    public void insertData(Data data){
        DataDao dataDao = daoSession.getDataDao();
        dataDao.insert(data);
        Log.d(LOG_TAG, "insert id: " + data.getId() + "data: "+data.getString() + "data2: "+data.getStringDos());
    }

    public void deleteData(Data data){
        DataDao dataDao = daoSession.getDataDao();
        dataDao.delete(data);

        reloadDatas = getDatas();
    }

    public void updateData(Data data){
        Log.d(LOG_TAG, String.format("ID: %d, STRING: %s , STRING_DOS: %s"
                , data.getId()
                , data.getString()
                , data.getStringDos()));

        DataDao dataDao = daoSession.getDataDao();
        dataDao.update(data);
    }

    public ArrayList<Pair<Long, Data>> getDatas(){
        reloadDataBase();
        return reloadDatas;
    }

    public void reloadDataBase(){
        Log.d(LOG_TAG, "reload database");

        DataDao dataDao = daoSession.getDataDao();
        List<Data> datas = dataDao.queryBuilder()
                .orderDesc(DataDao.Properties.Id)
                .list();

        for(int i = 0; i != datas.size(); ++i){
            Data data = datas.get(i);

            Log.d(LOG_TAG, String.format("ID: %d, STRING: %s , STRING_DOS: %s"
                    , data.getId()
                    , data.getString()
                    , data.getStringDos()));
        }

        Collections.sort(datas, new Comparator<Data>() {
            @Override
            public int compare(Data a, Data b) {
                return b.getId().compareTo(a.getId());
            }
        });

        reloadDatas.clear();
        for (int i = 0; i != datas.size(); ++i){
            Data data = datas.get(i);
            reloadDatas.add(new Pair<>(Long.valueOf(data.getId()), data));
        }


    }

    public void clear(){
        DataDao dataDao = daoSession.getDataDao();
        dataDao.deleteAll();

        isClearedDatabase = true;

    }

    public boolean isClearedDatabase() {
        return isClearedDatabase;
    }

    public void setClearedDatabase(boolean clearedDatabase) {
        isClearedDatabase = clearedDatabase;
    }

}
