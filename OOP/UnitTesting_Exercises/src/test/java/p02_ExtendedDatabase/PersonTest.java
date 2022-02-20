package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    private static final String NAME = "Anastasiy";
    private static final int ID = 2;

    @Test
    public void testContructorSuccessfulCreated() {
        Person person = new Person(ID, NAME);
        Assert.assertEquals(NAME,person.getUsername());
        Assert.assertEquals(ID, person.getId());
    }
}