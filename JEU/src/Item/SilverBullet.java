package Item;

public class SilverBullet extends Item {
    private final int MAX_NB_BULLET = 6;
    private int nbAmmo;


    public SilverBullet(int nbAmmo, IdentityItem id) {
        this.nbAmmo = nbAmmo;
        super.setId( id );
    }

    public int getMAX_NB_BULLET() {
        return MAX_NB_BULLET;
    }

    public int getNbAmmo() {
        return nbAmmo;
    }

    public void setNbAmmo(int nbAmmo) {
        this.nbAmmo = nbAmmo;
    }
}