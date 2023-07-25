package com.eloy.todoserver.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "todo")
public class TodoCard {
    @Id
    private String id = "41h4k";
    private String title;
    private String contents;

    private boolean isCompleted = false;

    public TodoCard(String id, String title, String contents, boolean isCompleted) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.isCompleted = isCompleted;
    }

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

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
