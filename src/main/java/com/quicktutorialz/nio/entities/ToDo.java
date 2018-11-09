package com.quicktutorialz.nio.entities;

import java.util.Objects;

public class ToDo {
    private String title;
    private String description;

    public ToDo() {
    }

    public ToDo(String title, String description) {
        this.title = title;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ToDo)) return false;
        ToDo toDo = (ToDo) o;
        return Objects.equals(getTitle(), toDo.getTitle()) &&
                Objects.equals(getDescription(), toDo.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getTitle(), getDescription());
    }

    @Override
    public String toString() {
        return "ToDo{" +
                "title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
