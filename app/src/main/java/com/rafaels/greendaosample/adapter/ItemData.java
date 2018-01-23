package com.rafaels.greendaosample.adapter;

import com.rafaels.greendaosample.database.Data;

/**
 * Created by Indogroup02 on 22/01/2018.
 */

public class ItemData {

    private String string;
    private String stringDos;
    private int delete;
    private Data data;


    public ItemData(String string, String stringDos, int delete, Data data){

        this.data = data;
        this.string = string;
        this.stringDos = stringDos;
        this.delete = delete;
    }


    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getStringDos() {
        return stringDos;
    }

    public void setStringDos(String stringDos) {
        this.stringDos = stringDos;
    }

    public int getDelete() {
        return delete;
    }

    public void setDelete(int delete) {
        this.delete = delete;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
