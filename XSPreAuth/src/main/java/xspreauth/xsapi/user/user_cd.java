package xspreauth.xsapi.user;

import org.bukkit.entity.Player;

public class user_cd {

    private int cd;
    private Player p;

    public user_cd(int cd,Player p) {
        this.cd = cd;
        this.p = p;
    }

    public int getCd() {
        return cd;
    }

    public void setCd(int cd) {
        this.cd = cd;
    }

    public Player getP() {
        return p;
    }
}
