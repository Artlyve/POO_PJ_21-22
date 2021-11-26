public class Candle extends Item {

    public final static int DEFAULT_LEVEL = 4;
    private int level;
    private Lighter lighter = null;

    public Candle() {
        super();
        this.level = Candle.DEFAULT_LEVEL;
    }

    public void use() {
        if (!this.isEmpty()) {
            this.level--;
        }
    }

    public boolean isEmpty() {
        return this.level == 0;
    }
    
    public int getLevel() {
        return this.level;
    }

    public boolean light() {
        return true;
    }
}