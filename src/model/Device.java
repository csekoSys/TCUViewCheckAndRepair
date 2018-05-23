package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Device {

    private String adbImsi;

    public Device(String adbImsi) {
        this.adbImsi = adbImsi;
    }

    public String getAdbImsi() {
        return adbImsi;
    }

    public String getAdbCommand(String command) {
        String cmd = "adb -s " + adbImsi + " shell " + command;
        return cmd;
    }

    /**
     * Lekérdezi az IMSI-t a reposytoryból
     *
     * @return repoImsi
     */
    public String getRepoImsi() {
        String repoImsi = null;

        Process process;
        try {
            process = Runtime.getRuntime().exec(getAdbCommand("cat /data//data/com.tekinvest.aeeapp/shared_prefs/repository.xml |grep -i Imsi"));
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

            repoImsi = br.readLine();
            repoImsi = repoImsi.replace("<string name=\"Imsi\">", "");
            repoImsi = repoImsi.replace("</string>", "");

        } catch (IOException ex) {
        }

        return repoImsi;
    }

    public Boolean isFileExsit() {

        return false;
    }

}
