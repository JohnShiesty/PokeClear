package world.pokeorigins.mc.pokeclear.commands;


import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import world.pokeorigins.mc.pokeclear.PokeClear;
import world.pokeorigins.mc.pokeclear.utilities.chat.Chat;

public class ReloadCommand implements CommandExecutor {

    private final PokeClear plugin;

    public ReloadCommand(PokeClear plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("pokeclear.reload")) {
            sender.sendMessage(Chat.style(this.plugin.getConfig().getString("Messages.Invalid-Permission")));
            return false;
        }
        this.plugin.getConfig().reload();
        this.plugin.getTask().cancel();
        this.plugin.loadTask();
        sender.sendMessage(Chat.style(this.plugin.getConfig().getString("Messages.Reload")));
        return true;
    }

}
