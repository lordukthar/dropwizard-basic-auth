package org.aja.helloworld;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskVariableData {

    private String decision = null;
    private Document document;
    private String ispClaimer;
    private Boolean ispClaimNext = true;

    private TaskVariableData(Builder builder) {
        setDecision(builder.decision);
        setDocument(builder.document);
        setIspClaimer(builder.ispClaimer);
        setIspClaimNext(builder.ispClaimNext);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public String getIspClaimer() {
        return ispClaimer;
    }

    public void setIspClaimer(String ispClaimer) {
        this.ispClaimer = ispClaimer;
    }

    public Boolean getIspClaimNext() {
        return ispClaimNext;
    }

    public void setIspClaimNext(Boolean ispClaimNext) {
        this.ispClaimNext = ispClaimNext;
    }

    @Override
    public String toString() {
        return "TaskVariableData{" +
                "decision='" + decision + '\'' +
                ", document=" + document +
                ", ispClaimer='" + ispClaimer + '\'' +
                ", ispClaimNext=" + ispClaimNext +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TaskVariableData that = (TaskVariableData) o;
        return Objects.equals(decision, that.decision) &&
                Objects.equals(document, that.document) &&
                Objects.equals(ispClaimer, that.ispClaimer) &&
                Objects.equals(ispClaimNext, that.ispClaimNext);
    }

    @Override
    public int hashCode() {
        return Objects.hash(decision, document, ispClaimer, ispClaimNext);
    }

    public static final class Builder {
        private String decision;
        private Document document;
        private String ispClaimer;
        private Boolean ispClaimNext;

        private Builder() {
        }

        public Builder decision(String val) {
            decision = val;
            return this;
        }

        public Builder document(Document val) {
            document = val;
            return this;
        }

        public Builder ispClaimer(String val) {
            ispClaimer = val;
            return this;
        }

        public Builder ispClaimNext(Boolean val) {
            ispClaimNext = val;
            return this;
        }

        public TaskVariableData build() {
            return new TaskVariableData(this);
        }
    }
}
