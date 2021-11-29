package Item.Weapons;

import Item.Identity;
import t_enum.Rarity;

public class AzraelBlade extends Weapon {

    public AzraelBlade(int d, Rarity r, Identity id, boolean b, int durability){
        super.setDamage( d );
        super.setMyRarity( r );
        super.setId( id );

        super.setDurability( durability );
        super.setUsable( b );
    }
}
