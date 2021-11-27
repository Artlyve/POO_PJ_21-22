package Item.Weapons;

import Item.IdentityItem;
import Item.SilverBullet;
import t_enum.Rarity;

public class ColtSAA45 extends Weapon {

    private SilverBullet gunMagazine;

    public ColtSAA45(int d, Rarity r, IdentityItem id, int nbAmmo, IdentityItem idAmmo, boolean b, int durability){
        this.gunMagazine = new SilverBullet( nbAmmo, idAmmo );
        super.setDamage( d );
        super.setMyRarity( r );
        super.setId( id );

        super.setDurability( durability );
        super.setUsable( b );
    }

    public SilverBullet getGunMagazine() {
        return gunMagazine;
    }

    public void setGunMagazine(SilverBullet gunMagazine) {
        this.gunMagazine = gunMagazine;
    }

    public void reload(SilverBullet gunMagazine) {

        if(this.gunMagazine.getNbAmmo() == 0){
            setGunMagazine( gunMagazine );
        }else{
            this.gunMagazine.setNbAmmo( this.gunMagazine.getMAX_NB_BULLET() );
        }
    }
}