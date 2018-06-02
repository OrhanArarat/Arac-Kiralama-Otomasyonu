package com.orhanararat.Controller;

import com.orhanararat.model.DataSource;
import com.orhanararat.model.Dept;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.util.HashMap;
import java.util.Map;

public class EklemeController {
    public static Map<String,Integer> departman = new HashMap<>();

    @FXML
    private ComboBox cbDepartman;
    @FXML
    private Button btnKaydet;
    @FXML
    private Button btnDepartmanEkle;
    @FXML
    private TextField tfIsim;
    @FXML
    private TextField tfDepartmanAdi;

    public void cbEkleDepartman(){
        for (Dept d: DataSource.getInstance().departmanGetir()
             ) {
            if (!departman.containsKey(d.getDepartman())){
                departman.put(d.getDepartman(),d.getId());
                cbDepartman.getItems().add(d.getDepartman());
            }

        }

//        cbDepartman.getItems().setAll();
        cbDepartman.setItems(DataSource.getInstance().getDepartmanList());
    }

    public void kayit(){
        btnKaydet.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                String deger = cbDepartman.getSelectionModel().getSelectedItem().toString();
                int departmanDeger= departman.get(deger);
                String isim = tfIsim.getText();
                DataSource.getInstance().calisanEkle(isim,departmanDeger);
            }
        });
    }
    @FXML
    public void departmanEkle(){
        String deger = tfDepartmanAdi.getText().trim();
        System.out.println(deger);
        if (!deger.equals("")){
            DataSource.getInstance().departmanEkle(deger);
            cbEkleDepartman();
        }
        else
            System.out.println("Bos geliyor");
    }


}
