package edu.course.lab04;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class IssueRegistry {
    private final Map<IssueId, ProjectTask> storage = new HashMap<>();

   
    public ProjectTask put(IssueId id, ProjectTask task) {
        Objects.requireNonNull(id, "id");
        Objects.requireNonNull(task, "task");
        return storage.put(id, task);
    }

    public ProjectTask get(IssueId id) {
        Objects.requireNonNull(id, "id");
        return storage.get(id);
    }

   
    public ProjectTask remove(IssueId id) {
        Objects.requireNonNull(id, "id");
        return storage.remove(id);
    }

   
    public boolean contains(IssueId id) {
        Objects.requireNonNull(id, "id");
        return storage.containsKey(id);
    }

    
    public int size() {
        return storage.size();
    }
}