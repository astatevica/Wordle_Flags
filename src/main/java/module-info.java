module com.example.sample{
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.sample to javafx.fxml;
    exports com.example.sample;
    exports Model;
    opens Model to javafx.fxml;
}
