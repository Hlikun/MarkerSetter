package net.hlikun.amettibluemap;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin {
    private static JavaPlugin plugin;

    // YamlFile
    private static File markerFile;
    private static YamlConfiguration markers;

    @Override
    public void onEnable() {
        // Plugin startup logic
        super.onEnable();

        plugin = this;

        // YamlFile
        markerFile = new File(getDataFolder(), "marker.yml");
        markers = YamlConfiguration.loadConfiguration(markerFile);

        getLogger().info("プラグインは正常に起動しました。");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        super.onDisable();

        getLogger().info("プラグインは正常に停止しました。");
    }

    public static JavaPlugin getPlugin() {
        return plugin;
    }

    public static File getMarkerFile() {
        return markerFile;
    }

    public static YamlConfiguration getMarkers() {
        return markers;
    }
}
