package com.rafaels.greendaosample.adapter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.rafaels.greendaosample.R;

/**
 * Created by Rafael S Martin on 22/01/2018.
 */

public class ItemActivity extends AppCompatActivity {

    private ItemFragment itemFragment;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        itemFragment = (ItemFragment) getSupportFragmentManager().findFragmentByTag(ItemFragment.TAG);

        if(itemFragment == null) {
            itemFragment = new ItemFragment();
        }

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_root, itemFragment)
                .commit();


    }



}
