public class CosmicalRayBlaster extends Weapon {

    public CosmicalRayBlaster(int d, Rarity r, IdentityItem id, boolean b, int durability){
        super.setDamage( d );
        super.setMyRarity( r );
        super.setId( id );

        super.setDurability( durability );
        super.setUsable( b );
    }

}