package Item.Weapons;

import Item.Identity;
import t_enum.Rarity;

public class SilverDagger extends Weapon {


    public SilverDagger(int d, Rarity r, Identity id, boolean b, int durability){
        super.setDamage( d );
        super.setMyRarity( r );
        super.setId( id );

        super.setDurability( durability );
        super.setUsable( b );
    }
}