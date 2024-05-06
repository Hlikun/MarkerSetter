package net.hlikun.markersetter.command;


import net.hlikun.markersetter.command.sub.Create;
import net.hlikun.markersetter.command.sub.Delete;
import net.hlikun.markersetter.command.sub.Help;
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
                    case "create" -> new Create(p, args);
                    case "delete" -> new Delete(p, args);
                    case "help" -> new Help(p);
                }
            }
        }

        return true;
    }
}
