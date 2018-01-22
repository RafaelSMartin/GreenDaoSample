package com.rafaels.greendaosample.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rafaels.greendaosample.R;
import com.rafaels.greendaosample.database.Data;
import com.rafaels.greendaosample.database.DatabaseManager;

import java.util.List;

/**
 * Created by Indogroup02 on 22/01/2018.
 */

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{

    private List<ItemData> items;
    private LayoutInflater inflate;
    protected View.OnClickListener onClickListener;

    //Constructor
    public ItemAdapter(Context context, List<ItemData> items){
        this.items = items;
        inflate = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    // Listener
    public void setOnItemClickListener (View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    // Crear ViewHolder
    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int i) {
        View v = inflate.inflate(R.layout.item_layout, parent, false);

        v.setOnClickListener(onClickListener);

        return new ItemViewHolder(v);
    }

    // Instanciar los items
    @Override
    public void onBindViewHolder(ItemViewHolder holder, int i) {
//        holder.fromLanguageTitle.setText(items.get(i).getFromLanguageTitle());
//        holder.fromText.setText(items.get(i).getFromText());
//        holder.toLanguageTitle.setText(items.get(i).getToLanguageTitle());
//        holder.toText.setText(items.get(i).getToText());
////        viewHolder.favourite.setImageResource(items.get(i).getFavourite());
//        holder.favourite.setImageResource(R.drawable.favorite);

        List<Data> results = DatabaseManager.getInstance().getAllDatas();
        Data data = new Data();
//
        holder.string.setText(results.get(i).getString());
        holder.stringDos.setText(results.get(i).getStringDos());


    }

    // Tamaño
    @Override
    public int getItemCount() {
        return items.size();
    }


    // Clase ViewHolder
    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView string;
        public TextView stringDos;


        public ItemViewHolder(View itemView) {
            super(itemView);
            string = (TextView) itemView.findViewById(R.id.textView);
            stringDos = (TextView) itemView.findViewById(R.id.textViewDos);

        }
    }


}