package me.experminator.CobbleTNTWars.command;

import org.bukkit.command.CommandSender;

/**
 * Copyright (c) 2015, Experminator.
 */
public abstract class SubCommand {

    public String name() {
        return getClass().getSimpleName().replace("Command", "").trim();
    }

    public String description() {
        return null;
    }

    public boolean isPlayerOnly() {
        return false;
    }

    public abstract void run(CommandSender sender, String[] args);
}
