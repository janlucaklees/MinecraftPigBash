package de.janlucaklees.pigbash.commands;

import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class PigBashCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            // Get the player
            Player player = (Player) commandSender;

            // Get a Netherite sword
            ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);

            // Give the player the sword
            player.getInventory().setItemInMainHand(sword);

            return true;
        }

        return false;
    }
}
