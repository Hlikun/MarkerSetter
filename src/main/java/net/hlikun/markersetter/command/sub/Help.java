package net.hlikun.markersetter.command.sub;

import net.hlikun.markersetter.tools.Util;
import org.bukkit.entity.Player;

public class Help {
    public Help(Player p) {
        p.sendMessage(Util.prefix() + "[/marker create [poi | html] <マーカー名>]: 現在立っている位置にMarkerを作成する。");
        p.sendMessage(Util.prefix() + "[/marker delete [poi | html] <マーカー名>]: 指定したMarkerを削除する。");
    }
}
