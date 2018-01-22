package com.rafaels.greendaosample.adapter;

/**
 * Created by Indogroup02 on 22/01/2018.
 */

public class ItemData {

    private String string;
    private String stringDos;


    public ItemData(String string, String stringDos){

        this.string = string;
        this.stringDos = stringDos;
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
}
