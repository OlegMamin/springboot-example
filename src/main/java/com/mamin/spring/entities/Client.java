package com.mamin.spring.entities;

/**
 * Created by otherz on 13.12.2019.
 */
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;
import java.util.Date;

@Entity
@Table(name = "clients")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 32)
    @Size(min = 2)
    private String firstName;

    @Column(length = 32)
    @Size(min = 2)
    private String lastName;

    @Column()
    @Temporal(TemporalType.DATE)
    @Past
    private Date birthDate;

    @Column(nullable = false, unique = true, length = 10)
    private String passportNumber;

    @Column
    private String address;

    @Column(unique = true)
    @Email
    private String eMail;

    @Column(nullable = false, unique = true,  length = 32)
    @Size(min = 4)
    private String login;

    @JsonIgnore
    @Column(nullable = false, length = 64)
    @Size(min = 4)
    private String encryptedPassword;

    @Column
    private boolean isAdmin;

    public Client() {
    }

    public Client(String firstName, String lastName, String passportNumber, String login, String encryptedPassword) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportNumber = passportNumber;
        this.login = login;
        this.encryptedPassword = encryptedPassword;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String surName) {
        this.lastName = surName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPassportNumber() {
        return passportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        this.passportNumber = passportNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String password) {
        this.encryptedPassword = password;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
