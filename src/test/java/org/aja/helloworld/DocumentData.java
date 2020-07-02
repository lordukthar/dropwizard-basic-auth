package org.aja.helloworld;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DocumentData {
    private final String documentID;
    private final Map<String, Object> variableData;
    private final CompletionType completionType;
    private final ConnectedTo connectedTo;
    private final List<Option> options;

    //TODO ADD LOGGER

    public DocumentData(String documentID, Map<String, Object> variableData) throws Exception {

        this.variableData = variableData;

        this.documentID = documentID;
        this.completionType = createCompletionType(variableData);
        this.connectedTo = createConnectedTo(variableData);
        this.options = createOptions(variableData);
    }

    private List<Option> createOptions(Map<String, Object> variableData) {

        List<Option> opts = new ArrayList<>();
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonNode = variableData.get("options").toString();

            Map<String, Object> jsonMap = objectMapper.readValue(jsonNode,
                    new TypeReference<Object>() {
                    });

            List<Map<String, String>> options = (List<Map<String, String>>) jsonMap.get("options");

            options.forEach(x -> {
                opts.add(new Option(x.get("partId"), x.get("orgnbr")));
            });

        } catch (Exception ex) {
            System.out.println("Ohh no" + ex);
        }

        return opts;
    }

    private ConnectedTo createConnectedTo(Map<String, Object> variableData) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonNode = variableData.get("/connectedTo").toString();

            Map<String, String> jsonMap = objectMapper.readValue(jsonNode,
                    new TypeReference<Object>() {
                    });
            return new ConnectedTo(jsonMap.get("partid"), jsonMap.get("name"));
        } catch (Exception ex) {
            System.out.println("Ohh no" + ex);
            return new ConnectedTo(null, null);
        }
    }

    private CompletionType createCompletionType(Map<String, Object> variableData) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            String jsonNode = variableData.get("completionType").toString();

            Map<String, String> jsonMap = objectMapper.readValue(jsonNode,
                    new TypeReference<Object>() {
                    });
            return new CompletionType(jsonMap.get("id"), jsonMap.get("name"));
        } catch (Exception ex) {
            System.out.println("Ohh no" + ex);
            return new CompletionType(null, null);
        }
    }

    public String getDocumentID() {
        return documentID;
    }

    public Map getVariableData() {
        return variableData;
    }

    public CompletionType getCompletionType() {
        return completionType;
    }

    public boolean hasCompletionTypeName() {
        return completionType.getName() != null;
    }

    public List<Option> getOptions() {
        return options;
    }

    public ConnectedTo getConnectedTo() {
        return connectedTo;
    }

    public String getIspLastActionKey() {
        return variableData.get("ispLastActionKey").toString();
    }
}