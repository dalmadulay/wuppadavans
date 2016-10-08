package users;

import java.util.Collections;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountUtils {

    public static final Map<Integer, String> BANKS;

    static {
        Hashtable<Integer, String> tmp =
                new Hashtable<Integer, String>();
        //csak ezekkel a bankokkal foglalkozunk
        tmp.put(107, "CIB");
        tmp.put(108, "Citibank");
        tmp.put(116, "Erste");
        tmp.put(117, "OTP");
        tmp.put(120, "Raiffeisen");
        tmp.put(137, "ING");
        tmp.put(190, "MNG");

        BANKS = Collections.unmodifiableMap(tmp);
    }

    public int amountOfAccounts(Scanner scanner) {
        System.out.println("How many bank accounts do you have?");
        return scanner.nextInt();
    }

    public String initCurrency (Scanner scanner) {
        System.out.println("What Foreign Currency would you like to set on that account?\n" +
                              "(specify with the 3 characters long ID. Like USD, EUR, etc...");
        return scanner.next();
    }

    public String setCurrency(String currency) {
        //create a pattern object
        Pattern p = Pattern.compile("[A-Z][A-Z][A-Z]");

        //create a matcher object
        Matcher m = p.matcher(currency);

        if (m.find()) {
           return currency;
        } else {
            System.out.println("Nem megfelelő deviza formátum.");
        }
        return null;
    }

    public String setBban(Scanner scanner) {

        System.out.println("Adja meg a számlaszámot!\n");

        //create a pattern object
        Pattern p = Pattern.compile( "1[0,1,2,3,9][\\d]{6}-[\\d]{8}-[\\d]{8}" );

        String bban = scanner.next();
        //create a matcher object
        Matcher m = p.matcher(bban);


        if (m.find()) {
            return bban;
        } else {
            System.out.println("Nem megfelelő bankszámlaszám formátum.");
        }
     return null;
    }

    //Magyarországon a számlaszám első 3 karaktere a bank azonosítóját határozza meg.
    //Levágjuk az azonosítót, majd az előre definiált BANKS listából megtudjuk a nevét.
    public String setBankName(String bban) {
        if (bban == null) {
            System.out.println("A bankszámla formátuma nem megfelelő. Kérem próbálja újra!");
        } else {
            //levágjuk az első 3 karaktert és megnézzük, hogy a listában létezik-e bank ilyen azonosítóval
            CharSequence bankID = bban.subSequence(0, 3);
            String bankName = BANKS.get(Integer.parseInt(bankID.toString()));
            if (bankName == null) {
                System.out.println("Ismeretlen bank! Kérem keresse a supportot!");
            }
            else {
                System.out.println("A bank neve: " + bankName);
                return bankName;
            }
        }
       return null;
    }
}
