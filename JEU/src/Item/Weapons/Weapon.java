package Item.Weapons;
import t_enum.Rarity;
import Item.Item;

public abstract class Weapon extends Item {

	private int damage;
	private Rarity myRarity;
	private int durability;
	private boolean usable;



	public int getDamage() {
		return damage;
	}

	public void broke(){
		if(this.durability == 0 && isUsable()){
			this.usable = false;
		}
	}


	public void setDamage(int damage) {
		this.damage = damage;
	}

	public Rarity getMyRarity() {
		return myRarity;
	}

	public void setMyRarity(Rarity myRarity) {
		this.myRarity = myRarity;
	}


	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	public boolean isUsable() {
		return usable;
	}

	public void setUsable(boolean usable) {
		this.usable = usable;
	}
}