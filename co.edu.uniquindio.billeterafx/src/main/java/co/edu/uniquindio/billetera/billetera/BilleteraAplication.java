package co.edu.uniquindio.billetera.billetera;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BilleteraAplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(BilleteraAplication.class.getResource("BilleteraApp.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("App Billetera!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}