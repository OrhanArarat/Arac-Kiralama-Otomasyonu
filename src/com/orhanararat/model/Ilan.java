package com.orhanararat.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Date;
import java.time.LocalDate;

public class Ilan {
    private int id;
    private String ilanAdi;
    private int ilanFiyat;
    private int km;
    private Date tarih;
    private int ArabaId;
    private int SehirId;

    private static ObservableList<Ilan> ilanListesi=FXCollections.observableArrayList();

    public Ilan(int id,String ilanAdi, int ilanFiyat, int km, Date tarih, int arabaId, int sehirId) {
        this.id=id;
        this.ilanAdi = ilanAdi;
        this.ilanFiyat = ilanFiyat;
        this.km = km;
        this.tarih = tarih;
        ArabaId = arabaId;
        SehirId = sehirId;
    }

    public String getIlanAdi() {
        return ilanAdi;
    }

    public int getIlanFiyat() {
        return ilanFiyat;
    }

    public int getKm() {
        return km;
    }

    public Date getTarih() {
        return tarih;
    }

    public int getArabaId() {
        return ArabaId;
    }

    public int getSehirId() {
        return SehirId;
    }

    public int getId() {
        return id;
    }

    public static ObservableList<Ilan> getIlanListesi() {
        return ilanListesi;
    }

    public static void setIlanListesi(ObservableList<Ilan> ilanListesi) {
        Ilan.ilanListesi = ilanListesi;
    }

    public void setIlanAdi(String ilanAdi) {
        this.ilanAdi = ilanAdi;
    }

    public void setIlanFiyat(int ilanFiyat) {
        this.ilanFiyat = ilanFiyat;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public void setTarih(Date tarih) {
        this.tarih = tarih;
    }

    public void setArabaId(int arabaId) {
        ArabaId = arabaId;
    }

    public void setSehirId(int sehirId) {
        SehirId = sehirId;
    }

    @Override
    public String toString() {
        return ilanAdi+" "+ilanFiyat+" ";
    }
}
