package Place;

import Place.Exit.Exit;
import Interface.Printable;
import Item.Item;
import Unity.Player;
import Unity.Unit;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Place implements Printable {

	private final String NAME;
	private List<Exit> ExitList;
	private List<Item> ItemList;
	private List<Unit> UnitList;
	private boolean neighbor;
	private boolean playerHere;


	public Place(String n, List<Item> i, List<Unit>  u, List<Exit> e) {
		this.NAME = n;
		this.ItemList = i;
		this.UnitList = u;
		this.ExitList = e;
		this.neighbor = false;
		this.playerHere = false;
	}


	public boolean isNeighbor(Place p) {

		this.neighbor = false;
		this.ExitList.forEach( exit -> {
			p.ExitList.forEach( exit1 -> {
				if(exit == exit1){
					this.neighbor = true;
				}

			} );
		} );
		return this.neighbor;
	}

	public Exit getNeighbor(Place p){
		AtomicReference<Exit> e = null;
		this.ExitList.forEach( exit -> {
			p.ExitList.forEach( exit1 -> {
				if(exit == exit1){
					e.set( exit );
				}

			} );
		} );

		return e.get();
	}

	public boolean isPlayerHere() {
		this.playerHere = false;
		this.UnitList.forEach( unit -> {
			if(unit instanceof Player){
				this.playerHere = true;
			}
		} );

		return this.playerHere;
	}

	@Override
	public void print() {

	}

	public String getNAME() {
		return NAME;
	}

	public List<Exit> getExitList() {
		return ExitList;
	}

	public void setExitList(List<Exit> exitList) {
		ExitList = exitList;
	}

	public List<Item> getItemList() {
		return ItemList;
	}

	public void setItemList(List<Item> itemList) {
		ItemList = itemList;
	}

	public List<Unit> getUnitList() {
		return UnitList;
	}

	public void setUnitList(List<Unit> unitList) {
		UnitList = unitList;
	}

	public boolean isNeighbor() {
		return neighbor;
	}

	public void setNeighbor(boolean neighbor) {
		this.neighbor = neighbor;
	}

	public void setPlayerHere(boolean playerHere) {
		this.playerHere = playerHere;
	}
}