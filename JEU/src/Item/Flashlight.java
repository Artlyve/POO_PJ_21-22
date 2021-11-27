package Item;

import Item.Battery;
import Item.Item;

public class Flashlight extends Item {

    private Battery battery;

    public Flashlight() {
        super();
    }

    public void freeBattery() {
        if (this.battery != null) {
            Battery oldBattery = this.battery;
            this.battery = null;
            oldBattery.freeFlashlight();
        }
    }

    public void changeBattery(Battery b) {
        this.freeBattery();
        b.freeFlashlight();
        this.battery = b;
        b.setFlashlight(this);
    }

    public boolean light() {
        if ((this.battery != null) && !(this.battery.isEmpty())) {
            this.battery.use();
            return true;
        }
        return false;
    }

    Battery getBattery() {
        return battery;
    }
}