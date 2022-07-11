package com.konyadonat.thesis.user;

public class User {
    private String email;
    private String password;
    private int age;

    public int getAge() {
        return age;
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
            user.email = email;
            return this;
        }

        public UserBuilder setPassword(String password){
            user.password = password;
            return this;
        }

        public UserBuilder setAge(int age){
            user.age = age;
            return this;
        }
        public User getUser() {
            return user;
        }
    }
}
