package ru.stqa.pft.mantis.model;

/**
 * Created by User on 22.12.2016.
 */
public class IdentifiableNamedEntity {
    int id;
    String name;

    public int getId() {
        return id;
    }

    public IdentifiableNamedEntity withId(int id) {
        this.id = id;
        return this;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public IdentifiableNamedEntity withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return "IdentifiableNamedEntity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IdentifiableNamedEntity that = (IdentifiableNamedEntity) o;

        if (id != that.id) return false;
        return name != null ? name.equals(that.name) : that.name == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }
}
