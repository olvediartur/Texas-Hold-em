package hu.ak_akademia.texasholdem.view;

/**
 * @author Iza
 * @author Enikő
 *
 */
public class Validator {

	boolean isValidMenuChoice(int userChoice, int numberOfOptions) {

		int menuItems[] = new int[numberOfOptions];
		for (int i = 0; i < menuItems.length; i++) {
			menuItems[i] = i + 1;
		}
		for (int i = 0; i < menuItems.length; i++) {
			if (menuItems[i] == userChoice)
				return true;
		}
		return false;
	}

	boolean isStrongPassword(String pw) {
		return pw.matches("[^(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[a-zA-Z]).{8,}$]");
	}

}
