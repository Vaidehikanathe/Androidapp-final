package com.example.app1;

public class HelperClass {
//    useful in organizing code, enhancing readability, and promoting reusability
//    data holder class for user information
//This class serves as a blueprint for creating user objects.
// Each instance of this class represents a user with specific attributes
    String name, email, username, password;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
//     initializes the member variables with the values passed as arguments
    public HelperClass(String name, String email, String username, String password) {
        this.name = name;
        this.email = email;
        this.username = username;
        this.password = password;
    }
//if no constr defined in the class
    public HelperClass() {
    }
}
