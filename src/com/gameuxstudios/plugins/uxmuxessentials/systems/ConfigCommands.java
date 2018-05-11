package com.gameuxstudios.plugins.uxmuxessentials.systems;

import com.gameuxstudios.plugins.uxmuxessentials.UxMuxEssentials;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class ConfigCommands implements CommandExecutor {

    UxMuxEssentials ums;
    public ConfigCommands(UxMuxEssentials ums) {
        this.ums = ums;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String Label, String[] args) {

        if(cmd.getName().equalsIgnoreCase("tc")) {

            if(args[0].equalsIgnoreCase("yenile")) {
                ums.cfgm.reloadTidyChat();
            }

        }

        return false;
    }

}
