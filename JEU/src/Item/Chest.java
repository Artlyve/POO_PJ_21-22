package Item;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chest extends Item {

	protected boolean state;
	private boolean locked;
	private List<Item> ItemList = new ArrayList<Item>();
	private Key myKey;

	public Chest(Key key) {
		this.myKey = key;
		close(myKey);
		this.ItemList.addAll(Arrays.asList());
	}

	public void open(Key k){
		this.state = true;
	}

	public void close(Key k){
		this.state = false;
	}

	public void lock(Key k) {
		if(!this.isState() && k == this.myKey){
			this.locked = true;
		}else{
			System.out.println("Attention tu ne peux pas la vérouiller, ta porte est ouverte");
		}
	}

	public void unLock(Key k) {
		if(!this.isState() && k == this.myKey){
			this.locked = false;
		}else{
			System.out.println("Attention ta porte est ouverte !");
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