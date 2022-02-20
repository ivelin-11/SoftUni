package p02_ExtendedDatabase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class DataBaseTest02 {

    private Database db;
    private Person[] people;

    @Before
    public void setUp() throws OperationNotSupportedException {
        people = new Person[3];
        people[0] = new Person(1, "Radi");
        people[1] = new Person(2, "Marty");
        people[2] = new Person(3, "Ivelin");
        db = new Database(people);
    }

    @Test
    public void testConstructorSuccessCreateObject() {
        Person[] dbPeople = db.getElements();
        Assert.assertEquals(people.length, dbPeople.length);
        Assert.assertArrayEquals(people, dbPeople);
        Assert.assertEquals(2, dbPeople.length - 1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionMoreThan16() throws OperationNotSupportedException {
        Person[] brokenP = new Person[17];
        new Database(brokenP);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowsExceptionLessThan1() throws OperationNotSupportedException {
        Person[] brokenP = new Person[0];
        new Database(brokenP);
    }

    @Test
    public void testAddPersonSuccessfull() throws OperationNotSupportedException {
        Person person = new Person(5, "AZ");
        db.add(person);
        Person[] dbElements = db.getElements();
        Assert.assertEquals(person, dbElements[dbElements.length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddThrowException() throws OperationNotSupportedException {
        db.add(null);
    }


    @Test
    public void testRemovedSuccesfull() throws OperationNotSupportedException {
        db.remove();
        Person[] dbElements = db.getElements();
        Assert.assertEquals(people.length - 1, dbElements.length);
        Assert.assertEquals(people[people.length - 2], dbElements[dbElements.length - 1]);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowException() throws OperationNotSupportedException {
        Person[] elements = db.getElements();
        for (Person person : elements) {
            db.remove();
        }
        db.remove();
    }

    @Test
    public void testFindPersonByNameSuccessful() throws OperationNotSupportedException {
        Person persontToFind = new Person(3, "Ivelin");
        db.findByUsername(persontToFind.getUsername());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindPersonByNameThrowsExceptionNullSearched() throws OperationNotSupportedException {
        db.findByUsername(null);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindPersonThrowsExceptionMorePeopleWithSameName() throws OperationNotSupportedException {

        Person brokePerson = new Person(3, "Ivelin");
        db.add(brokePerson);
        db.findByUsername(brokePerson.getUsername());

    }

    @Test
    public void testFindPersonByIDSuccessfull() throws OperationNotSupportedException {
        Person persontToFind = new Person(3, "Ivelin");
        db.findById(persontToFind.getId());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testFindPersonByIDThrowWhenMorepeopleWithSameID() throws OperationNotSupportedException {
        Person personBroken = new Person(3, "Ivelin");
       db.add(personBroken);
       db.findById(personBroken.getId());

    }
}
