package com.codecool.Model;

public class Poem {
   private int id;
   private int poet_id;
   private String title;
   private String text;
   private String date;


    public Poem(int id, int poet_id, String title, String text, String date) {
        this.id = id;
        this.poet_id = poet_id;
        this.title = title;
        this.text = text;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public int getPoet_id() {
        return poet_id;
    }

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Poem{" +
                "id=" + id +
                ", poet_id=" + poet_id +
                ", title='" + title + '\'' +
                ", text='" + text + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
