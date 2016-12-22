package ru.stqa.pft.mantis.model;

/**
 * Created by User on 22.12.2016.
 */
public class Issue extends IdentifiableNamedEntity {
    String summary;
    String description;
    Project project;

    public int getId() {
        return id;
    }

    public Issue withId(int id) {
        this.id = id;
        return this;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setProject(Project project) {
        this.project = project;
    }

    public Issue withSummary(String summary) {
        this.summary = summary;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Issue withDescription(String description) {
        this.description = description;
        return this;
    }

    public Project getProject() {
        return project;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Issue withProject(Project project) {
        this.project = project;
        return this;
    }
}
