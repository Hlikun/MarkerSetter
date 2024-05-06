package net.hlikun.amettibluemap.tools;

import net.hlikun.amettibluemap.AmettiBlueMap;

import java.io.IOException;

public class Util {
    public void saveFile() {
        try {
            AmettiBlueMap.getMarkers().save(AmettiBlueMap.getMarkerFile());
        } catch (IOException e) {
            AmettiBlueMap.getPlugin().getLogger().warning("markerの保存中にエラーが発生しました。");
        }
    }
}
