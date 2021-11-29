package Interface;

import Item.Weapons.Weapon;
import Unity.Enemy.Enemy;
import Unity.Player;

public interface Attack {

	<T extends Enemy>void AttackEnemy(T e, Weapon w);
	void AttackPlayer(Player p);
}