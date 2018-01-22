package com.rafaels.greendaosample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.rafaels.greendaosample.adapter.ItemActivity;
import com.rafaels.greendaosample.adapter.ItemFragment;
import com.rafaels.greendaosample.database.Data;
import com.rafaels.greendaosample.database.DatabaseManager;

public class MainActivity extends AppCompatActivity {

    private Data data;
    private DatabaseManager Dm;
    private String string ="inicializar";
    private String stringDos="inicializar2";
    private EditText edDos, ed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DatabaseManager.init(this);
        Dm = DatabaseManager.getInstance();

        ed = (EditText) findViewById(R.id.ed_string);
        edDos = (EditText) findViewById(R.id.ed_string_dos);
        Button getAllDatas = (Button) findViewById(R.id.getAllDatas);
        Button insertData = (Button) findViewById(R.id.insertData);
        Button deleteData = (Button) findViewById(R.id.deletedata);
        Button updateData = (Button) findViewById(R.id.updateDatas);
        Button getDatas = (Button) findViewById(R.id.getDatas);
        Button reloadDataBase = (Button) findViewById(R.id.reloadDataBase);
        Button clear = (Button) findViewById(R.id.clear);
        Button fragment = (Button) findViewById(R.id.fagment_main);


//        List<Data> datas = DatabaseManager.getInstance().getAllDatas();

//        string = ed.getText().toString();
//        stringDos = edDos.getText().toString();

        Log.d("DatabaseManagerSample", string);
        Log.d("DatabaseManagerSample", stringDos);








        getAllDatas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dm.getAllDatas();
            }
        });
        insertData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                string = ed.getText().toString();
                stringDos = edDos.getText().toString();

                data = new Data();
                data.setId(null);
                data.setString(string);
                data.setStringDos(stringDos);

                Dm.insertData(data);
            }
        });
        deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dm.deleteData(data);
            }
        });
        updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dm.updateData(data);
            }
        });
        getDatas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dm.getDatas();
            }
        });
        reloadDataBase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dm.reloadDataBase();
            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Dm.clear();
            }
        });

        fragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ItemActivity.class);
                startActivity(i);
            }
        });





    }
}
