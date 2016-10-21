package hu.wup.wuppadavans.users;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import org.iban4j.CountryCode;
import org.iban4j.Iban;
import org.iban4j.IbanFormatException;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AccountUtils {

    public static HashBiMap<Integer, String> banksByInt = new HashBiMap<>();
    public static Map<String, Integer> banksByString = new HashMap<>();

    static {
        HashMap<Integer, String> bankList = new HashMap<>();
        //csak ezekkel a bankokkal foglalkozunk
        bankList.put(107, "CIB");
        bankList.put(108, "Citibank");
        bankList.put(116, "Erste");
        bankList.put(117, "OTP");
        bankList.put(120, "Raiffeisen");
        bankList.put(137, "ING");
        bankList.put(190, "MNG");

        banksByInt.putAll(bankList);
        banksByString = banksByInt.inverse(); //NOSONAR

    }

    public int amountOfAccounts(Scanner scanner) {
        System.out.println("How many bank accounts do you have?");
        return scanner.nextInt();
    }

    public String initCurrency(Scanner scanner) {
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

        System.out.println("Adja meg a számlaszámot!");

        //create a pattern object
        Pattern p = Pattern.compile("1[0,1,2,3,9][\\d]{6}-[\\d]{8}");

        String bban = scanner.next();
        //create a matcher object
        Matcher m = p.matcher(bban);


        if (m.find()) {
            boolean isValid = validateBban(bban);
            if (isValid) {
                return bban;
            }
        } else {
            System.out.println("Nem megfelelő bankszámlaszám formátum.");
        }
        return null;
    }

    //Magyarországon a számlaszám első 3 karaktere a bank azonosítóját határozza meg.
    //Levágjuk az azonosítót, majd az előre definiált banksByInt listából megtudjuk a nevét.
    public String setBankName(String bban) {
        if (bban == null) {
            System.out.println("A bankszámla formátuma nem megfelelő. Kérem próbálja újra!");
        } else {
            //levágjuk az első 3 karaktert és megnézzük, hogy a listában létezik-e bank ilyen azonosítóval
            CharSequence bankID = bban.subSequence(0, 3);
            String bankName = banksByInt.get(Integer.parseInt(bankID.toString()));
            if (bankName == null) {
                System.out.println("Ismeretlen bank! Kérem keresse a supportot!");
            } else {
                System.out.println("A bank neve: " + bankName);
                return bankName;
            }
        }
        return null;
    }

    public boolean validateBban(String bban) {
        //http://gepembernaploja.blog.hu/-0001/11/30/bankszamlaszamok_felepitese
        //http://bankkerdes.blogspot.hu/2014/03/bankszamlaszam-felepitese.html

        int value = 0;
        int[] inspect = {9, 7, 3, 1};
        boolean valid = false;

        while (!valid) {
            int n = 0;
            for (int i = 0; i < bban.length(); i++) {
                if (n < 4) {
                    int asd = 0;
                    try {
                        asd = Integer.parseInt(String.valueOf(bban.charAt(i)));
                    } catch (NumberFormatException e) {
                        value = 0;
                        continue;
                    }

                    value += inspect[n] * asd;
                    n++;
                    if ((i % 8) == 0  && i != 0) {
                        if ((value % 10) == 0) {
                            valid = true;
                        }
                        else {
                            return false;
                        }
                    }

                } else {
                    n = 0;
                    i--;
                }
            }
        }
        return valid;
    }
    /**
            * Generates valid IBAN number from BBAN/GIRO number and country code
     *
             * @param request
     * @return IBAN number
     */

    public String generateIBAN (String bban) {
        String validBban = bban.replace("-","");
        String ibanAsString = null;
        try {
            Iban iban = new Iban.Builder()
                    .countryCode(CountryCode.HU)
                    .bankCode(validBban.substring(0,3))
                    .branchCode(validBban.substring(3,8))
                    .accountNumber(validBban.substring(8))
                    .nationalCheckDigit("")
                    .build(false);
            ibanAsString = iban.toString();
        } catch (IbanFormatException e){
            e.printStackTrace();
        }
        return ibanAsString;
    }
}
