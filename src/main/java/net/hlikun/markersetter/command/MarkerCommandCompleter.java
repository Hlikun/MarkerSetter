package net.hlikun.markersetter.command;

import net.hlikun.markersetter.tools.Markers;
import net.hlikun.markersetter.tools.Util;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

import java.util.ArrayList;
import java.util.List;

public class MarkerCommandCompleter implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> list = new ArrayList<>();

        switch (args.length) {
            case 1 -> {
                list.add("create");
                list.add("delete");
                list.add("help");
            }
            case 2 -> {
                // サブコマンドが「delete」だった場合全てのmarkerの名前をlistに追加する
                if (args[0].equals("delete")) {
                    Util.getMarkers().forEach(uuid -> {
                        String name = Markers.getPOIMarkerName(uuid);
                        list.add(name);
                    });
                }
            }
        }

        // 現在打っている引数が含まてれている引数だけを返す
        String arg = args[args.length - 1].toLowerCase();
        return list.stream()
                .filter(s -> s.toLowerCase().startsWith(arg))
                .toList();
    }
}
