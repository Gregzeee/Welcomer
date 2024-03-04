package me.gregzee.welcomer;

import co.aikar.commands.PaperCommandManager;
import lombok.Getter;
import me.gregzee.welcomer.managers.StartupManager;
import net.kyori.adventure.platform.bukkit.BukkitAudiences;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class Welcomer extends JavaPlugin {

    private BukkitAudiences adventure;
    private PaperCommandManager commandManager;

    @Override
    public void onEnable() {
        adventure = BukkitAudiences.create(this);
        commandManager = new PaperCommandManager(this);

        new StartupManager(this);

        enableBStats();
    }

    @Override
    public void onDisable() {
        adventure.close();
        getLogger().info("Plugin has been uninitialized!");
    }

    private void enableBStats() {
        try {
            // TODO: Replace 1 with your resource id
            new Metrics(this, 1);
        } catch (Exception e) {
            getLogger().warning("Something went wrong while enabling bStats.\n" + e.getMessage());
        }
    }
}
