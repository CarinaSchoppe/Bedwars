package util;

import main.BedWars;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

//C ode by: PixelsDE /
// All rights reserved! /
// Website: bypixels.weebly.com /
// Youtube: byPixels /
public class StatsSystem {

    private static BedWars plugin;

    public StatsSystem(BedWars plugin) {
        StatsSystem.plugin = plugin;
    }

    public static final File cfgFile = new File("plugins/main/stats.yml");
    public static final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(cfgFile);

    public static void SaveStats() {


        try {
            cfg.save(cfgFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
