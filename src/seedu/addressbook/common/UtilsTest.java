package seedu.addressbook.common;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import org.junit.Test;

import java.util.ArrayList;

public class UtilsTest {

    @Test
    public void testIsAnyNull_true() {
        assertTrue(Utils.isAnyNull("hellos", 23, null));
    }
    
    @Test
    public void testIsAnyNull_false() {
        assertFalse(Utils.isAnyNull("ready", "or", "not"));
    }

    @Test
    public void testElementsAreUnique_true() {
        ArrayList<Object> items = new ArrayList<Object>();
        items.add(3);
        items.add("a unique string");
        items.add("a ununique string");
        assertTrue(Utils.elementsAreUnique(items));
    }
    
    @Test
    public void testElementsAreUnique_false() {
        ArrayList<Object> items = new ArrayList<Object>();
        items.add("i am original");
        items.add("i am original");
        items.add("there cannot be two originals");
        assertFalse(Utils.elementsAreUnique(items));
    }

}
