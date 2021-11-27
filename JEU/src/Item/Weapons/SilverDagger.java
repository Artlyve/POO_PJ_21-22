package Item.Weapons;

import Item.IdentityItem;
import t_enum.Rarity;

public class SilverDagger extends Weapon {


    public SilverDagger(int d, Rarity r, IdentityItem id, boolean b, int durability){
        super.setDamage( d );
        super.setMyRarity( r );
        super.setId( id );

        super.setDurability( durability );
        super.setUsable( b );
    }
}