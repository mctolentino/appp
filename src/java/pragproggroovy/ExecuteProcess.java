package pragproggroovy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecuteProcess {
    public static void main(String[] args) {
        try {
            Process process = Runtime.getRuntime().exec("svn help");
            BufferedReader result = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            while ((line = result.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
