/**
 * 
 */
package hu.ak_akademia.texasholdem.control;

import hu.ak_akademia.texasholdem.model.db.PokerUserEntity;
import hu.ak_akademia.texasholdem.view.UI;
import hu.ak_akademia.texasholdem.view.consolemenu.Menu;
import hu.ak_akademia.texasholdem.view.consolemenu.MenuItem;
import hu.ak_akademia.texasholdem.view.consolemenu.Option;

/**
 * @author bnagy
 *
 */
public class AdminController extends ApplicationController {

	public AdminController() {
		super();
		menu = new Menu(UI.bundle.getString("firstmenu"));
		initialiseFirstMenu();
	}

	/**
	 * 
	 */
	private void initialiseFirstMenu() {
		MenuItem reg = new Option(1, UI.bundle.getString("firstmenu_register")) {
			@Override
			public void select() {
				String[] dataFromUser;
				String regMsg = "ui_void_msg";
				do {
					ui.showMessage(regMsg);
					dataFromUser = ui.registration();
					regMsg = "ui_notUnique_msg";
				} while (isUniqueName(dataFromUser[0]));
				dbc.getPokerUserController().setSelected(dataFromUser);
				String feedback = dbc.getPokerUserController().create();
				ui.showMessage(feedback);
				useMenu(menu);
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
								new MainController().start();
								break out;
							} else {
								ui.showMessage("login_wrongPassword_msg");
								wrongCounter++;
								continue out;
							}
						}
					}
					ui.showMessage("login_wrongUserName_msg");
					wrongCounter++;
				} while (wrongCounter < 5);
				if (wrongCounter == 5) {
					ui.showMessage("login_tomanytry_msg");
					ui.shutDown();
					System.exit(0);
				}
			}
		};
		MenuItem rules = new Option(3, UI.bundle.getString("firstmenu_rules")) {
			@Override
			public void select() {
				ui.showRules();
				useMenu(menu);
			}
		};
		MenuItem shutDown = new Option(4, UI.bundle.getString("firstmenu_shutdown")) {
			@Override
			public void select() {
				ui.shutDown();
				System.exit(0);
			}
		};

		menu.getOptions().add(reg);
		menu.getOptions().add(login);
		menu.getOptions().add(rules);
		menu.getOptions().add(shutDown);
	}

}
