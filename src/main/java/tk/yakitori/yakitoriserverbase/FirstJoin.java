package tk.yakitori.yakitoriserverbase;

import net.md_5.bungee.api.chat.ClickEvent;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

import static org.bukkit.ChatColor.*;

public class FirstJoin implements Listener {
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
            player.sendMessage(ChatColor.BOLD + "Welcome to " + ChatColor.ITALIC + "Yakitori Server" + ChatColor.RESET + ChatColor.BOLD + "!");

            TextComponent termsLink = new TextComponent("terms of use");
            termsLink.setColor(BLUE.asBungee());
            termsLink.setUnderlined(true);
            ClickEvent termsLinkClick = new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.yakitori.tk/terms");
            termsLink.setClickEvent(termsLinkClick);


            TextComponent terms = new TextComponent("Please read the ");
            terms.addExtra(termsLink);
            terms.addExtra(" (available in Japanese and English).");

            player.spigot().sendMessage(terms);

        if (!player.hasPlayedBefore()) {
            ItemStack[] items = {
                    new ItemStack(Material.STONE_PICKAXE),
                    new ItemStack(Material.STONE_AXE),
                    new ItemStack(Material.STONE_SHOVEL),
                    new ItemStack(Material.STONE_SWORD),
                    new ItemStack(Material.BREAD, 32)
            };
            for (int i = 0; i < items.length; i++) {
                player.getInventory().setItem(i, items[i]);
            }
        }
    }
}
