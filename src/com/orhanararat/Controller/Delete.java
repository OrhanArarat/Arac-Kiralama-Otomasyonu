package com.orhanararat.Controller;

import com.orhanararat.model.*;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

public class Delete {
    @FXML
    private ComboBox cbIlanSec,cbArabaSec,cbYakitSec,cbVitesSec,cbRenkSec,cbSehirSec;
    @FXML
    private Button btnIlanSil,btnArabaSil,btnYakitSil,btnVitesSil,btnRenkSil,btnSehirSil;


    public void setCbIlanSec(){
        cbIlanSec.getItems().clear();
        cbIlanSec.getItems().setAll(Ilan.getIlanListesi());
    }

    public void setCbArabaSec(){
        Araba.getArabaList().clear();
        Araba.setArabaList(DataModel.getInstance().arabaGetir());
        cbArabaSec.setItems(Araba.getArabaList());
    }

    public void setCbYakitSec(){
        Yakit.getYakitList().clear();
        Yakit.setYakitList(DataModel.getInstance().yakitGetir());
        cbYakitSec.setItems(Yakit.getYakitList());
    }

    public void setCbVitesSec(){
        Vites.getVitesList().clear();
        Vites.setVitesList(DataModel.getInstance().vitesGetir());
        cbVitesSec.setItems(Vites.getVitesList());
    }

    public void setCbRenkSec(){
        Renk.getRenkList().clear();
        Renk.setRenkList(DataModel.getInstance().renkGetir());
        cbRenkSec.setItems(Renk.getRenkList());
    }

    public void setCbSehirSec(){
        Sehir.getSehirList().clear();
        Sehir.setSehirList(DataModel.getInstance().sehirGetir());
        cbSehirSec.setItems(Sehir.getSehirList());
    }

    public void ilanSil(){
        Ilan ilan = (Ilan) cbIlanSec.getSelectionModel().getSelectedItem();
        DataModel.getInstance().ilanSil(ilan.getId());
        Ilan.getIlanListesi().remove(ilan);
        setCbIlanSec();
    }

    public void arabaSil(){
        Araba araba =(Araba) cbArabaSec.getSelectionModel().getSelectedItem();
        DataModel.getInstance().arabaSil(araba.getId());
        Araba.getArabaList().remove(araba);
    }

    public void yakitSil(){
        Yakit yakit =(Yakit) cbYakitSec.getSelectionModel().getSelectedItem();
        DataModel.getInstance().yakitSil(yakit.getId());
        Yakit.getYakitList().remove(yakit);
    }

    public void vitesSil(){
        Vites vites =(Vites) cbVitesSec.getSelectionModel().getSelectedItem();
        DataModel.getInstance().vitesSil(vites.getId());
        Vites.getVitesList().remove(vites);
    }

    public void renkSil(){
        Renk renk =(Renk) cbRenkSec.getSelectionModel().getSelectedItem();
        DataModel.getInstance().renkSil(renk.getId());
        Renk.getRenkList().remove(renk);
    }

    public void sehirSil(){
        Sehir sehir =(Sehir) cbSehirSec.getSelectionModel().getSelectedItem();
        DataModel.getInstance().sehirSil(sehir.getId());
        Sehir.getSehirList().remove(sehir);
    }

    public void initialize(){
        Ilan.getIlanListesi().clear();
        DataModel.getInstance().ilanGetir();
        setCbIlanSec();
        setCbArabaSec();
        setCbRenkSec();
        setCbSehirSec();
        setCbVitesSec();
        setCbYakitSec();
    }
}
