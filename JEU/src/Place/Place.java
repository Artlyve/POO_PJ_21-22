package Place;

import Place.Exit.Exit;
import Interface.Printable;
import Item.Item;
import Unity.Unit;

import java.util.List;

public class Place implements Printable {

	private final String NAME;
	private List<Exit> ExitList;
	private List<Item> ItemList;
	private List<Unit> UnitList;

	/**
	 * 
	 * @param NAME
	 * @param ItemList
	 * @param UnitList
	 */
	public Place(int NAME, int ItemList, int UnitList) {
		// TODO - implement Place.Place.Place.Place
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param Place
	 */
	public boolean isNeighbor(int Place) {
		// TODO - implement Place.Place.isNeighbor
		throw new UnsupportedOperationException();
	}

	public boolean isPlayerHere() {
		// TODO - implement Place.Place.isPlayerHere
		throw new UnsupportedOperationException();
	}

	@Override
	public void print() {

	}
}