import java.io.*;
import java.util.*;

public class changeConfig {

    private static final String FILE_PATH = "ServerConfig.toml";

    // Replace line
    private static String replaceLine(String startsWith, String newLine) {
        try {
            List<String> lines = new ArrayList<String>();
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;

            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            reader.close();

            for (int i = 0; i < lines.size(); i++) {
                if (lines.get(i).startsWith(startsWith)) {
                    lines.set(i, newLine);
                    break;
                }
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
            for (int i = 0; i < lines.size(); i++) {
                writer.write(lines.get(i));
                writer.newLine();
            }
            writer.close();

            return "Success!";
        } catch (Exception e) {
            return "Failed";
        }
    }

    // Set Line

    public static String setMap(String newMap) {
        String newLine = "Map = \"/levels/" + newMap + "/info.json\"";
        return replaceLine("Map = ", newLine);
    }

    public static String setMaxCars(int newMax) {
        String newLine = "MaxCars = " + newMax;
        return replaceLine("MaxCars = ", newLine);
    }

    public static String setDescription(String newDesc) {
        String newLine = "Description = \"" + newDesc + "\"";
        return replaceLine("Description = ", newLine);
    }

    public static String setName(String newName) {
        String newLine = "Name = \"" + newName + "\"";
        return replaceLine("Name = ", newLine);
    }

    public static String setPort(int port) {
        String newLine = "Port = " + port;
        return replaceLine("Port = ", newLine);
    }

    public static String setMaxPlayers(int players) {
        String newLine = "MaxPlayers = " + players;
        return replaceLine("MaxPlayers = ", newLine);
    }

    public static String setPrivate(boolean value) {
        String newLine = "Private = " + value;
        return replaceLine("Private = ", newLine);
    }

    public static String setAllowGuests(boolean value) {
        String newLine = "AllowGuests = " + value;
        return replaceLine("AllowGuests = ", newLine);
    }

    public static String setDebug(boolean value) {
        String newLine = "Debug = " + value;
        return replaceLine("Debug = ", newLine);
    }

    public static String setTags(String tags) {
        String newLine = "Tags = \"" + tags + "\"";
        return replaceLine("Tags = ", newLine);
    }

    public static String setAuthKey(String key) {
        String newLine = "AuthKey = \"" + key + "\"";
        return replaceLine("AuthKey = ", newLine);
    }
}
