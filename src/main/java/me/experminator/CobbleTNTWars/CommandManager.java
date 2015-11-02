package me.experminator.CobbleTNTWars;

import me.experminator.CobbleTNTWars.command.SubCommand;
import me.experminator.CobbleTNTWars.util.MessageUtil;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Copyright (c) 2015, Experminator.
 */
public class CommandManager implements CommandExecutor {

    private static List<SubCommand> subCommands;

    protected CommandManager() {
        subCommands = new ArrayList<>();
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String label, String[] args) {
        if(args.length == 0) {
            for(SubCommand c : subCommands) {
                commandSender.sendMessage(MessageUtil.toColor("&6{name}:&7 {desc}"
                                    .replace("{name}", c.name())
                                    .replace("{desc}", c.description())
                ));
            }

            return true;
        }

        SubCommand target = CommandManager.getCommand(args[0]);

        if(target == null) {
            commandSender.sendMessage(MessageUtil.toColor("&cThe command '{name}' does not exists."
                            .replace("{name}", args[0])
            ));
            return true;
        }

        if(target.isPlayerOnly() && !(commandSender instanceof Player)) {
            commandSender.sendMessage(MessageUtil.toColor("&cThis command can only be executed by a player."));
            return true;
        }

        List<String> newArgs = Arrays.asList(args);
        newArgs.remove(0);
        args = newArgs.toArray(new String[newArgs.size()]);

        if(commandSender instanceof Player) {
            target.run(((Player) commandSender), args);
            return true;
        } else {
            target.run(commandSender, args);
            return true;
        }
    }

    public static SubCommand[] getCommands() {
        return subCommands.toArray(new SubCommand[subCommands.size()]);
    }

    public static SubCommand getCommand(String name) {
        for(SubCommand c : subCommands) {
            if(c.name().equalsIgnoreCase(name)) {
                return c;
            }
        }

        return null;
    }
}
