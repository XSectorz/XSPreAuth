package xspreauth.xsapi.listeners;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;
import xspreauth.xsapi.core.XSPreAuthCore;
import xspreauth.xsapi.user.user_cd;

import java.util.Iterator;

public class onJumpad implements Listener {

    @EventHandler
    public void onJumpPad(PlayerMoveEvent e) {
        final Player p = e.getPlayer();
        if (((e.getFrom().getBlockX() == e.getTo().getBlockX() && e.getFrom().getBlockY() == e.getTo().getBlockY() && e.getFrom().getBlockZ() == e.getTo().getBlockZ() && p.getLocation().getBlock().getType() == Material.HEAVY_WEIGHTED_PRESSURE_PLATE || p.getLocation().getBlock().getType() == Material.LIGHT_WEIGHTED_PRESSURE_PLATE) && (p.getLocation().subtract(0.0, 1.0, 0.0).getBlock().getType() == Material.EMERALD_BLOCK || p.getLocation().subtract(0.0, 1.0, 0.0).getBlock().getType() == Material.REDSTONE_BLOCK))) {
            final Vector v = p.getLocation().getDirection().multiply(2.0).setY(1.0);
            p.setVelocity(v);
            p.playSound(p.getLocation(), Sound.BLOCK_PISTON_EXTEND, 5.0f, 5.0f);
            p.playSound(p.getLocation(), Sound.BLOCK_ANVIL_LAND, 5.0f, 5.0f);
            p.setFallDistance(-999.0f);
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Bukkit.getScheduler().runTask(XSPreAuthCore.getPlugin(), () -> e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 999999, 4, true, false)));
        e.setJoinMessage(null);

        XSPreAuthCore.getCooldowns().add(new user_cd(XSPreAuthCore.getMaxCD(),e.getPlayer()));
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        p.removePotionEffect(PotionEffectType.SPEED);
        e.setQuitMessage(null);

        final Iterator<user_cd> pls = XSPreAuthCore.getCooldowns().iterator();
        while (pls.hasNext()) {
            final user_cd pd = pls.next();
            if (pd.getP().getName().equalsIgnoreCase(e.getPlayer().getName())) {
                pls.remove();
            }
        }
    }
}
