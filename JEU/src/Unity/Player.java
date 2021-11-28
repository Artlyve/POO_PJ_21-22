package Unity;

import Item.Food;
import Item.Item;
import Item.Sedative;
import Item.Weapons.Weapon;
import Unity.Enemy.Enemy;
import t_enum.Rarity;

import java.util.List;

public class Player extends Unit {

	private final String NAME;
	private int mentalHealth;
	private boolean attaked;

	public Player(String name, List<Item> i, int w) {

		this.NAME = name;
		this.attaked = false;
		this.mentalHealth = super.getMAX_HEALTH();
		super.setDead( false );
		super.setHealth( super.getMAX_HEALTH() );
		super.setWallet( w );
		super.setItemList( i );
	}

	@Override
	public void print() {

	}


	//Méthode restauration des HP, usage unique supprimé des items que possèdent le joueur
	public void restoreH(Food f){
		if(super.getHealth()+f.getHealth() > 100 ){
			super.setHealth( 100 );
		}else {
			super.setHealth( super.getHealth() + f.getHealth() );
		}
		super.deleteItem( f );
	}

	//Méthode restauration du Mental, usage unique supprimé des items que possèdent le joueur
	public void restoreMH(Sedative s){

		if(this.getMentalHealth() + s.getHealing() > 100){
				setMentalHealth( 100 );
		}else{
				this.setMentalHealth( this.getMentalHealth() + s.getHealing() );
		}
		super.deleteItem( s );
	}

	public int getMentalHealth() {
		return mentalHealth;
	}

	public void setMentalHealth(int mentalHealth) {
		this.mentalHealth = mentalHealth;
	}




	public boolean canAttak(Enemy e, Weapon w){
		if(e.getMyRarity() == Rarity.common && w.getMyRarity() == Rarity.common){
			this.attaked = true;
		}else if(e.getMyRarity() == Rarity.unusual && w.getMyRarity() == Rarity.unusual){
			this.attaked = true;
		}else if(e.getMyRarity() == Rarity.epic && w.getMyRarity() == Rarity.epic){
			this.attaked = true;
		}else if(e.getMyRarity() == Rarity.legendary && w.getMyRarity() == Rarity.legendary){
			this.attaked = true;
		}else if(e.getMyRarity() == Rarity.common && ( w.getMyRarity() == Rarity.common
				|| w.getMyRarity() == Rarity.unusual || w.getMyRarity() == Rarity.epic
				|| w.getMyRarity() == Rarity.legendary)){
			this.attaked = true;
		}else if(e.getMyRarity() == Rarity.unusual && ( w.getMyRarity() == Rarity.unusual
				|| w.getMyRarity() == Rarity.epic || w.getMyRarity() == Rarity.legendary)){
			this.attaked = true;
		}else if(e.getMyRarity() == Rarity.epic && (w.getMyRarity() == Rarity.epic || w.getMyRarity() == Rarity.legendary)){
			this.attaked = true;
		}else {
			this.attaked = false;
		}

		return this.attaked;
	}


	//Manque méthode dead
	@Override
	public <T extends Enemy>void AttackEnemy(T e, Weapon w) {
		if(canAttak( e, w )){

			if(e.getHealth()-w.getDamage() < 0){
				e.dead(this);

			}else {
				e.setHealth( w.getDamage() );

			}
			w.use();
			this.attaked = false;
		}
	}


}