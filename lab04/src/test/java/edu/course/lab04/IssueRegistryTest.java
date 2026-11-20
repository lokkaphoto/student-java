package edu.course.lab04;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class IssueRegistryTest {

    @Test
    void differentInstancesOfEqualKeyFindSameValue() {
        IssueRegistry registry = new IssueRegistry();

        IssueId key1 = new IssueId("LAB", 1);
        IssueId key2 = new IssueId("LAB", 1); // логически равный, но другой экземпляр

        ProjectTask task = new ProjectTask("Fix bug", "Critical");
        registry.put(key1, task);

        assertSame(task, registry.get(key2),
                "Другой экземпляр логически равного ключа должен находить значение");
        assertTrue(registry.contains(key2));
    }

    @Test
    void putWithEqualKeyReplacesValueWithoutGrowingSize() {
        IssueRegistry registry = new IssueRegistry();

        IssueId key1 = new IssueId("LAB", 1);
        IssueId key2 = new IssueId("LAB", 1);

        ProjectTask first = new ProjectTask("v1", "old");
        ProjectTask second = new ProjectTask("v2", "new");

        registry.put(key1, first);
        assertEquals(1, registry.size());

        ProjectTask previous = registry.put(key2, second);

        assertEquals(first, previous, "put должен вернуть предыдущее значение");
        assertEquals(1, registry.size(), "Размер не должен вырасти");
        assertEquals(second, registry.get(key1));
    }

    @Test
    void collisionWithSameHashCodeKeepsDifferentValues() {
        IssueRegistry registry = new IssueRegistry();

        IssueId a = new IssueId("A", 1);
        IssueId b = new IssueId("B", 1);

        ProjectTask taskA = new ProjectTask("A-task", "a");
        ProjectTask taskB = new ProjectTask("B-task", "b");

        registry.put(a, taskA);
        registry.put(b, taskB);

        assertEquals(2, registry.size());
        assertSame(taskA, registry.get(a));
        assertSame(taskB, registry.get(b));
        assertNotEquals(a, b);
    }

    @Test
    void removeAndContainsAndSizeWork() {
        IssueRegistry registry = new IssueRegistry();
        IssueId id = new IssueId("LAB", 1);
        ProjectTask task = new ProjectTask("t", "d");

        assertFalse(registry.contains(id));
        registry.put(id, task);
        assertTrue(registry.contains(id));
        assertEquals(1, registry.size());

        ProjectTask removed = registry.remove(id);
        assertSame(task, removed);
        assertEquals(0, registry.size());
        assertFalse(registry.contains(id));
        assertNull(registry.get(id));
    }

    @Test
    void getReturnsNullForMissingKey() {
        IssueRegistry registry = new IssueRegistry();
        assertNull(registry.get(new IssueId("NOPE", 99)));
    }

    @Test
    void nullArgumentsRejected() {
        IssueRegistry registry = new IssueRegistry();
        IssueId id = new IssueId("LAB", 1);
        ProjectTask task = new ProjectTask("t", "d");

        assertThrows(NullPointerException.class, () -> registry.put(null, task));
        assertThrows(NullPointerException.class, () -> registry.put(id, null));
        assertThrows(NullPointerException.class, () -> registry.get(null));
        assertThrows(NullPointerException.class, () -> registry.contains(null));
        assertThrows(NullPointerException.class, () -> registry.remove(null));
    }
}