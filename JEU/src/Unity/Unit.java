package Unity;

import Interface.Attack;
import Interface.Printable;
import Item.Item;

import java.util.List;

public abstract class Unit implements Attack, Printable {

	private int Wallet;
	private List<Item> ItemList;
	private int Health;

	public void Attack() {
		// TODO - implement Unity.Unit.Interface.Attack
		throw new UnsupportedOperationException();
	}

}