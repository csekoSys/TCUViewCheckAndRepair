package ui.main3;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
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

    public RootLayoutController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    public void deviceOpenTab(ActionEvent event) {
        List<Device> devices = connectedDevices();

        if (devices.size() == 1) {
            deviceStatusTf.setText(devices.get(0).getAdbImsi());
        } else if (devices.size() > 1) {
            deviceStatusTf.setText("Csak EGY eszköz lehet csatlakoztatva!");
        } else {
            deviceStatusTf.setText("Csatlakoztass eszközt!");
        }

        for (int i = 0; i < devices.size(); i++) {
            System.out.println(devices.get(i).getAdbImsi());
        }

        String imsi = devices.get(0).getAdbImsi();

        if (imsi != null) {
            try {
                BorderPane deviceRootPane = FXMLLoader.load(this.getClass().getResource("/ui/device/DeviceRootPane.fxml"));
                Tab t = new Tab();
                t.setText(imsi);
                t.setContent(deviceRootPane);
                deviceTabPane.getTabs().add(t);
            } catch (IOException ex) {
                System.out.println("Error: /ui/device/DeviceRootPane.fxml ----ui.main3.RootLayoutController.deviceOpenTab() ");
            }
        } else {
            System.out.println("Error: ui.main3.RootLayoutController.deviceOpenTab() Nincs eszköz csatlakoztatva");
        }
    }

    public static List<Device> connectedDevices() {
        List<Device> devices = AdbDevices.getAdbDevices();

        return devices;
    }
}
