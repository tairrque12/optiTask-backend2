package com.optitask.task;

import com.optitask.robot.Robot;
import jakarta.persistence.*;

import java.math.BigDecimal;

//THIS IS TABLE NAME
@Entity
@Table(name = "tasks")

public class Task {
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private Long id;

 //Name of the tasks
 @Column
 private String name;

 //Price cannot be blank
 @Column(nullable = false)
 private BigDecimal basePrice;

 //Many tasks can belong to one robot.
 @ManyToOne
 //Foreign key between the Task and robot created in DB. (Each Robot has specific tasks)
 @JoinColumn(name = "robot_id", nullable = false)

 // By storing the robot object, when a task loads you get the full robot with it
 // One trip to the DB instead of 2.
 private Robot robot;

//EMPTY CONSTRUCTOR
    public Task(){
    }

    //PARAMETRIZED CONSTRUCTOR
    public Task(Robot robot, String name, BigDecimal basePrice) {
        this.robot = robot;
        this.name = name;
        this.basePrice = basePrice;
    }

    //Getters & Setters

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

    public BigDecimal getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(BigDecimal basePrice) {
        this.basePrice = basePrice;
    }

    public Robot getRobot() {
        return robot;
    }

    public void setRobot(Robot robot) {
        this.robot = robot;
    }
}


