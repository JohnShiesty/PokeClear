package world.pokeorigins.mc.pokeclear.utilities.chat;

import org.bukkit.ChatColor;

import java.util.List;
import java.util.stream.Collectors;

public class Chat {

    public static String style(String text) { return ChatColor.translateAlternateColorCodes('&', text); }

    public static List<String> style(List<String> text) { return text.stream().map(Chat::style).collect(Collectors.toList()); }
}
