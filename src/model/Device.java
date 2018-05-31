package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import tools.Terminal;

public class Device {

    private final String adbImsi;
    public final static String REPOSITORY_PATH = "/data/data/com.tekinvest.aeeapp/shared_prefs/";
    public final static String CASHREGISTER_PATH = "/data/data/com.tekinvest.novatek.cashregister/shared_prefs/";

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
            boolean isRepo = isFileExists(REPOSITORY_PATH, "repository.xml");
            if (isRepo) {
                process = Runtime.getRuntime().exec(getAdbCommand("cat " + REPOSITORY_PATH + "repository.xml |grep -i Imsi"));
                BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

                repoImsi = br.readLine();
                repoImsi = repoImsi.replace("<string name=\"Imsi\">", "");
                repoImsi = repoImsi.replace("</string>", "");
            } else {
                System.out.println("REPOSYTORY NEM LÉTEZIK!!! ---model.Device.isRepo()");
            }

        } catch (IOException ex) {
        }

        return repoImsi;
    }

    /**
     * Lekérdezi az TCU státuszát a reposytoryból
     *
     * @return repoTcuStatus
     */
    public String getRepoTcuStatus() {
        String repoTcuStatus = null;

        Process process;
        try {
            boolean isRepo = isFileExists(REPOSITORY_PATH, "repository.xml");
            if (isRepo) {
                process = Runtime.getRuntime().exec(getAdbCommand("cat " + REPOSITORY_PATH + "repository.xml |grep -i TCUStatus"));
                
                BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

                repoTcuStatus = br.readLine();
                repoTcuStatus = repoTcuStatus.replace("<string name=\"TCUStatus\">", "");
                repoTcuStatus = repoTcuStatus.replace("</string>", "");

            } else {
                System.out.println("REPOSYTORY NEM LÉTEZIK!!! ---model.Device.isRepo()");
            }
        } catch (IOException ex) {
            System.out.println("model.Device.getRepoTcuStatus()  exceptio");
        }

        return repoTcuStatus;

    }

    /**
     * Lekérdezi az AP-t a reposytoryból
     *
     * @return repoAp
     */
    public String getRepoAp() {
        String repoAp = null;

        Process process;
        try {
            boolean isRepo = isFileExists(REPOSITORY_PATH, "repository.xml");
            if (isRepo) {
                process = Runtime.getRuntime().exec(getAdbCommand("cat " + REPOSITORY_PATH + "repository.xml |grep -F <string name=\"Ap\">"));
                BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

                repoAp = br.readLine();
                repoAp = repoAp.replace("<string name=\"Ap\">", "");
                repoAp = repoAp.replace("</string>", "");
            } else {
                System.out.println("REPOSYTORY NEM LÉTEZIK!!! ---model.Device.isRepo()");
            }

        } catch (IOException ex) {
        }

        return repoAp;
    }

    /**
     * Lekérdezi a beüzemelés státuszát a reposytoryból
     *
     * @return repoRegistered
     */
    public Boolean getRepoRegistered() {
        String repoRegisteredS;
        Boolean repoRegistered = false;

        Process process;
        try {
            boolean isRepo = isFileExists(REPOSITORY_PATH, "repository.xml");
            if (isRepo) {
                process = Runtime.getRuntime().exec(getAdbCommand("cat " + REPOSITORY_PATH + "repository.xml |grep -i Registered"));
                BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

                repoRegisteredS = br.readLine();
                repoRegisteredS = repoRegisteredS.replace("<boolean name=\"Registered\" value=\"", "");
                repoRegisteredS = repoRegisteredS.replace("\" />", "");

                //ellenőrizni, hogy jó e
                if ("true".equals(repoRegisteredS)) {
                    repoRegistered = true;
                }

            } else {
                System.out.println("REPOSYTORY NEM LÉTEZIK!!! ---model.Device.isRepo()");
            }

        } catch (IOException ex) {
        }

        return repoRegistered;
    }

    /**
     * Lekérdezi a nyitott napot a reposytoryból
     *
     * @return repoOpened
     */
    public Boolean getRepoOpened() {
        String repoOpenedS;
        Boolean repoOpened = false;

        Process process;
        try {
            boolean isRepo = isFileExists(REPOSITORY_PATH, "repository.xml");
            if (isRepo) {
                process = Runtime.getRuntime().exec(getAdbCommand("cat " + REPOSITORY_PATH + "repository.xml |grep -i Opened"));
                BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

                repoOpenedS = br.readLine();
                repoOpenedS = repoOpenedS.replace("<boolean name=\"Opened\" value=\"", "");
                repoOpenedS = repoOpenedS.replace("\" />", "");

                //ellenőrizni, hogy jó e
                if ("true".equals(repoOpenedS)) {
                    repoOpened = true;
                }

            } else {
                System.out.println("REPOSYTORY NEM LÉTEZIK!!! ---model.Device.isRepo()");
            }

        } catch (IOException ex) {
        }

        return repoOpened;
    }

    /**
     * Lekérdezi az IMSI-t a com.tekinvest.novatek.cashregister_preferences.xml
     *
     * @return cashregAp
     */
    public String getCashregisterAp() {
        String cashregAp = null;

        Process process;
        try {
            boolean isRepo = isFileExists(CASHREGISTER_PATH, "com.tekinvest.novatek.cashregister_preferences.xml");
            if (isRepo) {
                process = Runtime.getRuntime().exec(getAdbCommand("cat " + CASHREGISTER_PATH + "com.tekinvest.novatek.cashregister_preferences.xml |grep -i AP_STRING"));
                BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

                cashregAp = br.readLine();
                cashregAp = cashregAp.replace("<string name=\"AP_STRING\">", "");
                cashregAp = cashregAp.replace("</string>", "");
            } else {
                System.out.println("REPOSYTORY NEM LÉTEZIK!!! ---model.Device.isRepo()");
            }

        } catch (IOException ex) {
        }

        return cashregAp;
    }

    /**
     * Lekérdezi az Versio-t a
     * com.tekinvest.novatek.cashregister_preferences.xml
     *
     * @return cashregAp
     */
    public String getCashregisterVersion() {
        String cashregVersion = null;

        Process process;
        try {
            boolean isRepo = isFileExists(CASHREGISTER_PATH, "com.tekinvest.novatek.cashregister_preferences.xml");
            if (isRepo) {
                process = Runtime.getRuntime().exec(getAdbCommand("cat " + CASHREGISTER_PATH + "com.tekinvest.novatek.cashregister_preferences.xml |grep -i SOFTWARE_VERSION_STRING"));
                BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));

                cashregVersion = br.readLine();
                cashregVersion = cashregVersion.replace("<string name=\"SOFTWARE_VERSION_STRING\">", "");
                cashregVersion = cashregVersion.replace("</string>", "");
            } else {
                System.out.println("REPOSYTORY NEM LÉTEZIK!!! ---model.Device.isRepo()");
            }

        } catch (IOException ex) {
        }

        return cashregVersion;
    }

    /**
     * Fájl létezik
     *
     * @param path
     * @param fileName
     * @return
     */
    public Boolean isFileExists(String path, String fileName) {
        String s = Terminal.execSingle(getAdbCommand("ls " + path));

        if (s != null) {
            if (s.contains(fileName)) {
                return true;
            }
        }
        return false;
    }
}
