package com.rafaels.greendaosample.adapter;

import android.content.ClipData;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

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

    // Listener para el item completo fuera del adaptador
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
    public void onBindViewHolder(ItemViewHolder holder, int position) {

        List<Data> results = DatabaseManager.getInstance().getAllDatas();

        ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
        itemViewHolder.bind(results, position);


//        holder.string.setText(results.get(position).getString());
//        holder.stringDos.setText(results.get(position).getStringDos());
//        holder.delete.setImageResource(R.drawable.ic_delete);
//
//        // Listener para cada item en particular
//        holder.delete.setOnClickListener(v -> {
//            Log.d("ItemAdaptador", position+"");
//
//            DatabaseManager.getInstance().deleteData(items.get(position).getData());
//
//            items.remove(position);
//            notifyItemRemoved(position);
//            notifyItemRangeChanged(position, items.size());
//        });


    }

    // Tamaño
    @Override
    public int getItemCount() {
        return items.size();
    }


    // Clase ViewHolder
    public class ItemViewHolder extends RecyclerView.ViewHolder {
        // Campos respectivos de un item
        public TextView string;
        public TextView stringDos;
        public ImageView delete;

        public ItemViewHolder(View itemView) {
            super(itemView);
            string = (TextView) itemView.findViewById(R.id.textView);
            stringDos = (TextView) itemView.findViewById(R.id.textViewDos);
            delete = (ImageView) itemView.findViewById(R.id.delete);
        }

        public void bind(List<Data> results, int position){

            string.setText(results.get(position).getString());
            stringDos.setText(results.get(position).getStringDos());
            delete.setImageResource(R.drawable.ic_delete);

            // Listener para cada item en particular
            delete.setOnClickListener(v -> {
                Log.d("ItemAdaptador", position+"");

                DatabaseManager.getInstance().deleteData(items.get(position).getData());

                items.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, items.size());
            });
        }

    }


}