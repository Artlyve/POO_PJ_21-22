package Unity.Enemy;

import Interface.Talk;
import Unity.NPC.Npc;
import Unity.Player;
import t_enum.Rarity;

import java.util.List;
import java.util.Random;

public abstract class Enemy extends Npc implements Talk {

	private final int MAX_TALKING = 10;
	private final int MIN_TALKING = 1;

	private Rarity myRarity;
	private List<String> talking;
	private final int MIN_DAMMAGE = 25;
	private final int MAX_DAMMAGE = 60;
	private int cc_attack;


	@Override
	public void Talk() {

		Random r = new Random();
		System.out.println(this.talking.get( r.nextInt((this.MAX_TALKING - this.MIN_TALKING) + 1) + this.MIN_TALKING) );

	}

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

	public List<String> getTalking() {
		return talking;
	}

	public void setTalking(List<String> talking) {
		this.talking = talking;
	}

	public int getMAX_TALKING() {
		return MAX_TALKING;
	}

	public int getMIN_TALKING() {
		return MIN_TALKING;
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