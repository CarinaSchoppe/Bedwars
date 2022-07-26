package util.methods.countdowns;

import util.methods.Messages;
import util.methods.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.WorldCreator;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;

import main.BedWars;
import util.methods.Var;

import java.util.Objects;

public class EndCountdown extends Countdown {

    private int taskID;
    private int seconds = 10;

    public static boolean nobuild = false;
    private static BedWars plugin;

    public EndCountdown(BedWars plugin) {
        EndCountdown.plugin = plugin;
    }

    @Override
    public void start() {
        if (!Settings.cfg.getBoolean("Edit_Mode")) {
            nobuild = true;


            taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(BedWars.getPlugin(), () -> {
                switch (seconds) {
                    case 10:
                    case 5:
                    case 3:
                    case 2:
                    case 1:
                        YamlConfiguration cfg = Messages.cfg;
                        String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Game_Restart")).replace("%seconds%", Integer.toString(seconds)));
                        String prefix = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                        Bukkit.broadcastMessage(prefix + msg);

                        break;
                    case 0:

                        for (Player a : Bukkit.getOnlinePlayers()) {
                            YamlConfiguration cfg1 = Messages.cfg;
                            String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg1.getString("Kickmessage")));
                            String prefix1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));

                            for (Entity e : Objects.requireNonNull(Bukkit.getWorld(a.getWorld().getName())).getEntities()) {
                                if (e instanceof Item)
                                    e.remove();
                            }
                                Bukkit.getServer().unloadWorld("world", false);
                                Bukkit.getServer().createWorld(new WorldCreator("world"));
                                Bukkit.getServer().shutdown();
                                Bukkit.getServer().reload();


                        }
                        break;
                    default:
                        break;
                }
                // TODO Auto-generated method stub
                seconds--;
            }, 0, 20);
            // TODO Auto-generated method stub

        }
    }

    @Override
    public void stop() {
        if (!Var.cfg.getBoolean("Edit_Mode")) {
            nobuild = false;
            Bukkit.getScheduler().cancelTask(taskID);
            // TODO Auto-generated method stub

        }
    }

    }


