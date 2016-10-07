package users;

import java.sql.Timestamp;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    public static final Map<Integer, String> BANKS;

    static {
        Hashtable<Integer, String> tmp =
                new Hashtable<Integer, String>();
        tmp.put(107, "CIB");
        tmp.put(108, "Citibank");
        tmp.put(116, "Erste");
        tmp.put(137, "ING");
        tmp.put(190, "MNG");
        tmp.put(117, "OTP");
        tmp.put(120, "Raiffeisen");

        BANKS = Collections.unmodifiableMap(tmp);
    }

    private String currency;
    private Timestamp creationDate;
    private String bban;
    private String bankName;

    public Account (String currency, String bban, String bbanValidator) {
        this.currency = currency;
        if (bban == bbanValidator) {
            this.bban = bban;
            setCreationDate();
            setBankName();
        }
        else {
            System.out.println("Bank account numbers are not the same. Try again!");
        }
    }

    //validate currency and set if valid
    public void setCurrency(String currency) {
        //create a pattern object
        Pattern p = Pattern.compile("[A-Z][A-Z][A-Z]");

        //create a matcher object
        Matcher m = p.matcher(currency);

        if (m.find()) {
            this.currency = currency;
        } else {
            System.out.println("Nem megfelelő deviza formátum.");
        }
    }

    public void setCreationDate() {
        //timestamp of account creation.
        java.util.Date date = new java.util.Date();
        this.creationDate = new Timestamp(date.getTime());
    }

    public String getBban() {
        return bban;
    }

    //magyarországon a számlaszám első 3 karaktere a bank azonosítóját határozza meg.
    //Levágjuk az azonosítót, majd az előre definiált BANKS listából megtudjuk a nevét.
    public void setBankName() {
        String bban = getBban();
        if (bban == null) {
            System.out.println("A bankszámla formátuma nem megfelelő. Kérem próbálja újra!");
        } else {
            //levágjuk az első 3 karaktert és megnézzük, hogy a listában létezik-e bank ilyen azonosítóval
            CharSequence bankID = bban.subSequence(0, 3);
            String bankName = BANKS.get(bankID);
            if (bankName == null) {
                System.out.println("Ismeretlen bank! Kérem hívja a supportot!");
            }
            else {
                this.bankName = bankName;
                System.out.println("A bank neve: " + bankName);
            }
        }
    }
}
