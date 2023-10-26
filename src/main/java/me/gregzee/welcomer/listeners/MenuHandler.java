package me.gregzee.welcomer.listeners;

import me.gregzee.welcomer.Welcomer;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class MenuHandler implements Listener {

    private final Welcomer plugin;

    public MenuHandler(Welcomer plugin) {
        this.plugin = plugin;
    }

    // This method is called when a player clicks in an inventory menu
    @EventHandler
    public void onInventoryClick(InventoryClickEvent e) {
        // Get the player who clicked
        Player p = (Player) e.getWhoClicked();
        // You can now handle the event for this player, e.g., check which item they clicked and respond accordingly
    }
}
