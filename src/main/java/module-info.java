module com.example.mypro {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.mypro to javafx.fxml;
    exports com.example.mypro;
}