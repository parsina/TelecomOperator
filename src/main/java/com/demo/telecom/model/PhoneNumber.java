package com.demo.telecom.model;

import javax.persistence.*;

@Entity
@Table(name="phone_number")
public class PhoneNumber {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "number", nullable = false)
    private String number;

    @Column(name = "activated", nullable = false)
    private boolean activated;

    @ManyToOne
    @JoinColumn(name="customer_id", nullable=false)
    private Customer customer;

    public PhoneNumber() {
    }

    public PhoneNumber(Long id, String number, boolean activated, Customer customer) {
        this.id = id;
        this.number = number;
        this.activated = activated;
        this.customer = customer;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public boolean isActivated() {
        return activated;
    }

    public void setActivated(boolean activated) {
        this.activated = activated;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }
}
