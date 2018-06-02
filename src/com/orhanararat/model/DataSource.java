package com.orhanararat.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import java.sql.*;
import java.util.ArrayList;

public class DataSource {
    private static DataSource instance = new DataSource();

    private static final String DATABASE_Name="deneme";
    private static final String DATABASE_USERNAME="root";
    private static final String DATABASE_Pass="123456789";
    private static final String DATABASE_ConnectionString="jdbc:mysql://localhost:3306/"+DATABASE_Name;

    public static final String TABLO_Calisan="calisan";
    public static final String TABLO_Dept="dept";

    public static final String TABLO_Calisan_ID="id";
    public static final String TABLO_Calisan_Isim="isim";
    public static final String TABLO_Calisan_Departman="departman";

    public static final String TABLO_Dept_ID="id";
    public static final String TABLO_Dept_Departman="departman";

    private DataSource(){}

    public static DataSource getInstance(){
        return instance;
    }

    private ObservableList<Dept> departmanList;

    private Connection connection;

    public boolean openDataBase(){
        try{
            connection= DriverManager.getConnection(DATABASE_ConnectionString,DATABASE_USERNAME,DATABASE_Pass);
            return true;
        }catch (SQLException e){
            System.out.println("Veri Tabani acilirken hata olustu");
            return false;
        }
    }

    public void closeDataBase(){
        try {
            if (connection!=null){
                connection.close();
            }
        }catch (SQLException e){
            System.out.println("Veri tabani kapatilirken hata olustu");
        }
    }

    public ArrayList<Calisan> calisanlariGetir(){
        try(Statement statement = connection.createStatement();
            ResultSet sonuc = statement.executeQuery("select * from "+TABLO_Calisan)) {
            ArrayList<Calisan> calisanlar = new ArrayList<>();

            while (sonuc.next()){
                Calisan geciciCalisan = new Calisan();
                geciciCalisan.setId(sonuc.getInt("id"));
                geciciCalisan.setIsim(sonuc.getString("isim"));
                geciciCalisan.setDepartman(sonuc.getInt("departman"));

                calisanlar.add(geciciCalisan);
            }
            return calisanlar;
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<Dept> departmanGetir(){
        try (Statement statement = connection.createStatement();
        ResultSet sonuc = statement.executeQuery("select * from "+ TABLO_Dept)) {
            departmanList= FXCollections.observableArrayList();

            while (sonuc.next()){
                Dept dept = new Dept();
                dept.setDepartman(sonuc.getString("departman"));
                dept.setId(sonuc.getInt("id"));
                departmanList.add(dept);
            }
            return departmanList;

        }catch (SQLException e){
            System.out.println("Departman bilgileri getirilirken hata olustu.");
            e.printStackTrace();
            return null;
        }
    }

    public void departmanEkle(String deger){
        try(Statement statement = connection.createStatement();
            ){
            PreparedStatement preStatement = connection.prepareStatement("insert into dept (departman) values (?)");
//            preStatement.setString(1,TABLO_Dept);
//            preStatement.setString(1,TABLO_Dept_Departman);
            preStatement.setString(1,deger);
//            preStatement.execute();

//            statement.execute("insert into dept (departman) values ('deger')");
//           if (){
//               System.out.println("Calisti");
//           }
//           else
//               System.out.println("Calismadi");
            preStatement.executeUpdate();

        }catch (SQLException e){
            System.out.println("Departman Eklerken Hata olustu.");
            e.printStackTrace();
        }
    }

    public void calisanEkle(String isim , int departman){
        try (Statement statement = connection.createStatement();
            PreparedStatement preparedStatement = connection.prepareStatement("insert into calisan (isim,departman) values(?,?)")) {
            preparedStatement.setString(1,isim);
            preparedStatement.setInt(2,departman);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Calisan Eklerken hata olustu");
            e.printStackTrace();
        }
    }

    public ObservableList<Dept> getDepartmanList() {
        return departmanList;
    }

    public void setDepartmanList(ObservableList<Dept> departmanList) {
        departmanList = departmanList;
    }

}
