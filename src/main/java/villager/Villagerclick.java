package villager;

import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEntityEvent;

import java.util.Objects;

//C ode by: PixelsDE /
// All rights reserved! /
// Website: bypixels.weebly.com /
// Youtube: byPixels /
public class Villagerclick implements Listener{


    @EventHandler
    public void onInteract(PlayerInteractEntityEvent e){
        EntityType entity = EntityType.VILLAGER;
        if (e.getRightClicked().getType().equals(entity)){
            Objects.requireNonNull(entity.getName());
        }

    }


}
