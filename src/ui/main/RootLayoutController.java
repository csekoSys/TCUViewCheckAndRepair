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
    private HBox deviceBox = new HBox();
    private TextField cabelNumberTf = new TextField();
    private Button deviceOpenBtn = new Button();

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
            devicesList.getChildren().add(new Label("Nincs eszköz!"));
            System.out.println("Nincs eszköz!");
        }
        
        
        
        
        

        for (int i = 0; i < devices.size(); i++) {

            for (int j = 0; j < 10; j++) {
                boolean isDevice = devices.get(j).equals(tempDevices.get(j));
                System.out.println("device: " + devices.get(j));
                System.out.println("tempDevice: " + tempDevices.get(j));

                System.out.println("van egyezés: " + isDevice);
            }

        }

        System.out.println("-----------------------------------------\n");

        for (int i = 0; i < tempDevices.size(); i++) {
            String imsi = tempDevices.get(i).getAdbImsi();

            cabelNumberTf.setMaxWidth(35);
            cabelNumberTf.setMinWidth(10);
            deviceOpenBtn.setText(imsi);
            deviceBox.getChildren().addAll(cabelNumberTf, deviceOpenBtn);
            devicesList.getChildren().add(deviceBox);
//            tempDevices.remove(tempDevices.get(i));

            //Device add TabPane 
            deviceOpenBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    Tab tab = new Tab(cabelNumberTf.getText() + " - " + imsi);
                    mainTabPane.getTabs().add(tab);
                }
            });
        }

    }
}
