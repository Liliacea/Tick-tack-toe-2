module com.example.ticktacktoe2 {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.ticktacktoe2 to javafx.fxml;
    exports com.example.ticktacktoe2;
}