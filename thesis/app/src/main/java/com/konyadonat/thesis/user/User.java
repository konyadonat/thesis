package com.konyadonat.thesis.user;

import com.konyadonat.thesis.user.Exception.EmailEmptyException;
import com.konyadonat.thesis.user.Exception.EmailInvalidException;
import com.konyadonat.thesis.user.Exception.EmailNullException;
import com.konyadonat.thesis.user.Exception.InvalidPasswordException;
import com.konyadonat.thesis.user.Exception.NameEmptyException;
import com.konyadonat.thesis.user.Exception.NameNullException;
import com.konyadonat.thesis.user.Exception.NameTooShortException;
import java.security.NoSuchAlgorithmException;

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

    public static boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

    public static boolean isValidPassword(String password) {
        String regex = "^(?=.*\\\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{8,20}$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(regex);
        java.util.regex.Matcher m = p.matcher(password);
        return m.matches();
    }

    public static class UserBuilder{
        User user = new User();

        public UserBuilder setEmail(String email) throws EmailInvalidException, EmailEmptyException, EmailNullException {
            //TODO Check for null, empty + email format
            if (email == "") {
                throw new EmailEmptyException("Írjon be egy e-mail címet!");
            }
            if (email == null) {
                throw new EmailNullException("A megadott email null típusú!");
            }
            //TODO Validate email
            if(!isValidEmailAddress(email)) {
                throw new EmailInvalidException("A megadott e-mail cím formátuma nem megfelelő!");
            }
            user.email = email;
            return this;
        }

        public UserBuilder setPassword(String password) throws InvalidPasswordException, NoSuchAlgorithmException {
            //TODO Validate password
            //TODO Check for null, empty, length, must contain at least 1 number then hash it
            if (!isValidPassword(password)) {
                throw new InvalidPasswordException("A jelszó legalább 8 karakter, " +
                        "tartalmaznia kell egy kis-és nagybetűt, egy speciális karaktert és egy számot!");
            }
            //TODO Need to check how to hash in Java
            user.password = password;
            return this;
        }

        public UserBuilder setName(String name) throws NameTooShortException, NameEmptyException, NameNullException {
            //TODO Name validation
            //TODO Check for length, null, empty, and to not contain any number
            if (name == "") {
                throw new NameEmptyException("A megadott felhasználónév üres!");
            }
            if (name == null) {
                throw new NameNullException("A megadott felhasználónév null!");
            }
            if (name.length() < 3) {
                throw new NameTooShortException("A megadott felhanszálónév túl rövid!");
            }
            user.name = name;
            return this;
        }
        public User getUser() {
            return user;
        }
    }
}
