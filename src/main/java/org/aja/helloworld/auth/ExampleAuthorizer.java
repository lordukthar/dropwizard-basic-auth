package org.aja.helloworld.auth;

import io.dropwizard.auth.Authorizer;
import org.aja.helloworld.core.User;

public class ExampleAuthorizer implements Authorizer<User> {

    @Override
    public boolean authorize(User user, String role) {
        return user.getRoles() != null && user.getRoles().contains(role);
    }
}
