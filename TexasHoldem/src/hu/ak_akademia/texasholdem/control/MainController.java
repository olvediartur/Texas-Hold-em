/**
 * 
 */
package hu.ak_akademia.texasholdem.control;

import hu.ak_akademia.texasholdem.model.db.PokerUserEntity;
import hu.ak_akademia.texasholdem.view.UI;
import hu.ak_akademia.texasholdem.view.consolemenu.Menu;
import hu.ak_akademia.texasholdem.view.consolemenu.MenuItem;
import hu.ak_akademia.texasholdem.view.consolemenu.Option;
import hu.ak_akademia.texasholdem.view.consolemenu.SubMenu;

/**
 * @author bnagy
 *
 */
public class MainController extends ApplicationController {

	private Menu firstMenu = new Menu(UI.bundle.getString("firstmenu"));
	private Menu mainMenu = new Menu(UI.bundle.getString("mainmenu"));

	public MainController() {
		super();
		initialiseFirstMenu();
		initialiseMainMenu();
	}

	/**
	 * 
	 */
	@Override
	public void start() {
		useMenu(firstMenu);
	}

	/**
	 * 
	 */
	private void initialiseFirstMenu() {
		MenuItem reg = new Option(1, UI.bundle.getString("firstmenu_register")) {
			@Override
			public void select() {
				String[] dataFromUser;
				String notUniqueName = "";
				do {
					ui.showMessage(notUniqueName);
					dataFromUser = ui.registration();
					notUniqueName = "ui_notUnique_msg";
				} while (isUniqueName(dataFromUser[0]));
				dbc.getPokerUserController().setSelected(dataFromUser);
				String feedback = dbc.getPokerUserController().create();
				ui.showMessage(feedback);
				useMenu(firstMenu);
			}

			private boolean isUniqueName(String string) {
				for (PokerUserEntity user : dbc.getPokerUserController().getAll()) {
					if (user.getName().equals(string)) {
						return true;
					}
				}
				return false;
			}
		};
		MenuItem login = new Option(2, UI.bundle.getString("firstmenu_login")) {
			@Override
			public void select() {
				String[] dataFromUser;
				int wrongCounter = 0;
				out: do {
					dataFromUser = ui.login();
					for (PokerUserEntity user : dbc.getPokerUserController().getAll()) {
						if (user.getName().equals(dataFromUser[0])) {
							if (user.getPassword().equals(dataFromUser[1])) {
								ui.setLogedUser(user);
								useMenu(mainMenu);
								break out;
							} else {
								ui.showMessage("login_wrongPassword_msg");
								wrongCounter++;
							}
						} else {
							ui.showMessage("login_wrongUserName_msg");
							wrongCounter++;
						}
					}
				} while (wrongCounter < 5);
				if (wrongCounter == 5) {
					ui.showMessage("login_tomanytry_msg");
					ui.shutDown();
					System.exit(0);
				}
			}
		};
		MenuItem shutDown = new Option(3, UI.bundle.getString("firstmenu_shutdown")) {
			@Override
			public void select() {
				ui.shutDown();
				System.exit(0);
			}
		};
		MenuItem rules; // TODO rules
		firstMenu.getOptions().add(reg);
		firstMenu.getOptions().add(login);
		firstMenu.getOptions().add(shutDown);
	}

	/**
	 * 
	 */
	private void initialiseMainMenu() {

		MenuItem start = new Option(1, UI.bundle.getString("mainmenu_start")) {
			@Override
			public void select() {
				new InGameController().start();
			}
		};

		MenuItem editProfile = new SubMenu(2, UI.bundle.getString("mainmenu_edit")) {
			@Override
			public void select() {
				useMenu(this);
			}
		};
		MenuItem payIn = new Option(1, UI.bundle.getString("mainmenu_edit_payin")) {
			@Override
			public void select() {
				int amountToPayIn = ui.getIntFromUser("mainmenu_edit_payin_msg");
				PokerUserEntity user = ui.getLogedUser();
				user.setCredits(user.getCredits() + amountToPayIn);
				dbc.getPokerUserController().setSelected(user);
				dbc.getPokerUserController().update();
				useMenu(mainMenu);
			}
		};
		MenuItem payOff = new Option(2, UI.bundle.getString("mainmenu_edit_payoff")) {
			@Override
			public void select() {
				int amountToPayIn = ui.getIntFromUser("mainmenu_edit_payoff_msg");
				PokerUserEntity user = ui.getLogedUser();
				user.setCredits(user.getCredits() - amountToPayIn);
				dbc.getPokerUserController().setSelected(user);
				String msg = dbc.getPokerUserController().update();
				ui.showMessage(msg);
				useMenu(mainMenu);
			}
		};
		MenuItem stats = new Option(3, UI.bundle.getString("mainmenu_edit_stats")) {
			@Override
			public void select() {
				// TODO write Player in game controller
			}
		};
		MenuItem changePW = new Option(4, UI.bundle.getString("mainmenu_edit_changepw")) {
			@Override
			public void select() {
				String newPw = ui.changePassword();
				PokerUserEntity user = ui.getLogedUser();
				user.setPassword(newPw);
				dbc.getPokerUserController().setSelected(user);
				dbc.getPokerUserController().update();
				useMenu(mainMenu);
			}
		};
		Menu subMenu = (Menu) editProfile;
		subMenu.getOptions().add(payIn);
		subMenu.getOptions().add(payOff);
		subMenu.getOptions().add(stats);
		subMenu.getOptions().add(changePW);

		MenuItem quit = new Option(3, UI.bundle.getString("mainmenu_quit")) {
			@Override
			public void select() {
				ui.setLogedUser(null);
				useMenu(firstMenu);
			}
		};

		mainMenu.getOptions().add(start);
		mainMenu.getOptions().add(subMenu);
		mainMenu.getOptions().add(quit);
	}

}
