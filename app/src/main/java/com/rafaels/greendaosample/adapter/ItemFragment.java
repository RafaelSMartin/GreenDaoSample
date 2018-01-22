package com.rafaels.greendaosample.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rafaels.greendaosample.R;
import com.rafaels.greendaosample.database.Data;
import com.rafaels.greendaosample.database.DatabaseManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Indogroup02 on 22/01/2018.
 */

public class ItemFragment extends Fragment {

    public static final String TAG ="MAIN_FRAGMENT";
    private Context context;

    private List items;
    private View view;

    private RecyclerView recyclerView;
    private ItemAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        context = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        view = inflater.inflate(R.layout.fragment_item, container, false);

        List<Data> results = DatabaseManager.getInstance().getAllDatas();
        items = new ArrayList(results.size());
        Data data = new Data();

        for(int i = 0; i < results.size(); ++i){
            items.add(new ItemData(data.getString(), data.getStringDos()));
        }

        // Obtener el Recycler
        recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        adapter = new ItemAdapter(context, items);
        recyclerView.setAdapter(adapter);
        layoutManager = new LinearLayoutManager(context);
        recyclerView.setLayoutManager(layoutManager);

        adapter.setOnItemClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos= recyclerView.getChildAdapterPosition(view);
                Toast.makeText(context, "Selección: " + pos , Toast.LENGTH_LONG).show();

            }
        });

//        recyclerView.setHasFixedSize(true);


        return view;
    }



}
