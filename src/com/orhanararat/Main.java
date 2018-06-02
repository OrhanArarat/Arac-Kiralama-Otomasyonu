package com.orhanararat;

import com.orhanararat.Controller.IlanController;
import com.orhanararat.model.DataModel;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    public FXMLLoader loader = new FXMLLoader(getClass().getResource("View/ilanSayfasi.fxml"));
    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = loader.load();

//        EklemeController controller = loader.getController();

//        controller.cbEkleDepartman();

//        Parent root = FXMLLoader.load(getClass().getResource("View.calisan.fxml"));
        primaryStage.setTitle("Ekleme Sayfasi");
        primaryStage.setScene(new Scene(root, 650, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
//        try(Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/deneme","root","123456789");
//            Statement statement = connect.createStatement();){
//            ResultSet result = statement.executeQuery("select * from calisan,dept where calisan.departman = dept.id");
//            while (result.next()){
//                System.out.println("Isim: "+ result.getString("isim")+" Departman: "+ result.getString("dept.departman"));
//            }
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }

//        DataSource.getInstance().openDataBase();
//
//        ArrayList<Calisan> calisanlar = DataSource.getInstance().calisanlariGetir();
//
//        for (Calisan gecici: calisanlar
//             ) {
//            System.out.println("Isim: " + gecici.getIsim()+" Departman: " +gecici.getDepartman());
//        }
//
//        DataSource.getInstance().closeDataBase();
    }

    @Override
    public void init() throws Exception {
        super.init();

        if (!DataModel.getInstance().openDataBase()){
            System.out.println("Database baglanilamadi.");
            Platform.exit();
        }else{
            DataModel.getInstance().arabaGetir();
            DataModel.getInstance().sehirGetir();
            DataModel.getInstance().renkGetir();
            DataModel.getInstance().vitesGetir();
            DataModel.getInstance().yakitGetir();
        }
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        DataModel.getInstance().closeDataBase();

    }
}
