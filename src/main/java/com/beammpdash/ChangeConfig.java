package com.beammpdash;

import java.io.*;
import java.util.*;

public class ChangeConfig {

    private static final String FILE_PATH = "ServerConfig.toml";

    // Replace line
    private static String replaceLine(String startsWith, String newLine) throws IOException 
    {
        synchronized(ConfigLock.LOCK) 
        {

            List<String> lines = new ArrayList<>();
            BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH));
            String line;

            while((line = reader.readLine()) != null) 
            {
                lines.add(line);
            }
            reader.close();

            boolean found = false;

            for(int i = 0; i < lines.size(); i++)
            {
                if(lines.get(i).trim().startsWith(startsWith)) {
                    lines.set(i, newLine);
                    found = true;
                    break;
                }
            }

            if(!found) 
            {
                throw new IllegalStateException("Key not found: " + startsWith);
            }

            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH));
            for(String l : lines) 
            {
                writer.write(l);
                writer.newLine();
            }
            writer.close();

            return "Success!";
        }
    }


    // Set Line

    public static String setMap(String newMap) throws IOException 
    {
        String newLine = "Map = \"/levels/" + newMap + "/info.json\"";
        return replaceLine("Map = ", newLine);
    }

    public static String setMaxCars(int newMax) throws IOException 
    {
        String newLine = "MaxCars = " + newMax;
        return replaceLine("MaxCars = ", newLine);
    }

    public static String setDescription(String newDesc) throws IOException 
    {
        String newLine = "Description = \"" + newDesc + "\"";
        return replaceLine("Description = ", newLine);
    }

    public static String setName(String newName) throws IOException 
    {
        String newLine = "Name = \"" + newName + "\"";
        return replaceLine("Name = ", newLine);
    }

    public static String setPort(int port) throws IOException 
    {
        String newLine = "Port = " + port;
        return replaceLine("Port = ", newLine);
    }

    public static String setMaxPlayers(int players) throws IOException 
    {
        String newLine = "MaxPlayers = " + players;
        return replaceLine("MaxPlayers = ", newLine);
    }

    public static String setPrivate(boolean value) throws IOException 
    {
        String newLine = "Private = " + value;
        return replaceLine("Private = ", newLine);
    }

    public static String setAllowGuests(boolean value) throws IOException 
    {
        String newLine = "AllowGuests = " + value;
        return replaceLine("AllowGuests = ", newLine);
    }

    public static String setDebug(boolean value) throws IOException 
    {
        String newLine = "Debug = " + value;
        return replaceLine("Debug = ", newLine);
    }

    public static String setTags(String tags) throws IOException 
    {
        String newLine = "Tags = \"" + tags + "\"";
        return replaceLine("Tags = ", newLine);
    }

    public static String setAuthKey(String key) throws IOException 
    {
        String newLine = "AuthKey = \"" + key + "\"";
        return replaceLine("AuthKey = ", newLine);
    }
}
