package me.experminator.CobbleTNTWars.game;

import com.sk89q.worldedit.regions.CuboidRegion;
import org.bukkit.Bukkit;
import org.bukkit.World;

/**
 * Copyright (c) 2015, Experminator.
 */
public class Map {

    private String name;
    private World world;
    private CuboidRegion islandRed, islandBlue;
    private CuboidRegion wall;

    public Map() { }

    public Map(String name, CuboidRegion wall, CuboidRegion islandRed, CuboidRegion islandBlue) {
        this.name = name;
        this.world = Bukkit.getWorld(name);
        this.islandRed = islandRed;
        this.islandBlue = islandBlue;
        this.wall = wall;
    }

    public Map(World world, CuboidRegion wall, CuboidRegion islandRed, CuboidRegion islandBlue) {
        this.name = world.getName();
        this.world = world;
        this.islandRed = islandRed;
        this.islandBlue = islandBlue;
        this.wall = wall;
    }

    public String getName() {
        return name;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }

    public CuboidRegion getIslandRed() {
        return islandRed;
    }

    public void setIslandRed(CuboidRegion islandRed) {
        this.islandRed = islandRed;
    }

    public CuboidRegion getIslandBlue() {
        return islandBlue;
    }

    public void setIslandBlue(CuboidRegion islandBlue) {
        this.islandBlue = islandBlue;
    }

    public CuboidRegion getWall() {
        return wall;
    }

    public void setWall(CuboidRegion wall) {
        this.wall = wall;
    }
}
