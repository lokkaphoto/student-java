package edu.course.lab04;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;


class MutableKeyExperiment {

    /** Нарочито «плохой» изменяемый ключ. Только для эксперимента. */
    static final class MutableKey {
        int number;
        String project;

        MutableKey(String project, int number) {
            this.project = project;
            this.number = number;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof MutableKey)) {
                return false;
            }
            MutableKey that = (MutableKey) o;
            return number == that.number
                    && Objects.equals(project, that.project);
        }

        @Override
        public int hashCode() {
            return Objects.hash(project, number);
        }
    }

    @Test
    void mutatingKeyBreaksLookup() {
        Map<MutableKey, String> map = new HashMap<>();
        MutableKey key = new MutableKey("LAB", 1);
        map.put(key, "value");

        assertEquals("value", map.get(key), "До изменения ключ находится");

        key.number = 999;

        assertNull(map.get(key),
                "После изменения поля поиск по тому же объекту перестаёт работать");
        assertEquals(1, map.size());
    }

    @Test
    void immutableIssueIdIsSafe() {
        IssueRegistry registry = new IssueRegistry();
        IssueId id = new IssueId("LAB", 1);
        ProjectTask task = new ProjectTask("t", "d");
        registry.put(id, task);

        assertSame(task, registry.get(new IssueId("LAB", 1)));
    }
}