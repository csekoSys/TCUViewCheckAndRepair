package tools;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import model.Device;

public class AdbDevices {

    public static List<Device> getAdbDevices() {
        ArrayList<Device> devices = new ArrayList();

        try {
            String command = "adb devices";
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line = null;
            int lineCount = 0;

            while ((line = br.readLine()) != null) {
//                System.out.println(line);
                if (lineCount > 0) {
                    String[] parts = line.split("\t");
                    if (parts.length == 2) {
                        devices.add(new Device(parts[0]));
                    }
                }
                lineCount++;
            }
            process.waitFor();
        } catch (Exception e) {
        }

        return devices;
    }
}
