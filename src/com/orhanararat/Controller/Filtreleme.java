package com.orhanararat.Controller;

import com.orhanararat.model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Filtreleme {
    @FXML
    private TextField tfFiyatMin,tfFiyatMax,tfKmMin,tfKmMax;
    @FXML
    private ComboBox cbSehir,cbYakit,cbVites,cbRenk,cbTarih,cbSiralama;
    @FXML
    private TableView tableIlan;


    public void initialize(){
        setCbRenk();
        setCbSehir();
        setCbSiralama();
        setCbTarih();
        setCbVites();
        setCbYakit();
    }

    public void setCbSehir(){
        cbSehir.getItems().clear();
        cbSehir.getItems().setAll(Sehir.getSehirList());
    }

    public void setCbYakit(){
        cbYakit.getItems().clear();
        cbYakit.getItems().setAll(Yakit.getYakitList());
    }

    public void setCbVites(){
        cbVites.getItems().clear();
        cbVites.getItems().setAll(Vites.getVitesList());
    }

    public void setCbRenk(){
        cbRenk.getItems().clear();
        cbRenk.getItems().setAll(Renk.getRenkList());
    }

    public void setCbTarih(){
        cbTarih.getItems().clear();
        cbTarih.getItems().add("Son 24 saat");
        cbTarih.getItems().add("Son 1 Hafta");
        cbTarih.getItems().add("Son 1 Ay");
    }

    public void setCbSiralama(){
        cbSiralama.getItems().clear();
        cbSiralama.getItems().add("Fiyata Gore (Once En Yuksek)");
        cbSiralama.getItems().add("Fiyata Gore (Once En Dusuk)");
        cbSiralama.getItems().add("Tarihe Gore (Once En Yeni Ilan)");
        cbSiralama.getItems().add("Tarihe Gore (Once En Eski Ilan)");
        cbSiralama.getItems().add("Km`ye Gore (Once En Yuksek)");
        cbSiralama.getItems().add("Km`ye Gore (Once En Dusuk)");
        cbSiralama.getItems().add("Sehire Gore (A-Z ye)");
        cbSiralama.getItems().add("Sehire Gore (Z-A ya)");
        cbSiralama.getItems().add("Renge Gore (A-Z ye)");
        cbSiralama.getItems().add("Renge Gore (Z-A ya)");
    }

    public ObservableList<Ilan> filtreleme(){
//        int fiyatMin=-1;
//        int fiyatMax = -1;
        String fiyatMin = tfFiyatMin.getText().trim();
        String fiyatMax = tfFiyatMax.getText().trim();

//        int kmMin =-1;
//        int kmMax = -1;
        String kmMin = tfKmMin.getText().trim();
        String kmMax = tfKmMax.getText().trim();

        Sehir sehir = null;
        Vites vites = null;
        Yakit yakit = null;
        Renk renk = null;

        if (!cbSehir.getSelectionModel().isEmpty()){
            sehir = (Sehir) cbSehir.getSelectionModel().getSelectedItem();
        }

        if (!cbVites.getSelectionModel().isEmpty()){
            vites = (Vites) cbVites.getSelectionModel().getSelectedItem();
        }

        if (!cbYakit.getSelectionModel().isEmpty()){
            yakit = (Yakit) cbYakit.getSelectionModel().getSelectedItem();
        }
        if (!cbRenk.getSelectionModel().isEmpty()){
            renk=(Renk) cbRenk.getSelectionModel().getSelectedItem();
        }

        int tarihIndex =-1;
        int siralamaIndex =-1;

        if (!cbTarih.getSelectionModel().isEmpty()){
            tarihIndex = cbTarih.getSelectionModel().getSelectedIndex();
        }

        if (!cbSiralama.getSelectionModel().isEmpty()){
            siralamaIndex = cbSiralama.getSelectionModel().getSelectedIndex();
        }

        System.out.println("Fiyat min: "+fiyatMin);
        System.out.println("Fiyat Max: "+fiyatMax);
        System.out.println("Km min: "+kmMin);
        System.out.println("Km max: "+kmMax);
        System.out.println("Sehir id: "+sehir);
        System.out.println("Yakit id: "+yakit);
        System.out.println("Vites id: "+vites);
        System.out.println("Renk: "+renk);
        System.out.println("Tarih index: "+tarihIndex);
        System.out.println("Siralama index: "+siralamaIndex);

        ObservableList<Ilan> ilanlar= DataModel.getInstance().filtrelemeIslemi(fiyatMin,fiyatMax,kmMin,kmMax,sehir,yakit,vites,renk,tarihIndex,siralamaIndex);

        System.out.println("======================"+ilanlar.size());

        return ilanlar;
// DataModel.getInstance().filtrelemeIslemi(fiyatMin,fiyatMax,kmMin,kmMax,sehir,yakit,vites,renk,tarihIndex,siralamaIndex);
    }

    public void tabloYaz(){
        Task<ObservableList<Ilan>> task = new IlanlariGetir();
        tableIlan.itemsProperty().bind(task.valueProperty());
//        System.out.println("aaaaaa");
        new Thread(task).start();
//        System.out.println("bbbbb");
    }

    class IlanlariGetir extends Task {

        @Override
        protected ObservableList<Ilan> call() throws Exception {
            System.out.println("Thread: "+Thread.currentThread().getName());
            return FXCollections.observableArrayList(filtreleme());
        }
    }

}

