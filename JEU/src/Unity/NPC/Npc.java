package Unity.NPC;

import Unity.Unit;
import Unity.Player;
import t_enum.Rarity;
import Item.Weapons.Weapon;
import java.util.Random;

public abstract class Npc extends Unit {

    private Rarity myRarity;
    private Weapon weapon;
    private final int MIN_DAMMAGE = 25;
    private final int MAX_DAMMAGE = 60;
    private int cc_attack;

    @Override
    public void AttackPlayer(Player p) {
        Random r = new Random();
        int n = r.nextInt((6-1) +1 ) + 1;
        int d = r.nextInt((MAX_DAMMAGE - MIN_DAMMAGE) +1 ) + MIN_DAMMAGE;
        if(n == 1){
            if(p.getHealth()-this.cc_attack <= 0){
                p.setDead( true );
            }else{

                p.setHealth( p.getHealth()-this.cc_attack );
            }
        }else {
            if(p.getHealth()- d <= 0){
                p.setDead( true );
            }else{

                p.setHealth( p.getHealth()-d );
            }
        }
    }

    public abstract void dead(Player p);

    public Rarity getMyRarity() {
        return myRarity;
    }

    public void setMyRarity(Rarity myRarity) {
        this.myRarity = myRarity;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public int getMIN_DAMMAGE() {
        return MIN_DAMMAGE;
    }

    public int getMAX_DAMMAGE() {
        return MAX_DAMMAGE;
    }

    public int getCc_attack() {
        return cc_attack;
    }

    public void setCc_attack(int cc_attack) {
        this.cc_attack = cc_attack;
    }
}