package listeners;
// Made by PixelsDE /
// Minecraft-Developer /
// Copyright PixelsDE /
// youtube.com/bypixels /

import main.BedWars;
import gamestates.GameState;
import util.methods.Factory;
import util.methods.Messages;
import util.methods.Settings;
import util.methods.Var;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Objects;

public class EVENTkill implements Listener {


    public EVENTkill(BedWars plugin) {
    }


    @EventHandler
    public void onDeath(PlayerDeathEvent e) {

        try {
            if (!Settings.cfg.getBoolean("Edit_Mode")) {
                e.deathMessage(null);
                Player p = e.getEntity();
                Player killer = e.getEntity().getKiller();


                p.getInventory().clear();


                YamlConfiguration cfg = Messages.cfg;
                String prefix = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                Objects.requireNonNull(e.getEntity().getPlayer()).getInventory().clear();
                if (Var.playing.contains(p)) {
                    if (Var.blue.contains(p)) {
                        if (Var.bed_blue) {
                            if (Objects.requireNonNull(p.getLastDamageCause()).getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {
                                String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Respawn")));
                                String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Death_Message")).replace("%player%", p.getDisplayName()).replace("%killer%", Objects.requireNonNull(killer).getDisplayName()));
                                e.setDeathMessage(msg);
                                p.teleport(Factory.getConfigLocation("Spawn.blue", Var.cfg));
                                p.sendMessage(msg1);
                                GameState.checkWinning();
                                for (Player a : Bukkit.getOnlinePlayers())
                                    util.Scoreboard.updateScoreboard(a);
                            } else {
                                String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Deathmessage")).replace("%player%", p.getDisplayName()));
                                String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Respawn")));
                                e.setDeathMessage(msg);
                                p.teleport(Factory.getConfigLocation("Spawn.blue", Var.cfg));
                                p.sendMessage(msg1);
                                GameState.checkWinning();
                                for (Player a : Bukkit.getOnlinePlayers())
                                    util.Scoreboard.updateScoreboard(a);
                            }
                        } else {
                            if (Objects.requireNonNull(p.getLastDamageCause()).getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {
                                Var.blue.remove(p);
                                String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Out")));
                                String msg2 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Left_Blue")).replace("%size%", Integer.toString(Var.blue.size())));
                                String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Death_Message")).replace("%player%", p.getDisplayName()).replace("%killer%", Objects.requireNonNull(killer).getDisplayName()));
                                e.setDeathMessage(msg);
                                Bukkit.broadcastMessage(msg2);
                                p.teleport(Factory.getConfigLocation("Spawn.Spectator", Var.cfg));
                                p.sendMessage(msg1);
                                p.setDisplayName("§7" + p.getName());
                                p.setPlayerListName("§7" + p.getName());
                                Var.playing.remove(p);
                                Var.spectating.add(p);
                                GameState.checkWinning();
                                for (Player a : Bukkit.getOnlinePlayers())
                                    util.Scoreboard.updateScoreboard(a);
                            } else {
                                Var.blue.remove(p);
                                String msg2 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Left_Blue")).replace("%size%", Integer.toString(Var.blue.size())));
                                String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Deathmessage")).replace("%player%", p.getDisplayName()));
                                String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Out")));
                                e.setDeathMessage(msg);
                                p.teleport(Factory.getConfigLocation("Spawn.Spectator", Var.cfg));
                                p.sendMessage(msg1);
                                p.setDisplayName("§7" + p.getName());
                                p.setPlayerListName("§7" + p.getName());
                                Var.playing.remove(p);
                                Var.spectating.add(p);
                                Bukkit.broadcastMessage(msg2);
                                GameState.checkWinning();
                                for (Player a : Bukkit.getOnlinePlayers())
                                    util.Scoreboard.updateScoreboard(a);
                            }
                        }
                    } else if (Var.green.contains(p)) {
                        if (Var.bed_green) {
                            if (Objects.requireNonNull(p.getLastDamageCause()).getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {
                                String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Respawn")));
                                String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Death_Message")).replace("%player%", p.getDisplayName()).replace("%killer%", Objects.requireNonNull(killer).getDisplayName()));
                                e.setDeathMessage(msg);
                                p.teleport(Factory.getConfigLocation("Spawn.green", Var.cfg));
                                p.sendMessage(msg1);
                                GameState.checkWinning();
                                for (Player a : Bukkit.getOnlinePlayers())
                                    util.Scoreboard.updateScoreboard(a);
                            } else {
                                String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Deathmessage")).replace("%player%", p.getDisplayName()));
                                String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Respawn")));
                                e.setDeathMessage(msg);
                                p.teleport(Factory.getConfigLocation("Spawn.green", Var.cfg));
                                p.sendMessage(msg1);
                                GameState.checkWinning();
                                for (Player a : Bukkit.getOnlinePlayers())
                                    util.Scoreboard.updateScoreboard(a);
                            }
                        } else {
                            if (Objects.requireNonNull(p.getLastDamageCause()).getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {
                                Var.green.remove(p);
                                String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Out")));
                                String msg2 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Left_Green")).replace("%size%", Integer.toString(Var.green.size())));
                                String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Death_Message")).replace("%player%", p.getDisplayName()).replace("%killer%", Objects.requireNonNull(killer).getDisplayName()));
                                e.setDeathMessage(msg);
                                Bukkit.broadcastMessage(msg2);
                                p.teleport(Factory.getConfigLocation("Spawn.Spectator", Var.cfg));
                                p.sendMessage(msg1);
                                p.setDisplayName("§7" + p.getName());
                                p.setPlayerListName("§7" + p.getName());
                                Var.playing.remove(p);
                                Var.spectating.add(p);
                                GameState.checkWinning();
                                for (Player a : Bukkit.getOnlinePlayers())
                                    util.Scoreboard.updateScoreboard(a);
                            } else {
                                Var.green.remove(p);
                                String msg2 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Left_Green")).replace("%size%", Integer.toString(Var.green.size())));
                                String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Deathmessage")).replace("%player%", p.getDisplayName()));
                                String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Out")));
                                e.setDeathMessage(msg);
                                p.teleport(Factory.getConfigLocation("Spawn.Spectator", Var.cfg));
                                p.sendMessage(msg1);
                                p.setDisplayName("§7" + p.getName());
                                p.setPlayerListName("§7" + p.getName());
                                Var.playing.remove(p);
                                Var.spectating.add(p);
                                Bukkit.broadcastMessage(msg2);
                                GameState.checkWinning();
                                for (Player a : Bukkit.getOnlinePlayers())
                                    util.Scoreboard.updateScoreboard(a);
                            }
                        }
                    } else if (Var.red.contains(p)) {
                        if (Var.bed_red) {
                            if (Objects.requireNonNull(p.getLastDamageCause()).getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {
                                String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Respawn")));
                                String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Death_Message")).replace("%player%", p.getDisplayName()).replace("%killer%", Objects.requireNonNull(killer).getDisplayName()));
                                e.setDeathMessage(msg);
                                p.teleport(Factory.getConfigLocation("Spawn.red", Var.cfg));
                                p.sendMessage(msg1);
                                GameState.checkWinning();
                                for (Player a : Bukkit.getOnlinePlayers())
                                    util.Scoreboard.updateScoreboard(a);
                            } else {
                                String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Deathmessage")).replace("%player%", p.getDisplayName()));
                                String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Respawn")));
                                e.setDeathMessage(msg);
                                p.teleport(Factory.getConfigLocation("Spawn.red", Var.cfg));
                                p.sendMessage(msg1);
                                GameState.checkWinning();
                                for (Player a : Bukkit.getOnlinePlayers())
                                    util.Scoreboard.updateScoreboard(a);


                            }
                        } else {
                            if (Objects.requireNonNull(p.getLastDamageCause()).getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {
                                Var.red.remove(p);
                                String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Out")));
                                String msg2 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Left_Red")).replace("%size%", Integer.toString(Var.red.size())));
                                String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Death_Message")).replace("%player%", p.getDisplayName()).replace("%killer%", Objects.requireNonNull(killer).getDisplayName()));
                                e.setDeathMessage(msg);
                                Bukkit.broadcastMessage(msg2);
                                p.teleport(Factory.getConfigLocation("Spawn.Spectator", Var.cfg));
                                p.sendMessage(msg1);
                                p.setDisplayName("§7" + p.getName());
                                p.setPlayerListName("§7" + p.getName());
                                Var.playing.remove(p);
                                Var.spectating.add(p);
                                GameState.checkWinning();
                                for (Player a : Bukkit.getOnlinePlayers())
                                    util.Scoreboard.updateScoreboard(a);
                            } else {
                                Var.red.remove(p);
                                String msg2 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Left_Red")).replace("%size%", Integer.toString(Var.red.size())));
                                String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Deathmessage")).replace("%player%", p.getDisplayName()));
                                String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Out")));
                                e.setDeathMessage(msg);
                                p.teleport(Factory.getConfigLocation("Spawn.Spectator", Var.cfg));
                                p.sendMessage(msg1);
                                p.setDisplayName("§7" + p.getName());
                                p.setPlayerListName("§7" + p.getName());
                                Var.playing.remove(p);
                                Var.spectating.add(p);
                                GameState.checkWinning();
                                Bukkit.broadcastMessage(msg2);
                                for (Player a : Bukkit.getOnlinePlayers())
                                    util.Scoreboard.updateScoreboard(a);
                            }
                        }
                    } else if (Var.yellow.contains(p)) {
                        if (Var.bed_yellow) {
                            if (Objects.requireNonNull(p.getLastDamageCause()).getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {
                                String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Respawn")));
                                String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Death_Message")).replace("%player%", p.getDisplayName()).replace("%killer%", Objects.requireNonNull(killer).getDisplayName()));
                                e.setDeathMessage(msg);
                                p.teleport(Factory.getConfigLocation("Spawn.yellow", Var.cfg));
                                p.sendMessage(msg1);
                                GameState.checkWinning();
                                for (Player a : Bukkit.getOnlinePlayers())
                                    util.Scoreboard.updateScoreboard(a);
                            } else {
                                String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Deathmessage")).replace("%player%", p.getDisplayName()));
                                String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Respawn")));
                                e.setDeathMessage(msg);
                                p.teleport(Factory.getConfigLocation("Spawn.yellow", Var.cfg));
                                p.sendMessage(msg1);
                                GameState.checkWinning();
                                for (Player a : Bukkit.getOnlinePlayers())
                                    util.Scoreboard.updateScoreboard(a);
                            }
                        } else {
                            if (Objects.requireNonNull(p.getLastDamageCause()).getCause().equals(EntityDamageEvent.DamageCause.ENTITY_ATTACK)) {
                                Var.yellow.remove(p);
                                String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Out")));
                                String msg2 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Left_Yellow")).replace("%size%", Integer.toString(Var.yellow.size())));
                                String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Death_Message")).replace("%player%", p.getDisplayName()).replace("%killer%", Objects.requireNonNull(killer).getDisplayName()));
                                e.setDeathMessage(msg);
                                Bukkit.broadcastMessage(msg2);
                                p.teleport(Factory.getConfigLocation("Spawn.Spectator", Var.cfg));
                                p.sendMessage(msg1);
                                p.setDisplayName("§7" + p.getName());
                                p.setPlayerListName("§7" + p.getName());
                                Var.playing.remove(p);
                                Var.spectating.add(p);
                                GameState.checkWinning();
                                for (Player a : Bukkit.getOnlinePlayers())
                                    util.Scoreboard.updateScoreboard(a);
                            } else {
                                Var.yellow.remove(p);
                                String msg2 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Left_Yellow")).replace("%size%", Integer.toString(Var.yellow.size())));
                                String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Deathmessage")).replace("%player%", p.getDisplayName()));
                                String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Out")));
                                e.setDeathMessage(msg);
                                p.teleport(Factory.getConfigLocation("Spawn.Spectator", Var.cfg));
                                p.sendMessage(msg1);
                                p.setDisplayName("§7" + p.getName());
                                p.setPlayerListName("§7" + p.getName());
                                Var.playing.remove(p);
                                Var.spectating.add(p);
                                GameState.checkWinning();
                                Bukkit.broadcastMessage(msg2);
                                for (Player a : Bukkit.getOnlinePlayers())
                                    util.Scoreboard.updateScoreboard(a);
                            }
                        }
                    }
                }


            }
        } catch (Exception ignored) {

        }
    }


}
