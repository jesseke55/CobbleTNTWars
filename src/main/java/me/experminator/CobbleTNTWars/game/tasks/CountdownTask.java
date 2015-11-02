package me.experminator.CobbleTNTWars.game.tasks;

import me.experminator.CobbleTNTWars.game.Game;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Copyright (c) 2015, Experminator.
 */
public class CountdownTask extends BukkitRunnable {

    @Override
    public void run() {
        if(Game.getCountdown() <= 0) {
            this.cancel();
            Game.startGame();
        }
    }
}
