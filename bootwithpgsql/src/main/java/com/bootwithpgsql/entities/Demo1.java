package com.bootwithpgsql.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Demo1 {

    @Id
    private int id;
    private String name;
    private int age;

    public Demo1() {
    }

    public Demo1(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
