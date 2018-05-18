package GameLogicAna;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class UserServiceAna {

	// ObjectMapper OM = new ObjectMapper();
	FileOutputStream outputStream = null;
	PrintStream fileWriter;
	FileReader fileReader;

	public UserServiceAna(String filename) {
		
		userA = FilehandlerAna.getFromFile();
	}

	public static void main(String[] args) {
		UserServiceAna userService = new UserServiceAna("player");
		userService.newUser("Natalia", "1234");
		System.out.println(userService.login("Natalia", "1234"));
	}

	public static Map<String, UserAna> userA = new HashMap<>();

	public void newUser(String username, String password) {
		UserAna user = new UserAna();
		user.setUsername(username);
		user.setPassword(password);
		userA.put(username, user);
		// persist(user);
	}

	public boolean login(String username, String password) {
		// getUserFromFile();
		if (userA.containsKey(username)) {
			if (userA.get(username).password.equals(password))
				return true;
		}
		return false;
	}
}

