package commands;

import main.BedWars;
import org.jetbrains.annotations.NotNull;
import util.methods.Bed;
import util.methods.Messages;
import util.methods.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.IOException;
import java.util.Objects;

public class CMDsetbed implements CommandExecutor {

    private static BedWars plugin;


    public CMDsetbed(BedWars plugin) {
        CMDsetbed.plugin = plugin;
    }


    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String label, String[] args) {
        // TODO Auto-generated method stub
        if (cmd.getName().equalsIgnoreCase("setbed")) {
            if (sender instanceof Player p) {
                if (p.hasPermission("bw.setbed")) {


                    if (args.length == 1) {
                        try {
                            String platz = args[0];
                            if (platz.equalsIgnoreCase("blue") || platz.equalsIgnoreCase("red") || platz.equalsIgnoreCase("yellow") || platz.equalsIgnoreCase("green")) {

                                String world = p.getWorld().getName();
                                double x = p.getLocation().getX();
                                double y = p.getLocation().getY();
                                double z = p.getLocation().getZ();

                                Bed.cfg.set("Spawn.Bed." + platz + ".World", world);
                                Bed.cfg.set("Spawn.Bed." + platz + ".X", x);
                                Bed.cfg.set("Spawn.Bed." + platz + ".Y", y);
                                Bed.cfg.set("Spawn.Bed." + platz + ".Z", z);


                                try {
                                    Bed.cfg.save(Bed.file);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                                YamlConfiguration cfg1 = Messages.cfg;
                                String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg1.getString("SetBed")).replace("%team%", args[0]));
                                String prefix1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                                p.sendMessage(prefix1 + msg1);


                            }
                        } catch (Exception exe) {
                            exe.printStackTrace();
                        }


                    }

                } else {
                    YamlConfiguration cfg1 = Messages.cfg;
                    String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg1.getString("Noperm")));
                    String prefix1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                    p.sendMessage(prefix1 + msg1);
                }

            }else{
                YamlConfiguration cfg1 = Messages.cfg;
                String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg1.getString("Must_Player")));
                String prefix1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                Bukkit.getConsoleSender().sendMessage(prefix1 + msg1);
            }
        }


        return false;


    }


}
