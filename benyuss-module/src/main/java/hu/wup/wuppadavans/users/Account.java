package hu.wup.wuppadavans.users;

import java.sql.Timestamp;

public class Account {

    private String currency;
    private Timestamp creationDate;
    private String bban;
    private String iban;
    private String bankName;

    public Account(String currency, String bban, String bankName, String iban) {
        this.bban = bban;
        this.bankName = bankName;
        this.currency = currency;
        this.iban = iban;
        setCreationDate();
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

     public void setCreationDate() {
        //timestamp of account creation.
        java.util.Date date = new java.util.Date();
        this.creationDate = new Timestamp(date.getTime());
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getBban() {
        return bban;
    }

    public void setBban(String bban) {
        this.bban = bban;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Override
    public String toString() {
        return "Account{" +
                "currency='" + currency + '\'' +
                ", creationDate=" + creationDate +
                ", bban='" + bban + '\'' +
                ", iban='" + iban + '\'' +
                ", bankName='" + bankName + '\'' +
                '}';
    }
}
