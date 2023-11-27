package sio.devoir1sioalt;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class DevoirApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(DevoirApplication.class.getResource("devoir-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Devoir n°1");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}