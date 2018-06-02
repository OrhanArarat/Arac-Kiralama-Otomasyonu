package com.orhanararat.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Yakit {
    private int id;
    private String yakit;

    private static ObservableList<Yakit> yakitList = FXCollections.observableArrayList();

    public Yakit(int id,String yakit) {
        this.id=id;
        this.yakit = yakit;

    }

    public String getYakit() {
        return yakit;
    }

    public int getId() {
        return id;
    }

    public static ObservableList<Yakit> getYakitList() {
        return yakitList;
    }

    public static void setYakitList(ObservableList<Yakit> yakitList) {
        Yakit.yakitList = yakitList;
    }

    @Override
    public String toString() {
        return yakit;
    }

    public void setYakit(String yakit) {
        this.yakit = yakit;
    }
}
