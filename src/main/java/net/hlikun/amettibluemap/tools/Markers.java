package net.hlikun.amettibluemap.tools;

import net.hlikun.amettibluemap.Main;
import org.bukkit.Location;

import java.util.UUID;

public class Markers {
    // Marker name
    public static String getPOIMarkerName(UUID marker) {
        return Main.getMarkers().getString("markers.POIMarkers." + marker + ".name");
    }

    public static void setPOIMarkerName(UUID marker, String name) {
        Main.getMarkers().get("markers.POIMarkers." + marker + ".name", name);
    }

    // Marker location
    public static Location getPOIMarkerLocation(UUID marker) {
        return Main.getMarkers().getLocation("markers.POIMarkers." + marker + ".location");
    }

    public static void setPOIMarkerLocation(UUID marker, Location loc) {
        Main.getMarkers().set("markers.POIMarkers." + marker + ".location", loc);
    }

    // Marker data
    public static void setPOIMarkerData(UUID marker, Object markerData) {
        Main.getMarkers().set("markers.POIMarkers." + marker, markerData);
    }
}
