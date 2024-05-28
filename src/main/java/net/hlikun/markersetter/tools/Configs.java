package net.hlikun.markersetter.tools;

import net.hlikun.markersetter.Main;

public class Configs {
    public static String getConfigVersion() {
        return Main.getConfigs().getString("config-version");
    }

    public static int getMarkerUpdateInterval() {
        return Main.getConfigs().getInt("marker-update-interval");
    }

    public static String getMarketListName() {
        return Main.getConfigs().getString("marker-list-name");
    }
}
