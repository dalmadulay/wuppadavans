package hu.wup.wuppadavans;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

public class User extends Account {
		public String lastName;
		public String firstName;
		public String gender;
		public int age;
		public long ID;
		public List<Account> accounts;

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accountList) {
		this.accounts = accountList;
	}

	@Override
		    public String toString() {
		        return
// "Felhasználo: " +
//		                "ID= " + ID+1 +
		                "Keresztnev= " + firstName + '\'' +
		                ", Vezeteknev= " + lastName + '\'' +
		                ", Eletkor= " + age +
		                ", Nemed= " + gender + '\'' + " " +
								accounts +
//		                ", Szamlaszam: " + szamlaszam + '\'' +
//						", Devizanem: " + devizanem + '\'' +
//						", IBAN szam: HU" + iban + " " + szamlaszam + '\'' +
						"";
		}
		
		
		
		public String getLastName() {
			return lastName;
		}
		public void setLastName(String lastName) {
			this.lastName = lastName;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		public long getID() {
			return ID;
		}
		public void setID(long iD) {
			ID = iD;
		}
		
		
		 
}