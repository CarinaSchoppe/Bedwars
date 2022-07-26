package util.methods.countdowns;

import main.BedWars;
import gamestates.GameState;
import gamestates.GameStateHandler;
import gamestates.LobbyState;
import util.methods.Messages;
import util.methods.Settings;
import util.methods.Var;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.util.Objects;

public class LobbyCountdown extends Countdown {

    public static boolean isIdling = false, isRunning = false;
    private int seconds = 60;
    private int taskID, idleID;
    public LobbyCountdown(BedWars plugin) {
    }


    final YamlConfiguration cfg = Messages.cfg;
    final String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Game_Timer")).replace("%seconds%", Integer.toString(seconds)));
    final String prefix = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
    @Override
    public void start() {
        if (!Settings.cfg.getBoolean("Edit_Mode")) {
            isRunning = true;

            taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(BedWars.getPlugin(), () -> {
                if (!Settings.cfg.getBoolean("Edit_Mode")) {
                    seconds--;
                    for (Player a : Var.playing)
                        if (Var.plays.contains(a)) {
                            a.setLevel(seconds);
                        }

                    switch (seconds) {
                        case 30, 2, 3, 5, 10, 15 -> {
                            for (Player all : Bukkit.getOnlinePlayers())
                                all.sendMessage(prefix + msg);
                            for (Player a : Var.playing)
                                a.playSound(a.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
                        }
                        case 1 -> {
                            YamlConfiguration cfg1 = Messages.cfg;
                            String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg1.getString("Game_Timer")).replace("%seconds%", Integer.toString(seconds)));
                            String prefix1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                            for (Player all : Bukkit.getOnlinePlayers())
                                all.sendMessage(prefix1 + msg1);
                            for (Player a : Var.playing)
                                a.playSound(a.getLocation(), Sound.BLOCK_LAVA_POP, 1, 1);
                        }
                        case 0 -> GameStateHandler.setGameState(GameState.INGAME_STATE);
                        default -> {
                        }
                    }
                    // TODO Auto-generated method stub

                }else{
                    LobbyCountdown.isRunning = false;
                    LobbyCountdown.isIdling = false;
                }
            }, 0, 20);


        } else {
            stop();
            stopIdle();
            stopCountDown();
        }
    }

    public void idle() {
        if (!Settings.cfg.getBoolean("Edit_Mode")) {
            isIdling = true;
            idleID = Bukkit.getScheduler().scheduleSyncRepeatingTask(BedWars.getPlugin(), () -> {

                int missing = LobbyState.MIN_PLAYERS - Var.playing.size();
                YamlConfiguration cfg = Messages.cfg;
                String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Missing_Player")).replace("%missing%", Integer.toString(missing)));
                String prefix = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                Bukkit.broadcastMessage(prefix + msg);
                // TODO Auto-generated method stub

            }, 0, 20 * 10);

        }
    }

    public void stopIdle() {

        if (isIdling)
            isIdling = false;
        Bukkit.getScheduler().cancelTask(idleID);

    }

    public void stopCountDown() {
        if (!Settings.cfg.getBoolean("Edit_Mode")) {
            if (isRunning) {
                isRunning = false;
                Bukkit.getScheduler().cancelTask(taskID);
                seconds = 60;
                for (Player a : Var.playing)
                    a.setLevel(0);
            }
        }

    }

    public void stop() {
        isIdling = false;
        isRunning = false;
        // TODO Auto-generated method stub
        seconds = 60;
        Bukkit.getScheduler().cancelTask(taskID);

        Bukkit.getScheduler().cancelTask(idleID);
    }

    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

}
