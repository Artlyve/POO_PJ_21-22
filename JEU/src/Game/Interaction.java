package Game;

import Item.Item;
import Place.Exit.LockDoor;
import Place.Exit.Exit;
import Place.Exit.MagicDoor;
import Place.Place;
import Unity.Player;
import Item.MagicTablet;

import Item.Key;

public class Interaction {


	public void go(Place dest, Place src, Player p) {


		if(src.isNeighbor(dest)){
			Exit e = src.getNeighbor( dest );
			if(e instanceof LockDoor){
				if(((LockDoor) e).isLocked()){

					p.getItemList().forEach( item -> {
						if(item == ((LockDoor) e).getMyKey()){
							System.out.println("Vous possédez la clé pour rentrer dans la pièce, Vous l'utilisez pour entrer dans " + dest.getNAME() +".");
							((LockDoor) e).open( ((Key) item) );
							p.getItemList().remove( item );
							dest.getUnitList().add( p );
							src.getUnitList().remove( p );


						}else {
							System.out.println("Vous ne pouvez pas accéder à cette pièce: " + dest.getNAME());
							System.out.println("Une clé est requise: " + ((LockDoor) e).getMyKey().getName());
						}
					} );


			}}else if(e instanceof MagicDoor){
				p.getItemList().forEach( item -> {
					if(item == ((MagicDoor) e).getMyTablet()){
						((MagicDoor) e).open((MagicTablet) item);
						System.out.println("La tablette à ouvert la porte, vous y entrez.");
						dest.getUnitList().add( p );
						src.getUnitList().remove( p );
						p.getItemList().remove( item );
					}else{
						System.out.println("Il semble qu'un objet sois requis pour entrer dans cette pièce.");
					}
				} );
			}else{
				if(e.isState()){
					e.open();
					System.out.println("La porte était fermée, vous l'ouvrez et entrez dans la pièce" + dest.getNAME() + ".");
					dest.getUnitList().add( p );
					src.getUnitList().remove( p );
				}
			}
		}

	}

	public void help() {
		System.out.println("Voici les actions que vous pouvez effectuer");
		System.out.println("\t-GO [Location], permet de se rendre dans un lieu");
	}


	public void look(Place p) {
		// TODO - implement Game.Interaction.LOOK
		throw new UnsupportedOperationException();
	}


	public void take(Item p) {
		// TODO - implement Game.Interaction.TAKE
		throw new UnsupportedOperationException();
	}

	public void quit() {
		// TODO - implement Game.Interaction.QUIT
		throw new UnsupportedOperationException();
	}


	public void use(Item Items) {
		// TODO - implement Game.Interaction.USE
		throw new UnsupportedOperationException();
	}

	public void gardener() {
		// TODO - implement Game.Interaction.GARDENER
		throw new UnsupportedOperationException();
	}

}