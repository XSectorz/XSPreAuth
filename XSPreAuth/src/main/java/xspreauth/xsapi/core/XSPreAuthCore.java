package xspreauth.xsapi.core;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;
import xspreauth.xsapi.listeners.onCMD;
import xspreauth.xsapi.listeners.onJumpad;
import xspreauth.xsapi.tasks.task_check;
import xspreauth.xsapi.user.user_cd;

import java.util.LinkedList;
import java.util.List;

public final class XSPreAuthCore extends JavaPlugin {

    public static XSPreAuthCore plugin;

    private static LinkedList<user_cd> cooldown = new LinkedList<user_cd>();
    private static int maxCD = 30;
    private static String[] colors = {"&x&e&e&6&a&2&a&l","&x&e&e&b&f&3&3&l","&x&a&d&e&e&3&3&l","&x&3&3&e&e&5&7&l"
    ,"&x&3&6&d&d&e&e&l","&x&3&a&7&2&e&e&l","&x&9&8&3&8&e&e&l","&x&e&e&3&a&c&1&l","&x&e&e&3&d&6&2&l"};

    public static int getMaxCD() {
        return XSPreAuthCore.maxCD;
    }
    public static String[] getColors() {
        return XSPreAuthCore.colors;
    }

    public static List<user_cd> getCooldowns() {
        return XSPreAuthCore.cooldown;
    }

    public static XSPreAuthCore getPlugin() {
        return plugin;
    }
    @Override
    public void onEnable() {
        Bukkit.getLogger().info("§e***************************");
        Bukkit.getLogger().info("§r");
        Bukkit.getLogger().info("§a    XSPreAuth - v1.0");
        Bukkit.getLogger().info("§e   Status: §aEnabled");
        Bukkit.getLogger().info("§c   By Panat Xsectorz");
        Bukkit.getLogger().info("§r");
        Bukkit.getLogger().info("§e***************************");

        plugin = this;

        Bukkit.getPluginManager().registerEvents(new onCMD(),this);
        Bukkit.getPluginManager().registerEvents(new onJumpad(),this);
        BukkitTask task_updateUI = (new task_check()).runTaskTimer((Plugin) plugin, 0L, 20L);
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("§e***************************");
        Bukkit.getLogger().info("§r");
        Bukkit.getLogger().info("§a    XSPreAuth - v1.0");
        Bukkit.getLogger().info("§e   Status: §cDisabled");
        Bukkit.getLogger().info("§c   By Panat Xsectorz");
        Bukkit.getLogger().info("§r");
        Bukkit.getLogger().info("§e***************************");
    }

    public static String transColor(String str) {
        return str.replace("&","§");
    }
}
