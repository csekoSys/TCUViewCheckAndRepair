package ui.main3;

import ui.main2.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartApp extends Application {

    @Override
    public void start(Stage stage) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("RootLayout.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("TCU ellenőrző és javító");
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(StartApp.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
