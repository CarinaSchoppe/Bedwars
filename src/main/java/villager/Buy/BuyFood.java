package villager.Buy;
// Made by PixelsDE /
// Minecraft-Developer /
// Copyright PixelsDE /
// youtube.com/bypixels /

import util.methods.Messages;
import util.methods.Settings;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Objects;

public class BuyFood implements Listener {

    @EventHandler
    public void onBuy(InventoryClickEvent e) {
        YamlConfiguration cfg = Messages.cfg;
        String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("No_Material")));
        String prefix = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
        Player p = (Player) e.getWhoClicked();
        ItemStack i = e.getCurrentItem();


        org.bukkit.inventory.Inventory inv = e.getClickedInventory();

        e.getView().title();
        if (e.getView().getTitle().equalsIgnoreCase("§6Food")) {
            e.setCancelled(true);
            p.updateInventory();

            if (Objects.requireNonNull(i).getType().equals(Material.APPLE)) {
                if (p.getInventory().contains(Material.GOLD_INGOT, 1)) {
                    ItemStack item = new ItemStack(Material.GOLD_INGOT, 1);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("§6Gold");
                    item.setItemMeta(meta);
                    p.getInventory().removeItem(item);
                    p.getInventory().addItem(i);
                    p.updateInventory();
                } else {
                    p.sendMessage(prefix + msg);
                }
            } else if (i.getType().equals(Material.COOKED_BEEF)) {
                if (p.getInventory().contains(Material.GOLD_INGOT, 3)) {
                    ItemStack item = new ItemStack(Material.GOLD_INGOT, 3);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("§6Gold");
                    item.setItemMeta(meta);
                    p.getInventory().removeItem(item);
                    p.getInventory().addItem(i);
                    p.updateInventory();
                } else {
                    p.sendMessage(prefix + msg);
                }

            } else if (i.getType().equals(Material.GOLDEN_APPLE)) {

                if (p.getInventory().contains(Material.EMERALD, 1)) {
                    ItemStack item = new ItemStack(Material.EMERALD, 1);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("§aEmerald");
                    item.setItemMeta(meta);
                    p.getInventory().removeItem(item);
                    p.getInventory().addItem(i);
                    p.updateInventory();
                } else {
                    p.sendMessage(prefix + msg);
                }

            }

        }


    }


}





