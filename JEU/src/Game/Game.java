package Game;
import Item.*;
import Item.Item;
import Item.Key;
import Place.Exit.Exit;
import Place.Exit.LockDoor;
import Place.Place;
import Unity.NPC.Gardener;
import Unity.Player;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private List<Place> PlaceList;
	private Interaction myInteraction;



	/*Key*/
	private Key  keyVS = new Key("Clé pour se rendre à l'escalier", 0);
	private Key  keyC2C1 = new Key("Clé pour se rendre au Couloir 1", 1);
	private Key  keyC2C3 = new Key("Clé pour se rendre au Couloir 3", 2);
	private Key  keySpecial1 = new Key("Clé pour ouvrir toutes les portes de la cuisine", 3);
	private Key  keyC1SM = new Key("Clé pour ouvrir se rendre à la salle à manger", 4);
	private Key  keyC3CH3 = new Key("Clé pour ouvrir toutes les portes de la chambre 3", 5);
	private Key  keyC3SJ = new Key("Clé pour ouvrir la salle de jeux", 6);

	/*Exit*/
	//Jardin à Vestibule
	private Exit jv = new Exit();
	//Vestibule à C2
	private Exit vc2 = new Exit();
	//Escalier à Vestibule
	private LockDoor ev = new LockDoor( this.keyVS );
	//C2 à Salon
	private Exit c2s = new Exit();
	//C2 à C1
	private LockDoor c2c1 = new LockDoor( this.keyC2C1 );
	//C2 à C3
	private LockDoor c2c3 = new LockDoor( this.keyC2C3 );
	//Salon à Cuisine
	private LockDoor scui = new LockDoor( this.keySpecial1 );
	//C1 à B1
	private Exit c1b1 = new Exit();
	//C1 à CH1
	private Exit c1ch1 = new Exit();
	//C1 à SM
	private LockDoor c1sm = new LockDoor( this.keyC1SM );
	//C1 à Cui
	private LockDoor c1cui = new LockDoor( this.keySpecial1  );
	//SM à Cui
	private LockDoor smcui = new LockDoor( this.keySpecial1  );
	//C3 à CH2
	private Exit c3ch2 = new Exit();
	//C3 à SB
	private Exit c3sb = new Exit();
	// C3 à CH3
	private LockDoor c3ch3 = new LockDoor( this.keyC3CH3  );
	//C3 à SJ
	private LockDoor c3sj = new LockDoor( this.keyC3SJ );
	//CH2 à SB
	private Exit ch2sb = new Exit(  );
	//CH3 à SJ
	private Exit ch3sj = new Exit( );



	/*Items*/
	private Battery battery = new Battery();
	private Flashlight flashlight = new Flashlight(battery);



	/*
	* Les liste items*/

	//Pour player
	private List<Item> itemsPlayer = new ArrayList<Item>();


	/*
	* Unit
	* */
	private Player myPlayer = new Player( "Arthur", this.itemsPlayer ,10, this.garden );
	private Gardener gardener = new Gardener(  );
	/*Places*/
	private Place garden = new Place(  );

}