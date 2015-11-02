package me.experminator.CobbleTNTWars.game;

import java.util.Collection;
import java.util.HashMap;

/**
 * Copyright (c) 2015, Experminator.
 */
public class MapManager {

    private static HashMap<Integer, Map> BY_ID = new HashMap<>();
    private static HashMap<String, Map> BY_NAME = new HashMap<>();

    public static void addMap(Map map) {
        BY_ID.put(BY_ID.size() + 1, map);
        BY_NAME.put(map.getName(), map);
    }

    public static void removeMap(String str) {
        try {
            if(getMap(Integer.valueOf(str)) != null) {
                BY_ID.remove(Integer.valueOf(str));
            }
        } catch(NumberFormatException e) {
            if(getMap(str) != null) {
                BY_NAME.remove(str);
            }
        }
    }

    public Collection<Map> getMaps() {
        return BY_ID.values();
    }

    public static Map getMap(int id) {
        return BY_ID.get(id);
    }

    public static Map getMap(String name) {
        return BY_NAME.get(name);
    }
}
