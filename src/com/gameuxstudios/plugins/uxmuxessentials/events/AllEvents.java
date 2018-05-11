package com.gameuxstudios.plugins.uxmuxessentials.events;

import com.gameuxstudios.plugins.uxmuxessentials.UxMuxEssentials;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.*;

public class AllEvents implements Listener {

    UxMuxEssentials ums;

    @EventHandler
    public void playerJoinEvent(PlayerJoinEvent e) {

        Player p = e.getPlayer();
        Bukkit.broadcastMessage(ChatColor.GREEN + p.getName() + ChatColor.AQUA + " Adlı Oyuncu Sunucuya Giriş Yaptı!");

    }

    @EventHandler
    public void playerQuitEvent(PlayerQuitEvent e) {

        Player p = e.getPlayer();

        Bukkit.broadcastMessage(ChatColor.GREEN + p.getName() + ChatColor.AQUA + " Adlı Oyuncu Sunucudan Çıkış Yaptı!");

    }

}
