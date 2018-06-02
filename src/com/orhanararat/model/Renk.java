package com.orhanararat.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Renk {
    private int id;
    private String renk;

    private static ObservableList<Renk> renkList = FXCollections.observableArrayList();

    public Renk(int id, String renk) {
        this.id=id;
        this.renk = renk;
    }

    public String getRenk() {
        return renk;
    }

    public int getId() {
        return id;
    }

    public static ObservableList<Renk> getRenkList() {
        return renkList;
    }

    public static void setRenkList(ObservableList<Renk> renkList) {
        Renk.renkList = renkList;
    }

    @Override
    public String toString() {
        return renk;
    }

    public void setRenk(String renk) {
        this.renk = renk;
    }
}
