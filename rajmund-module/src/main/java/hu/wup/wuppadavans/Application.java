package hu.wup.wuppadavans;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Application {

    public static void main(String[] args) {
        List<User> userList = new ArrayList<User>();
        Scanner sc = new Scanner(System.in);
        System.out.println("Add meg a felhasznaloszamot!");
        int usernumber = sc.nextInt();
        List<Account> accountList = null;
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
            accountList = new ArrayList<Account>();
            Account account = new Account();
            account.setSzamlaszamdarab(sc.nextInt());
            for (int i = 1; i <= account.getSzamlaszamdarab(); i++) {
                account.setSzamlaszam(sc.next());                                                // account.setSzamlaszam(Math.random() * 999999999999999999999999) + 100000000000000000000000;
                account.setIban(sc.next());                                                      // account.setIban(Math.random() * 99) + 01);

            }
           // accountList.add(account);
            userList.add(user);
            System.out.println("");
        }
       // accountList.forEach(System.out::println);
        userList.forEach(System.out::println);
    }


}

			
		/* ArrayList lista = new ArrayList();
			for(int ID = 1; ID <= usernumber; ID++) {
				if(ID>1) {
					System.out.println(ID+". Felhaszn�l�");
				}
				lista.add(ID);
				System.out.println("Add meg a vezet�kneved!");
				user.setLastName(sc.next());
				lista.add(user.getLastName());
				System.out.println("Add meg a keresztneved!");
				user.setFirstName(sc.next());
				lista.add(user.getLastName());
				System.out.println("Add meg a nemed!");
				user.setGender(sc.next());
				lista.add(user.getGender());
				System.out.println("�s add meg az �letkorod!");
				user.setAge(sc.nextInt());
				lista.add(user.getAge());
				System.out.println("");
				//System.out.print(ID+1 + ". Felhaszn�l�:\n");
			}
			System.out.println(lista); 
			
	}

} */
