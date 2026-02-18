package com.beammpdash;

import java.io.BufferedReader;
import java.io.FileReader;

public class ReadConfig {

    private static final String FILE_PATH = "ServerConfig.toml";

    // Read full line that starts with key
    public static String readConfig(String startsWith) 
    {
        synchronized(ConfigLock.LOCK)
        {
            try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
                String line;

                while ((line = reader.readLine()) != null) {
                    line = line.trim();
                    if (line.startsWith(startsWith)) {
                        return line;
                    }
                }

                return "No such line exists.";
            }
            catch (Exception e) {
                e.printStackTrace();
                return "Failed: " + e.getMessage();
            }
        }

    }

    // Extract value
    private static String extractValue(String key) 
    {
        String line = readConfig(key + " = ");
        if(line.equals("No such line exists.") || line.equals("Failed"))
            return null;

        return line.substring(line.indexOf("=") + 1).trim();
    }

    // Read values

    public static String readMap() 
    {
        String value = extractValue("Map");
        if (value == null) return null;

        // remove quotes
        value = value.replace("\"", "");

        // /levels/west_coast_usa/info.json
        String[] parts = value.split("/");
        return parts[parts.length - 2]; // west_coast_usa
    }

    public static int readMaxCars() 
    {
        String value = extractValue("MaxCars");
        if (value == null) return -1;

        return Integer.parseInt(value);
    }

    public static String readDescription() 
    {
        String value = extractValue("Description");
        if (value == null) return null;

        return value.replace("\"", "");
    }

    public static String readName() 
    {
        String value = extractValue("Name");
        if (value == null) return null;

        return value.replace("\"", "");
    }

    public static int readPort() 
    {
        String value = extractValue("Port");
        if (value == null) return -1;

        return Integer.parseInt(value);
    }

    public static int readMaxPlayers() 
    {
        String value = extractValue("MaxPlayers");
        if (value == null) return -1;

        return Integer.parseInt(value);
    }

    public static boolean readPrivate() 
    {
        String value = extractValue("Private");
        if (value == null) return false;

        return Boolean.parseBoolean(value);
    }

    public static boolean readAllowGuests() 
    {
        String value = extractValue("AllowGuests");
        if (value == null) return false;

        return Boolean.parseBoolean(value);
    }

    public static boolean readDebug() 
    {
        String value = extractValue("Debug");
        if (value == null) return false;

        return Boolean.parseBoolean(value);
    }

    public static String readTags() 
    {
        String value = extractValue("Tags");
        if (value == null) return null;

        return value.replace("\"", "");
    }

    public static String readAuthKey() 
    {
        String value = extractValue("AuthKey");
        if (value == null) return null;

        return value.replace("\"", "");
    }
}
