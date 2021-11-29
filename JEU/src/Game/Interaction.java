package Game;

import Item.Item;
import Place.Exit.LockDoor;
import Place.Exit.Exit;
import Place.Exit.MagicDoor;
import Place.Place;
import Unity.Enemy.Devil;
import Unity.Enemy.Spectre;
import Unity.Player;
import Item.MagicTablet;

import Item.Key;

import java.util.List;

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


	public void look(List<Place> lp, Place p) {
		System.out.println("Voici les ennemis qui rodent: ");
		p.getUnitList().forEach( unit -> {
			if(unit instanceof Spectre){
				System.out.println("\t-" + ((Spectre) unit).getNAME());
			}else if(unit instanceof Devil){
				System.out.println("\t-" + ((Devil) unit).getNAME());
			}
		} );
		System.out.println("Sortie disponible:");
		lp.forEach( place -> {
			if(place.isNeighbor(p)){
				System.out.println("\t-"+place.getNAME());
			}
		} );
		System.out.println("Objets se trouvant dans la pièce.");
		p.getItemList().forEach( item -> {
			System.out.println("\t-" + item.getId().getName() + ": " + item.getId().getDescription());
		} );



	}


	public void take(Player p, Item i, Place place) {
		System.out.println("Vous ajoutez " + i.getId().getName() + " à votre liste d'objet");
		p.getItemList().add( i );
		place.getItemList().remove( i );
	}

	public void quit() {
		System.exit( 0 );
	}


	public void use(Item Items) {

	}

	public void gardener(Place src, Place dest, Player p) {
		System.out.println("Vous vous redirigez vers le jardinier.");
		dest.getUnitList().add( p );
		src.getUnitList().remove( p );
	}

}