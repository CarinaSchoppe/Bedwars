package util.methods;
// Made by PixelsDE /
// Minecraft-Developer /
// Copyright PixelsDE /
// youtube.com/bypixels /

import main.BedWars;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class Bed {

    public static final File file = new File("plugins/main/beds.yml");
    public static final YamlConfiguration cfg = YamlConfiguration.loadConfiguration(file);
    private static BedWars plugin;
    public Bed(BedWars plugin) {
        Bed.plugin = plugin;
    }

    public static void setbed() {
        cfg.addDefault("Spawn.Bed.yellow.World", "world");
        cfg.addDefault("Spawn.Bed.yellow.X", 0);
        cfg.addDefault("Spawn.Bed.yellow.Z", 0);
        cfg.addDefault("Spawn.Bed.yellow.Y", 0);

        cfg.addDefault("Spawn.Bed.green.World", "world");
        cfg.addDefault("Spawn.Bed.green.Z", 0);
        cfg.addDefault("Spawn.Bed.green.X", 0);
        cfg.addDefault("Spawn.Bed.green.Y", 0);

        cfg.addDefault("Spawn.Bed.blue.World", "world");
        cfg.addDefault("Spawn.Bed.blue.Z", 0);
        cfg.addDefault("Spawn.Bed.blue.X", 0);
        cfg.addDefault("Spawn.Bed.blue.Y", 0);

        cfg.addDefault("Spawn.Bed.red.World", "world");
        cfg.addDefault("Spawn.Bed.red.Z", 0);
        cfg.addDefault("Spawn.Bed.red.X", 0);
        cfg.addDefault("Spawn.Bed.red.Y", 0);

        try {
            cfg.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
