package com.gameuxstudios.plugins.uxmuxessentials.systems;

import com.gameuxstudios.plugins.uxmuxessentials.UxMuxEssentials;
import com.gameuxstudios.plugins.uxmuxessentials.utils.PluginVariables;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.*;

public class Gamemode implements CommandExecutor {

    UxMuxEssentials ums;
    PluginVariables pv = new PluginVariables();
    public Gamemode(UxMuxEssentials ums) {
        this.ums = ums;
    }

    public boolean onCommand( CommandSender sender, Command cmd, String Label, String[] args) {

        if(sender instanceof Player) {

            Player p = (Player) sender;

            if(cmd.getName().equalsIgnoreCase("gmc")) {
                p.setGameMode(GameMode.CREATIVE);
                sender.sendMessage(ChatColor.GOLD + "Oyun modunuz " + ChatColor.AQUA + "Yaratıcı " + ChatColor.GOLD + "olarak ayarlandı!");
            }
            if(cmd.getName().equalsIgnoreCase("gms")) {
                p.setGameMode(GameMode.SURVIVAL);
                sender.sendMessage(ChatColor.GOLD + "Oyun modunuz " + ChatColor.AQUA + "Hayatta Kalma " + ChatColor.GOLD + "olarak ayarlandı!");
            }
            if(cmd.getName().equalsIgnoreCase("gma")) {
                p.setGameMode(GameMode.ADVENTURE);
                sender.sendMessage(ChatColor.GOLD + "Oyun modunuz " + ChatColor.AQUA + "Maceracı " + ChatColor.GOLD + "olarak ayarlandı!");
            }

        } else {
            sender.sendMessage(ChatColor.AQUA + pv.error_prefix + ChatColor.RED + "Only players can use this command!");
        }

        return false;
    }

}
