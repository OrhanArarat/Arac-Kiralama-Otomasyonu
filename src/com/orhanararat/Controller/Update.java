package com.orhanararat.Controller;

import com.orhanararat.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

import javax.xml.crypto.Data;
import java.sql.Date;


public class Update {
    @FXML
    private TextField tfIlanAdi,tfAracFiyat,tfAracKm,tfMarka,tfModel,tfYakit,tfVites,tfRenk,tfSehir;

    @FXML
    private ComboBox cbIlanSec,cbAracSec,cbSehirSec,cbArabaSec,cbVitesSec,cbYakitSec,cbRenkSec,cbYakitGuncelle,
        cbVitesGuncelle,cbRenkGuncelle,cbSehirGuncelle;

    @FXML
    private Button btnIlanGuncelle,btnArabaGuncelle,btnYakitGuncelle,btnVitesGuncelle,btnRenkGuncelle,btnSehirGuncelle;

    @FXML
    private DatePicker dpIlanTarihi;

    public void setCbIlanSec(){
        cbIlanSec.getItems().clear();
        cbIlanSec.getItems().setAll(Ilan.getIlanListesi());
    }

    public void setCbAracSec(){
//        Araba.getArabaList().clear();
//        Araba.setArabaList(DataModel.getInstance().arabaGetir());
        cbAracSec.getItems().clear();
        cbAracSec.getItems().setAll(Araba.getArabaList());
    }

    public void setCbSehirSec(){
//        Sehir.getSehirList().clear();
//        Sehir.setSehirList(DataModel.getInstance().sehirGetir());
        cbSehirSec.getItems().clear();
        cbSehirSec.getItems().setAll(Sehir.getSehirList());
    }

    public void setCbArabaSec(){
//        Araba.getArabaList().clear();
//        Araba.setArabaList(DataModel.getInstance().arabaGetir());
        cbArabaSec.getItems().clear();
        cbArabaSec.getItems().setAll(Araba.getArabaList());
    }

    public void setCbVitesSec(){
//        Vites.getVitesList().clear();
//        Vites.setVitesList(DataModel.getInstance().vitesGetir());
//        cbVitesSec.setItems(Vites.getVitesList());
        cbVitesSec.getItems().clear();
        cbVitesSec.getItems().setAll(Vites.getVitesList());
    }

    public void setCbYakitSec(){
//        Yakit.getYakitList().clear();
//        Yakit.setYakitList(DataModel.getInstance().yakitGetir());
        cbYakitSec.getItems().clear();
        cbYakitSec.getItems().setAll(Yakit.getYakitList());
    }

    public void setCbRenkSec(){
//        Renk.getRenkList().clear();
//        Renk.setRenkList(DataModel.getInstance().renkGetir());
        cbRenkSec.getItems().clear();
        cbRenkSec.getItems().setAll(Renk.getRenkList());
    }

    public void setCbYakitGuncelle(){
//        Yakit.getYakitList().clear();
//        Yakit.setYakitList(DataModel.getInstance().yakitGetir());
        cbYakitGuncelle.getItems().clear();
        cbYakitGuncelle.getItems().setAll(Yakit.getYakitList());
    }

    public void setCbVitesGuncelle(){
//        Vites.getVitesList().clear();
//        Vites.setVitesList(DataModel.getInstance().vitesGetir());
//        cbVitesGuncelle.setItems(Vites.getVitesList());
        cbVitesGuncelle.getItems().clear();
        cbVitesGuncelle.getItems().setAll(Vites.getVitesList());
    }

    public void setCbRenkGuncelle(){
//        Renk.getRenkList().clear();
//        Renk.setRenkList(DataModel.getInstance().renkGetir());
        cbRenkGuncelle.getItems().clear();
        cbRenkGuncelle.getItems().setAll(Renk.getRenkList());
    }

    public void setCbSehirGuncelle(){
//        Sehir.getSehirList().clear();
//        Sehir.setSehirList(DataModel.getInstance().sehirGetir());
        cbSehirGuncelle.getItems().clear();
        cbSehirGuncelle.getItems().setAll(Sehir.getSehirList());
    }


    public void initialize(){
        Ilan.getIlanListesi().clear();
        DataModel.getInstance().ilanGetir();
        setCbRenkGuncelle();
        setCbSehirGuncelle();
        setCbYakitGuncelle();
        setCbVitesGuncelle();
        setCbIlanSec();
        setCbAracSec();
        setCbArabaSec();
        setCbRenkSec();
        setCbSehirSec();
        setCbVitesSec();
        setCbYakitSec();
//        DataModel.getInstance().vitesGetir();
    }

    public void ilanGuncelle(){
        Ilan ilan = (Ilan) cbIlanSec.getSelectionModel().getSelectedItem();

        String ilanAdi= tfIlanAdi.getText();
        int ilanFiyat = Integer.parseInt(tfAracFiyat.getText());
        int ilanKm= Integer.parseInt(tfAracKm.getText());
        Date ilanTarih =Date.valueOf(dpIlanTarihi.getValue());
        Araba araba = (Araba) cbAracSec.getSelectionModel().getSelectedItem();
        Sehir sehir = (Sehir) cbSehirSec.getSelectionModel().getSelectedItem();
        int arabaID=araba.getId();
        int sehirID = sehir.getId();

        DataModel.getInstance().ilanGuncelle(ilan.getId(),ilanAdi,ilanFiyat,ilanKm,ilanTarih,arabaID,sehirID);

        setCbIlanSec();

        ilan.setIlanAdi(ilanAdi);
        ilan.setIlanFiyat(ilanFiyat);
        ilan.setKm(ilanKm);
        ilan.setTarih(ilanTarih);
        ilan.setArabaId(arabaID);
        ilan.setSehirId(sehirID);

    }

    public void arabaGuncelle(){
        Araba araba = (Araba) cbArabaSec.getSelectionModel().getSelectedItem();
        Vites vites = (Vites) cbVitesSec.getSelectionModel().getSelectedItem();
        Yakit yakit = (Yakit) cbYakitSec.getSelectionModel().getSelectedItem();
        Renk renk = (Renk) cbRenkSec.getSelectionModel().getSelectedItem();
        boolean sonuc=DataModel.getInstance().arabaGuncelle(araba.getId(),tfMarka.getText(),tfModel.getText()
                ,vites.getId(),yakit.getId(),renk.getId());
        System.out.println(sonuc);
        setCbAracSec();
        setCbArabaSec();

        araba.setMarka(tfMarka.getText());
        araba.setModel(tfModel.getText());
        araba.setRenkId(renk.getId());
        araba.setVitesTuruId(vites.getId());
        araba.setYakitTuruId(yakit.getId());
    }

    public void yakitGuncelle(){
        Yakit yakit = (Yakit) cbYakitGuncelle.getSelectionModel().getSelectedItem();
        boolean sonuc = DataModel.getInstance().yakitGuncelle(yakit.getId(),tfYakit.getText());
        System.out.println(sonuc);
        setCbYakitGuncelle();
        setCbYakitSec();
        yakit.setYakit(tfYakit.getText());
    }

    public void vitesGuncelle(){
        Vites vites = (Vites) cbVitesGuncelle.getSelectionModel().getSelectedItem();
        boolean sonuc = DataModel.getInstance().vitesGuncelle(vites.getId(),tfVites.getText());
        System.out.println(sonuc);
        setCbVitesGuncelle();
        setCbVitesSec();
        vites.setVites(tfVites.getText());
//        cbVitesGuncelle.setItems(Vites.getVitesList());
//        cbVitesSec.setItems(Vites.getVitesList());

//        for (Vites v : Vites.getVitesList()
//             ) {
//            System.out.println(v.getVites());
//        }
//        System.out.println("-------------------");

    }

    public void renkGuncelle(){
        Renk renk =(Renk) cbRenkGuncelle.getSelectionModel().getSelectedItem();
        boolean sonuc = DataModel.getInstance().renkGuncelle(renk.getId(),tfRenk.getText());
        System.out.println(sonuc);
        setCbRenkGuncelle();
        setCbRenkSec();

        renk.setRenk(tfRenk.getText());


    }

    public void sehirGuncelle(){
        Sehir sehir =(Sehir) cbSehirGuncelle.getSelectionModel().getSelectedItem();
        boolean sonuc = DataModel.getInstance().sehirGuncelle(sehir.getId(),tfSehir.getText());
        System.out.println(sonuc);
        setCbSehirSec();
        setCbSehirGuncelle();

        sehir.setSehir(tfSehir.getText());
    }


}
