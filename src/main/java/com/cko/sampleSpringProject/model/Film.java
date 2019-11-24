package com.cko.sampleSpringProject.model;

import javax.persistence.*;

@Entity
public class Film {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String title;

    @Column
    private int raiting;

    public Film(String title, int raiting, int age) {
        this.title = title;
        this.raiting = raiting;
        this.age = age;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRaiting(int raiting) {
        this.raiting = raiting;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getRaiting() {
        return raiting;
    }

    public int getAge() {
        return age;
    }

    @Column
    private int age;
}
