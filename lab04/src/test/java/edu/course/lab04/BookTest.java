package edu.course.lab04;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

class BookTest {

    @Test
    void equalBooksByIsbnFindValueInHashMap() {
        Book stored = new Book("978-3-16-148410-0", "Effective Java");
        Book lookup = new Book("978-3-16-148410-0", "Some other title");

        Map<Book, String> map = new HashMap<>();
        map.put(stored, "value");

        assertEquals("value", map.get(lookup),
                "Book с тем же ISBN должен находить значение");
    }

    @Test
    void booksWithDifferentIsbnAreNotEqual() {
        Book a = new Book("111", "A");
        Book b = new Book("222", "B");

        assertNotEquals(a, b);
        assertFalse(a.equals(b));
    }

    @Test
    void equalBooksHaveEqualHashCode() {
        Book a = new Book("111", "A");
        Book b = new Book("111", "B");
        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode(),
                "Контракт equals/hashCode должен соблюдаться");
    }
}