package com.project.crud.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String email;
    private String phone;
    private String gender;
    private String city;

    public User(){

    }

    public User(String name, String email, String gender, String city , String phone) {
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.city = city;
        this.phone = phone;
    }

    public User(Integer id, String name, String email, String gender, String city, String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.gender = gender;
        this.city = city;
        this.phone = phone;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
