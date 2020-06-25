/**
 * 
 */
package hu.ak_akademia.texasholdem.view;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

import hu.ak_akademia.texasholdem.control.ApplicationController;
import hu.ak_akademia.texasholdem.model.deck.Card;
import hu.ak_akademia.texasholdem.view.consolemenu.Menu;

/**
 * @author Iza
 * @author Enikő
 *
 */
public class UI {

	private Validator validator;
	private Printer printer;
	private Scanner scanner;

	public UI() {
		super();
		this.validator = new Validator();
		this.printer = new Printer();
		this.scanner = new Scanner(System.in);
	}

	public void showMenu(Menu m) {
		printer.print(m.show());
	}

	public void showMessage(String msg) {
		printer.print(msg);
	}

	public void showBoard(List<Card> board) {
		String printMe = "";
		for (int i = 0; i < board.size(); i++) {
			printMe += board.get(i).toString();
		}
		printer.print(printMe);
	}

	public void showPlayerCards(List<Card> cards) {
		String printMe = "";
		for (int i = 0; i < cards.size(); i++) {
			printMe += cards.get(i).toString();
		}
		printer.print(printMe);
	}

	public String getStringFromUser() {
		String input = "";
		try {
			printer.print(ApplicationController.bundle.getString("ui_getstring_askforpassword"));
			input = scanner.nextLine();
		} catch (NoSuchElementException e) {
			printer.print(ApplicationController.bundle.getString("ui_getstring_askforcorrection"));
		}
		return input;
	}

	public int getIntFromUser() {
		int input = 0;
		try {
			printer.print(ApplicationController.bundle.getString("ui_getint_askfornumber"));
			input = scanner.nextInt();
		} catch (NoSuchElementException e) {
			scanner.next();
			//printer.print(ApplicationController.bundle.getString("ui_getint_askfornumber"));
		}
		return input;
	}

	public int getMenuChoice(int numberOfOptions) {
		int res = 0;
		do {
			res = getIntFromUser();
		} while (!validator.isValidMenuChoice(res, numberOfOptions));
		return res;
	}

	public void shutDown() {
		printer.print(ApplicationController.bundle.getString("goodbyemsg"));
		scanner.close();
	}

}
