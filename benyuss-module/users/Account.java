package users;

import java.sql.Timestamp;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Account {

    private String currency;
    private Timestamp creationDate;
    private String bban;
    private String bankName;

    public Account (String currency, String bban, String bankName) {

            this.bban = bban;
            this.bankName = bankName;
            this.currency = currency;
            setCreationDate();
    }

    public void setCreationDate() {
        //timestamp of account creation.
        java.util.Date date = new java.util.Date();
        this.creationDate = new Timestamp(date.getTime());
    }

    public String getBban() {
        return bban;
    }
}
