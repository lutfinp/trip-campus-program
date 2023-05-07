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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class PilihAsal implements Initializable {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private String myKota;

    @FXML
    private ChoiceBox<String> myChoiceBox;
    @FXML
    private Button berangkatButton;

    private String[] kota = {
            "Jakarta",
            "Bogor",
            "Depok",
            "Bekasi",
            "Tangerang"
    };

    @Override
    public void initialize(URL arg0, ResourceBundle arg1){
        berangkatButton.setManaged(false);
        berangkatButton.setVisible(false);
        myChoiceBox.getItems().addAll(kota);
        myChoiceBox.setOnAction(this::getKota);
    }

    private void showButton(){
        berangkatButton.setManaged(true);
        berangkatButton.setVisible(true);
    }
    public void getKota(ActionEvent event){
        myKota = myChoiceBox.getValue();
        showButton();
    }


    protected User user;
    public void switchToKendaraan1(ActionEvent event) throws IOException {
        if (myKota.equals("Jakarta")){
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pilih-kendaraan1-jakarta.fxml"));
            root = loader.load();
            user = new User(myKota);

            PilihKendaraan1Jakarta pilihKendaraan1Jakarta = loader.getController();
            pilihKendaraan1Jakarta.setInfo(user);
            pilihKendaraan1Jakarta.setTopLabels();

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            String css = this.getClass().getResource("pilih-kendaraan1-jakarta.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();
        } else {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("pilih-kendaraan1.fxml"));
            root = loader.load();
            user = new User(myKota);

            PilihKendaraan1 pilihKendaraan1 = loader.getController();
            pilihKendaraan1.setInfo(user);
            pilihKendaraan1.setTopLabels();

            stage = (Stage)((Node)event.getSource()).getScene().getWindow();
            scene = new Scene(root);
            String css = this.getClass().getResource("pilih-kendaraan1.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setScene(scene);
            stage.show();
        }
    }
}
