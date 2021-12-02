package Item;

import static org.junit.After;
import static org.junit.Before;
import static org.junit.Test;
import static org.junit.Assert.*;

public class BatteryTest {

    private Battery battery1;

    @Before
    public void setUp() {
        battery1 = new Battery();
    }

    @Test
    public void testIsEmpty() {
        while (battery1.getLevel() > 0) {
            assertFalse(battery1.isEmpty());
            battery1.use();
        }
        assertTrue(battery1.isEmpty());
        assertEquals(battery1.getLevel(), 0);
        battery1.use();
        assertEquals(battery1.getLevel(), 0);
    }

    @Test
    public void testUse() {
        int level = Battery.DEFAULT_LEVEL;
        while (battery1.getLevel() > 0) {
            assertEquals(battery1.getLevel(), level);
            battery1.use();
            level--;
        }
    }

    @Test
    public void testUse2() {
        while (battery1.getLevel() > 0) {
            battery1.use();
        }
        assertEquals(battery1.getLevel(), 0);
        assertTrue(battery1.isEmpty());
    }
}