package gamestates;

import main.BedWars;
import util.methods.Messages;
import util.methods.Settings;
import org.bukkit.Bukkit;

import util.methods.countdowns.LobbyCountdown;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import java.util.Objects;

public class LobbyState extends GameState {

	public static final int MIN_PLAYERS = Settings.cfg.getInt("Min_Players") -1, MAX_PLAYERS = Settings.cfg.getInt("Max_Players") -1;

	private LobbyCountdown countdown;

	@Override
	public void init() {

		if (!Settings.editmode) {
			// TODO Auto-generated method stub
			countdown = new LobbyCountdown(BedWars.getPlugin());

		}
	}

	@Override
	public void end() {

		// TODO Auto-generated method stub

		YamlConfiguration cfg1 = Messages.cfg;
		String msg1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(cfg1.getString("Game_Start")));
		String prefix1 = ChatColor.translateAlternateColorCodes('&', Objects.requireNonNull(Settings.cfg.getString("Prefix")));
		Bukkit.broadcastMessage(prefix1 + msg1);

	}

	public LobbyCountdown getCountdown() {


		return countdown;
	}

}
