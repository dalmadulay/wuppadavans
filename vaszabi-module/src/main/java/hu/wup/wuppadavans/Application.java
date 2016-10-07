package hu.wup.wuppadavans;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Application {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		List<User> userList = new ArrayList<>();

		System.out.println("Number of users:");
		long userAmount = scanner.nextLong();

		for (long i = 0; i < userAmount; i++) {

			User user = new User();
			user.setId(i);
			System.out.println(i+1 + ". User\nGive the first name:");
			user.setFirstname(scanner.next());
			System.out.println(i+1 + ". User\nGive the last name:");
			user.setLastname(scanner.next());
			System.out.println(i+1 + ". User\nGive the age:");
			user.setAge(scanner.nextInt());
			System.out.println(i+1 + ". User\nGender:");
			user.setGender(scanner.next());
			userList.add(user);

		}
				
		userList.forEach(System.out::println);

	}
}
