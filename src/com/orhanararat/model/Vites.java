package com.orhanararat.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Vites {
    private int id;
    private String vites;

    private static ObservableList<Vites> vitesList= FXCollections.observableArrayList();

    public Vites(int id,String vites) {
        this.id=id;
        this.vites = vites;

    }

    public String getVites() {
        return vites;
    }

    public int getId() {
        return id;
    }

    public static ObservableList<Vites> getVitesList() {
        return vitesList;
    }

    public static void setVitesList(ObservableList<Vites> vitesList) {
        Vites.vitesList = vitesList;
    }

    @Override
    public String toString() {
        return vites;
    }

    public void setVites(String vites) {
        this.vites = vites;
    }
}
