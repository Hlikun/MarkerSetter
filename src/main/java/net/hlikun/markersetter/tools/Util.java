package net.hlikun.markersetter.tools;

import net.hlikun.markersetter.Main;
import org.bukkit.ChatColor;

import javax.annotation.Nullable;
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

    // POIMarkerを全て取得するメソッド
    public static Set<UUID> getPOIMarkers() {
        Set<UUID> set = new HashSet<>();

        for (String marker : Main.getMarkers().getKeys(true)) {
            String[] keyParts = marker.split("\\.");
            if (keyParts.length < 3) continue;

            if (keyParts[1].equalsIgnoreCase("POIMarkers")) {
                UUID uuid = UUID.fromString(keyParts[2]);
                set.add(uuid);
            }
        }
        return set;
    }

    // HTMLMarkerを全て取得するメソッド
    public static Set<UUID> getHTMLMarkers() {
        Set<UUID> set = new HashSet<>();

        for (String marker : Main.getMarkers().getKeys(true)) {
            String[] keyParts = marker.split("\\.");
            if (keyParts.length < 3) continue;

            if (keyParts[1].equalsIgnoreCase("HTMLMarkers")) {
                UUID uuid = UUID.fromString(keyParts[2]);
                set.add(uuid);
            }
        }
        return set;
    }

    @Nullable
    public static UUID getPOIMarkerUUIDFromMarkerName(String name) {
        for (UUID marker : getPOIMarkers()) {
            String valueName = Markers.getPOIMarkerName(marker);
            if (name.equalsIgnoreCase(valueName)) return marker;
        }
        return null;
    }

    @Nullable
    public static UUID getHTMLMarkerUUIDFromMarkerName(String name) {
        for (UUID marker : getHTMLMarkers()) {
            String valueName = Markers.getHTMLMarkerName(marker);
            if (name.equalsIgnoreCase(valueName)) return marker;
        }
        return null;
    }
}
