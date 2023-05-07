module main.ppbo_ta {
    requires javafx.controls;
    requires javafx.fxml;
    requires fontawesomefx;


    opens main.ppbo_ta to javafx.fxml;
    exports main.ppbo_ta;
}