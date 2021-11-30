package Unity.Enemy;

import Item.Item;
import Item.Weapons.Weapon;
import Place.Place;
import Unity.Player;
import t_enum.Rarity;

import java.util.List;
import java.util.Random;

public class Devil extends Enemy {

	private final String NAME;

	public Devil(String name, List<Item> i, int w, List<String> s, Rarity r, int c){

		this.NAME = name;

		super.setDead( false );
		super.setHealth( super.getMAX_HEALTH() );
		super.setWallet( w );
		super.setItemList( i );
		super.setMyRarity( r );
		super.setTalking( s );
		super.setCc_attack( c );
	}

	@Override
	public void print() {

	}

	@Override
	public <T extends Enemy> void AttackEnemy(T e, Weapon w) {

	}

	@Override
	public void dead(Player p) {
		if(super.getHealth() == 0){
			System.out.println("Vous avez vaincu " + this.getNAME() + " !");
			super.setDead( true );
		}
	}

	public String getNAME() {
		return NAME;
	}
}