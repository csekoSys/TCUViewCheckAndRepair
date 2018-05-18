package ui.main;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.Set;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.Device;
import tools.AdbDevices;

public class RootLayoutController implements Initializable {

    @FXML
    private Button devicesSearchBtn;
    @FXML
    private VBox devicesList;
    @FXML
    private TabPane mainTabPane;

    private List<Device> devices;
    private List<Device> tempDevices;

    public RootLayoutController() {
        tempDevices = new ArrayList<>();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void devicesSearch(ActionEvent event) {
        devices = AdbDevices.getAdbDevices();

        if (tempDevices.size() < 1) {
            tempDevices = devices;
        }

        System.out.println("Csatlakoztatott eszközök:" + devices.size());
        for (int j = 0; j < tempDevices.size(); j++) {
            System.out.println(j + " Temp devise: " + tempDevices.get(j).getAdbImsi());
        }
        System.out.println("");

        if (devices.size() > 0) {
            for (int i = 0; i < devices.size(); i++) {
                System.out.println(i + ". adb eszköz: " + devices.get(i).getAdbImsi());
            }
        } else {
            System.out.println("Nincs csatlakoztatva eszköz!");
        }

        for (int j = 0; j < devices.size(); j++) {
            boolean isDevice = devices.get(j).equals(tempDevices.get(j));
            System.out.println("device: " + devices.get(j));
            System.out.println("tempDevice: " + tempDevices.get(j));

            System.out.println("van egyezés: " + isDevice);
        }
        System.out.println("-----------------------------------------\n");

        for (int i = 0; i < tempDevices.size(); i++) {
            String imsi = tempDevices.get(i).getAdbImsi();
            HBox hBox = new HBox();
            TextField tf = new TextField();
            Button btn = new Button();
            tf.setMaxWidth(35);
            tf.setMinWidth(10);
            btn.setText(tempDevices.get(i).getAdbImsi());
            hBox.getChildren().addAll(tf, btn);
            devicesList.getChildren().add(hBox);
            tempDevices.remove(tempDevices.get(i));

            btn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Tab tab = new Tab(tf.getText() + " - " + imsi);
                    mainTabPane.getTabs().add(tab);
                }
            });
        }

    }
}
