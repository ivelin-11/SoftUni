package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class HeroTest {

    private Hero hero;

    @Before
    public void setUp() {
        Weapon weapon = Mockito.mock(Weapon.class);
        this.hero = new Hero("Batman", weapon);
    }

    @Test
    public void testTargetStillAliveHeroGetNoXP() {
        Target mock = Mockito.mock(Target.class);
        Mockito.when(mock.isDead()).thenReturn(false);
        Mockito.when(mock.giveExperience()).thenReturn(100);

        this.hero.attack(mock);
        assertEquals(0, this.hero.getExperience());
    }

    @Test
    public void testTargetDeadHeroGetXP() {
        Target mock = Mockito.mock(Target.class);
        Mockito.when(mock.isDead()).thenReturn(true);
        Mockito.when(mock.giveExperience()).thenReturn(100);

        this.hero.attack(mock);
        assertEquals(100,this.hero.getExperience());
    }
}