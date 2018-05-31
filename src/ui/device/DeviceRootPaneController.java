package ui.device;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import model.Device;
import ui.main3.RootLayoutController;

public class DeviceRootPaneController implements Initializable {

    @FXML
    private Button logcatOpenTabBtn;
    @FXML
    private Button tcuInfoOpenTabBtn;
    @FXML
    private Button paymentCategoryHufDbOpenTabBtn;
    private Label testImsiLb;

    private List<Device> devices;
    private Device device;
    @FXML
    private TextArea rightBoxArea;

    public DeviceRootPaneController() {
        this.devices = RootLayoutController.connectedDevices();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        device = new Device(devices.get(0).getAdbImsi());
        rightBoxArea.appendText("REPO IMSI: " + device.getRepoImsi() + "\n");
        rightBoxArea.appendText("REPO AP: " + device.getRepoAp()+ "\n");
        rightBoxArea.appendText("REPO Registered: " + device.getRepoRegistered()+ "\n");
        rightBoxArea.appendText("REPO TCUStatus: " + device.getRepoTcuStatus() + "\n");
        rightBoxArea.appendText("REPO Opened: " + device.getRepoOpened()+ "\n");
        rightBoxArea.appendText("CASHREG AP: " + device.getCashregisterAp() + "\n");
        rightBoxArea.appendText("CASHREG Version: " + device.getCashregisterVersion()+ "\n");
        

    }

    public void openLogcatTab() {

        logcatOpenTabBtn.setOnAction((ActionEvent event) -> {
            System.out.println("Open logcat");
        });
    }

}
