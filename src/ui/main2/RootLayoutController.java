package ui.main2;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import model.Device;
import tools.AdbDevices;

public class RootLayoutController implements Initializable {

    private List<Device> devices;
    @FXML
    private Label deviseStatusLb;
    @FXML
    private Button deviceSearchBtn;
    private Button deviceNewTabOpenBtn;
    @FXML
    private TextArea deviceSmallStatusTa;
    @FXML
    private VBox devicesSearch;
    @FXML
    private TabPane deviceTabPane;
    private String adbImsi;

    public RootLayoutController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void deviceSearchAction(ActionEvent event) {
        System.out.println("Eszköz keresése");
        devices = AdbDevices.getAdbDevices();

        if (devices.size() == 1) {
            adbImsi = devices.get(0).getAdbImsi();
            deviseStatusLb.setText(adbImsi);
        } else if (devices.size() > 1) {
            deviseStatusLb.setText("Csak EGY eszköz lehet csatlakoztatva!");
        } else {
            deviseStatusLb.setText("Csatlakoztass eszközt!");
        }
    }

    @FXML
    private void deviceNewTabOpenAction(ActionEvent event) {

        if (adbImsi != null) {
            try {
                BorderPane devicePane = FXMLLoader.load(this.getClass().getResource("/ui/device/DeviceViewPane.fxml"));
                Tab t = new Tab();
                t.setText(adbImsi);
                t.setContent(devicePane);
                deviceTabPane.getTabs().add(t);
            } catch (Exception ex) {
                Logger.getLogger(RootLayoutController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("/ui/device/DeviceViewPane.fxml betöltési hiba");

            }

        } else {
            deviceSmallStatusTa.appendText("Nincs eszköz\n");
        }

    }
}
