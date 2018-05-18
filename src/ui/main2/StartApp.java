
package ui.main2;

import ui.main.*;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartApp extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("RootLayout.fxml"));
        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("TCU ellenőrző és javító");
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
