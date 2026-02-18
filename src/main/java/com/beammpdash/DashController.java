package com.beammpdash;

import org.springframework.web.bind.annotation.*;
import java.io.IOException;

@RestController
@CrossOrigin
@RequestMapping("/api")
public class DashController
{
    // ===== GETTERS =====

    @GetMapping("/getMap")
    public String getMap()
    {
        return ReadConfig.readMap();
    }

    @GetMapping("/getMaxCars")
    public int getMaxCars()
    {
        return ReadConfig.readMaxCars();
    }

    @GetMapping("/getDescription")
    public String getDescription()
    {
        return ReadConfig.readDescription();
    }

    @GetMapping("/getName")
    public String getName()
    {
        return ReadConfig.readName();
    }

    @GetMapping("/getPort")
    public int getPort()
    {
        return ReadConfig.readPort();
    }

    @GetMapping("/getMaxPlayers")
    public int getMaxPlayers()
    {
        return ReadConfig.readMaxPlayers();
    }

    @GetMapping("/getPrivate")
    public boolean getIsPrivate()
    {
        return ReadConfig.readPrivate();
    }

    @GetMapping("/getAllowGuests")
    public boolean getAllowGuests()
    {
        return ReadConfig.readAllowGuests();
    }

    @GetMapping("/getDebug")
    public boolean getDebug()
    {
        return ReadConfig.readDebug();
    }

    @GetMapping("/getTags")
    public String getTags()
    {
        return ReadConfig.readTags();
    }

    // ===== SETTERS =====

    @PutMapping("/setMap")
    public String setMap(@RequestBody String map) throws IOException
    {
        return ChangeConfig.setMap(map);
    }

    @PutMapping("/setMaxCars")
    public String setMaxCars(@RequestBody int newMax) throws IOException
    {
        return ChangeConfig.setMaxCars(newMax);
    }

    @PutMapping("/setDescription")
    public String setDescription(@RequestBody String newDesc) throws IOException
    {
        return ChangeConfig.setDescription(newDesc);
    }

    @PutMapping("/setName")
    public String setName(@RequestBody String newName) throws IOException
    {
        return ChangeConfig.setName(newName);
    }

    @PutMapping("/setPort")
    public String setPort(@RequestBody int newPort) throws IOException
    {
        return ChangeConfig.setPort(newPort);
    }

    @PutMapping("/setMaxPlayers")
    public String setMaxPlayers(@RequestBody int newMax) throws IOException
    {
        return ChangeConfig.setMaxPlayers(newMax);
    }

    @PutMapping("/setPrivate")
    public String setPrivate(@RequestBody boolean isPrivate) throws IOException
    {
        return ChangeConfig.setPrivate(isPrivate);
    }

    @PutMapping("/setAllowGuests")
    public String setAllowGuests(@RequestBody boolean allowGuests) throws IOException
    {
        return ChangeConfig.setAllowGuests(allowGuests);
    }

    @PutMapping("/setDebug")
    public String setDebug(@RequestBody boolean isDebug) throws IOException
    {
        return ChangeConfig.setDebug(isDebug);
    }

    @PutMapping("/setTags")
    public String setTags(@RequestBody String newTags) throws IOException
    {
        return ChangeConfig.setTags(newTags);
    }
}
