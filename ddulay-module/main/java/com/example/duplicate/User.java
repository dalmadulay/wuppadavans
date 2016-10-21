package com.example.duplicate;


import com.example.entity.Accounts;


import java.util.List;

public class User {

    private String name;
    private int age;

    private List<Accounts> accountList;

    public List<Accounts> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Accounts> accountList) {
        this.accountList = accountList;
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
