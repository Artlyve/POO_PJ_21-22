package Unity.Enemy;

import Interface.Talk;
import Unity.NPC.Npc;
import t_enum.Rarity;

public abstract class Enemy extends Npc implements Talk {

	private Rarity myRarity;

	public Rarity getMyRarity() {
		return myRarity;
	}

	public void setMyRarity(Rarity myRarity) {
		this.myRarity = myRarity;
	}
}