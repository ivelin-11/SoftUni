package rpg_lab;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AxeTest {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILLITY = 10;

    private Axe axe;
    private Dummy dummy;
    private Axe brokenAxe;

    @Before
    public void setUp() {
        axe = new Axe(AXE_ATTACK, AXE_DURABILLITY);
        dummy = new Dummy(100, 50);
        brokenAxe = new Axe(AXE_ATTACK, 0);
    }

    @Test
    public void testIfAxeLostDurabilityAfterAttack() {
        axe.attack(dummy);
        Assert.assertEquals(AXE_DURABILLITY-1,axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void testAxeAttackThrowIfIsBroken(){
        brokenAxe.attack(dummy);

    }



}