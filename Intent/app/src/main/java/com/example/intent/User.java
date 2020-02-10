package com.example.intent;

import java.io.Serializable;

public class User implements Serializable {

    String name;
    double age;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public User(String name, double age) {
        this.name = name;
        this.age = age;


    }
}
