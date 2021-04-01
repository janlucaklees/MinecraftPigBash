package de.janlucaklees.pigbash.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class PigBashCommand implements CommandExecutor {

    private final JavaPlugin plugin;

    public PigBashCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {
        if (commandSender instanceof Player) {
            // Get the player
            Player player = (Player) commandSender;

            // Get a Netherite sword
            ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);

            // Give the player the sword
            player.getInventory().setItemInMainHand(sword);

            Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
                @Override
                public void run() {
                    player.getInventory().removeItem(sword);
                }
            }, 5*20);

            return true;
        }

        return false;
    }
}
