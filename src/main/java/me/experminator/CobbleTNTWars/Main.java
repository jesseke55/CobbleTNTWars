package me.experminator.CobbleTNTWars;

import me.experminator.CobbleTNTWars.game.Game;
import me.experminator.CobbleTNTWars.game.MapManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Copyright (c) 2015, Experminator.
 */
public class Main extends JavaPlugin {

    private static Plugin plugin;

    @Override
    public void onEnable() {
        if(plugin == null) {
            plugin = this;
        }

        getCommand("tntwars").setExecutor(new CommandManager());

        Game.setGameWorld(Bukkit.getWorlds().get(0));
        Game.setMinPlayers(2);
        Game.setMaxPlayers(20);
        Game.setCountdown(60);
        Game.setMap(MapManager.getMap("Classic"));
    }

    @Override
    public void onDisable() {
        if(plugin != null) plugin = null;
    }

    public static Plugin getPlugin() {
        return plugin;
    }
}
