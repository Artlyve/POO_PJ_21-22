public class Lighter extends Item {

    private boolean isLight;
    private Battery battery;
    private Candle candle = null;

    public Lighter() {
        super();
        this.isLight = false;
        this.battery = new Battery();
    }

    public boolean light() {
        if (this.battery != null) {
            this.battery.use();
            this.isLight = true;
            return true;
        }
        this.isLight = false;
        return false;
    }

    public boolean getLight() {
        return this.isLight;
    }

    Battery getBattery() {
        return battery;
    }

    Candle getCandle() {
        return candle;
    }
}