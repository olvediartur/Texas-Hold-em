/**
 * 
 */
package hu.ak_akademia.texasholdem.view;

import java.io.Console;
import java.io.File;
import java.util.List;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.ResourceBundle;
import java.util.Scanner;

import hu.ak_akademia.texasholdem.control.bl.WinnerPokerHand;
import hu.ak_akademia.texasholdem.model.db.PokerUserEntity;
import hu.ak_akademia.texasholdem.model.deck.Card;
import hu.ak_akademia.texasholdem.view.consolemenu.Menu;

/**
 * @author Iza
 * @author Enikő
 *
 */
public final class UI {

	private Validator validator;
	private Printer printer;
	private Scanner scanner;

	public static final ResourceBundle bundle = ResourceBundle.getBundle("Bundle", new Locale("en", "US"));
	private static final UI ui = new UI();

	/**
	 * 
	 */
	private PokerUserEntity logedUser = null;

	private UI() {
		this.validator = new Validator();
		this.printer = new Printer();
		this.scanner = new Scanner(System.in);
	}

	public static UI getUi() {
		return ui;
	}

	/**
	 * @return
	 */
	public PokerUserEntity getLogedUser() {
		return logedUser;
	}

	/**
	 * @param logedUser
	 */
	public void setLogedUser(PokerUserEntity logedUser) {
		this.logedUser = logedUser;
	}

	/**
	 * @param m
	 */
	public void showMenu(Menu m) {
		printer.printLine(m.show());
	}

	/**
	 * @param msg
	 */
	public void showMessage(String msg) {
		printer.printLine(bundle.getString(msg));
	}
	
	public void print(String text) {
		printer.print(text);
	}
	public void showRules() {
		printer.print(new File("res\\rules.txt"));
	}

	/**
	 * @param board
	 */
	public void showBoard(List<Card> board) {
		showMessage("cards_in_board");
		String printMe = "";
		for (int i = 0; i < board.size(); i++) {
			printMe += board.get(i).toString();
		}
		printer.printLine(printMe);
	}

	/**
	 * @param cards
	 */
	public void showPlayerCards(List<Card> cards) {
		showMessage("your_cards");
		String printMe = "";
		for (int i = 0; i < cards.size(); i++) {
			printMe += cards.get(i).toString();
		}
		printer.printLine(printMe);
	}
	public void showStatisticList(List<WinnerPokerHand> list) {
		if(list.isEmpty()) {
			showMessage("statistic_emptylist");
			return;
		}
		StringBuilder sb = new StringBuilder();
		int index = 1;
		for (WinnerPokerHand w : list) {
			sb.append(index + ") "+ w.toString() + "\n");
			index++;
		}
		printer.printLine(sb.toString());
	}
	/**
	 * @param askMsg
	 * @return
	 */
	public String getStringFromUser(String askMsg) {
		String input = "";
		try {
			showMessage((askMsg));
			input = scanner.nextLine();
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		return input;
	}

	/**
	 * @param 
	 * @return
	 */
	private String getPasswordFromUser(String askMsg) {
		Console console = System.console();
		if (console != null) {
			printer.printLine(bundle.getString(askMsg));
			char passwordArray[] = console.readPassword();
			return new String(passwordArray);
		} else {
			showMessage("firstmenu_login_noconsole");
			shutDown();
			System.exit(0);
		}
		return null;
		
	}

	/**
	 * @param askMsg
	 * @return
	 */
	public int getIntFromUser(String askMsg) {
		int input = 0;
		try {
			printer.printLine(bundle.getString(askMsg));
			input = scanner.nextInt();
			scanner.nextLine();
		} catch (NoSuchElementException e) {
			scanner.next();
		}
		return input;
	}

	/**
	 * @param numberOfOptions
	 * @return
	 */
	public int getMenuChoice(int numberOfOptions) {
		int res = 0;
		do {
			res = getIntFromUser("ui_getint_askfornumber");
		} while (!validator.isValidMenuChoice(res, numberOfOptions));
		return res;
	}

	/**
	 * 
	 */
	public void shutDown() {
		printer.printLine(bundle.getString("goodbyemsg"));
		scanner.close();
	}

	/**
	 * @return
	 */
	public String[] registration() {
		String[] userData = new String[3];
		String msg = "ui_void_msg";
		userData[0] = getStringFromUser("ui_getstring_askforname");
		do {
			ui.showMessage(msg);
			userData[1] = getStringFromUser("ui_getstring_askforpassword");
			msg = "reg_notstrongpw_msg";
		} while (!validator.isStrongPassword(userData[1]));
		userData[2] = "" + getIntFromUser("ui_getint_askforcredits");
		return userData;
	}

	/**
	 * @return
	 */
	public String[] login() {
		String[] userData = new String[2];
		userData[0] = getStringFromUser("login_username");
		if (System.console()==null) {
			userData[1]=getStringFromUser("login_psw");
		} else {
			userData[1] = getPasswordFromUser("login_psw");
		}
		return userData;
	}

	public String changePassword() {
		String newPassword = "";
		boolean ready = false;
		while (!ready) {
			String oldPw = getStringFromUser("mainmenu_edit_oldpw_msg");
			if (!oldPw.equals(logedUser.getPassword())) {
				showMessage(("mainmenu_edit_wrongoldpw_msg"));
				continue;
			}
			String newPw = getStringFromUser("mainmenu_edit_newpw_msg");
			if (!validator.isStrongPassword(newPw)) {
				showMessage(("reg_notstrongpw_msg"));
				continue;
			}
			String new2Pw = getStringFromUser("mainmenu_edit_newpwagain_msg");
			if (!newPw.equals(new2Pw)) {
				showMessage(("mainmenu_edit_differentpw_msg"));
				continue;
			}
			newPassword = newPw;
			ready = true;
		}
		return newPassword;
	}

	public void clearConsole() {
		Printer.clearConsole();
	}
}
