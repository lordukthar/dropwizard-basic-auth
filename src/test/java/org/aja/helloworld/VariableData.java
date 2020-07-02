package org.aja.helloworld;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VariableData {

    private CompletionType completionType;
    private ConnectedTo connectedTo;

    public CompletionType getCompletionType() {
        return completionType;
    }

    public void setCompletionType(CompletionType completionType) {
        this.completionType = completionType;
    }

    public ConnectedTo getConnectedTo() {
        return connectedTo;
    }

    public void setConnectedTo(ConnectedTo connectedTo) {
        this.connectedTo = connectedTo;
    }
}
