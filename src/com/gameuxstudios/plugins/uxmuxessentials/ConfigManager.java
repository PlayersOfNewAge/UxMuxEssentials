package com.gameuxstudios.plugins.uxmuxessentials;
import com.gameuxstudios.plugins.uxmuxessentials.utils.PluginVariables;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.libs.jline.internal.InputStreamReader;


import java.io.*;

import static com.google.common.io.Resources.copy;
import static com.google.common.io.Resources.getResource;

public class ConfigManager {

    private UxMuxEssentials plugin = UxMuxEssentials.getPlugin(UxMuxEssentials.class);
    private PluginVariables pv = new PluginVariables();

    // Dosyalar ve Config Dosyaları Burada


    public FileConfiguration tidychatCfg;
    public File tidychatFile;


    // -----------------------------------

    public void setup() {

        // Dizin kontrolü yapar.
        if(!plugin.getDataFolder().exists()) {
            plugin.getDataFolder().mkdir();
        }

        // CREATING PLUGINS FOLDER
        String PATH = plugin.getDataFolder() + File.separator + "plugins";
        String directoryName = PATH;

        File directory = new File(directoryName);

        if(!directory.exists()) {
            directory.mkdir();
        }
        // ----------------------

        tidychatFile = new File(plugin.getDataFolder() + File.separator + "plugins", "tidychat.yml");

        if(!tidychatFile.exists()) {

            try {
                tidychatCfg = YamlConfiguration.loadConfiguration(tidychatFile);

                try
                {
                    FileWriter fw = new FileWriter(this.tidychatFile, true);
                    BufferedWriter bw = new BufferedWriter(fw);
                    bw.write("# UxMux Essentials | v1.0 Made By GameUx Studios / Poyraz Hancilar\n" +
                            "# -----------------------------------------------------------------\n" +
                            "# TidyChat | Version 1.0\n" +
                            "\n" +
                            "# Activates/De-Activates Caps-Lock Protection \n" +
                            "capsLockProtect: true\n" +
                            "# If players say a banned word, send message to console?\n" +
                            "sendConsoleMessages: true\n" +
                            "# If players say a banned word, write a log to ChatLog.txt ?\n" +
                            "writeLogFiles: true\n" +
                            "# List of the banned words.\n" +
                            "bannedWords: []\n" +
                            "# Players name in this list, they can add/del banned word, reload config and more.\n" +
                            "authorizedPlayers: []\n" +
                            "# Players name in this list, if they say bad word they are not effected. And they don't take warning.\n" +
                            "bypassPlayers: []\n");

                    fw.flush();
                    bw.close();
                }
                catch (Exception exception)
                {
                    exception.printStackTrace();
                }

                tidychatFile.createNewFile();

            } catch (IOException e) {
                Bukkit.getConsoleSender().sendMessage(pv.error_prefix + ChatColor.RED + "Could not create " + ChatColor.GOLD + "plugins/tidychat.yml" + ChatColor.RED +" file!");
            }

            Bukkit.getConsoleSender().sendMessage("\n\n" + pv.info_prefix + ChatColor.GREEN + "File " + ChatColor.LIGHT_PURPLE + "plugins/tidychat.yml" + ChatColor.GREEN + " has been created.");

        } else {
            tidychatCfg = YamlConfiguration.loadConfiguration(tidychatFile);
        }

    }

    public FileConfiguration getTidyChat() { return tidychatCfg; }
    public void saveTidyChat() {

        try {
            tidychatCfg.save(tidychatFile);
            Bukkit.getConsoleSender().sendMessage(pv.info_prefix + ChatColor.GREEN + "Saved plugins/tidychat.yml file.");
        } catch(IOException e) {
            Bukkit.getConsoleSender().sendMessage(pv.error_prefix + ChatColor.RED + "Could not save plugins/tidychat.yml file!");
        }

    }
    public void reloadTidyChat() {
        tidychatCfg = YamlConfiguration.loadConfiguration(tidychatFile);
        setup();
        Bukkit.getConsoleSender().sendMessage(pv.info_prefix + ChatColor.GREEN + "File plugin/tidychat.yml has been reloaded!");
    }


}
