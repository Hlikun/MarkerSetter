package net.hlikun.markersetter.command;

import net.hlikun.markersetter.command.sub.create.CreateHTML;
import net.hlikun.markersetter.command.sub.create.CreatePOI;
import net.hlikun.markersetter.command.sub.Help;
import net.hlikun.markersetter.command.sub.delete.DeleteHTML;
import net.hlikun.markersetter.command.sub.delete.DeletePOI;
import net.hlikun.markersetter.tools.Util;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MarkerCommandExecutor implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player p)) {
            sender.sendMessage("コマンドを実行できるのはプレイヤーのみです。");
        } else {
            if (args.length == 0) {
                p.sendMessage(Util.prefix() + ChatColor.RED + "サブコマンドがありません。「/marker help」でコマンド一覧が確認できます。");
            } else {
                switch (args[0]) {
                    case "create" -> create(p, args);
                    case "delete" -> delete(p, args);
                    case "help" -> new Help(p);
                    case "save" -> Util.saveFile();
                }
            }
        }
        return true;
    }

    private void create(Player p, String[] args) {
        if (args.length == 1) {
            p.sendMessage(Util.prefix() + ChatColor.RED + "サブコマンドが不正です。正しいコマンドは「/marker create [poi|html] <マーカー名>」です。");
        } else {
            switch (args[1]) {
                case "poi" -> new CreatePOI(p, args);
                case "html" -> new CreateHTML(p, args);
                default -> p.sendMessage(Util.prefix() + ChatColor.RED + "サブコマンドが不正です。正しいコマンドは「/marker create [poi|html] <マーカー名>」です。");
            }
        }
    }

    private void delete(Player p, String[] args) {
        if (args.length == 1) {
            p.sendMessage(Util.prefix() + ChatColor.RED + "サブコマンドが不正です。正しいコマンドは「/marker delete [poi|html] <マーカー名>」です。");
        } else {
            switch (args[1]) {
                case "poi" -> new DeletePOI(p, args);
                case "html" -> new DeleteHTML(p, args);
                default -> p.sendMessage(Util.prefix() + ChatColor.RED + "サブコマンドが不正です。正しいコマンドは「/marker delete [poi|html] <マーカー名>」です。");
            }
        }
    }
}
