package com.leyton.models;

import java.util.Objects;

public class Client {
    private String lastName;
    private String firstName;
    private int seniority;
    private double discount;

    public Client() {
    }

    public Client(String lastName, String firstName, int seniority, double discount) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.seniority = seniority;
        this.discount = discount;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public Integer getSeniority() {
        return seniority;
    }

    public void setSeniority(int seniority) {
        this.seniority = seniority;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    @Override
    public String toString() {
        return "Client{" +
                "lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                ", seniority=" + seniority +
                ", discount=" + discount + "%" +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(lastName, client.lastName) && Objects.equals(firstName, client.firstName) && Objects.equals(seniority, client.seniority) && Objects.equals(discount, client.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lastName, firstName, seniority, discount);
    }
}
