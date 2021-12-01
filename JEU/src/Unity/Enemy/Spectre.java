package Unity.Enemy;

import Item.Item;
import Item.Weapons.Weapon;
import Unity.Player;
import t_enum.Rarity;

import java.util.ArrayList;
import java.util.List;

public class Spectre extends Enemy {

	private final String NAME;

	public Spectre(String name, List<Item> i, int w, Rarity r){
		List<String> talk = new ArrayList<>();
		String talk1 = "MEURT !!";
		talk.add( talk1 );
		String talk2 = "TU VAS MOURRIR !!";
		talk.add( talk2 );
		String talk3 = "BOUUU !!";
		talk.add( talk3 );

		this.NAME = name;

		super.setDead( false );
		super.setHealth( super.getMAX_HEALTH() );
		super.setWallet( w );
		super.setItemList( i );
		super.setMyRarity( r );
		super.setTalking( talk );
		if(super.getMyRarity() == Rarity.common){
			super.setCc_attack( 65 );
		}else if(super.getMyRarity() == Rarity.unusual){
			super.setCc_attack( 75 );
		}else if(super.getMyRarity() == Rarity.epic){
			super.setCc_attack( 85 );
		}else if(super.getMyRarity() == Rarity.legendary){
			super.setCc_attack( 100 );
		}
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