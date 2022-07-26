package listeners;
// Made by PixelsDE /
// Minecraft-Developer /
// Copyright PixelsDE /
// youtube.com/bypixels /

import util.methods.Messages;
import util.methods.Settings;
import util.methods.Var;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.server.ServerListPingEvent;

import java.util.ArrayList;
import java.util.Objects;


public class EVENTmap implements Listener {


    public static final ArrayList<Block> playerblock = new ArrayList<>();

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        if (!Settings.cfg.getBoolean("Edit_Mode")) {
            Player p = e.getPlayer();

            if (Var.playing.contains(p)) {
                playerblock.add(e.getBlock());
            }
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        if (!Settings.cfg.getBoolean("Edit_Mode")) {
            if (playerblock.contains(e.getBlock())) {

            } else {
                if (e.getBlock().getType() == Material.RED_BED || e.getBlock().getType().equals(Material.BEDROCK)) {

                } else {
                    YamlConfiguration cfg = Messages.cfg;
                    String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Map_Break")));
                    String prefix = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                    e.getPlayer().sendMessage(prefix + msg.replace("%block%", e.getBlock().getType().name()));
                    e.setCancelled(true);
                }
            }

        }
    }

    @EventHandler
    public void onPing(ServerListPingEvent event) {

        event.setMaxPlayers(Settings.cfg.getInt("Max_Players"));
    }
}
