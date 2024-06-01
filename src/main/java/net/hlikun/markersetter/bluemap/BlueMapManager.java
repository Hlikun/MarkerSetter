package net.hlikun.markersetter.bluemap;

import de.bluecolored.bluemap.api.BlueMapAPI;
import net.hlikun.markersetter.bluemap.scheduler.MarkerUpdate;
import net.hlikun.markersetter.tools.Configs;
import org.bukkit.plugin.java.JavaPlugin;

public class BlueMapManager {
    public BlueMapManager(JavaPlugin plugin) {
        BlueMapAPI.onEnable(blueMapAPI -> new MarkerUpdate(blueMapAPI).runTaskTimer(plugin, 0, Configs.getMarkerUpdateInterval()));
    }
}
