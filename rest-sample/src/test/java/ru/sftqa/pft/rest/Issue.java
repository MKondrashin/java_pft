package ru.sftqa.pft.rest;

/**
 * Created by User on 23.12.2016.
 */
public class Issue {
    int id;
    String subject;

    public String getSubject() {
        return subject;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Issue issue = (Issue) o;

        return id == issue.id;

    }

    @Override
    public int hashCode() {
        return id;
    }

    public Issue withSubject(String subject) {
        this.subject = subject;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Issue withDescription(String description) {
        this.description = description;
        return this;
    }

    public int getId() {

        return id;
    }

    public Issue withId(int id) {
        this.id = id;
        return this;
    }

    String description;
}
