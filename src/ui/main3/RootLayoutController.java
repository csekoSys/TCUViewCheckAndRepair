package ui.main3;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import model.Device;
import tools.AdbDevices;

public class RootLayoutController implements Initializable {

    @FXML
    private VBox devicesListBox;
    @FXML
    private TextField deviceStatusTf;
    @FXML
    private TabPane deviceTabPane;
    List<Device> devices;

    public RootLayoutController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private List<Device> devicesSearch(ActionEvent event) {
        devices = AdbDevices.getAdbDevices();

        if (devices.size() == 1) {
            deviceStatusTf.setText(devices.get(0).getAdbImsi());
//          addDevicesList(devices.get(0).getAdbImsi());
        } else if (devices.size() > 1) {
            deviceStatusTf.setText("Csak EGY eszköz lehet csatlakoztatva!");
        } else {
            deviceStatusTf.setText("Csatlakoztass eszközt!");
        }
        return devices;
    }

    @FXML
    private void deviceOpenTab(ActionEvent event) {
        String imsi = devices.get(0).getAdbImsi();

        if (imsi != null) {
            try {
                StackPane deviceRootPane = FXMLLoader.load(this.getClass().getResource("/ui/device/DeviceRootPane.fxml"));
                Tab t = new Tab();
                t.setText(imsi);
                t.setContent(deviceRootPane);
                deviceTabPane.getTabs().add(t);
            } catch (IOException ex) {
                Logger.getLogger(RootLayoutController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            System.out.println("ui.main3.RootLayoutController.deviceOpenTab() Nincs eszköz csatlakoztatva");
        }

    }

}
