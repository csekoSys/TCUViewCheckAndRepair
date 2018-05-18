package ui.main2;

import ui.main.*;
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
    private final HBox deviceBox = new HBox();
    private final TextField cabelNumberTf = new TextField();
    private final Button deviceOpenBtn = new Button();

    private List<Device> devices;
    private List<Device> printDevices;

    public RootLayoutController() {
        printDevices = new ArrayList<>();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void devicesSearch(ActionEvent event) {
        devices = AdbDevices.getAdbDevices();

        if (printDevices.size() < 1) {
            printDevices = devices;
        }
        /**
         * Csatlakoztatott eszközök listázása
         */
        System.out.println("Csatlakoztatott eszközök:" + devices.size());
        for (int i = 0; i < printDevices.size(); i++) {
            String imsi = printDevices.get(i).getAdbImsi();
            System.out.println(i + " Temp devise: " + imsi + " " + printDevices.get(i));

 //           cabelNumberTf.setMaxWidth(35);
 //           cabelNumberTf.setMinWidth(10);
 //           deviceOpenBtn.setText(imsi);
 //           deviceBox.getChildren().addAll(cabelNumberTf, deviceOpenBtn);

        }
        System.out.println("");

        if (devices.size() > 0) {
            for (int i = 0; i < devices.size(); i++) {
                System.out.println(i + ". adb eszköz: " + devices.get(i).getAdbImsi() + " " + devices.get(i));
            }
        } else {
            devicesList.getChildren().add(new Label("Nincs eszköz!"));
            System.out.println("Nincs eszköz!");
        }

        /**
         * device hozzáadása a listához, ha a tempDeviceben nem található majd
         * hozzáadni a tempdevicehez is
         */
        for (int i = 0; i < devices.size(); i++) {
            for (int j = 0; j < printDevices.size(); j++) {
                boolean isDevice = devices.get(j).equals(printDevices.get(j));
                if (!isDevice) {
                }
            }

        }

        System.out.println("-----------------------------------------\n");

        /*       
                            String imsi = tempDevices.get(j).getAdbImsi();


         */
 /*
        for (int i = 0; i < tempDevices.size(); i++) {

//            tempDevices.remove(tempDevices.get(i));
            //Device add TabPane 
            deviceOpenBtn.setOnAction((ActionEvent event1) -> {
                Tab tab = new Tab(cabelNumberTf.getText() + " - " + imsi);
                mainTabPane.getTabs().add(tab);
            });
        }
         */
    }
}
