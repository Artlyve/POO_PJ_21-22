package Game;
import Item.*;
import Item.Item;
import Item.Key;
import Item.Weapons.*;
import Place.Exit.Exit;
import Place.Exit.LockDoor;
import Place.Place;
import Unity.Enemy.Spectre;
import Unity.NPC.Gardener;
import Unity.Player;
import Unity.Unit;
import t_enum.Rarity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game {

	private List<Place> PlaceList;
	private Interaction myInteraction;



	/******************************	KEYS	*********************************/
	private Key  keyVS = new Key("Clé pour se rendre à l'escalier", 0);
	private Key  keyC2C1 = new Key("Clé pour se rendre au Couloir 1", 1);
	private Key  keyC2C3 = new Key("Clé pour se rendre au Couloir 3", 2);
	private Key  keySpecial1 = new Key("Clé pour ouvrir toutes les portes de la cuisine", 3);
	private Key  keyC1SM = new Key("Clé pour ouvrir se rendre à la salle à manger", 4);
	private Key  keyC3CH3 = new Key("Clé pour ouvrir toutes les portes de la chambre 3", 5);
	private Key  keyC3SJ = new Key("Clé pour ouvrir la salle de jeux", 6);

	/****************************** 	EXITS	*********************************/
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


	/******************************	Identity	*********************************/
	private Identity identityWS = new Identity( 10, "Bâton de combat", "Cette arme à failbe dégat permet d'affronter de simple spectre" );
	private Identity identitySD = new Identity( 50, "Dague en argent", "Une arme assez puissante pour affronter des spectres puisssants" );
	private Identity identityColt = new Identity( 75, "Colt SAA 45.", "Ce petit pistolet t'aidera à tuer les spectres" );
	private Identity identityAZB = new Identity( 150,"Lame d'Azrael", "La lame d'Azrael, cette lame si spécial qu'elle tuera n'importe qu'elle Demon" );
	private Identity identitySB = new Identity( 6, "Chargeur du Colt", "");

	/******************************	Lists Items	*********************************/
	///////////////////////////////// For Player

	private Battery battery = new Battery();
	private Flashlight flashlight = new Flashlight(battery);
	private WoodStaff woodStaff = new WoodStaff( 20, Rarity.common, identityWS, false);

	private List<Item> itemsPlayer = new ArrayList<Item>();


	////////////////////////////// For gardener

	private WoodStaff woodStaffGardener = new WoodStaff( 20, Rarity.common, identityWS, false );
	private AzraelBlade azraelBladeGardener = new AzraelBlade( 100, Rarity.epic, identityAZB, false );
	private SilverDagger silverDaggerGardener = new SilverDagger( 50, Rarity.unusual, identitySD,false );
	private ColtSAA45 coltSAA45Gardener = new ColtSAA45( 60, Rarity.unusual, identityColt, new SilverBullet( 6, identitySB ),false );
	private Lighter lighterGardener = new Lighter();
	private MagicTablet magicTablet = new MagicTablet();

	private List<Item> itemsGardener = new ArrayList<Item>();
	private List<Item> itemsSecret = new ArrayList<Item>();

	private SilverDagger SDGardener = new SilverDagger( 75, Rarity.unusual, identitySD,false );


	///////////////////////////////// For Spectre

	private List<Item> itemsSpectre00 = new ArrayList<Item>();
	private List<Item> itemsSpectre01 = new ArrayList<Item>();
	private List<Item> itemsSpectre02 = new ArrayList<Item>();


	///////////////////////////// For Cheat
	private  MagicTabletFragment magicTabletFragment00 = new MagicTabletFragment();
	private  MagicTabletFragment magicTabletFragment01 = new MagicTabletFragment();
	private  MagicTabletFragment magicTabletFragment02 = new MagicTabletFragment();

	/////////////////////////// For Vestibule
	private Key keyChestVestibule = new Key( "Clé du coffre Vestibule", 7);
	private List<Item> itemsChestVestibule = new ArrayList<Item>();
	private Chest chestVestibule = new Chest( keyChestVestibule,initItemList( itemsChestVestibule, new Food(), new Food(), new Food() ) );

	/******************************	Units	*********************************/
	private Player myPlayer = new Player( "Arthur",
			initItemList( itemsPlayer, flashlight, woodStaff, new Battery(), new Battery() ) ,10, this.garden );

	private Gardener gardener = new Gardener( "Edward",
			initItemList( itemsGardener, woodStaffGardener, azraelBladeGardener, silverDaggerGardener, coltSAA45Gardener, lighterGardener ),
			initItemList( itemsSecret, magicTablet, keyVS ), 0, SDGardener);

	/*Units Vestibule*/

	private Spectre spectre00 = new Spectre( "Roger le spectre",
			initItemList( itemsSpectre00, new Lighter(), new Battery(), new Battery() ), 10, Rarity.common );
	private Spectre spectre01 = new Spectre( "Mirielle l'accro au sport",
			initItemList( itemsSpectre00, new Food(), new Sedative() ), 5, Rarity.common );
	private Spectre spectre02 = new Spectre( "Bob le bricoleur", initItemList( itemsSpectre02, keyChestVestibule ), 0, Rarity.common );

	/******************************	Places	*********************************/
	//////////////////////////Garden
	private List<Unit> unitListGarden = new ArrayList<>();
	private List<Exit> exitsListGarden = new ArrayList<>();
	private List<Item> itemsGarden = new ArrayList<Item>();

	private Place garden = new Place( "Jardin",
			initItemList( itemsGarden, magicTabletFragment00, new Candle(), new Candle() ),
			initUnitList( unitListGarden, gardener ),
			initExitList( exitsListGarden, jv ), "", 0);


	////////////////////////////////// Vestibule
	private List<Unit> unitListVestibule = new ArrayList<>();
	private List<Exit> exitsListVestibule = new ArrayList<>();
	private List<Item> itemsListVestibule = new ArrayList<Item>();

	private Place Vestibule = new Place( "Vestibule"
			,initItemList( itemsListVestibule, new Candle(), new Candle(), magicTabletFragment01, chestVestibule )
			,initUnitList( unitListVestibule, spectre00, spectre01, spectre02 )
			,initExitList( exitsListGarden, jv, vc2, ev ), "", 0
			);






	public List<Exit> initExitList(List<Exit> listExits,Exit...exits){

		Collections.addAll( listExits, exits );
		return listExits;

	}
	public List<Unit> initUnitList(List<Unit> listUnits,Unit...units){

		Collections.addAll( listUnits, units );
		return listUnits;

	}
	public List<Item> initItemList(List<Item> listItems,Item...items){

		Collections.addAll( listItems, items );
		return listItems;

	}

	public List<Battery> createNBBat(int n){
		List<Battery> b = new ArrayList<Battery>();
		for(int i = 1; i <= n; i++){
			b.add( new Battery() );
		}
		return b;
	}

}