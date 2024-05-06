package net.hlikun.amettibluemap.bluemap.scheduler;

import de.bluecolored.bluemap.api.BlueMapAPI;
import de.bluecolored.bluemap.api.BlueMapMap;
import de.bluecolored.bluemap.api.markers.MarkerSet;
import de.bluecolored.bluemap.api.markers.POIMarker;
import net.hlikun.amettibluemap.tools.Markers;
import net.hlikun.amettibluemap.tools.Util;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.UUID;

public class MarkerUpdate extends BukkitRunnable {
    private final BlueMapAPI blueMapAPI;

    public MarkerUpdate(BlueMapAPI blueMapAPI) {
        this.blueMapAPI = blueMapAPI;
    }

    @Override
    public void run() {
        MarkerSet markerSet = MarkerSet.builder()
                .label("あめくら")
                .build();

        // 全てのマーカーをマップに設定
        for (UUID uuid : Util.getMarkers()) {
            String name = Markers.getPOIMarkerName(uuid);
            Location loc = Markers.getPOIMarkerLocation(uuid);

            // POIMarkerを作成
            POIMarker poiMarker = createPOIMarker(name, loc);
            // Setに追加
            markerSet.put(name, poiMarker);
        }

        blueMapAPI.getWorld(Bukkit.getWorld("world")).ifPresent(world -> {
            for (BlueMapMap map : world.getMaps()) {
                map.getMarkerSets().put("あめくら", markerSet);
            }
        });
    }

    // POIMarkerを作成するメソッド
    private POIMarker createPOIMarker(String name, Location loc) {
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();

        return POIMarker.builder()
                .label(name)
                .position(x, y, z)
                .maxDistance(1000)
                .build();
    }
}
