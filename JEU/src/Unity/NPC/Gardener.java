package Unity.NPC;

import Item.Weapons.Weapon;
import Unity.Enemy.Enemy;
import Unity.Player;

public class Gardener extends Neutral {

	private String NAME;

	public void exchange() {
		// TODO - implement Unity.NPC.Gardener.exchange
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Items
	 */
	public void craft(int Items) {
		// TODO - implement Unity.NPC.Gardener.craft
		throw new UnsupportedOperationException();
	}

	@Override
	public void print() {

	}

	@Override
	public <T extends Enemy> void AttackEnemy(T e, Weapon w) {

	}

	@Override
	public void AttackPlayer(Player p) {

	}
}