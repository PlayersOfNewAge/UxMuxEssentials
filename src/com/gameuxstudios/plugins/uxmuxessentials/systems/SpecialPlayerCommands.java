package com.gameuxstudios.plugins.uxmuxessentials.systems;

import com.gameuxstudios.plugins.uxmuxessentials.UxMuxEssentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpecialPlayerCommands implements CommandExecutor {

    UxMuxEssentials ums;
    public SpecialPlayerCommands(UxMuxEssentials ums) {
        this.ums = ums;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {

        if(cmd.getName().equalsIgnoreCase("candoldur") || cmd.getName().equalsIgnoreCase("heal")) {

            for(Player playerToHeal : Bukkit.getServer().getOnlinePlayers()) {
                if(playerToHeal.getName().equalsIgnoreCase(args[0])) {

                    playerToHeal = Bukkit.getPlayer(args[0]);
                    playerToHeal.setHealth(20.0);
                    playerToHeal.sendMessage(ChatColor.GREEN + "Canınız " + ChatColor.RED + sender.getName() + ChatColor.GREEN + " tarafından dolduruldu!");
                    sender.sendMessage(ChatColor.RED + playerToHeal.getName() + ChatColor.GREEN + " adlı oyuncunun canı dolduruldu!");

                }
            }

        }

        return false;
    }

}
