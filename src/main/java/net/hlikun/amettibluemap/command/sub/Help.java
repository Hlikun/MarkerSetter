package net.hlikun.amettibluemap.command.sub;

import net.hlikun.amettibluemap.tools.Util;
import org.bukkit.entity.Player;

public class Help {
    public Help(Player p) {
        p.sendMessage(Util.prefix() + "[/marker create <マーカー名>]: 現在立っている位置にPOIMarkerを作成する。");
        p.sendMessage(Util.prefix() + "[/marker delete <マーカー名>]: 指定したPOIMarkerを削除する。");
    }
}
