package Unity.Enemy;

import Interface.Talk;
import Unity.NPC.Npc;

import java.util.List;
import java.util.Random;

public abstract class Enemy extends Npc implements Talk {

	private final int MAX_TALKING = 10;
	private final int MIN_TALKING = 1;

	private List<String> talking;

	@Override
	public void Talk() {

		Random r = new Random();
		System.out.println(this.talking.get( r.nextInt((this.MAX_TALKING - this.MIN_TALKING) + 1) + this.MIN_TALKING) );

	}

	public List<String> getTalking() {
		return talking;
	}

	public void setTalking(List<String> talking) {
		this.talking = talking;
	}

	public int getMAX_TALKING() {
		return MAX_TALKING;
	}

	public int getMIN_TALKING() {
		return MIN_TALKING;
	}
}