package com.orhanararat.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Araba {
    private int id;
    private String marka;
    private String model;
    private int vitesTuruId;
    private int yakitTuruId;
    private int renkId;

    private static ObservableList<Araba> arabaList = FXCollections.observableArrayList();

    public Araba(int id, String marka, String model, int vitesTuruId, int yakitTuruId, int renkId) {
        this.id=id;
        this.marka = marka;
        this.model = model;
        this.vitesTuruId = vitesTuruId;
        this.yakitTuruId = yakitTuruId;
        this.renkId = renkId;
    }

    public String getMarka() {
        return marka;
    }

    public String getModel() {
        return model;
    }

    public int getVitesTuruId() {
        return vitesTuruId;
    }

    public int getYakitTuruId() {
        return yakitTuruId;
    }

    public int getRenkId() {
        return renkId;
    }

    public int getId() {
        return id;
    }

    public static ObservableList<Araba> getArabaList() {
        return arabaList;
    }

    public static void setArabaList(ObservableList<Araba> arabaList) {
        Araba.arabaList = arabaList;
    }

    @Override
    public String toString() {
        return marka+" "+model+" "+vitesTuruId+" "+yakitTuruId;
    }

    public void setMarka(String marka) {
        this.marka = marka;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setVitesTuruId(int vitesTuruId) {
        this.vitesTuruId = vitesTuruId;
    }

    public void setYakitTuruId(int yakitTuruId) {
        this.yakitTuruId = yakitTuruId;
    }

    public void setRenkId(int renkId) {
        this.renkId = renkId;
    }
}
