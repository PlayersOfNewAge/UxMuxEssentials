package com.gameuxstudios.plugins.uxmuxessentials;

import com.gameuxstudios.plugins.uxmuxessentials.events.*;
import com.gameuxstudios.plugins.uxmuxessentials.systems.*;
import com.gameuxstudios.plugins.uxmuxessentials.utils.*;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class UxMuxEssentials extends JavaPlugin {

    // Sınıf Tanımları
    PluginVariables pv = new PluginVariables();
    AllEvents ae = new AllEvents();
    // ---------------

    public void onEnable() {

        // CONFIG.YML \\
        getConfig().options().copyDefaults(true);
        saveConfig();
        // ---------- \\

        getServer().getPluginManager().registerEvents(new AllEvents(), this);

        // GETTING COMMANDS \\
        getCommand("gmc").setExecutor(new Gamemode(this));
        getCommand("gms").setExecutor(new Gamemode(this));
        getCommand("gma").setExecutor(new Gamemode(this));
        getCommand("candoldur" ).setExecutor(new SpecialPlayerCommands(this));
        getCommand("heal" ).setExecutor(new SpecialPlayerCommands(this));
        getCommand("tc").setExecutor(new ChatManager(this));
        // ---------------- \\

        getServer().getConsoleSender().sendMessage(

                "\n\n\n" + ChatColor.AQUA + pv.info_prefix + ChatColor.GREEN + "Plugin has been activated! \n" + ChatColor.LIGHT_PURPLE + "Author: " + ChatColor.YELLOW + "GameUx Studios / Poyraz Hancilar \n\n\n"

        );

    }

    public void onDisable() {

        getServer().getConsoleSender().sendMessage(

                "\n\n\n" + ChatColor.AQUA + pv.info_prefix + ChatColor.RED + "Plugin has been de-activated! \n" + ChatColor.LIGHT_PURPLE + "Author: " + ChatColor.YELLOW + "GameUx Studios / Poyraz Hancilar \n\n\n"

        );

    }

    public void scanConfigs() {

        if(getConfig().getBoolean("playerJoinEvent")) {
            ae.IsPlayerJoinEvent = true;
        }

        if(getConfig().getBoolean("playerQuitEvent")) {
            ae.IsPlayerQuitEvent = true;
        }

    }

}
