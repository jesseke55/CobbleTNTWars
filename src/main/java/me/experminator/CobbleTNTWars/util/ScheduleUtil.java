package me.experminator.CobbleTNTWars.util;

import me.experminator.CobbleTNTWars.Main;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Copyright (c) 2015, Experminator.
 */
public class ScheduleUtil {

    public static BukkitRunnable runRepeatingTask(Runnable runnable, long period, long delay, boolean async) {
        if(async) {
            Bukkit.getScheduler().scheduleAsyncRepeatingTask(Main.getPlugin(), runnable, delay, period);
        } else {
            Bukkit.getScheduler().scheduleSyncRepeatingTask(Main.getPlugin(), runnable, delay, period);
        }

        return ((BukkitRunnable) runnable);
    }

    public static BukkitRunnable runDelayTask(Runnable runnable, long delay, boolean async) {
        if(async) {
            Bukkit.getScheduler().scheduleAsyncDelayedTask(Main.getPlugin(), runnable, delay);
        } else {
            Bukkit.getScheduler().scheduleSyncDelayedTask(Main.getPlugin(), runnable, delay);
        }

        return ((BukkitRunnable) runnable);
    }

    public static void runTaskAfter(Runnable current, Runnable after) {

    }
}
