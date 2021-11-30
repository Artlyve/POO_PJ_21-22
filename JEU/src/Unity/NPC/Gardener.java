package Unity.NPC;

import Item.Item;
import Item.Weapons.Weapon;
import Unity.Enemy.Enemy;
import Unity.Player;
import Unity.Unit;

import java.util.*;

public class Gardener extends Npc {

	private final String NAME;
	protected boolean talkative;
	private List<Item> items = null;

	public Gardener(String name, List<Item> i, int wa, Weapon we, int c) {
		this.NAME = name;
		this.talkative = false;
		super.setDead(false);
		super.setHealth(super.getMAX_HEALTH());
		super.setWallet(wa);
		super.setItemList(i);
		super.setWeapon(we);
		super.setCc_attack(c);
	}

	public void exchange() {
		if (this.talkative = true) {
			System.out.println("Voici quelques articles en ma possession : ");
			items.forEach( item -> {
				System.out.println("\t-"+ item.getId().getName() + item.getId().getValue() + "\n" + item.getId().getDescription());
				Scanner sc = new Scanner(System.in);
				System.out.println("Indique moi le nom de l'article qui t'intéresse : ");
				String answer = sc.next();
				if (answer == item.getId().getName()) {
					if (super.getWallet() >= item.getId().getValue()) {
						System.out.println("Voici ton article.");
						System.out.println("\t" + item.getId().getName() + item.getId().getValue() + "\n" + item.getId().getDescription());
					}else {
						System.out.println("Tu n'as pas assez d'argent pour pouvoir acheter cet article !");
					}
				} else {
					System.out.println("Je ne possède pas cet article sur moi.");
				}
			} );
		}
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

	public String getNAME() {
		return NAME;
	}

	public boolean isTalkative() {
		return talkative;
	}

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}

	@Override
	public void dead(Player p) {
		if(super.getHealth() == 0){
			System.out.println("Vous avez vaincu " + this.getNAME() + " !");
			super.setDead( true );
		}
	}
}