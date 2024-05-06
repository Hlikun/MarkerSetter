package net.hlikun.amettibluemap.command;


import net.hlikun.amettibluemap.command.sub.Create;
import net.hlikun.amettibluemap.command.sub.Delete;
import net.hlikun.amettibluemap.command.sub.Help;
import net.hlikun.amettibluemap.tools.Util;
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
            switch (args.length) {
                case 0 -> p.sendMessage(Util.prefix() + ChatColor.RED + "サブコマンドがありません。「/marker help」でコマンド一覧が確認できます。");
                case 1 -> {
                    switch (args[0]) {
                        case "create" -> new Create(p, args);
                        case "delete" -> new Delete(p, args);
                        case "help" -> new Help(p);
                    }
                }
            }
        }

        return true;
    }
}
