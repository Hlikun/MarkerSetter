package net.hlikun.markersetter.bluemap.scheduler;

import de.bluecolored.bluemap.api.BlueMapAPI;
import de.bluecolored.bluemap.api.BlueMapMap;
import de.bluecolored.bluemap.api.markers.HtmlMarker;
import de.bluecolored.bluemap.api.markers.MarkerSet;
import de.bluecolored.bluemap.api.markers.POIMarker;
import net.hlikun.markersetter.tools.Configs;
import net.hlikun.markersetter.tools.Markers;
import net.hlikun.markersetter.tools.Util;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class MarkerUpdate extends BukkitRunnable {
    private final BlueMapAPI blueMapAPI;

    private final String markerListName = Configs.getMarketListName();
    private final int markerDisplayRange = Configs.getPoiMarkerRange();

    public MarkerUpdate(BlueMapAPI blueMapAPI) {
        this.blueMapAPI = blueMapAPI;
    }

    @Override
    public void run() {
        MarkerSet markerSet = MarkerSet.builder()
                .label(markerListName)
                .build();

        // 全てのPOIMarkerをマップに設定
        setPOIMarker(markerSet);
        // 全てのHTMLMarkerをマップに設定
        setHTMLMarker(markerSet);

        blueMapAPI.getWorld(Bukkit.getWorld("world")).ifPresent(world -> {
            for (BlueMapMap map : world.getMaps()) {
                map.getMarkerSets().put(markerListName, markerSet);
            }
        });
    }

    // 全てのPOIMarkerをマップに設定するメソッド
    private void setPOIMarker(MarkerSet markerSet) {
        for (UUID uuid : Util.getPOIMarkers()) {
            String name = Markers.getPOIMarkerName(uuid);
            Location loc = Markers.getPOIMarkerLocation(uuid);

            // POIMarkerを作成
            POIMarker poiMarker = createPOIMarker(name, loc);
            // Setに追加
            markerSet.put(name, poiMarker);
        }
    }

    // 全てのHTMLMarkerをマップに設定するメソッド
    private void setHTMLMarker(MarkerSet markerSet) {
        for (UUID uuid : Util.getHTMLMarkers()) {
            String name = Markers.getHTMLMarkerName(uuid);
            Location loc = Markers.getHTMLMarkerLocation(uuid);

            // HTMLMarkerを作成
            HtmlMarker poiMarker = createHTMLMarker(name, loc);
            // Setに追加
            markerSet.put(name, poiMarker);
        }
    }

    // POIMarkerを作成するメソッド
    private POIMarker createPOIMarker(String name, Location loc) {
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();

        return POIMarker.builder()
                .label(name)
                .position(x, y, z)
                .maxDistance(markerDisplayRange)
                .build();
    }

    // HTMLMarkerを作成するメソッド
    private HtmlMarker createHTMLMarker(String name, Location loc) {
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();

        return HtmlMarker.builder()
                .html("<span style=\"font-weight:bold; color:white;\">" + name + "</span>")
                .label(name)
                .position(x, y, z)
                .maxDistance(markerDisplayRange)
                .build();
    }
}
