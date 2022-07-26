package listeners;

import util.Scoreboard;


import util.methods.Messages;
import util.methods.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import gamestates.GameState;
import gamestates.GameStateHandler;
import gamestates.LobbyState;
import util.methods.Var;
import util.methods.countdowns.LobbyCountdown;

import java.util.Objects;

public class EVENTquit implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {

        if (!Settings.editmode) {
            e.quitMessage(null);
            Player p = e.getPlayer();
            if (GameStateHandler.getCurrentState() instanceof LobbyState ls) {

                try {
                    p.getInventory().clear();
                    p.updateInventory();
                    Var.blue.remove(p);
                    Var.red.remove(p);
                    Var.green.remove(p);
                    Var.yellow.remove(p);
                    Var.playing.remove(p);
                    Var.spectating.add(p);
                    GameState.checkWinning();
                    p.getInventory().clear();
                    YamlConfiguration cfg = Messages.cfg;
                    String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Game_Quit")).replace("%max_players%", Integer.toString(Settings.cfg.getInt("Max_Players")))).replace("%player%", p.getDisplayName()).replace("%playing%", Integer.toString(Var.playing.size()));
                    String prefix = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                    Bukkit.broadcastMessage(prefix + msg);
                    GameState.checkWinning();
                    for (Player a : Bukkit.getOnlinePlayers())
                        Scoreboard.updateScoreboard(a);
                } catch (Exception exe) {
                    // TODO: handle exception
                }


                if (Var.playing.size() < LobbyState.MIN_PLAYERS) {
                    if (LobbyCountdown.isRunning) {
                        ls.getCountdown().stopCountDown();
                        ls.getCountdown().idle();

                    }

                }
            } else {
                p.getInventory().clear();
                p.updateInventory();
                if (Var.playing.contains(p)) {
                    Var.playing.remove(p);
                    Var.spectating.add(p);
                    YamlConfiguration cfg = Messages.cfg;
                    String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Ingame_Quit")).replace("%player%", p.getDisplayName()));
                    String prefix = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                    Bukkit.broadcastMessage(prefix + msg);
                    GameState.checkWinning();
                    try {
                        for (Player a : Bukkit.getOnlinePlayers())
                            Scoreboard.updateScoreboard(a);
                    } catch (Exception ignored) {

                    }


                }
            }
        }
    }


    @EventHandler
    public void shutdown(PlayerQuitEvent e){
        if (Bukkit.getOnlinePlayers().size() ==0){
            Bukkit.getServer().reload();

        }
    }

}
