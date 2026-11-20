package edu.course.lab04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IssueIdTest {

    @Test
    void equalIdsHaveEqualHashCode() {
        IssueId a = new IssueId("LAB", 42);
        IssueId b = new IssueId("LAB", 42);

        assertEquals(a, b);
        assertEquals(a.hashCode(), b.hashCode());
    }

    @Test
    void equalsReturnsFalseForNull() {
        IssueId id = new IssueId("LAB", 1);
        assertFalse(id.equals(null));
    }

    @Test
    void equalsReturnsFalseForDifferentType() {
        IssueId id = new IssueId("LAB", 1);
        assertFalse(id.equals("LAB-1"));
        assertFalse(id.equals(new Book("LAB", "title")));
    }

    @Test
    void equalsReturnsTrueForSameInstance() {
        IssueId id = new IssueId("LAB", 1);
        assertTrue(id.equals(id));
    }

    @Test
    void differentFieldsMakeIdsNotEqual() {
        assertNotEquals(new IssueId("LAB", 1), new IssueId("LAB", 2));
        assertNotEquals(new IssueId("LAB", 1), new IssueId("OTHER", 1));
    }

    @Test
    void constructorRejectsInvalidArgs() {
        assertThrows(NullPointerException.class, () -> new IssueId(null, 1));
        assertThrows(IllegalArgumentException.class, () -> new IssueId("", 1));
        assertThrows(IllegalArgumentException.class, () -> new IssueId("LAB", 0));
    }
}