package hu.wup.wuppadavans.users;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class UserUtils {

    //ebben a listában fogjuk tárolni a usereket.
    private ArrayList<User> users = new ArrayList<User>();

    //csupán két nem létezik, diszkrimáljuk azokat, akik másnak hiszik magukat. Sry conchita.
    private final String[] gender = {"male", "female"};

    private String setGender(int gender) {
        return this.gender[gender];
    }

    public void addUser(User user, Scanner scanner) {
        //ezzel a metódussal tudok user-t hozzáadni a listához
        users.add(user);
        AccountUtils accountUtils = new AccountUtils();
        int userAccounts = accountUtils.amountOfAccounts(scanner);

        for (int i = 0; i < userAccounts; i++) {
            String bban;
            String currency;
            String bankName;
            String iban;

            do {
                bban = accountUtils.setBban(scanner);
            } while (bban == null);

            do {
                currency = accountUtils.setCurrency(accountUtils.initCurrency(scanner));
            } while (currency == null);

            do {
                bankName = accountUtils.setBankName(bban);
            } while (bankName == null);

            iban = accountUtils.generateIBAN(bban);

            Account account = new Account(currency,
                    bban, bankName, iban);
            user.getAccounts().add(account);
        }
    }


    public User initUser(Scanner scanner) {
        //figyeljük meg a már említett passzolt scannert.

        System.out.println("You have to define user's data.");

        String username = null;
        long id = this.generateID();
        boolean validUser = true; //true, mert egy while ciklust fog "meghajtani". addig nem állítjuk false-ra, amíg nem adnak meg olyan user-t, aki még nem létezik.

        while (validUser) {
            System.out.println("Username: ");
            String valid = new String(scanner.next()); //ez fogja tárolni a validálni való username-t.
            String user = valid.toLowerCase();
            //kisbetű, nagybetű nem számít, minden user neve kisbetűsre lesz konvertálva.
            // A megoldás életszerűtlen, de erre az eldobható megoldásra jó volt, mert könnyű és gyors.


            if (this.isExisting(user, id) == false) {
                //megkeressük, hogy az adott username vagy id létezik -e már. Ha igen, új username-t kérünk és új id-t generálunk.
                username = user;
                validUser = false;
            } else {
                System.out.println("Username is already existing. Choose another one!");
                id = generateID();
            }
        }

        System.out.println("First name: ");
        String firstName = scanner.next();

        System.out.println("Last name: ");
        String lastName = scanner.next();

        boolean validAge = true;
        int age = 1;
        while (validAge) {
            System.out.println("Age: ");
            //senki nem lehet 0 évesnél fiatalabb, így ezt eldobjuk.
            // Ha mondjuk facebookszerűen gondolkozunk, akkor ezt felvehetjük, 14-15-re és ez alatt a kor alatt nem lehet regisztrálni. Na persze..
            age = scanner.nextInt();
            if (age < 0) {
                System.out.print("You can't be 0 or less years old. LoLfagit. Try Again!");
            } else {
                validAge = false;
            }
        }

        boolean validGender = true;
        int gender = 2;
        while (validGender) {
            System.out.print("Gender (0 - male, 1 - female): ");
            gender = scanner.nextInt();
            if (gender != 0 && gender != 1) {
                System.out.print("Only 0 or 1 is acceptable. Try Again!");
            } else {
                validGender = false;
            }
        }

        return new User(username, firstName, lastName, age, setGender(gender), id);
        //A setGender be fogja állítani a 2 elemű tömbböl a megfelelőt. (male, female)
    }

    public long generateID() {
        Random random = new Random();
        return random.nextLong();
        //generálunk egy random longot, ez lesz az id.
    }

    public void printUser(Scanner scanner) {
        System.out.println("Choose a user by username and get it's data.");
        String username = scanner.next();
        String userdata = null;

        //ha létezik az adott username, akkor kiírjuk annak minden adatát. Ilyen célokra jobb lenne mapet használni,
        //mert nem lenne szükséges az iterálás, csupán egy kulcsot keresnénk, ami visszadobná az értéket.
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                userdata = user.toString();
            }
        }
        if (userdata == null) {
            System.out.println("There's no existing user with this username.");
        } else {
            System.out.print(userdata);
        }
    }

    public boolean isExisting(String username, long id) {
        //szokásos iterálás, ha létezik az adott id, vagy username, akkor visszaküldünk egy true-t és emiatt új user nevet kell majd megadni.
        for (User user : users) {
            if (user.getUsername().equals(username) || user.getId() == id) {
                return true;
            }
        }
        return false;
    }
}