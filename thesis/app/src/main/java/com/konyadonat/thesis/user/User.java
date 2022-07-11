package com.konyadonat.thesis.user;

import com.konyadonat.thesis.user.Exception.NameTooShortException;

public class User {
    private String email;
    private String password;
    private String name;

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }
    //TODO it works but should be replaced
    public String getPassword() {
        return password;
    }

    public static class UserBuilder{
        User user = new User();

        public UserBuilder setEmail(String email){
            //TODO Validate email
            //TODO Check for null, empty + email format
            user.email = email;
            return this;
        }

        public UserBuilder setPassword(String password) {
            //TODO Validate password
            //TODO Check for null, empty, length, must contain at least 1 number then hash it
            //TODO Need to check how to hash in Java
            user.password = password;
            return this;
        }

        public UserBuilder setName(String name) throws NameTooShortException {
            //TODO Name validation
            //TODO Check for length, null, empty, and to not contain any number
            if (name.length() < 3) {
                throw new NameTooShortException("A megadott név túl rövid!");
            }
            user.name = name;
            return this;
        }
        public User getUser() {
            return user;
        }
    }
}
