package commands;

import main.BedWars;
import org.jetbrains.annotations.NotNull;
import util.methods.Factory;
import util.methods.Messages;
import util.methods.Settings;
import util.methods.Var;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.Objects;

public class CMDsetspawn implements CommandExecutor {

    final File file = Var.cfgFile;
    final YamlConfiguration cfg = Var.cfg;

    public CMDsetspawn(BedWars plugin) {
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String label, String[] args) {
        // TODO Auto-generated method stub
        if (cmd.getName().equalsIgnoreCase("setspawn")) {
            if (sender instanceof Player p) {
                if (p.hasPermission("bw.setspawn")) {


                    if (args.length == 1) {
                        try {
                            String platz = args[0];
                            if (platz.equalsIgnoreCase("blue") || platz.equalsIgnoreCase("red") || platz.equalsIgnoreCase("yellow") || platz.equalsIgnoreCase("green")) {
                                Factory.createConfiguration(p.getLocation(), "Spawn." + platz, file, cfg);
                                YamlConfiguration cfg1 = Messages.cfg;
                                String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg1.getString("SetSpawns")).replace("%team%", args[0]));
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
