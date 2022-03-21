package com.arcanetravel.command;

import me.mattstudios.mf.annotations.Command;
import me.mattstudios.mf.annotations.Default;
import me.mattstudios.mf.annotations.SubCommand;
import me.mattstudios.mf.base.CommandBase;
import org.bukkit.command.CommandSender;

@Command("webstore")
public class Main extends CommandBase {

    @Default
    public void defaultCommand(final CommandSender commandSender) {
        commandSender.sendMessage("Current version checked!");
    }


    @SubCommand("reload")
    public void testSubCommand(final CommandSender commandSender) {
        commandSender.sendMessage("Test!");
    }


}
