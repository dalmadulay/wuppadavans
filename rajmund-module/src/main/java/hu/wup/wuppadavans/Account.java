package hu.wup.wuppadavans;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

public class Account {

    public String szamlaszam;
    public int szamlaszamdarab;
    public String devizanem;
    public String iban;


    @Override
    public String toString() {
        return "Szamlaszam: " + szamlaszam +
                ", IBAN szam: HU" + iban + " " + szamlaszam + '\'' +
                "";
    }

    public String getSzamlaszam() {
        return szamlaszam;
    }

    public void setSzamlaszam(String szamlaszam) {
        this.szamlaszam = szamlaszam;
    }

    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public int getSzamlaszamdarab() {
        return szamlaszamdarab;
    }

    public void setSzamlaszamdarab(int szamlaszamdarab) {
        this.szamlaszamdarab = szamlaszamdarab;
    }


    public String getDevizanem() {
        return devizanem;
    }

    public void setDevizanem(String devizanem) {
        this.devizanem = devizanem;
    }

}
