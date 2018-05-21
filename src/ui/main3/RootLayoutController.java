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

    public RootLayoutController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }



    @FXML
    private void devicesSearch(ActionEvent event) {
        List<Device> devices = AdbDevices.getAdbDevices();

        if (devices.size() == 1) {
            deviceStatusTf.setText(devices.get(0).getAdbImsi());
//          addDevicesList(devices.get(0).getAdbImsi());
        } else if (devices.size() > 1) {
            deviceStatusTf.setText("Csak EGY eszköz lehet csatlakoztatva!");
        } else {
            deviceStatusTf.setText("Csatlakoztass eszközt!");
        }
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
        Tab t = new Tab();
        t.setText("valami");
        deviceTabPane.getTabs().add(t);
    }

}
