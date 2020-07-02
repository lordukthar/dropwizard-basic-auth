package org.aja.helloworld;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.beans.ConstructorProperties;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class PublishDestination {

    private boolean internetBanken = false;

    @ConstructorProperties({"internetBanken"})
    public PublishDestination(boolean internetBanken) {
        this.internetBanken = internetBanken;
    }

    public boolean isInternetBanken() {
        return internetBanken;
    }

    public void setInternetBanken(boolean internetBanken) {
        this.internetBanken = internetBanken;
    }

    @Override
    public String toString() {
        return "PublishDestination{" +
                "internetBanken=" + internetBanken +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PublishDestination that = (PublishDestination) o;
        return internetBanken == that.internetBanken;
    }

    @Override
    public int hashCode() {
        return Objects.hash(internetBanken);
    }
}
