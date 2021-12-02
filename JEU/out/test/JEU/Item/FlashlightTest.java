package Item;

import static org.junit.After;
import static org.junit.Before;
import static org.junit.Test;
import static org.junit.Assert.*;

public class FlashlightTest {

    private Battery battery1;
    private Identity id;
    private Identity idBat;
    private Flashlight flashlight1;

    @Before
    public void setUp() {
        battery1 = new Battery(idBat);
        flashlight1 = new Flashlight(battery1, id);
    }

    @Test
    public void testFreeBattery() {
        flashlight1.freeBattery();
        assertNull(flashlight1.getBattery());
    }

    @Test
    public void testFreeBattery2() {
        flashlight1.changeBattery(battery1);
        flashlight1.freeBattery();
        assertNull(flashlight1.getBattery());
        assertNull(battery1.getFlashlight());
    }

    @Test
    public void testChangeBattery() {
        flashlight1.changeBattery(battery1);
        assertSame(flashlight1.getBattery(), battery1);
        assertSame(battery1.getFlashlight(), flashlight1);
    }

    @Test
    public void testTurnOn() {
        while (battery1.getLevel() > 0) {
            assertTrue(flashlight1.isActivate());
            battery1.use();
        }
        assertFalse(flashlight1.isActivate());
    }

    @Test
    public void testTurnOff() {
        assertFalse(flashlight1.isActivate());
    }
}