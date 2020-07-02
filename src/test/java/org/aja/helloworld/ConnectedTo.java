package org.aja.helloworld;


public class ConnectedTo {
    private final String partId;
    private final String name;

    public ConnectedTo(String partId, String name) {
        this.partId = partId;
        this.name = name;
    }

    public String getPartId() {
        return partId;
    }

    public String getName() {
        return name;
    }
}
