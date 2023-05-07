package main.ppbo_ta;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PilihKendaraan2 implements Initializable {
    @FXML
    private Label asalLabel, kendaraanLabel, detailLabel, tanyaLabel2;
    @FXML
    private ChoiceBox<String> pilihKendaraan;
    @FXML
    private Button yesButton, noButton;
    @FXML
    private Rectangle midRectangle;
    protected User user;
    protected String asal;
    public void setInfo(User user){
        this.user = user;
        this.asal = user.getAsal();
        yesButton.setVisible(false);
        yesButton.setManaged(false);
        noButton.setVisible(false);
        noButton.setManaged(false);
        midRectangle.setArcHeight(30);
        midRectangle.setArcWidth(30);
    }

    private String textAsal = "Dikarenakan asal Anda diluar wilayah Jakarta, Anda harus memilih minimal 2 kendaraan";
    public void setTopLabels(){
        String textLabel = "Kendaraan\t\t\tTarif\n" +
                "Angkot\t\t\tRp5000\n" +
                "Ojek Online\t\tRp12000\n" +
                "Kereta\t\tRp" + user.asalKota.getHargaKereta();
        if (!this.user.getAsal().equals("Jakarta")){
            asalLabel.setText(textAsal);
        }
        kendaraanLabel.setText(textLabel);
    }

    private String[] pilihan = {
            "Angkot",
            "Ojek Online",
            "Kereta",
    };

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        pilihKendaraan.getItems().addAll(pilihan);
        pilihKendaraan.setOnAction(this::getKendaraan);
    }

    private String myKendaraan, textKendaraan;
    public void getKendaraan(ActionEvent event){
        myKendaraan = pilihKendaraan.getValue();
        if(myKendaraan.equals("Angkot")){
            this.textKendaraan = "\tKeterangan\n" +
                    "Anda memilih Angkot\n" +
                    "Tarif: 5000\n" +
                    "Waktu: 30 Menit";
        } else if(myKendaraan.equals("Ojek Online")){
            this.textKendaraan = "\tKeterangan\n" +
                    "Anda memilih Ojek Online\n" +
                    "Tarif: 10000\n" +
                    "Waktu: 20 Menit";
        } else{
            this.textKendaraan = "\tKeterangan\n" +
                    "Anda memilih Kereta\n" +
                    "Tarif: " + user.asalKota.getHargaKereta() + "\n" +
                    "Waktu: 60 Menit";
        }
        setLabelKendaraan();
        yesButton.setVisible(true);
        yesButton.setManaged(true);
        noButton.setVisible(true);
        noButton.setManaged(true);
    }

    private String tanyaString = "Apakah Anda ingin menambah transportasi lagi?";
    public void setLabelKendaraan(){
        detailLabel.setText(this.textKendaraan);
        detailLabel.setWrapText(true);
        detailLabel.setMinHeight(80);
        tanyaLabel2.setText(tanyaString);
    }

    private Parent root;
    private Stage stage;
    private Scene scene;
    public void switchToKendaraan3(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("pilih-kendaraan3.fxml"));
        root = loader.load();

        user.setListKendaraan(myKendaraan);

        PilihKendaraan3 pilihKendaraan3 = loader.getController();
        pilihKendaraan3.setInfo(user);
        pilihKendaraan3.setTopLabels();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("pilih-kendaraan3.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }

    public void switchToHasil(ActionEvent event) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("hasil.fxml"));
        root = loader.load();
        user.setListKendaraan(myKendaraan);

        Hasil hasil = loader.getController();
        hasil.setInfo(user);
        hasil.setLabel();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        String css = this.getClass().getResource("hasil.css").toExternalForm();
        scene.getStylesheets().add(css);
        stage.setScene(scene);
        stage.show();
    }
}
