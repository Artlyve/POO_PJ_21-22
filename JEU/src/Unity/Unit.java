package Unity;

import Interface.Attack;
import Interface.Printable;
import Item.Item;
import Unity.Enemy.Enemy;

import java.util.List;

public abstract class Unit implements Attack, Printable {


	private final int MAX_HEALTH = 100;
	private int Wallet;
	private List<Item> ItemList;
	private int Health;



	public <T extends Item> void deleteItem(T e){
		ItemList.remove( e );
	}

	public int getWallet() {
		return Wallet;
	}

	public void setWallet(int wallet) {
		Wallet = wallet;
	}

	public List<Item> getItemList() {
		return ItemList;
	}

	public void setItemList(List<Item> itemList) {
		ItemList = itemList;
	}

	public int getHealth() {
		return Health;
	}

	public void setHealth(int health) {
		Health = health;
	}

	public int getMAX_HEALTH() {
		return MAX_HEALTH;
	}

}