package de.janlucaklees.pigbash.commands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.List;

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

            ItemStack sword = this.giveNetheriteSwordToPlayer(player);
            this.registerSwordRemovalTimeout(player, sword);

            this.spawnSomePigsAroundPlayer(player);

            return true;
        }

        return false;
    }

    private ItemStack giveNetheriteSwordToPlayer(Player player) {
        ItemStack sword = new ItemStack(Material.NETHERITE_SWORD);
        player.getInventory().setItemInMainHand(sword);
        return sword;
    }

    private void registerSwordRemovalTimeout(Player player, ItemStack item) {
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this.plugin, new Runnable() {
            @Override
            public void run() {
                player.getInventory().removeItem(item);
            }
        }, 5*20);
    }

    private void spawnSomePigsAroundPlayer(Player player) {
        player.getWorld().spawnEntity(player.getLocation(), EntityType.PIG);
    }
}
