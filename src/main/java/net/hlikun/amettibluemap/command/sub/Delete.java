package net.hlikun.amettibluemap.command.sub;

import net.hlikun.amettibluemap.tools.Markers;
import net.hlikun.amettibluemap.tools.Util;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.UUID;

public class Delete {
    public Delete(Player p, String[] args) {
        // marker create <マーカー名>
        if (args.length == 1) {
            p.sendMessage(Util.prefix() + ChatColor.RED + "サブコマンドが不正です。正しいコマンドは「/marker delete <マーカー名>」です。");
        } else {
            String name = args[1];
            UUID marker = Util.getMarkerUUIDFromMarkerName(name);

            if (marker == null) {
                p.sendMessage(Util.prefix() + ChatColor.RED + "「" +  name + "」というマーカーは存在しません。");
            } else {
                // マーカのデータをnullに設定 = マーカーを削除
                Markers.setPOIMarkerData(marker, null);

                // メッセージを送信
                p.sendMessage(Util.prefix() + ChatColor.RED + "指定したマーカー「" +  name + "」を削除しました。");
            }
        }
    }
}
