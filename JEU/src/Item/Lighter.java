package Item;

public class Lighter extends Item {

    private boolean isLight;
    private Battery battery;

    public Lighter() {
        super();
        this.isLight = false;
        this.battery = new Battery();
    }

    public boolean light() {
        if (this.battery != null) {
            this.battery.use();
            this.isLight = true;

        }else{
            this.isLight = false;
        }

        return this.isLight;
    }

    public void freeBattery() {
        if (this.battery != null) {
            this.battery = null;

        }
    }

    public void changeBattery(Battery b) {
        this.freeBattery();
        this.battery = b;

    }

    public boolean getLight() {
        return this.isLight;
    }

    Battery getBattery() {
        return battery;
    }
}