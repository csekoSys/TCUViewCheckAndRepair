package tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Terminal {

    public static String execSingle(String command) {
        try {
            Process process = Runtime.getRuntime().exec(command);
            BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String resp = "";
            String line = "";
 //           System.out.println("Command: " + command);

            while ((line = br.readLine()) != null) {
                resp += line;
 //               System.out.println("execSingle: " + line);
            }

            return resp;

        } catch (IOException ex) {
        }
        return null;
    }

}
