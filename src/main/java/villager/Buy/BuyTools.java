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

public class BuyTools implements Listener {

    @EventHandler
    public void onBuy(InventoryClickEvent e) {
        YamlConfiguration cfg = Messages.cfg;
        String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("No_Material")));
        String prefix = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
        Player p = (Player) e.getWhoClicked();
        ItemStack i = e.getCurrentItem();

        org.bukkit.inventory.Inventory inv = e.getClickedInventory();
        e.getView().title();
        if (e.getView().getTitle().equalsIgnoreCase("§6Tools")) {
            e.setCancelled(true);
            p.updateInventory();
            if (Objects.requireNonNull(i).getType().equals(Material.WOODEN_PICKAXE)) {
                if (p.getInventory().contains(Material.GOLD_INGOT, 4)) {
                    ItemStack item = new ItemStack(Material.GOLD_INGOT, 4);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("§6Gold");
                    item.setItemMeta(meta);
                    p.getInventory().removeItem(item);
                    p.getInventory().addItem(i);
                    p.updateInventory();
                } else {
                    p.sendMessage(prefix + msg);
                }

            } else if (i.getType().equals(Material.STONE_PICKAXE)) {
                if (p.getInventory().contains(Material.GOLD_INGOT, 8)) {
                    ItemStack item = new ItemStack(Material.GOLD_INGOT, 8);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("§6Gold");
                    item.setItemMeta(meta);
                    p.getInventory().removeItem(item);
                    p.getInventory().addItem(i);
                    p.updateInventory();
                } else {
                    p.sendMessage(prefix + msg);
                }


            } else if (i.getType().equals(Material.IRON_PICKAXE)) {
                if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§6Pickaxe LV. 3")) {
                    if (p.getInventory().contains(Material.DIAMOND, 2)) {
                        ItemStack item = new ItemStack(Material.DIAMOND, 2);
                        ItemMeta meta = item.getItemMeta();
                        meta.setDisplayName("§bDiamond");
                        item.setItemMeta(meta);
                        p.getInventory().removeItem(item);
                        p.getInventory().addItem(i);
                        p.updateInventory();
                    } else {
                        p.sendMessage(prefix + msg);
                    }

                } else if (i.getItemMeta().getDisplayName().equalsIgnoreCase("§6Pickaxe LV. 4")) {
                    if (p.getInventory().contains(Material.DIAMOND, 5)) {
                        ItemStack item = new ItemStack(Material.DIAMOND, 5);
                        ItemMeta meta = item.getItemMeta();
                        meta.setDisplayName("§bDiamond");
                        item.setItemMeta(meta);
                        p.getInventory().removeItem(item);
                        p.getInventory().addItem(i);
                        p.updateInventory();
                    } else {
                        p.sendMessage(prefix + msg);
                    }
                }

            } else if (i.getType().equals(Material.STONE_PICKAXE)) {
                if (p.getInventory().contains(Material.DIAMOND, 2)) {

                    ItemStack item = new ItemStack(Material.DIAMOND, 2);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("§bDiamond");
                    item.setItemMeta(meta);
                    p.getInventory().removeItem(item);
                    p.getInventory().addItem(i);
                    p.updateInventory();
                } else {
                    p.sendMessage(prefix + msg);
                }


            } else if (i.getType().equals(Material.IRON_AXE)) {
                if (p.getInventory().contains(Material.DIAMOND, 5)) {

                    ItemStack item = new ItemStack(Material.DIAMOND, 5);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("§bDiamond");
                    item.setItemMeta(meta);
                    p.getInventory().removeItem(item);
                    p.getInventory().addItem(i);
                    p.updateInventory();

                } else {
                    p.sendMessage(prefix + msg);
                }

            } else if (i.getType().equals(Material.SHEARS)) {
                if (p.getInventory().contains(Material.DIAMOND, 3)) {

                    ItemStack item = new ItemStack(Material.DIAMOND, 3);
                    ItemMeta meta = item.getItemMeta();
                    meta.setDisplayName("§bDiamond");
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
