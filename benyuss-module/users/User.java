package users;

import java.util.ArrayList;
import java.util.List;

public class User {

    //Csupán getterek, setterek, hiszen ez egy adatmodell.
    private long id;
    private int age;
    private String username;
    private String firstName;
    private String lastName;
    private String gender;
    private List<Account> accounts = new ArrayList<Account>();

    public User (String username, String firstName, String lastName, int age, String gender, long id) {

        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.gender = gender;
        this.id = id;

        System.out.println("User " + username + " is created with " + id + " ID.");
    }

    public String getUsername() {
        return username;
    }

    public long getId() {
        return id;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", gender='" + gender + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
