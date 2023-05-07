package main.ppbo_ta;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Rectangle;
import javafx.stage.PopupWindow;
import javafx.stage.Stage;

public class Hasil {
    protected User user;
    protected String asal, hasil, footer, header;
    @FXML
    private Rectangle hasilRectangle;
    public void setInfo(User user){
        this.user = user;
        this.asal = asal;
        setText();
        hasilRectangle.setArcHeight(30);
        hasilRectangle.setArcWidth(30);
    }

    public void setText(){
        hasil = "Total Harga: Rp" + this.user.getTotalHarga() +
                "\nEstimasi Waktu: " +  this.user.getTotalWaktu() + " Menit" +
                "\nDengan menggunakan: " + this.user.getSemuaKendaraan();
        footer = "Terimakasih sudah menggunakan TRIPUS! Semoga selamat sampai tujuan :)";
        header = "Rangkuman perjalanan anda dari " + this.user.getAsal() + " menuju UPNVJ";
    }

    @FXML
    protected Label asalLabel, kendaraanLabel, detailLabel;
    protected void setLabel(){
        asalLabel.setText(header);
        kendaraanLabel.setText(hasil);
        detailLabel.setText(footer);
    }

    Stage stage;
    @FXML
    private Button doneButton;
    @FXML
    private AnchorPane scenePane;
    public void logout(ActionEvent event){
        stage = (Stage) scenePane.getScene().getWindow();
        stage.close();
    }
}
