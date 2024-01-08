package tk.yakitori.yakitoriserverbase;

import net.md_5.bungee.api.ChatMessageType;
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
        String language = player.getLocale();

        if (language.equals("ja_jp")) {
            player.sendMessage(ChatColor.BOLD + "\u3088\u3046\u3053\u305D\u3001" + ChatColor.ITALIC + "\u3084\u304D\u3068\u308A\u30B5\u30FC\u30D0\u30FC" + ChatColor.RESET + ChatColor.BOLD + "\u3078!");

            TextComponent termsLink = new TextComponent("\u5229\u7528\u898F\u7D04");
            termsLink.setColor(BLUE.asBungee());
            termsLink.setUnderlined(true);
            ClickEvent termsLinkClick = new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.yakitori.tk/terms");
            termsLink.setClickEvent(termsLinkClick);

            TextComponent terms = new TextComponent();
            terms.addExtra(termsLink);
            terms.addExtra("\u3092\u304A\u8AAD\u307F\u304F\u3060\u3055\u3044 (\u65E5\u672C\u8A9E\u3068\u82F1\u8A9E\u306B\u5BFE\u5FDC\u3057\u3066\u3044\u307E\u3059)\u3002");

            player.spigot().sendMessage(terms);
        } else {
            player.sendMessage(ChatColor.BOLD + "Welcome to " + ChatColor.ITALIC + "Yakitori Server" + ChatColor.RESET + ChatColor.BOLD + "!");

            TextComponent termsLink = new TextComponent("terms of use");
            termsLink.setColor(BLUE.asBungee());
            termsLink.setUnderlined(true);
            ClickEvent termsLinkClick = new ClickEvent(ClickEvent.Action.OPEN_URL, "https://www.yakitori.tk/en/terms");
            termsLink.setClickEvent(termsLinkClick);

            TextComponent terms = new TextComponent("Please read the ");
            terms.addExtra(termsLink);
            terms.addExtra(" (available in Japanese and English).");

            player.spigot().sendMessage(terms);
        }

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
