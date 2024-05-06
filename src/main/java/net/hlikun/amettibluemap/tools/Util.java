package net.hlikun.amettibluemap.tools;

import net.hlikun.amettibluemap.Main;

import java.io.IOException;

public class Util {
    public static void saveFile() {
        try {
            Main.getMarkers().save(Main.getMarkerFile());
        } catch (IOException e) {
            Main.getPlugin().getLogger().warning("markerの保存中にエラーが発生しました。");
        }
    }
}
