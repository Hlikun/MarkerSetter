package net.hlikun.amettibluemap;

import org.bukkit.plugin.java.JavaPlugin;

public final class AmettiBlueMap extends JavaPlugin {
    private static JavaPlugin plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        super.onEnable();

        plugin = this;

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
}
