package ui.device;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import model.Device;
import ui.main3.RootLayoutController;

public class DeviceRootPaneController implements Initializable {

    @FXML
    private Button logcatOpenTabBtn;
    @FXML
    private Button tcuInfoOpenTabBtn;
    @FXML
    private Button paymentCategoryHufDbOpenTabBtn;
    @FXML
    private Label testImsiLb;

    private List<Device> devices;

    public DeviceRootPaneController() {
        this.devices = RootLayoutController.connectedDevices();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        testImsiLb.setText("IMSI: " + devices.get(0).getAdbImsi());
    }

    public void openLogcatTab() {

        logcatOpenTabBtn.setOnAction((ActionEvent event) -> {
            System.out.println("Open logcat");
        });
    }

}
