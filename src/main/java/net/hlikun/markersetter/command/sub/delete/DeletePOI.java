package net.hlikun.markersetter.command.sub.delete;

import net.hlikun.markersetter.tools.Markers;
import net.hlikun.markersetter.tools.Util;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.UUID;

public class DeletePOI {
    public DeletePOI(Player p, String[] args) {
        // marker create <マーカー名>
        if (args.length == 1) {
            p.sendMessage(Util.prefix() + ChatColor.RED + "サブコマンドが不正です。正しいコマンドは「/marker delete poi <マーカー名>」です。");
        } else {
            String name = args[2];
            UUID marker = Util.getHTMLMarkerUUIDFromMarkerName(name);

            if (marker == null) {
                p.sendMessage(Util.prefix() + ChatColor.RED + "「" +  name + "」というPOIマーカーは存在しません。");
            } else {
                // マーカのデータをnullに設定 = マーカーを削除
                Markers.setPOIMarkerData(marker, null);

                // メッセージを送信
                p.sendMessage(Util.prefix() + ChatColor.RED + "指定したPOIマーカー「" +  name + "」を削除しました。");
            }
        }
    }
}
