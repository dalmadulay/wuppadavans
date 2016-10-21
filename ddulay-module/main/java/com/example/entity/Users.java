package com.example.entity;


import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "upp_user")
public class Users {

    public static final String ID_COLUMN_NAME = "User_Id";
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = ID_COLUMN_NAME)
    private long id;
    private String name;
    private int age;

    @OneToMany(cascade = CascadeType.ALL,mappedBy = "user")
    private List<Accounts> accountsList;

    public List<Accounts> getAccountsList() {
        return accountsList;
    }

    public void setAccountsList(List<Accounts> accountsList) {
        this.accountsList = accountsList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
