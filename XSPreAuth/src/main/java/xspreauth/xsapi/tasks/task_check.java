package xspreauth.xsapi.tasks;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;
import xspreauth.xsapi.core.XSPreAuthCore;
import xspreauth.xsapi.user.user_cd;

import java.util.ArrayList;
import java.util.List;

public class task_check extends BukkitRunnable {

    @Override
    public void run() {

        final List<user_cd> user_cd_list = new ArrayList<user_cd>(XSPreAuthCore.getCooldowns());

        for (final user_cd user : user_cd_list) {
            final Player p = user.getP();
            if (Bukkit.getPlayer(p.getName()) == null) {
                continue;
            }

            int cd = user.getCd();

            int color_index = cd % (XSPreAuthCore.getColors().length-1) ;

            if(cd > 0) {
                p.sendTitle(XSPreAuthCore.transColor("&a● &x&e&e&9&8&2&5&lS&x&f&1&a&5&2&c&lI&x&f&4&b&2&3&4&lA&x&f&6&b&e&3&b&lM&x&f&9&c&b&4&2&lC&x&f&9&c&e&4&c&lR&x&f&9&d&0&5&6&lA&x&f&9&d&3&6&0&lF&x&f&9&d&5&6&a&lT &a●"),
                        XSPreAuthCore.transColor("&x&8&e&e&e&7&1กรุณาเดินเข้าประตูภายใน " + XSPreAuthCore.getColors()[color_index] + cd + " &x&8&e&e&e&7&1วินาที"),0,40,0);
            } else {
                p.kickPlayer(XSPreAuthCore.transColor("&a● &x&e&e&9&8&2&5&lS&x&f&1&a&5&2&c&lI&x&f&4&b&2&3&4&lA&x&f&6&b&e&3&b&lM&x&f&9&c&b&4&2&lC&x&f&9&c&e&4&c&lR&x&f&9&d&0&5&6&lA&x&f&9&d&3&6&0&lF&x&f&9&d&5&6&a&lT &a●\n&x&8&e&e&e&7&1คุณเข้าประตูไม่ทันในระยะเวลาที่กำหนด"));
            }

            user.setCd(user.getCd()-1);

        }

    }

}
