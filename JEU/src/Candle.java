public class Candle extends Item {

    public final static int DEFAULT_LEVEL = 4;
    private int level;
    private Lighter lighter = null;
    private boolean usable;

    public Candle() {
        super();
        this.level = DEFAULT_LEVEL;
        this.usable = true;
    }

    public void use() {
        if (!this.isEmpty()) {
            this.level--;
        }
    }

    public boolean isEmpty() {
        if (this.level == 0) {
            this.usable = false;
        }
        return usable;
    }

    public int getLevel() {
        return this.level;
    }

    public boolean light() {
        if (!(this.isEmpty())) {
          this.use();
          return true;
        }
        return false;
    }
}