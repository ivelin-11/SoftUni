package cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class HouseTests {

    private House catHouse;

    @Before
    public void setUp() {
        catHouse = new House("Pansion", 5);
        catHouse.addCat(new Cat("Tom"));
        catHouse.addCat(new Cat("Rocky"));
        catHouse.addCat(new Cat("Timy"));
    }

    @Test
    public void testAddSuccessful() {
        Cat catToAdd = new Cat("Added!");
        catHouse.addCat(catToAdd);
        Assert.assertEquals(catToAdd, catHouse.catForSale(catToAdd.getName()));
    }


    @Test(expected = IllegalArgumentException.class)
    public void testAddThrowExceptionWhenHouseIsFull() {
        Cat catToAdd = new Cat("Added!");
        catHouse.addCat(catToAdd);
        Cat test = new Cat("last!");
        catHouse.addCat(catToAdd);
        Cat broke = new Cat("Broke!");
        catHouse.addCat(broke);
    }

    @Test
    public void testGetName() {
        Assert.assertEquals("Pansion", catHouse.getName());
    }

    @Test
    public void testCreateHouseSuccesfull() {
        House test = new House("test", 2);
        Assert.assertNotNull(test);
    }
    @Test
    public void testCreateHouseSuccesfullWithZeroCapacity() {
        House test = new House("test", 0);
        Assert.assertNotNull(test);
    }
    @Test(expected = NullPointerException.class)
    public void testCtorThrowNullName() {
        House house = new House(null, 1);
        ;
    }

    @Test(expected = NullPointerException.class)
    public void testCtorThrowNullNameWithWhyteSpace() {
        House house = new House("    ", 1);
    }

    @Test
    public void testGetCapacitySuccessful() {
        Assert.assertEquals(5, catHouse.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCtorThrowExceptionCapacityLessThanZero() {
        House house = new House("test", -1);
    }

    @Test
    public void testGetCount() {
        Assert.assertEquals(3, catHouse.getCount());
    }

    @Test
    public void testRemoveSuccesfull() {
        Cat catToRemove = new Cat("remove");
        catHouse.addCat(catToRemove);
        catHouse.removeCat("remove");
    }



    @Test(expected = IllegalArgumentException.class)
    public void testRemoveTrhowErrorNotContainsName() {
        catHouse.removeCat("remove");
    }

    @Test
    public void testCatForSaleSuccessfull() {
        Cat catToAdd = new Cat("Added!");
        catHouse.addCat(catToAdd);
        Cat cat = catHouse.catForSale("Added!");
        Assert.assertEquals(catToAdd, cat);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testCatForSaleThrowExNotConatainsName() {
        catHouse.catForSale("error");
    }

    @Test
    public void testGetStatistics(){
        String statistics = catHouse.statistics();
        Assert.assertEquals(statistics,catHouse.statistics());
    }

    @Test
    public void testGetIsHungry(){
        Cat catToAdd = new Cat("Hungry");
        Assert.assertTrue(catToAdd.isHungry());
    }
}
