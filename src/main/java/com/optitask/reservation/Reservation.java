package com.optitask.reservation;

import com.optitask.customer.Customer;
import com.optitask.task.Task;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "reservations")
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "task_id", nullable = false)
    private Task task;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private Integer duration;

    @Column(nullable = false)
    private BigDecimal totalPrice;

    private LocalDateTime createdAt;

    //EMPTY CONSTRUCTOR
    public Reservation(){

    }

    //CONSTRUCTOR - THIS SHOULD ONLY TAKE WHAT USER PROVIDES
    public Reservation(Customer customer, Task task, String location, Integer duration, BigDecimal totalPrice) {
        this.customer = customer;
        this.task = task;
        this.location = location;
        this.duration = duration;
        this.totalPrice = totalPrice;
    }

    //GETTERS & SETTERS
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
