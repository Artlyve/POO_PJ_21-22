package Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chest extends Item {

	protected boolean state;
	private boolean locked;
	private List<Item> ItemList1 = null;
	private List<Item> ItemList2 = null;
	private Key myKey;

	public Chest(Key key, List<Item> ItemList1) {
		this.myKey = key;
		close(myKey);
		this.ItemList1.addAll(Arrays.asList());
	}

	public void open(Key k){
		this.state = true;
		System.out.println("Inventaire du coffre : " + ItemList1);
	}

	public void close(Key k){
		this.state = false;
	}

	public void lock(Key k) {
		if(!this.isState() && k == this.myKey){
			this.locked = true;
		}else{
			System.out.println("Attention tu ne peux pas la vérrouiller, ta porte est ouverte");
		}
	}

	public void unLock(Key k) {
		if(!this.isState() && k == this.myKey){
			this.locked = false;
		}else{
			System.out.println("Attention ta porte est ouverte !");
		}
	}

	public void addItem(List<Item> ItemList1, List<Item> ItemList2) {
		if ((state = true) && (this.ItemList1 != null)) {
			this.ItemList2.addAll(ItemList1);
			System.out.println("Inventaire de votre sac : " + ItemList2);
		}
	}

	public boolean isState() {
		return state;
	}

	public void setState(boolean state) {
		this.state = state;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}

}