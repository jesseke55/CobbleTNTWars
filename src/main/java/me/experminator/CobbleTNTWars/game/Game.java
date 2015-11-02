package me.experminator.CobbleTNTWars.game;

import me.experminator.CobbleTNTWars.game.tasks.CountdownTask;
import me.experminator.CobbleTNTWars.game.tasks.EndTask;
import me.experminator.CobbleTNTWars.game.tasks.GameTask;
import me.experminator.CobbleTNTWars.util.ScheduleUtil;
import org.bukkit.Bukkit;
import org.bukkit.World;

/**
 * Copyright (c) 2015, Experminator.
 */
public class Game {

    private static GameState gameState;
    private static World gameWorld;
    private static int minPlayers;
    private static int maxPlayers;
    private static long countdown;
    private static Map map;

    private Game() { }

    public static boolean isReady() {
        return (Bukkit.getOnlinePlayers().size() >= minPlayers && Bukkit.getOnlinePlayers().size() <= maxPlayers) && (gameState == GameState.WAITING);
    }

    public static Map getMap() {
        return map;
    }

    public static void setMap(Map map) {
        Game.map = map;
    }

    public static GameState getGameState() {
        return gameState;
    }

    public static void setGameState(GameState gameState) {
        Game.gameState = gameState;
    }

    public static World getGameWorld() {
        return gameWorld;
    }

    public static void setGameWorld(World gameWorld) {
        Game.gameWorld = gameWorld;
    }

    public static int getMinPlayers() {
        return minPlayers;
    }

    public static void setMinPlayers(int minPlayers) {
        Game.minPlayers = minPlayers;
    }

    public static int getMaxPlayers() {
        return maxPlayers;
    }

    public static void setMaxPlayers(int maxPlayers) {
        Game.maxPlayers = maxPlayers;
    }

    public static long getCountdown() {
        return countdown;
    }

    public static  void setCountdown(long countdown) {
        Game.countdown = countdown;
    }

    public static void startCountdown() {
        Game.setGameState(GameState.COUNTDOWN);
        ScheduleUtil.runRepeatingTask(new CountdownTask(), 20L, 20L, false);
    }

    public static void startGame() {
        Game.setGameState(GameState.INGAME);
        ScheduleUtil.runRepeatingTask(new GameTask(), 20L, 20L, false);
    }

    public static void endGame() {
        Game.setGameState(GameState.ENDED);
        ScheduleUtil.runDelayTask(new EndTask(), 20L, false);
    }
}
