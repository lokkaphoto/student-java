package edu.course.lab04;

import java.util.Objects;


public final class ProjectTask {
    private final String title;
    private final String description;

    public ProjectTask(String title, String description) {
        this.title = Objects.requireNonNull(title, "title");
        this.description = Objects.requireNonNull(description, "description");
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ProjectTask that = (ProjectTask) o;
        return title.equals(that.title)
                && description.equals(that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description);
    }

    @Override
    public String toString() {
        return "ProjectTask{title='" + title + "', description='" + description + "'}";
    }
}