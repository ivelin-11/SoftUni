package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {

    private static final int DUMMY_HEALTH = 100;
    private static final int XP = 50;

    private Dummy dummyAlive;
    private Dummy deadDummy;

    @Before
    public void setUp() {
        dummyAlive = new Dummy(DUMMY_HEALTH, XP);
        deadDummy = new Dummy(0, XP);
    }

    @Test
    public void testDummyLosesHealthWhenAttacked() {
        int attackPoints = 10;
        dummyAlive.takeAttack(attackPoints);
        Assert.assertEquals(DUMMY_HEALTH - attackPoints, dummyAlive.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testDummyThrowWhenAttacked(){
        deadDummy.takeAttack(10);
    }

    @Test
    public void testDeadDummyGivesXP(){
        int actual=deadDummy.giveExperience();
        Assert.assertEquals(actual,deadDummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void testDummyAliveThrowGivesXp(){
        dummyAlive.giveExperience();
    }
}