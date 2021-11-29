package Item;

import Interface.Printable;

public abstract class Item implements Printable {

	private IdentityItem id;


	@Override
	public void print() {

	}
	public IdentityItem getId() {
		return id;
	}

	public void setId(IdentityItem id) {
		this.id = id;
	}

}