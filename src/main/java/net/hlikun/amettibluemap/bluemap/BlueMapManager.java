package net.hlikun.amettibluemap.bluemap;

import de.bluecolored.bluemap.api.BlueMapAPI;
import net.hlikun.amettibluemap.bluemap.scheduler.MarkerUpdate;
import org.bukkit.plugin.java.JavaPlugin;

public class BlueMapManager {
    public BlueMapManager(JavaPlugin plugin) {
        BlueMapAPI.onEnable(blueMapAPI -> new MarkerUpdate(blueMapAPI).runTaskTimer(plugin, 0, 30 * 20));
    }
}
