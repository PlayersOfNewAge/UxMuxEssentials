package com.gameuxstudios.plugins.uxmuxessentials.systems;

import com.gameuxstudios.plugins.uxmuxessentials.UxMuxEssentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ChatManager implements CommandExecutor {

    UxMuxEssentials ums;
    public ChatManager(UxMuxEssentials ums) {
        this.ums = ums;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {

        if(cmd.getName().equalsIgnoreCase("tc")) {

            if(args[0].equalsIgnoreCase("-s")) {

                int count = 0;
                while(count < 500) {
                    Bukkit.broadcastMessage(" ");
                    count++;
                }

                if(count == 500 || count > 500 || count > 499) {
                    Bukkit.broadcastMessage(ChatColor.GREEN + "Sohbet " + ChatColor.AQUA + sender.getName() + ChatColor.GREEN + " tarafından temizlendi!");
                }

            }

        }

        return false;
    }

}
