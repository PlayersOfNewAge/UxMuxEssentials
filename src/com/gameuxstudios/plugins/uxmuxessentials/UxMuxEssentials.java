package com.gameuxstudios.plugins.uxmuxessentials;

import com.gameuxstudios.plugins.uxmuxessentials.events.*;
import com.gameuxstudios.plugins.uxmuxessentials.systems.*;
import com.gameuxstudios.plugins.uxmuxessentials.utils.*;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class UxMuxEssentials extends JavaPlugin {

    // Sınıf Tanımları
    public ConfigManager cfgm;
    PluginVariables pv = new PluginVariables();
    AllEvents ae = new AllEvents();
    // ---------------

    public void onEnable() {

        // TIDYCHAT.YML \\
        // ------------ \\

        // CONFIG.YML \\
        loadConfigManager();
        getConfig().options().copyDefaults(true);
        saveConfig();
        // ---------- \\

        // Event Kaydetme
        getServer().getPluginManager().registerEvents(new AllEvents(), this);

        // GETTING COMMANDS \\
        getCommand("gmc").setExecutor(new Gamemode(this));
        getCommand("gms").setExecutor(new Gamemode(this));
        getCommand("gma").setExecutor(new Gamemode(this));
        getCommand("candoldur" ).setExecutor(new SpecialPlayerCommands(this));
        getCommand("heal" ).setExecutor(new SpecialPlayerCommands(this));
        getCommand("tc").setExecutor(new ConfigCommands(this));
        // ---------------- \\

        getServer().getConsoleSender().sendMessage(

                "\n\n\n" + ChatColor.AQUA + pv.info_prefix + ChatColor.GREEN + "Plugin has been activated! \n" + ChatColor.LIGHT_PURPLE + "Author: " + ChatColor.YELLOW + "GameUx Studios / Poyraz Hancilar \n\n\n"

        );

    }

    public void loadConfigManager() {
        cfgm = new ConfigManager();
        cfgm.setup();
    }

    public void onDisable() {

        getServer().getConsoleSender().sendMessage(

                "\n\n\n" + ChatColor.AQUA + pv.info_prefix + ChatColor.RED + "Plugin has been de-activated! \n" + ChatColor.LIGHT_PURPLE + "Author: " + ChatColor.YELLOW + "GameUx Studios / Poyraz Hancilar \n\n\n"

        );

    }


}
