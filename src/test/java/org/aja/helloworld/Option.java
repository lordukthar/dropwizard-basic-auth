package org.aja.helloworld;


public class Option {

    private final String partId;
    private final String pid;

    public Option(String partId, String pid) {
        this.partId = partId;
        this.pid = pid;
    }

    public String getPartId() {
        return partId;
    }

    public String getPid() {
        return pid;
    }

}
