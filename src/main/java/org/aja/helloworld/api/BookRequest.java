package org.aja.helloworld.api;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BookRequest {
    private String title;
    private String published;

    @JsonCreator
    public BookRequest(@JsonProperty(value = "title",required = true) String title,
                       @JsonProperty(value = "published",required = true) String published) {
        this.title = title;
        this.published = published;
    }

    @JsonProperty
    public String getTitle() {
        return title;
    }

    @JsonProperty
    public String getPublished() {
        return published;
    }


}
