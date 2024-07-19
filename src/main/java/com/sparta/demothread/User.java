package com.sparta.demothread;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@Table(name = "users")
public class User {
    @Id
    private String email;

    private String first;

    private String last;

    private String city;

    private String county;

    private int age;

    public String getId() {
        return email;
    }

    public void setId(String email) {
        this.email = email;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String name) {
        this.first = name;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String name) {
        this.last = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}