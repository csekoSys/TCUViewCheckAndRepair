package ui.main3;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
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

    private void addDevicesList(String imsi) {
        HBox deviceBox = new HBox();
        deviceBox.autosize();
        TextField calbelNumber = new TextField();
        Button openTab = new Button(imsi);
        deviceBox.getChildren().addAll(calbelNumber, openTab);
        devicesListBox.getChildren().add(deviceBox);
    }

    @FXML
    private void deviceOpenTab(ActionEvent event) {
        String imsi = devices.get(0).getAdbImsi();
        Tab t = new Tab();
        t.setText(imsi);
        deviceTabPane.getTabs().add(t);
    }

}
