
package util;


import main.BedWars;
import util.methods.Messages;
import util.methods.Settings;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.BufferedReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class Autoupdater {

    private static BedWars plugin;
    public Autoupdater(BedWars plugin){

        Autoupdater.plugin = plugin;

    }

    public void checkUpdate(String resourceId) {
        YamlConfiguration cfg1 = Settings.cfg;
        boolean ja = Settings.cfg.getBoolean("Autoupdate");
        if (ja) {
            try {
                HttpURLConnection con = (HttpURLConnection) new URL("http://www.spigotmc.org/api/general.php")
                        .openConnection();
                con.setDoOutput(true);
                con.setRequestMethod("POST");
                con.getOutputStream().write(("key=98BE0FE67F88AB82B4C197FAF1DC3B69206EFDCC4D3B80FC83A00037510B99B4&resource=" + resourceId)
                        .getBytes(StandardCharsets.UTF_8));
                String version = new BufferedReader(new java.io.InputStreamReader(con.getInputStream())).readLine();
                if (!version.equals(BedWars.getPlugin().getDescription().getVersion())) {
                    YamlConfiguration cfg = Messages.cfg;
                    String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Autoupdate")));
                    String prefix = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                    Bukkit.getConsoleSender().sendMessage(prefix + msg);
                } else {
                    YamlConfiguration cfg = Messages.cfg;
                    String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Update_True")));
                    String prefix = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                    Bukkit.getConsoleSender().sendMessage(prefix + msg);
                }
            } catch (Exception ex) {
                YamlConfiguration cfg = Messages.cfg;
                String msg = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg.getString("Update_Error")));
                String prefix = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
                Bukkit.getConsoleSender().sendMessage(prefix + msg);
            }
        }

    }


}
