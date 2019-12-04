package org.aja.helloworld.resources;

public class Translate {
    String swedish;
    String persian;

    public Translate(String swedish, String persian) {
        this.swedish = swedish;
        this.persian = persian;
    }

    public String getPersian() {
        return persian;
    }

    public String getSwedish() {
        return swedish;
    }
}
