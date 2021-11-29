package Unity.NPC;

import Item.Item;
import Item.Weapons.Weapon;
import Unity.Enemy.Enemy;
import Unity.Player;
import java.util.*;

public class Gardener extends Npc {

	private String NAME;
	private List<Item> ItemList = new ArrayList<Item>();


	public void exchange() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Entrez l'identifiant de l'article : ");

	}

	/**
	 * 
	 * @param Items
	 */
	public void craft(int Items) {
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