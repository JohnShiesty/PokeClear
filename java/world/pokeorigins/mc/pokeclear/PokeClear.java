package world.pokeorigins.mc.pokeclear;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import world.pokeorigins.mc.pokeclear.commands.ReloadCommand;
import world.pokeorigins.mc.pokeclear.tasks.ClearPokemon;
import world.pokeorigins.mc.pokeclear.utilities.file.FileHandler;

public final class PokeClear extends JavaPlugin {

    private FileHandler config;
    private BukkitTask task;

    @Override
    public void onEnable() {
        this.config = new FileHandler(this, "config.yml", true);
        this.loadTask();
        getCommand("pcreload").setExecutor(new ReloadCommand(this));
        this.getLogger().info("Has been enabled");
    }

    @Override
    public void onDisable() {
        this.task.cancel(); // once plugin is disabled, stop the task by calling it
        this.getLogger().info("Has been disabled");
    }

    public void loadTask() {
        this.task = new ClearPokemon(this).runTaskTimer(this, 0L, config.getLong("Time"));
    }

    @Override
    public FileHandler getConfig() { return this.config; }

    public BukkitTask getTask() {
        return this.task;
    }
}
