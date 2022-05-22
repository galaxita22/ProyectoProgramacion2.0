package cl.utalca.alumnos.proyecto;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;


import java.io.IOException;

public class Main extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 850, 400);
        stage.setTitle("Calculadora");
        stage.setScene(scene);

        //Image icon = new Image(String.valueOf(Main.class.getResource("logo.png")));
        //stage.getIcons().add(icon);

        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}