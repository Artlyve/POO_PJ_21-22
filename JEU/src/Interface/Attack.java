package Interface;

import Item.Weapons.Weapon;
import Unity.Enemy.Enemy;

public interface Attack {

	<T extends Enemy>void AttackEnemy(T e, Weapon w);

}