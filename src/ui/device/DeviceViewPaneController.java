package ui.device;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;

public class DeviceViewPaneController implements Initializable {

    @FXML
    private TabPane deviceInfoTabPane;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        initDeviceInfoTabPane();
    }

    public void initDeviceInfoTabPane() {
        try {
            BorderPane logcatPane = FXMLLoader.load(this.getClass().getResource("/ui/logcat/LogcatReaderView.fxml"));
            Tab t = new Tab();
            t.setText("logcat");
            t.setContent(logcatPane);
            deviceInfoTabPane.getTabs().add(t);
        } catch (Exception ex) {
            Logger.getLogger(DeviceViewPaneController.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("LogcatReaderView.fxml betöltési hiba");
        }

    }

}
