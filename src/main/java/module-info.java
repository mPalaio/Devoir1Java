module sio.devoir1sioa {
    requires javafx.controls;
    requires javafx.fxml;


    opens sio.devoir1sioalt to javafx.fxml;
    exports sio.devoir1sioalt;
}