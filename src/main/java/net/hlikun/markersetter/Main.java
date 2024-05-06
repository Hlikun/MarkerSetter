package net.hlikun.markersetter;

import net.hlikun.markersetter.bluemap.BlueMapManager;
import net.hlikun.markersetter.command.MarkerCommandCompleter;
import net.hlikun.markersetter.command.MarkerCommandExecutor;
import net.hlikun.markersetter.tools.Util;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Objects;

public final class Main extends JavaPlugin {
    private static JavaPlugin plugin;

    // Yaml file
    private static File markerFile;
    private static YamlConfiguration markers;

    @Override
    public void onEnable() {
        // Plugin startup logic
        super.onEnable();

        plugin = this;

        // Yaml file
        markerFile = new File(getDataFolder(), "marker.yml");
        markers = YamlConfiguration.loadConfiguration(markerFile);

        // command
        Objects.requireNonNull(getCommand("marker")).setExecutor(new MarkerCommandExecutor());
        Objects.requireNonNull(getCommand("marker")).setTabCompleter(new MarkerCommandCompleter());

        // BlueMapを管理するクラス
        new BlueMapManager(plugin);

        getLogger().info("プラグインは正常に起動しました。");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        super.onDisable();

        // save yaml file
        Util.saveFile();

        getLogger().info("プラグインは正常に停止しました。");
    }

    // ========== getter ==========

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
