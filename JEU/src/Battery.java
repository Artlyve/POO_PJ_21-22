public class Battery extends Item {

    public final static int DEFAULT_LEVEL = 3;
    private int level;
    private Flashlight flashlight = null;

    public Battery() {
        super();
        this.level = Battery.DEFAULT_LEVEL;
    }

    public void freeFlashlight() {
        Flashlight oldFlashlight = this.flashlight;
        this.flashlight = null;
        if (oldFlashlight != null) {
            oldFlashlight.freeBattery();
        }
    }

    public void setFlashlight(Flashlight f) {
        if (f == null) {
            this.freeFlashlight();
        }
        else {
            if (f.getBattery() == this) {
                this.flashlight = f;
            }
            else {
                f.changeBattery(this);
            }
        }
    }

    public void use() {
        if (!this.isEmpty()) {
            this.level--;
        }
    }

    public boolean isEmpty() {
        return this.level == 0;
    }

    Flashlight getFlashlight() {
        return this.flashlight;
    }

    public int getLevel() {
        return this.level;
    }
}