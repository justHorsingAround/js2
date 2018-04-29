package com.codecool.Model;

public class Poem {
    private String poetName;
    private String title;
    private String textContent;

    public Poem(String poetName, String title, String textContent) {
        this.poetName = poetName;
        this.title = title;
        this.textContent = textContent;
    }

    public String getPoetName() {
        return poetName;
    }

    public void setPoetName(String poetName) {
        this.poetName = poetName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTextContent() {
        return textContent;
    }

    public void setTextContent(String textContent) {
        this.textContent = textContent;
    }

    @Override
    public String toString() {
        return "Poem{" +
                "poetName='" + poetName + '\'' +
                ", title='" + title + '\'' +
                ", textContent='" + textContent + '\'' +
                '}';
    }
}
