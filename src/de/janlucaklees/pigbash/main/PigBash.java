package de.janlucaklees.pigbash.main;

import de.janlucaklees.pigbash.commands.PigBashCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class PigBash extends JavaPlugin {
    @Override
    public void onEnable() {
        this.registerCommands();
    }

    private void registerCommands() {
        this.getCommand("pigbash").setExecutor(new PigBashCommand(this));
    }
}
