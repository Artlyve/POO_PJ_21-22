package Unity.Enemy;

import Item.Item;
import Item.Weapons.Weapon;
import Unity.Player;
import t_enum.Rarity;

import java.util.List;

public class Spectre extends Enemy {

	private final String NAME;

	public Spectre(String name, List<Item> i, int w, List<String> s, Rarity r, int c){

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
			super.getItemList().forEach( item -> {
				p.getItemList().add( item );
				System.out.println("Vous obtenez " + item.getId().getName() + ".");
			} );

			super.setDead( true );
		}
	}

	public String getNAME() {
		return NAME;
	}
}