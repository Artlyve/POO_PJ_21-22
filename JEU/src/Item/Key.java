package Item;

public class Key extends Item {

	public final static String DEFAULT_NAME = "nom";
	public final static int DEFAULT_ID = 0;

	private final String NAME;
	private final int ID;

	public Key(String n, int id) {
		this.NAME = n;
		this.ID = id;
	}

	public String getName() {
		return NAME;
	}

	public int getID() {
		return ID;
	}
}