package com.rafaels.greendaosample.database;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Transient;


@Entity
public class Data {

    @Id(autoincrement = true) //Not reusing old values
    private Long id; //Primary Key

    @Property()
    private String string;

    @Property()
    private String stringDos;

    @Transient
    private int tempUsageNoPersistent;

    @Generated(hash = 339139799)
    public Data(Long id, String string, String stringDos) {
        this.id = id;
        this.string = string;
        this.stringDos = stringDos;
    }

    @Generated(hash = 2135787902)
    public Data() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getString() {
        return this.string;
    }

    public void setString(String string) {
        this.string = string;
    }

    public String getStringDos() {
        return this.stringDos;
    }

    public void setStringDos(String stringDos) {
        this.stringDos = stringDos;
    }



}
