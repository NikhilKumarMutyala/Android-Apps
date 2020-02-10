package com.example.inclass03;


import java.io.Serializable;

public class User implements Serializable {
    String gender;

    public User(String gender, String first_name, String last_name) {
        this.gender = gender;
        this.first_name = first_name;
        this.last_name = last_name;
    }

    String first_name;
    String last_name;

}
