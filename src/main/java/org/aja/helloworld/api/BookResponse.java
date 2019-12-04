package org.aja.helloworld.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookResponse {
    private String title;
    private String published;
    private Integer id;

    @JsonCreator
    public BookResponse(@JsonProperty(value = "title",required = true) String title,
                        @JsonProperty(value = "published",required = true) String published,
                        @JsonProperty(value = "id",required = true) Integer id) {
        this.title = title;
        this.published = published;
        this.id = id;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public String getPublished() {
        return published;
    }
    @JsonProperty
    public Integer getId() {
        return id;
    }

}
