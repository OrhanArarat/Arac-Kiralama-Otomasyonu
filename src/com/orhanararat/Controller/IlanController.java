package com.orhanararat.Controller;

import com.orhanararat.model.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

public class IlanController {
    @FXML
    private GridPane anaGridPane;
    @FXML
    private TextField tfMarka,tfModel,tfYakitTuru,tfVitesTuru,tfRenk,tfSehir;
    @FXML
    private TextField tfIlanAdi,tfAracFiyat,tfAracKm;
    @FXML
    private DatePicker dpIlanTarihi;
    @FXML
    private ComboBox cbMarka;
    @FXML
    private ComboBox cbSehir;
    @FXML
    private ComboBox cbVitesTuru;
    @FXML
    private ComboBox cbYakitTuru;
    @FXML
    private ComboBox cbRenk;

    @FXML
    public void setCbMarka(){
        Araba.getArabaList().clear();
        Araba.setArabaList(DataModel.getInstance().arabaGetir());
        cbMarka.setItems(Araba.getArabaList());
    }

    @FXML
    public void setCbSehir(){
        Sehir.getSehirList().clear();
        Sehir.setSehirList(DataModel.getInstance().sehirGetir());
        cbSehir.setItems(Sehir.getSehirList());
    }
    @FXML
    public void setCbVitesTuru(){
        Vites.getVitesList().clear();
        Vites.setVitesList(DataModel.getInstance().vitesGetir());
        cbVitesTuru.setItems(Vites.getVitesList());
//        cbVitesTuru.getItems().setAll(Vites.getVitesList());
    }
    @FXML
    public void setCbYakitTuru(){
        Yakit.getYakitList().clear();
        Yakit.setYakitList(DataModel.getInstance().yakitGetir());
        cbYakitTuru.setItems(Yakit.getYakitList());
    }
    @FXML
    public void setCbRenk(){
        Renk.getRenkList().clear();
        Renk.setRenkList(DataModel.getInstance().renkGetir());
        cbRenk.setItems(Renk.getRenkList());
    }

//    public void yaz(){
//        Sehir sehir =(Sehir) cbSehir.getSelectionModel().getSelectedItem();
//        System.out.println(sehir.getId());
//    }

    @FXML
    public void arabaEkle(){
        String model,marka;
        int vitesTuruId,yakitTuruId,renkId;

        model=tfModel.getText();
        marka=tfMarka.getText();

        Vites vites =(Vites) cbVitesTuru.getSelectionModel().getSelectedItem();
        vitesTuruId = vites.getId();

        Yakit yakit = (Yakit) cbYakitTuru.getSelectionModel().getSelectedItem();
        yakitTuruId= yakit.getId();

        Renk renk = (Renk) cbRenk.getSelectionModel().getSelectedItem();
        renkId= renk.getId();

        DataModel.getInstance().arabaEkle(marka,model,vitesTuruId,yakitTuruId,renkId);
//        DataModel.getInstance().arabaGetir();
        setCbMarka();

    }
    @FXML
    public void yakitEkle(){
        String yakit=tfYakitTuru.getText();
        DataModel.getInstance().yakitEkle(yakit);
        setCbYakitTuru();
    }
    @FXML
    public void vitesEkle(){
        String vites = tfVitesTuru.getText();
        DataModel.getInstance().vitesEkle(vites);
        setCbVitesTuru();
    }
    @FXML
    public void renkEkle(){
        String renk = tfRenk.getText();
        DataModel.getInstance().renkEkle(renk);
        setCbRenk();
    }
    @FXML
    public void sehirEkle(){
        String sehir = tfSehir.getText();
        DataModel.getInstance().sehirEkle(sehir);
        setCbSehir();
    }

    DateTimeFormatter formatter=DateTimeFormatter.ofPattern("dd-MM-yyyy");

    @FXML
    public void ilanEkle(){
        String ilanAdi;
        int ilanFiyat,ilanKm,arabaID,sehirID;
        Date ilanTarihi;

//        System.out.println(dpIlanTarihi.getValue().format(formatter));

        ilanAdi=tfIlanAdi.getText();
        ilanFiyat=Integer.parseInt(tfAracFiyat.getText());
        ilanKm=Integer.parseInt(tfAracKm.getText());
        Araba araba = (Araba) cbMarka.getSelectionModel().getSelectedItem();
        arabaID=araba.getId();
        Sehir sehir = (Sehir) cbSehir.getSelectionModel().getSelectedItem();
        sehirID= sehir.getId();
        ilanTarihi=Date.valueOf(dpIlanTarihi.getValue());

        DataModel.getInstance().ilanEkle(ilanAdi,ilanFiyat,ilanKm,ilanTarihi,arabaID,sehirID);

    }

    public void dialogPaneDelete() throws IOException {
        Dialog<ButtonType> dialogDelete =new Dialog<>();
        dialogDelete.initOwner(anaGridPane.getScene().getWindow());

        FXMLLoader fxmlLoader = new FXMLLoader();
        dialogDelete.setHeaderText("Silme Sayfasi");
        fxmlLoader.setLocation(getClass().getResource("../View/delete.fxml"));
        dialogDelete.getDialogPane().setContent(fxmlLoader.load());

        dialogDelete.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        Optional<ButtonType> sonuc = dialogDelete.showAndWait();
    }

    public void dialogPaneUpdate() throws IOException {
        Dialog<ButtonType> dialogUpdate =new Dialog<>();
        dialogUpdate.initOwner(anaGridPane.getScene().getWindow());

        FXMLLoader fxmlLoader = new FXMLLoader();
        dialogUpdate.setHeaderText("Update Sayfasi");
        fxmlLoader.setLocation(getClass().getResource("../View/update.fxml"));

        dialogUpdate.getDialogPane().setContent(fxmlLoader.load());
        dialogUpdate.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        Optional<ButtonType> sonuc = dialogUpdate.showAndWait();
    }

    public void dialogPaneFiltre() throws IOException {
        Dialog<ButtonType> dialogFiltre =new Dialog<>();
        dialogFiltre.initOwner(anaGridPane.getScene().getWindow());

        FXMLLoader fxmlLoader = new FXMLLoader();
        dialogFiltre.setHeaderText("Filtre Sayfasi");
        fxmlLoader.setLocation(getClass().getResource("../View/filtreleme.fxml"));

        dialogFiltre.getDialogPane().setContent(fxmlLoader.load());
        dialogFiltre.getDialogPane().getButtonTypes().add(ButtonType.CLOSE);

        Optional<ButtonType> sonuc = dialogFiltre.showAndWait();
    }

    public void initialize(){
        setCbMarka();
        setCbSehir();
        setCbVitesTuru();
        setCbYakitTuru();
        setCbRenk();
    }

}
