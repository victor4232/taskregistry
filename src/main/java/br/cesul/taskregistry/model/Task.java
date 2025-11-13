package br.cesul.taskregistry.model;

import java.util.UUID;

public class Task {

    private String id;
    private String title;
    private String description;

    //  Construtor padrão
    public Task() {
        this.id = UUID.randomUUID().toString();
        this.title = "";
        this.description = "";
    }

    //  Construtor com título e descrição
    public Task(String title, String description) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
    }

    //  Getters e Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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



    //  Sobrescrevendo toString (útil para debug e TableView)
    @Override
    public String toString() {
        return "Task{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
