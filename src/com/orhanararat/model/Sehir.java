package com.orhanararat.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Sehir {
    private int id;
    private String sehir;

    private static ObservableList<Sehir> sehirList=FXCollections.observableArrayList();

    public Sehir(int id,String sehir) {
        this.id=id;
        this.sehir = sehir;
    }

    public String getSehir() {
        return sehir;
    }

    public int getId() {
        return id;
    }

    public static ObservableList<Sehir> getSehirList() {
        return sehirList;
    }

    public static void setSehirList(ObservableList<Sehir> sehirList) {
        Sehir.sehirList = sehirList;
    }

    @Override
    public String toString() {
        return sehir;
    }

    public void setSehir(String sehir) {
        this.sehir = sehir;
    }
}
