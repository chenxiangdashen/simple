package com.example.simple.entity;

public class User {
    private Integer id;
    private String name;
    private Integer age;
    private String password;
    private String mark;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                        ", name='" + name + '\'' +
                        ", age=" + age
                ;
    }
}
