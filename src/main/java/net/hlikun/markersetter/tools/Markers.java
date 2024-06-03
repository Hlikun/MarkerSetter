package net.hlikun.markersetter.tools;

import net.hlikun.markersetter.Main;
import org.bukkit.Bukkit;
import org.bukkit.Location;

import java.util.UUID;

public class Markers {
    // =========== POIMarker ==========
    // POIMarker name
    public static String getPOIMarkerName(UUID marker) {
        return Main.getMarkers().getString("markers.POIMarkers." + marker + ".name");
    }

    public static void setPOIMarkerName(UUID marker, String name) {
        Main.getMarkers().set("markers.POIMarkers." + marker + ".name", name);
    }

    // POIMarker location
    public static Location getPOIMarkerLocation(UUID marker) {
        String world = Main.getMarkers().getString("markers.POIMarkers." + marker + ".location.world");
        int x = Main.getMarkers().getInt("markers.POIMarkers." + marker + ".location.x");
        int y = Main.getMarkers().getInt("markers.POIMarkers." + marker + ".location.y");
        int z = Main.getMarkers().getInt("markers.POIMarkers." + marker + ".location.z");

        return new Location(Bukkit.getWorld(world), x, y, z);
    }

    public static void setPOIMarkerLocation(UUID marker, Location loc) {
        Main.getMarkers().set("markers.POIMarkers." + marker + ".location.world", loc.getWorld().getName());
        Main.getMarkers().set("markers.POIMarkers." + marker + ".location.x", loc.getBlockX());
        Main.getMarkers().set("markers.POIMarkers." + marker + ".location.y", loc.getBlockY());
        Main.getMarkers().set("markers.POIMarkers." + marker + ".location.z", loc.getBlockZ());
    }

    // POIMarker data
    public static void setPOIMarkerData(UUID marker, Object markerData) {
        Main.getMarkers().set("markers.POIMarkers." + marker, markerData);
    }

    // ========== HTMLMarker ==========
    // HTMLMarker name
    public static String getHTMLMarkerName(UUID marker) {
        return Main.getMarkers().getString("markers.HTMLMarkers." + marker + ".name");
    }

    public static void setHTMLMarkerName(UUID marker, String name) {
        Main.getMarkers().set("markers.HTMLMarkers." + marker + ".name", name);
    }

    // HTMLMarker location
    public static Location getHTMLMarkerLocation(UUID marker) {
        String world = Main.getMarkers().getString("markers.HTMLMarkers." + marker + ".location.world");
        int x = Main.getMarkers().getInt("markers.HTMLMarkers." + marker + ".location.x");
        int y = Main.getMarkers().getInt("markers.HTMLMarkers." + marker + ".location.y");
        int z = Main.getMarkers().getInt("markers.HTMLMarkers." + marker + ".location.z");

        return new Location(Bukkit.getWorld(world), x, y, z);
    }

    public static void setHTMLMarkerLocation(UUID marker, Location loc) {
        Main.getMarkers().set("markers.HTMLMarkers." + marker + ".location.world", loc.getWorld().getName());
        Main.getMarkers().set("markers.HTMLMarkers." + marker + ".location.x", loc.getBlockX());
        Main.getMarkers().set("markers.HTMLMarkers." + marker + ".location.y", loc.getBlockY());
        Main.getMarkers().set("markers.HTMLMarkers." + marker + ".location.z", loc.getBlockZ());
    }

    // HTMLMarker data
    public static void setHTMLMarkerData(UUID marker, Object markerData) {
        Main.getMarkers().set("markers.HTMLMarkers." + marker, markerData);
    }
}
