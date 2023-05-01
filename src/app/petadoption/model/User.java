/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.petadoption.model;

import java.time.LocalDate;
import java.time.Period;

/**
 *
 * @author Philip
 */
public abstract class User {

    private int id;
    private String firstName;
    private String midName;
    private String lastName;
    private Gender gender;
    private Address address;
    private String email;

    private LocalDate birthDay;
    private Account account;

    public User() {
    }

    public User(int id, String firstName, String midName, String lastName, Gender gender, Address address, String email, LocalDate birthDay, Account account) {
        this.id = id;
        this.firstName = firstName;
        this.midName = midName;
        this.lastName = lastName;
        this.gender = gender;
        this.address = address;
        this.email = email;
        this.birthDay = birthDay;
        this.account = account;
    }

   

    public abstract String getUserType();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMidName() {
        return midName;
    }

    public void setMidName(String midName) {
        this.midName = midName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return Period.between(birthDay, LocalDate.now()).getYears();
    }

   
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
    }

   

}
