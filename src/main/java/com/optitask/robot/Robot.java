package com.optitask.robot;
import jakarta.persistence.*;

@Entity // Tells Spring This Class Is A DB table
@Table(name = "robots") //Tells Spring Which Table Specifically

public class Robot {

    @Id // Tells Spring This Field Is The Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) //DB Automatically Generates ID.
    private Long id;

    @Column(nullable = false) //Enforces Not Nullable At The Java Level.
    private String name;

    private String description;

    public Robot(){} //Spring Requires An Empty Constructor. This Creates Robots From DB.


    //GETTERS & SETTERS. Never Set ID, DB sets it.

    public Robot(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

