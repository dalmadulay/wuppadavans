package hu.wup.wuppadavans;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@EnableAutoConfiguration
@RestController
public class Application {

    private void metodus() {
        List<User> userList = new ArrayList<User>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Add meg a felhasznaloszamot!");
        int usernumber = sc.nextInt();
        for (long ID = 1; ID <= usernumber; ID++) {
            if (ID > 1) {
                System.out.println(ID + ". Felhasznalo");
            }
            User user = new User();

            System.out.println("Add meg a vezetekneved!");
            user.setLastName(sc.next());
            System.out.println("Add meg a keresztneved!");
            user.setFirstName(sc.next());
            System.out.println("Add meg a nemed!");
            user.setGender(sc.next());
            System.out.println("Es add meg az eletkorod!");
            user.setAge(sc.nextInt());
            System.out.println("Hany darab szamlaval rendelkezel?");

            int darabszam = sc.nextInt();

            List<Account> accountList = new ArrayList<>();

            for (int i = 1; i <= darabszam; i++) {
                Account account = new Account();
                System.out.println("Mi a szamlaszam?");
                account.setSzamlaszam(sc.next());
                System.out.println("Mi az IBAN szam?");                                           // account.setSzamlaszam(Math.random() * 999999999999999999999999) + 100000000000000000000000;
                account.setIban(sc.next());

                accountList.add(account);
                // account.setIban(Math.random() * 99) + 01);
            }
            user.setAccounts(accountList);
            userList.add(user);
            System.out.println("");
        }

        userList.forEach(System.out::println);
    }

    @RequestMapping("/")
    public String printHello() {return "csa baszdmeg";}

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        Application fometodus = new Application();
        fometodus.metodus();

    }
}

