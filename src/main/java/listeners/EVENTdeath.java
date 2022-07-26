package listeners;

import main.BedWars;
import util.Scoreboard;
import gamestates.GameState;
import util.methods.Factory;
import util.methods.Messages;
import util.methods.Settings;
import util.methods.Var;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

import java.util.Objects;

public class EVENTdeath implements Listener {

    public EVENTdeath(BedWars plugin) {
    }


    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = e.getEntity();
        if (Var.playing.contains(p)) {
            if (Var.green.contains(p)) {
                YamlConfiguration cfg = Messages.cfg;
                if (Var.bed_green) {


                    String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Respawn")));
                    String prefix = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                    p.sendMessage(prefix + msg);
                    String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("deathmessage")).replace("%player%", p.getDisplayName()));

                    e.setDeathMessage(prefix + msg1);

                    p.teleport(Factory.getConfigLocation("Spawn.green", Var.cfg));

                } else {


                    String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Out")));
                    String prefix = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                    p.sendMessage(prefix + msg);
                    Var.playing.remove(p);
                    p.teleport(Factory.getConfigLocation("Spawn.Spectator", Var.cfg));
                    Var.spectating.add(p);
                    String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("deathmessage")).replace("%player%", p.getDisplayName()));
                    p.setDisplayName("7" + p.getName());
                    p.setPlayerListName("§7" + p.getName());
                    e.setDeathMessage(prefix + msg1);
                    p.setGameMode(GameMode.SPECTATOR);
                    Var.green.remove(p);
                    String msg21 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Left_Green")).replace("%size%", Integer.toString(Var.green.size())));
                    String prefix1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                    Bukkit.broadcastMessage(prefix1 + msg21);
                    p.setDisplayName("§7" + p.getName());
                    p.setPlayerListName("§7" + p.getName());
                    Scoreboard.updateScoreboard(p);
                    GameState.checkWinning();
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        if (Var.playing.contains(all)) {
                            if (Var.spectating.contains(p)) {
                                all.hidePlayer(p);
                            }
                        }
                    }

                }

            } else if (Var.blue.contains(p)) {
                if (Var.bed_blue) {

                    p.teleport(Factory.getConfigLocation("Spawn.blue", Var.cfg));
                    YamlConfiguration cfg = Messages.cfg;
                    String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Respawn")));
                    String prefix = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                    p.sendMessage(prefix + msg);

                    String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("deathmessage")).replace("%player%", p.getDisplayName()));

                    e.setDeathMessage(prefix + msg1);

                } else {


                    YamlConfiguration cfg = Messages.cfg;
                    String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Out")));
                    String prefix = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                    p.sendMessage(prefix + msg);
                    Var.playing.remove(p);
                    Var.spectating.add(p);
                    p.setGameMode(GameMode.SPECTATOR);
                    GameState.checkWinning();
                    p.teleport(Factory.getConfigLocation("Spawn.Spectator", Var.cfg));
                    Var.blue.remove(p);
                    String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Left_Blue")).replace("%size%", Integer.toString(Var.blue.size())));
                    String prefix1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                    Bukkit.broadcastMessage(prefix1 + msg1);
                    GameState.checkWinning();
                    String msg11 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("deathmessage")).replace("%player%", p.getDisplayName()));
                    p.setDisplayName("§7" + p.getName());
                    e.setDeathMessage(prefix + msg11);
                    p.setDisplayName("7" + p.getName());
                    Scoreboard.updateScoreboard(p);
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        if (Var.playing.contains(all)) {
                            if (Var.spectating.contains(p)) {
                                all.hidePlayer(p);
                            }

                        }

                    }
                }
            } else if (Var.red.contains(p)) {
                if (Var.bed_red) {
                    p.teleport(Factory.getConfigLocation("Spawn.red", Var.cfg));
                    GameState.checkWinning();
                    YamlConfiguration cfg = Messages.cfg;
                    String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Respawn")));
                    String prefix = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                    p.sendMessage(prefix + msg);
                    String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("deathmessage")).replace("%player%", p.getDisplayName()));

                    e.setDeathMessage(prefix + msg1);


                } else {

                    YamlConfiguration cfg = Messages.cfg;
                    String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Out")));
                    String prefix = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                    p.sendMessage(prefix + msg);
                    Var.playing.remove(p);
                    Var.spectating.add(p);
                    p.setGameMode(GameMode.SPECTATOR);
                    p.teleport(Factory.getConfigLocation("Spawn.Spectator", Var.cfg));
                    Var.red.remove(p);

                    GameState.checkWinning();
                    String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Left_Red")).replace("%size%", Integer.toString(Var.red.size())));
                    String prefix1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                    Bukkit.broadcastMessage(prefix1 + msg1);
                    GameState.checkWinning();
                    String msg11 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("deathmessage")).replace("%player%", p.getDisplayName()));
                    p.setDisplayName("7" + p.getName());
                    e.setDeathMessage(prefix + msg11);
                    p.setDisplayName("§7" + p.getName());
                    Scoreboard.updateScoreboard(p);
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        if (Var.playing.contains(all)) {
                            if (Var.spectating.contains(p)) {
                                all.hidePlayer(p);
                            }
                        }
                    }
                }
            } else if (Var.yellow.contains(p)) {
                if (Var.bed_yellow) {

                    p.teleport(Factory.getConfigLocation("Spawn.yellow", Var.cfg));
                    YamlConfiguration cfg = Messages.cfg;
                    String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Respawn")));
                    String prefix = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                    p.sendMessage(prefix + msg);
                    String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("deathmessage")).replace("%player%", p.getDisplayName()));

                    e.setDeathMessage(prefix + msg1);

                } else {

                    YamlConfiguration cfg = Messages.cfg;
                    String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Out")));
                    String prefix = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                    p.sendMessage(prefix + msg);
                    p.setGameMode(GameMode.SPECTATOR);
                    Var.playing.remove(p);
                    Var.spectating.add(p);
                    Var.yellow.remove(p);
                    String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Left_Yellow")).replace("%size%", Integer.toString(Var.yellow.size())));
                    String prefix1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                    Bukkit.broadcastMessage(prefix1 + msg1);
                    p.teleport(Factory.getConfigLocation("Spawn.Spectator", Var.cfg));
                    GameState.checkWinning();
                    String msg11 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("deathmessage")).replace("%player%", p.getDisplayName()));

                    e.setDeathMessage(prefix + msg11);

                    p.setDisplayName("§7" + p.getName());

                    p.setPlayerListName("7" + p.getName());
                    Scoreboard.updateScoreboard(p);
                    for (Player all : Bukkit.getOnlinePlayers()) {
                        if (Var.playing.contains(all)) {
                            if (Var.spectating.contains(p)) {
                                all.hidePlayer(p);
                            }
                        }
                    }
                }
            }
        }

    }

}
