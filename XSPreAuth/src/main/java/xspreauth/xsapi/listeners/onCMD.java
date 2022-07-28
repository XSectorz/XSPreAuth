package xspreauth.xsapi.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerChatTabCompleteEvent;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class onCMD implements Listener {

    @EventHandler
    public void onCommandProcess(PlayerCommandPreprocessEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onTabComplete(PlayerChatTabCompleteEvent e) {
        e.getTabCompletions().clear();
    }

    @EventHandler
    public void onAsyncChat(AsyncPlayerChatEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void onChatMsg(PlayerChatEvent e) {
        e.setCancelled(true);
    }
}
