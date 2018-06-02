package com.orhanararat.model;

public class Dept {
    private int id;
    private String departman;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDepartman() {
        return departman;
    }

    public void setDepartman(String departman) {
        this.departman = departman;
    }

    @Override
    public String toString() {
        return departman;
    }
}
