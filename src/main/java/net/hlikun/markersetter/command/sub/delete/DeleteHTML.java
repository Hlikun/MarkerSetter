package net.hlikun.markersetter.command.sub.delete;

import net.hlikun.markersetter.tools.Markers;
import net.hlikun.markersetter.tools.Util;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.UUID;

public class DeleteHTML {
    public DeleteHTML(Player p, String[] args) {
        // marker create <マーカー名>
        if (args.length == 1) {
            p.sendMessage(Util.prefix() + ChatColor.RED + "サブコマンドが不正です。正しいコマンドは「/marker delete html <マーカー名>」です。");
        } else {
            String name = args[1];
            UUID marker = Util.getHTMLMarkerUUIDFromMarkerName(name);

            if (marker == null) {
                p.sendMessage(Util.prefix() + ChatColor.RED + "「" +  name + "」というHTMLマーカーは存在しません。");
            } else {
                // マーカのデータをnullに設定 = マーカーを削除
                Markers.setHTMLMarkerData(marker, null);

                // メッセージを送信
                p.sendMessage(Util.prefix() + ChatColor.RED + "指定したHTMLマーカー「" +  name + "」を削除しました。");
            }
        }
    }
}
