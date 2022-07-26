package util.methods;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;

import java.util.ArrayList;


public class Spectator implements Listener {

	public static final ArrayList<Player> looking = new ArrayList<>();

	@EventHandler
	public static void onClick(EntityDamageByEntityEvent e) {
		if (e.getEntity() instanceof Player target) {
			Player p = (Player) e.getDamager();
			if (Var.spectating.contains(p)) {
				if (Var.playing.contains(target)) {
					if (!looking.contains(p)) {
						looking.add(p);
						e.setCancelled(true);
						for (Player all : Bukkit.getOnlinePlayers()) {
							if (!Var.playing.contains(all)) {
								if (Var.spectating.contains(all)) {
									all.hidePlayer(p);
								}

							}
						}

					}
				}

			}

		}
	}

	@EventHandler
	public static void onShift(PlayerToggleSneakEvent e) {
		Player p = e.getPlayer();
		if (Var.spectating.contains(p)) {
			if (looking.contains(p)) {
				looking.remove(p);
				for (Player all : Bukkit.getOnlinePlayers()) {
					if (!Var.playing.contains(all)) {
						if (Var.spectating.contains(all)) {
							all.showPlayer(p);
						}

					}
				}
			}

		}
	}

}
