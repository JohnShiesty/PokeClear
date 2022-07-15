package world.pokeorigins.mc.pokeclear.tasks;

import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitRunnable;
import world.pokeorigins.mc.pokeclear.PokeClear;
import world.pokeorigins.mc.pokeclear.utilities.chat.Chat;

public class ClearPokemon extends BukkitRunnable {

    private final PokeClear plugin;

    public ClearPokemon(PokeClear plugin) {
        this.plugin = plugin;
    }

    @Override
    public void run() {
        Bukkit.broadcastMessage(Chat.style(plugin.getConfig().getString("Messages.Broadcast")));
        Bukkit.getServer().dispatchCommand(Bukkit.getConsoleSender(), "pokekill");
    }

    // you can use 1 task only so dont need 2

    // move the broadcast to here

    // now you can delete the broadcast class
}