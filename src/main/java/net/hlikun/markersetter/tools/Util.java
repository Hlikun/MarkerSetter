package net.hlikun.markersetter.tools;

import net.hlikun.markersetter.Main;
import org.bukkit.ChatColor;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

public class Util {
    // このプラグインのPrefixを返すメソッド
    public static String prefix() {
        return ChatColor.AQUA + "[" + ChatColor.GREEN + "MarkerSetter" + ChatColor.AQUA + "]" + ChatColor.RESET;
    }

    // Yamlファイルを保存するメソッド
    public static void saveFile() {
        try {
            Main.getMarkers().save(Main.getMarkerFile());
        } catch (IOException e) {
            Main.getPlugin().getLogger().warning("markerの保存中にエラーが発生しました。");
        }
    }

    // markerを全て取得するメソッド
    public static Set<UUID> getMarkers() {
        Set<UUID> set = new HashSet<>();

        for (String marker : Main.getMarkers().getKeys(true)) {
            String[] keyParts = marker.split("\\.");

            if (keyParts.length >= 3) {
                UUID uuid = UUID.fromString(keyParts[2]);
                set.add(uuid);
            }
        }
        return set;
    }

    public static UUID getMarkerUUIDFromMarkerName(String name) {
        for (UUID marker : getMarkers()) {
            String valueName = Markers.getPOIMarkerName(marker);
            if (name.equalsIgnoreCase(valueName)) return marker;
        }
        return null;
    }
}
