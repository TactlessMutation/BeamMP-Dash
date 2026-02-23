package com.beammpdash;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class StartStop 
{

    private static final String FILE_PATH = "start-stop-restart.txt";

    private static synchronized String writeCommand(String command) 
    {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH))) 
        {
            writer.write(command);
            writer.flush();
            return "Success!";
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
            return "Failed: " + e.getMessage();
        }
    }

    public static String startServer() 
    {
        return writeCommand("1");
    }

    public static String stopServer() 
    {
        return writeCommand("-1");
    }

    public static String restartServer() 
    {
        return writeCommand("0");
    }
}