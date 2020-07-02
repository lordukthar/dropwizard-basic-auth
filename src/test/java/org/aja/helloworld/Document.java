package org.aja.helloworld;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Document {
    private String id;
    private Type type;

    private Document(Builder builder) {
        setId(builder.id);
        setType(builder.type);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Document document = (Document) o;
        return Objects.equals(id, document.id) &&
                Objects.equals(type, document.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type);
    }

    public static final class Builder {
        private String id;
        private Type type;

        private Builder() {
        }

        public Builder id(String val) {
            id = val;
            return this;
        }

        public Builder type(Type val) {
            type = val;
            return this;
        }

        public Document build() {
            return new Document(this);
        }
    }
}
