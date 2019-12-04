package org.aja.helloworld.model;

public class Book {
    private String title;
    private String published;
    private Integer id;

    public Book(String title,
                        String published,
                       Integer id) {
        this.title = title;
        this.published = published;
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public String getPublished() {
        return published;
    }
    public Integer getId() {
        return id;
    }


}
