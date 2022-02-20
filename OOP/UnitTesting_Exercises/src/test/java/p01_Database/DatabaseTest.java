package p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class DatabaseTest {
    private static final Integer[] NUMBERS = {1, 2, 3, 4};


    private Database dataBase;

    @Before
    public void setUp() throws OperationNotSupportedException {
        dataBase = new Database(NUMBERS);
    }

    @Test
    public void testConstructorCreateObject() {
        Assert.assertEquals(4, NUMBERS.length);
        Integer[] dbElements = dataBase.getElements();
        Assert.assertEquals(NUMBERS.length, dbElements.length);
        Assert.assertArrayEquals(NUMBERS, dbElements);
        int index = NUMBERS.length - 1;
        Assert.assertEquals(index, dbElements.length - 1);
    }


    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionMoreThan16() throws OperationNotSupportedException {
        Integer[] broken = new Integer[17];
        new Database(broken);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionLessThan1() throws OperationNotSupportedException {
        Integer[] broken = new Integer[0];
        new Database(broken);
    }

    @Test
    public void testAddElementSuccessful() throws OperationNotSupportedException {
        dataBase.add(6);
        Integer[] dbElements = dataBase.getElements();
        Assert.assertEquals(Integer.valueOf(6), dbElements[dbElements.length - 1]);
        Assert.assertEquals(NUMBERS.length + 1, dbElements.length);
    }


    @Test(expected = OperationNotSupportedException.class)
    public void testAddMethodThrowsException() throws OperationNotSupportedException {
        dataBase.add(null);
    }

    @Test
    public void testRemoveElementSuccessful() throws OperationNotSupportedException {
        dataBase.remove();
        Integer[] dbElements = dataBase.getElements();
        Assert.assertEquals(NUMBERS.length - 2, dbElements.length - 1);
        Assert.assertEquals(NUMBERS[NUMBERS.length - 2], dbElements[dbElements.length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveElementThrowException() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            dataBase.remove();
        }
        dataBase.remove();
    }
}