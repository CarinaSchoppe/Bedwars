package commands;
// Made by PixelsDE 
// Project: main
// Copyright PixelsDE
// youtube.com/bypixels
// Date: 12.01.2018
// Package: commands
// Created by: Daniel

import org.jetbrains.annotations.NotNull;
import util.methods.Messages;
import util.methods.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Objects;

public class CMDvotegold implements CommandExecutor {

    public static final ArrayList<Player> yes = new ArrayList<>();
    public static final ArrayList<Player> no = new ArrayList<>();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, Command cmd, @NotNull String label, String[] args) {

        if (cmd.getName().equalsIgnoreCase("vote")) {
            if (sender instanceof Player p) {
                if (p.hasPermission("bw.emeraldvote")) {

                    if (yes.contains(p)) {
                        yes.remove(p);
                        no.add(p);

                        YamlConfiguration cfg1 = Messages.cfg;
                        String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg1.getString("Vote_No")));
                        String prefix1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                        p.sendMessage(prefix1 + msg1);


                    } else if (no.contains(p)) {
                        no.remove(p);
                        yes.add(p);

                        YamlConfiguration cfg1 = Messages.cfg;
                        String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg1.getString("Vote_Yes")));
                        String prefix1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                        p.sendMessage(prefix1 + msg1);

                    }


                } else {
                    YamlConfiguration cfg1 = Messages.cfg;
                    String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg1.getString("Noperm")));
                    String prefix1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                    p.sendMessage(prefix1 + msg1);
                }

            } else {
                YamlConfiguration cfg1 = Messages.cfg;
                String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg1.getString("Must_Player")));
                String prefix1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                Bukkit.getConsoleSender().sendMessage(prefix1 + msg1);
            }
        }

        return false;
    }
}
