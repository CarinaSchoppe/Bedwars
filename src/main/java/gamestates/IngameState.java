package gamestates;

import main.BedWars;
import util.methods.*;
import util.methods.countdowns.EndCountdown;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class IngameState extends GameState {

    public static boolean spawners = false;
    private static BedWars plugin;
    private EndCountdown endCountdown;

    public IngameState(BedWars plugin) {
        IngameState.plugin = plugin;
    }

    @Override
    public void init() {
        if (!Settings.editmode) {
            endCountdown = new EndCountdown(BedWars.getPlugin());
            // TODO Auto-generated method stub
            for (int i = 0; i < Var.playing.size(); i++) {
                Player p = Var.playing.get(i);


                Var.plays.remove(p);
                p.getInventory().clear();


                RushSpawner rs = new RushSpawner(plugin);
                rs.startSpawners();

                if (Var.blue.contains(p)) {
                    try {
                        p.teleport(Factory.getConfigLocation("Spawn.blue", Var.cfg));
                        p.setGameMode(GameMode.SURVIVAL);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (Var.red.contains(p)) {
                    try {
                        p.teleport(Factory.getConfigLocation("Spawn.red", Var.cfg));
                        p.setGameMode(GameMode.SURVIVAL);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (Var.green.contains(p)) {

                    try {

                        p.teleport(Factory.getConfigLocation("Spawn.green", Var.cfg));
                        p.setGameMode(GameMode.SURVIVAL);
                    } catch (Exception ignored) {

                    }
                } else if (Var.yellow.contains(p)) {
                    try {
                        p.teleport(Factory.getConfigLocation("Spawn.yellow", Var.cfg));
                        p.setGameMode(GameMode.SURVIVAL);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }

        }
    }

    @Override
    public void end() {
        endCountdown.start();
        // TODO Auto-generated method stub
    }

}
