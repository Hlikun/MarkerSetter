package net.hlikun.markersetter.command.sub.create;

import net.hlikun.markersetter.tools.Markers;
import net.hlikun.markersetter.tools.Util;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.UUID;

public class CreatePOI {
    public CreatePOI(Player p, String[] args) {
        // marker create <マーカー名>
        if (args.length == 1) {
            p.sendMessage(Util.prefix() + ChatColor.RED + "サブコマンドが不正です。正しいコマンドは「/marker create poi <マーカー名>」です。");
        } else {
            // マーカー名
            String markerName = args[2];

            // 名前が既に存在しているか確認
            if (isArgumentAlreadyExists(markerName)) {
                p.sendMessage(Util.prefix() + ChatColor.RED + "この名前のマーカーは既に存在しています。");
            } else {
                // 必要な情報を取得
                UUID markerUUID = UUID.randomUUID();
                Location loc = p.getLocation();

                // 名前を位置を設定
                Markers.setPOIMarkerName(markerUUID, markerName);
                Markers.setPOIMarkerLocation(markerUUID, loc);

                // メッセージを送信
                p.sendMessage(Util.prefix() + ChatColor.GREEN + "現在立っている位置にPOIMarkerを作成しました。");
            }
        }
    }

    // POIMarkerの名前が既に存在するか確認するメソッド
    private boolean isArgumentAlreadyExists(String name) {
        for (UUID marker : Util.getPOIMarkers()) {
            String valueName = Markers.getPOIMarkerName(marker);

            if (name.equalsIgnoreCase(valueName)) {
                return true;
            }
        }
        return false;
    }
}
