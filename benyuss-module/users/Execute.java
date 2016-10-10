package users;

import com.sun.istack.internal.NotNull;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Execute {

    public void doStuff () {

        Scanner scanner = new Scanner(System.in);
        // Sok bugot lehet azzal előidézni (legalább is nekem sikerült és ekkora javasolta Szaszi, hogy inkább egy Scanner példány legyen
        // és ezt passzoljuk a metódusoknak.

        System.out.println("How many users do you want to create?\nAmount: ");
        int amountOfUsers = scanner.nextInt();

        UserUtils utils = new UserUtils();
        //csúnya az, ha egy adott metódus túl sok mindent csinál.
        //Mivel ez a main fv-nk, egyébként sem érdemes telepakolni. A users osztályba nem tehetünk üzleti logikát (számolásokat),
        //Mert az egy adat modell osztály. Ott csupán getterek, setterek (equals és hash) lehetnek.
        //Szükségünk van utility osztályra, ami elvégzi a számolásokat.

        for (int i = 0; i < amountOfUsers; i++) {
            //Annyi usert adunk a listához, amennyit bekértünk. Az initUser metódusban több infót találtok.
            utils.addUser(utils.initUser(scanner), scanner);
        }

        //toString() metódus és ahhoz tartozó bekérés.
        utils.printUser(scanner);

    }
}