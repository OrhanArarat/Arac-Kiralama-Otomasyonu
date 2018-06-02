package com.orhanararat.Controller;

import com.orhanararat.model.Calisan;
import com.orhanararat.model.DataSource;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class Controller {
//    @FXML
//    private TextField ilanAdi,aracFiyati,aracKm,aracMarka,aracSehir;

//    public void textWriter(){
//        System.out.println("DataModel Adi: "+ ilanAdi.getText()+" Fiyat: "+ aracFiyati.getText()+ " Km: "+aracKm.getText());
//    }

//    @FXML
//    private TableView tableCalisan;
//
//    public void calisanlariGetir(){
//        Task<ObservableList<Calisan>> task = new CalisanlariGetir();
//        tableCalisan.itemsProperty().bind(task.valueProperty());
//        new Thread(task).start();
//    }

}

//class CalisanlariGetir extends Task {
//
//    @Override
//    protected ObservableList<Calisan> call() throws Exception {
//        System.out.println("Thread: "+Thread.currentThread().getName());
//        return FXCollections.observableArrayList(DataSource.getInstance().calisanlariGetir());
//    }
//}