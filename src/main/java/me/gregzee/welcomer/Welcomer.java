package me.gregzee.welcomer;

import lombok.Getter;
import me.gregzee.welcomer.manager.StartupManager;
import org.bstats.bukkit.Metrics;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class Welcomer extends JavaPlugin {

    @Override
    public void onEnable() {

        new StartupManager(this);

    }

    @Override
    public void onDisable() {
        getLogger().info("Plugin has been uninitialized!");
    }
}
