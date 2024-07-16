package Utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Dotenv {

    // Provide the path to your .env file
    private static final String ENV_FILE_PATH = ".env";

    public static Map<String, String> loadEnv() {
        Map<String, String> env = new HashMap<>();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(ENV_FILE_PATH));
            String line;

            while ((line = reader.readLine()) != null) {
                String[] keyValue = line.split("=", 2);
                if (keyValue.length == 2) {
                    env.put(keyValue[0].trim(), keyValue[1].trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading .env file");
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return env;
    }
}