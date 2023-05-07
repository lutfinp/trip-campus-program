package main.ppbo_ta;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        try{
            Parent root = FXMLLoader.load(getClass().getResource("Hello-view.fxml"));
            Scene scene = new Scene(root);
            String css = this.getClass().getResource("background1.css").toExternalForm();
            scene.getStylesheets().add(css);
            stage.setTitle("Tripus");
            stage.getIcons().add(new Image(getClass().getResourceAsStream("testicon.jpg")));
            stage.setScene(scene);
            stage.show();
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch();
    }
}