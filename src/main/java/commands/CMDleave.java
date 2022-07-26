package commands;
//Code by: PixelsDE

import org.jetbrains.annotations.NotNull;
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

import java.util.Objects;

public class CMDleave implements CommandExecutor{


    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("leave")){
            if (sender instanceof Player p){
                if (p.hasPermission("bw.leave")){

                    if (Var.playing.contains(p)){
                        try {

                            Var.playing.remove(p);
                            Var.spectating.add(p);
                            Var.blue.remove(p);
                            Var.red.remove(p);
                            Var.yellow.remove(p);
                            Var.green.remove(p);
                            p.kick(null);

                            try {
                                YamlConfiguration cfg1 = Messages.cfg;
                                String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg1.getString("Iname_Quit")).replace(("%player%"), p.getDisplayName()));
                                String prefix1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                                Bukkit.broadcastMessage(prefix1 + msg1);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                }else{
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
