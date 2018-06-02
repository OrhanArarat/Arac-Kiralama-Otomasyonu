package com.orhanararat.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.LocalDate;

public class DataModel {
    private static DataModel instance =  new DataModel();

    private static final String DATABASE_Name="Ilan";
    private static final String DATABASE_USERNAME="root";
    private static final String DATABASE_Pass="123456789";
    private static final String DATABASE_ConnectionString="jdbc:mysql://localhost:3306/"+DATABASE_Name;

    public static final String TABLO_Araba="Tbl_Araba";
    public static final String TABLO_Ilan="Tbl_Ilan";
    public static final String TABLO_Renk="Tbl_Renk";
    public static final String TABLO_Sehir="Tbl_Sehir";
    public static final String TABLO_VitesTuru="Tbl_VitesTuru";
    public static final String TABLO_YakitTuru="Tbl_YakitTuru";


    public static final String TABLO_Araba_ArabaID="ArabaID";
    public static final String TABLO_Araba_Araba_Marka="Araba_Marka";
    public static final String TABLO_Araba_Araba_Model="Araba_Model";
    public static final String TABLO_Araba_Araba_VitesTuruID="Araba_VitesTuruID";
    public static final String TABLO_Araba_Araba_YakitTuruID="Araba_YakitTuruID";
    public static final String TABLO_Araba_Araba_RenkID="Araba_RenkID";

    public static final String TABLO_Ilan_IlanID="IlanID";
    public static final String TABLO_Ilan_Ilan_Adi="Ilan_Adi";
    public static final String TABLO_Ilan_Ilan_Fiyat="Ilan_Fiyat";
    public static final String TABLO_Ilan_Ilan_Km="Ilan_Km";
    public static final String TABLO_Ilan_Ilan_Tarih="Ilan_Tarih";
    public static final String TABLO_Ilan_Ilan_ArabaID="Ilan_ArabaID";
    public static final String TABLO_Ilan_Ilan_SehirID="Ilan_SehirID";

    public static final String TABLO_Renk_RenkID="RenkID";
    public static final String TABLO_Renk_Renk_Renk="Renk";

    public static final String TABLO_VitesTuru_VitesTuruID="VitesTuruID";
    public static final String TABLO_VitesTuru_VitesTuru="Vites_Turu";

    public static final String TABLO_YakitTuru_YakitTuruID="YakitTuruID";
    public static final String TABLO_YakitTuru_YakitTuru="Yakit_Turu";

    public static final String TABLO_Sehir_SehirID="SehirID";
    public static final String TABLO_Sehir_Sehir="Sehir";

    private DataModel(){}

    public static DataModel getInstance(){
        return instance;
    }

    private Connection connection;

    public boolean openDataBase(){
        try{
            connection=DriverManager.getConnection(DATABASE_ConnectionString,DATABASE_USERNAME,DATABASE_Pass);
            return true;
        }catch (SQLException e){
            System.out.println("Veri Tabani Acilirken Hata Olustu.");
            e.printStackTrace();
            return false;
        }
    }

    public void closeDataBase(){
        try {
            if (connection!=null){
                connection.close();
            }
        }catch (SQLException e){
            System.out.println("Veri Tabani kapatilirken hata olustu.");
            e.printStackTrace();
        }
    }


    public ObservableList<Ilan> ilanGetir(){
        try(Statement statement = connection.createStatement();
            ResultSet sonuc = statement.executeQuery("SELECT * FROM "+TABLO_Ilan)){
            while(sonuc.next()){
                Ilan ilan = new Ilan
                        (sonuc.getInt(1),
                                sonuc.getString(2),
                                sonuc.getInt(3),
                                sonuc.getInt(4),
                                sonuc.getDate(5),
                                sonuc.getInt(6),
                                sonuc.getInt(7));
                Ilan.getIlanListesi().add(ilan);
            }
            return Ilan.getIlanListesi();
        }catch (SQLException e){
            System.out.println("Arabalar Veri Tabanindan getirilirken hata olustu");
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<Araba> arabaGetir(){
        try(Statement statement = connection.createStatement();
            ResultSet sonuc = statement.executeQuery("SELECT * FROM "+TABLO_Araba)){
            while(sonuc.next()){
                Araba araba = new Araba
                        (sonuc.getInt(1),
                                sonuc.getString(TABLO_Araba_Araba_Marka),
                                sonuc.getString(TABLO_Araba_Araba_Model),
                                sonuc.getInt(TABLO_Araba_Araba_VitesTuruID),
                                sonuc.getInt(TABLO_Araba_Araba_YakitTuruID),
                                sonuc.getInt(TABLO_Araba_Araba_RenkID));
                Araba.getArabaList().add(araba);
            }
            return Araba.getArabaList();
        }catch (SQLException e){
            System.out.println("Arabalar Veri Tabanindan getirilirken hata olustu");
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<Sehir> sehirGetir(){
        try(Statement statement = connection.createStatement();
            ResultSet sonuc = statement.executeQuery("select * from "+TABLO_Sehir)) {
            while (sonuc.next()){
                Sehir sehir = new Sehir(sonuc.getInt(TABLO_Sehir_SehirID),sonuc.getString(TABLO_Sehir_Sehir));
                Sehir.getSehirList().add(sehir);
//                System.out.println(sehir.getSehir());
            }
//            System.out.println("*******************");
            return Sehir.getSehirList();
        }catch (SQLException e){
            System.out.println("Sehirler veritabanindan cekilirken hata olustu.");
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<Vites> vitesGetir(){
        try(Statement statement = connection.createStatement();
            ResultSet sonuc = statement.executeQuery("select * from "+TABLO_VitesTuru)){
            while (sonuc.next()){
                Vites vites = new Vites(sonuc.getInt(1),sonuc.getString(2));
                Vites.getVitesList().add(vites);
            }
            return Vites.getVitesList();
        }catch (SQLException e){
            System.out.println("Vites veri tabanindan cekilirken hata olustu");
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<Yakit> yakitGetir(){
        try(Statement statement = connection.createStatement();
            ResultSet sonuc = statement.executeQuery("select * from "+TABLO_YakitTuru)){
            while (sonuc.next()){
                Yakit yakit = new Yakit(sonuc.getInt(1),sonuc.getString(2));
                Yakit.getYakitList().add(yakit);
            }
            return Yakit.getYakitList();
        }catch (SQLException e){
            System.out.println("Yakitlar veritabanindan cekilirken hata olustu");
            e.printStackTrace();
            return null;
        }
    }

    public ObservableList<Renk> renkGetir(){
        try(Statement statement = connection.createStatement();
            ResultSet sonuc = statement.executeQuery("select * from "+TABLO_Renk)) {
            while (sonuc.next()){
                Renk renk= new Renk(sonuc.getInt(1),sonuc.getString(2));
                Renk.getRenkList().add(renk);
            }
            return Renk.getRenkList();
        }catch (SQLException e){
            System.out.println("Renkler veritabanindan cekilirken hata olustu.");
            e.printStackTrace();
            return null;
        }

    }


    public void ilanEkle(String ilanAdi, int ilanFiyat, int ilanKm, Date ilanTarihi,int arabaID,int sehirID){
        try(PreparedStatement preparedStatement = connection.prepareStatement
                ("insert into "+TABLO_Ilan+"(Ilan_Adi,Ilan_Fiyat,Ilan_Km,Ilan_Tarih,Ilan_ArabaID,Ilan_SehirID) values (?,?,?,?,?,?)")){
            preparedStatement.setString(1,ilanAdi);
            preparedStatement.setInt(2,ilanFiyat);
            preparedStatement.setInt(3,ilanKm);
            preparedStatement.setDate(4,ilanTarihi);
            preparedStatement.setInt(5,arabaID);
            preparedStatement.setInt(6,sehirID);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Veritabanina Ilan eklerken bir sorun olustu.");
            e.printStackTrace();
        }
    }

    public void arabaEkle(String marka,String model,int vitesTuruId, int yakitTuruId, int renkId){
        try(PreparedStatement preparedStatement = connection.prepareStatement
                ("insert into "+TABLO_Araba+"(Araba_Marka,Araba_Model,Araba_VitesTuruID,Araba_YakitTuruID,Araba_RenkID) values (?,?,?,?,?)")){
            preparedStatement.setString(1,marka);
            preparedStatement.setString(2,model);
            preparedStatement.setInt(3,vitesTuruId);
            preparedStatement.setInt(4,yakitTuruId);
            preparedStatement.setInt(5,renkId);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Veritabanina araba eklerken bir sorun olustu.");
            e.printStackTrace();
        }
    }

    public void sehirEkle(String sehir){
        try(PreparedStatement preparedStatement = connection.prepareStatement("insert into "+TABLO_Sehir+
            " (Sehir) values (?)")){
            preparedStatement.setString(1,sehir);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Veritabanina sehir eklerken hata olustu");
            e.printStackTrace();
        }
    }

    public void vitesEkle(String vites){
        try(PreparedStatement preparedStatement = connection.prepareStatement("insert into "+TABLO_VitesTuru+
                " (Vites_Turu) values (?)")){
            preparedStatement.setString(1,vites);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Veritabanina Vites eklerken hata olustu");
            e.printStackTrace();
        }
    }

    public void yakitEkle(String yakit){
        try(PreparedStatement preparedStatement = connection.prepareStatement("insert into "+TABLO_YakitTuru+
                " (Yakit_Turu) values (?)")){
            preparedStatement.setString(1,yakit);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Veritabanina sehir eklerken hata olustu");
            e.printStackTrace();
        }
    }

    public void renkEkle(String renk){
        try(PreparedStatement preparedStatement = connection.prepareStatement("insert into "+TABLO_Renk+
                " (Renk) values (?)")){
            preparedStatement.setString(1,renk);

            preparedStatement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Veritabanina sehir eklerken hata olustu");
            e.printStackTrace();
        }
    }

    public void ilanSil(int id){
        try(PreparedStatement statement = connection.prepareStatement("delete from Tbl_Ilan where IlanID=?")){
//            statement.setString(1,TABLO_Araba_ArabaID);
            statement.setInt(1,id);
//            System.out.println(id);
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Veritabanindan Ilan nesnesi silinirken hata olustu");
            e.printStackTrace();
        }
    }

    public void arabaSil(int id){
        try(PreparedStatement statement = connection.prepareStatement("delete from Tbl_Araba where ArabaID=?")){
//            statement.setString(1,TABLO_Araba_ArabaID);
            statement.setInt(1,id);
//            System.out.println(id);
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Veritabanindan Araba nesnesi silinirken hata olustu");
            e.printStackTrace();
        }
    }

    public void yakitSil(int id){
        try(PreparedStatement statement = connection.prepareStatement("delete from Tbl_YakitTuru where YakitTuruID=?")){
//            statement.setString(1,TABLO_Araba_ArabaID);
            statement.setInt(1,id);
//            System.out.println(id);
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Veritabanindan Yakit nesnesi silinirken hata olustu");
            e.printStackTrace();
        }
    }

    public void vitesSil(int id){
        try(PreparedStatement statement = connection.prepareStatement("delete from Tbl_VitesTuru where VitesTuruID=?")){
//            statement.setString(1,TABLO_Araba_ArabaID);
            statement.setInt(1,id);
//            System.out.println(id);
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Veritabanindan Vites nesnesi silinirken hata olustu");
            e.printStackTrace();
        }
    }

    public void renkSil(int id){
        try(PreparedStatement statement = connection.prepareStatement("delete from Tbl_Renk where RenkID=?")){
//            statement.setString(1,TABLO_Araba_ArabaID);
            statement.setInt(1,id);
//            System.out.println(id);
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Veritabanindan Renk nesnesi silinirken hata olustu");
            e.printStackTrace();
        }
    }

    public void sehirSil(int id){
        try(PreparedStatement statement = connection.prepareStatement("delete from Tbl_Sehir where SehirID=?")){
//            statement.setString(1,TABLO_Araba_ArabaID);
            statement.setInt(1,id);
//            System.out.println(id);
            statement.executeUpdate();
        }catch (SQLException e){
            System.out.println("Veritabanindan Renk nesnesi silinirken hata olustu");
            e.printStackTrace();
        }
    }


    public boolean ilanGuncelle(int id ,String ilanAdi,int ilanFiyat,int ilanKm, Date ilanTarih,int arabaID, int sehirID){
        try(PreparedStatement preparedStatement = connection.prepareStatement
                ("update "+TABLO_Ilan+" set Ilan_Adi=?,Ilan_Fiyat=?,Ilan_Km=?," +
                        "Ilan_Tarih=?,Ilan_ArabaID=?,Ilan_SehirID=? where " +
                        "IlanID = ?")){
            preparedStatement.setString(1,ilanAdi);
            preparedStatement.setInt(2,ilanFiyat);
            preparedStatement.setInt(3,ilanKm);
            preparedStatement.setDate(4, ilanTarih);
            preparedStatement.setInt(5,arabaID);
            preparedStatement.setInt(6,sehirID);
            preparedStatement.setInt(7,id);

            preparedStatement.executeUpdate();
            return true;
        }catch (SQLException e){
            System.out.println("Veritabanina Ilan guncellerken bir sorun olustu.");
            e.printStackTrace();
            return false;
        }
    }

    public boolean arabaGuncelle(int id ,String marka,String model, int vites,int yakit ,int renk){
        try(PreparedStatement statement = connection.prepareStatement("update Tbl_Araba set Araba_Marka=?" +
                ", Araba_Model =?, Araba_VitesTuruID=?, Araba_YakitTuruID=?, Araba_RenkID=? " +
                "where ArabaID=?")){
            statement.setString(1,marka);
            statement.setString(2,model);
            statement.setInt(3,vites);
            statement.setInt(4,yakit);
            statement.setInt(5,renk);
            statement.setInt(6,id);

            statement.executeUpdate();
            return true;

        }catch (SQLException e){
            System.out.println("Veritabanindan Araba nesnesi guncellenirken hata olustu");
            e.printStackTrace();
            return false;
        }
    }

    public boolean yakitGuncelle(int id ,String yakit){
        try(PreparedStatement statement = connection.prepareStatement("update Tbl_YakitTuru set Yakit_Turu=? where YakitTuruID=?")){
            statement.setString(1,yakit);
            statement.setInt(2,id);

            statement.executeUpdate();
            return true;

        }catch (SQLException e){
            System.out.println("Veritabanindan Yakit nesnesi guncellenirken hata olustu");
            e.printStackTrace();
            return false;
        }
    }

    public boolean vitesGuncelle(int id ,String vites){
        try(PreparedStatement statement = connection.prepareStatement("update Tbl_VitesTuru set Vites_Turu=? where VitesTuruID=?")){
            statement.setString(1,vites);
            statement.setInt(2,id);

            statement.executeUpdate();
            return true;

        }catch (SQLException e){
            System.out.println("Veritabanindan Vites nesnesi guncellenirken hata olustu");
            e.printStackTrace();
            return false;
        }
    }

    public boolean renkGuncelle(int id,String renk){
        try(PreparedStatement statement = connection.prepareStatement("update Tbl_Renk set Renk=? where RenkID=?")){
            statement.setString(1,renk);
            statement.setInt(2,id);

            statement.executeUpdate();
            return true;

        }catch (SQLException e){
            System.out.println("Veritabanindan Renk nesnesi guncellenirken hata olustu");
            e.printStackTrace();
            return false;
        }
    }

    public boolean sehirGuncelle(int id,String sehir){
        try(PreparedStatement statement = connection.prepareStatement("update Tbl_Sehir set Sehir=? where SehirID=?")){
            statement.setString(1,sehir);
            statement.setInt(2,id);

            statement.executeUpdate();
            return true;

        }catch (SQLException e){
            System.out.println("Veritabanindan Sehir nesnesi guncellenirken hata olustu");
            e.printStackTrace();
            return false;
        }
    }


    public ObservableList<Ilan> filtrelemeIslemi(String fiyatMin,String fiyatMax,String kmMin,String kmMax,Sehir sehir,Yakit yakit,Vites vites,
        Renk renk,int tarihIndex,int siralamaIndex){
//        String tabloName="1";

        String Deneme="1";
        String fiyatIsimMin ="1";
        String fiyatIsimMax ="1";
        String sehirIsim= "1";
        String kmIsimMin="1";
        String kmIsimMax="1";
        String yakitIsim="1";
        String vitesIsim="1";
        String renkIsim="1";

        int minFiyat=-1,maxFiyat=-1,minKm=-1,maxKm=-1;

        if (sehir!=null){
            sehirIsim=TABLO_Ilan_Ilan_SehirID;
//            System.out.println("null degil");
        }
        if (vites!=null){
            vitesIsim=TABLO_Araba_Araba_VitesTuruID;
        }

        if (renk!=null){
            renkIsim=TABLO_Araba_Araba_RenkID;
        }
        if (yakit!=null){
            yakitIsim=TABLO_Araba_Araba_YakitTuruID;
        }
        if (!fiyatMin.equals("")){
            fiyatIsimMin=TABLO_Ilan_Ilan_Fiyat;
            minFiyat=Integer.parseInt(fiyatMin);
        }
        if (!fiyatMax.equals("")){
            fiyatIsimMax=TABLO_Ilan_Ilan_Fiyat;
            maxFiyat=Integer.parseInt(fiyatMax);
        }

        if (!kmMin.equals("")){
            kmIsimMin=TABLO_Ilan_Ilan_Fiyat;
            minKm=Integer.parseInt(kmMin);
        }
        if (!kmMax.equals("")){
            kmIsimMax=TABLO_Ilan_Ilan_Fiyat;
            maxKm=Integer.parseInt(kmMax);
        }

        try(PreparedStatement statement =connection.prepareStatement("SELECT * from Tbl_Ilan,Tbl_Araba " +
                "where Tbl_Ilan.Ilan_ArabaID=Tbl_Araba.ArabaID and "+sehirIsim+"=? and "+yakitIsim+"=? and "+vitesIsim+"=? and " +
                renkIsim+"=? and "+fiyatIsimMin+">=? and "+fiyatIsimMax+"<=? and "+kmIsimMin+">=? and "+kmIsimMax+"<=? ")) {
            ObservableList<Ilan> filtreIlan=FXCollections.observableArrayList();
//            statement.setString(1,Deneme);

            if (sehir==null){
                statement.setString(1,"1");
            } else{
                statement.setInt(1,sehir.getId());
            }
            if (yakit==null){
                statement.setString(2,"1");
            }else{
                statement.setInt(2,yakit.getId());
            }
            if (vites==null){
                statement.setString(3,"1");
            }else{
                statement.setInt(3,vites.getId());
            }
            if (renk==null){
                statement.setString(4,"1");
            }else{
                statement.setInt(4,renk.getId());
            }
            if (fiyatIsimMin.equals("1")){
                statement.setString(5,"1");
            }else{
                statement.setInt(5,minFiyat);
            }
            if (fiyatIsimMax.equals("1")){
                statement.setString(6,"1");
            }else{
                statement.setInt(6,maxFiyat);
            }

            if (kmIsimMin.equals("1")){
                statement.setString(7,"1");
            }else{
                statement.setInt(7,minKm);
            }
            if (kmIsimMax.equals("1")){
                statement.setString(8,"1");
            }else{
                statement.setInt(8,maxKm);
            }

            ResultSet sonuc = statement.executeQuery();
            while (sonuc.next()){
                System.out.println(sonuc.getString(1));
                Ilan i = new Ilan(sonuc.getInt(TABLO_Ilan_IlanID),sonuc.getString(TABLO_Ilan_Ilan_Adi),sonuc.getInt(TABLO_Ilan_Ilan_Fiyat),
                sonuc.getInt(TABLO_Ilan_Ilan_Km),sonuc.getDate(TABLO_Ilan_Ilan_Tarih),sonuc.getInt(TABLO_Ilan_Ilan_ArabaID),
                        sonuc.getInt(TABLO_Ilan_Ilan_SehirID));
                System.out.println("Aaaadafaf");
                filtreIlan.add(i);
            }
            System.out.println("+++++++++++++++++");
            return  filtreIlan;
        }catch (SQLException e){
            System.out.println("Filtreleme islemi sirasinda hata olustu.");
            e.printStackTrace();
            return null;
        }
    }

}
