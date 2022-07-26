package util.methods;
//Code by: PixelsDE

import main.BedWars;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Settings {

    private static BedWars plugin;

    public Settings(BedWars plugin) {
        Settings.plugin = plugin;
    }

    public static final File cfgFile = new File("plugins/main/settings.yml");
    public static final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(cfgFile);
    public static String pl = "";
    public static boolean editmode = cfg.getBoolean("Edit_Mode");


    public static void settings() {

        cfg.addDefault("Prefix", "&7[&6BedWars&7] ");
        cfg.addDefault("Max_Players", 16);
        cfg.addDefault("Min_Players", 2);
        cfg.addDefault("Min_Team", 1);
        cfg.addDefault("Max_Team", 4);
        cfg.addDefault("Server_Name", "&fPixelTopia");
        cfg.addDefault("Ts_Ip", "&fts.PixelTopia.de");
        cfg.addDefault("Autoupdate", true);
        cfg.addDefault("Teams_2", false);
        cfg.addDefault("Team_Blue", true);
        cfg.addDefault("Team_Red", true);
        cfg.addDefault("Team_Yellow", true);
        cfg.addDefault("Team_Green", true);
        cfg.addDefault("Edit_Mode", false);
        cfg.addDefault("Spawner_Gold", 1);
        cfg.addDefault("Spawner_Emerald", 30);
        cfg.addDefault("Spawner_Diamond", 10);

        try {
            cfg.options().copyDefaults(true);
            cfg.save(cfgFile);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
