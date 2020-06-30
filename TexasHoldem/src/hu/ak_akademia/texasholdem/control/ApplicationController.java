/**
 * 
 */
package hu.ak_akademia.texasholdem.control;

import java.util.Locale;
import java.util.ResourceBundle;

import hu.ak_akademia.texasholdem.exception.CantSelectException;
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
public class ApplicationController {

	public ApplicationController() {
		initialiseFirstMenu();
		initialiseMainMenu();
		initialiseNewGameMenu();
		initialiseInGameMenu();
	}

	public static final ResourceBundle bundle = ResourceBundle.getBundle("Bundle", new Locale("en", "US"));

	private UI ui = new UI();
	private DbController dbController = new DbController();
	
	private Menu firstMenu = new Menu(bundle.getString("firstmenu"));
	private Menu mainMenu = new Menu(bundle.getString("mainmenu"));
	private Menu newGameMenu = new Menu(bundle.getString("newgamemenu"));
	private Menu inGameMenu = new Menu(bundle.getString("ingamemenu"));
	
	public void start() {
		ui.showMenu(firstMenu);
		try {
			firstMenu.selectOption(ui.getMenuChoice(firstMenu.getOptions().size()));
		} catch (CantSelectException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	private void initialiseFirstMenu() {
		MenuItem reg = new Option(1, bundle.getString("firstmenu_register")) {
			@Override
			public void select() {
				String[] dataFromUser;
				String notUniqueName = "";
				do {
					ui.showMessage(notUniqueName);
					dataFromUser = ui.registration();
					notUniqueName = bundle.getString("ui_notUnique_msg");
				} while(isUniqueName(dataFromUser[0]));
				dbController.getPokerUserController().setSelected(dataFromUser);
				String feedback = dbController.getPokerUserController().create();
				ui.showMessage(feedback);
				start();
			}

			private boolean isUniqueName(String string) {
				for(PokerUserEntity user : dbController.getPokerUserController().getAll()) {
					if(user.getName().equals(string)) {
						return true;
					}
				}
				return false;
			}
		};
		MenuItem login = new Option(2, bundle.getString("firstmenu_login")) {
			@Override
			public void select() {
				// TODO Auto-generated method stub
			}
		};
		MenuItem shutDown = new Option(3, bundle.getString("firstmenu_shutdown")) {
			@Override
			public void select() {
				ui.shutDown();
				System.exit(0);
			}
		};
		firstMenu.getOptions().add(reg);
		firstMenu.getOptions().add(login);
		firstMenu.getOptions().add(shutDown);
	}

	/**
	 * 
	 */
	private void initialiseMainMenu() {

		MenuItem start = new Option(1, bundle.getString("mainmenu_start")) {
			@Override
			public void select() {
				// TODO Auto-generated method stub
			}
		};

		MenuItem editProfile = new SubMenu(2, bundle.getString("mainmenu_edit")) {
			@Override
			public void select() {
				// TODO Auto-generated method stub
			}
		};
		MenuItem payIn = new Option(1, bundle.getString("mainmenu_edit_payin")) {
			@Override
			public void select() {
				// TODO Auto-generated method stub
			}
		};
		MenuItem payOff = new Option(2, bundle.getString("mainmenu_edit_payoff")) {
			@Override
			public void select() {
				// TODO Auto-generated method stub
			}
		};
		MenuItem stats = new Option(3, bundle.getString("mainmenu_edit_stats")) {
			@Override
			public void select() {
				// TODO Auto-generated method stub
			}
		};
		MenuItem changePW = new Option(4, bundle.getString("mainmenu_edit_changepw")) {
			@Override
			public void select() {
				// TODO Auto-generated method stub
			}
		};
		Menu subMenu = (Menu) editProfile;
		subMenu.getOptions().add(payIn);
		subMenu.getOptions().add(payOff);
		subMenu.getOptions().add(stats);
		subMenu.getOptions().add(changePW);

		MenuItem quit = new Option(3, bundle.getString("mainmenu_quit")) {
			@Override
			public void select() {
				// TODO Auto-generated method stub
			}
		};

		mainMenu.getOptions().add(start);
		mainMenu.getOptions().add(subMenu);
		mainMenu.getOptions().add(quit);
	}

	/**
	 * 
	 */
	private void initialiseNewGameMenu() {
		MenuItem setup = new SubMenu(1,bundle.getString("newgamemenu_setup")) {
			@Override
			public void select() {
				// TODO Auto-generated method stub
			}
		};
		MenuItem addUser = new Option(1,bundle.getString("newgamemenu_setup_adduser")) {
			@Override
			public void select() {
				// TODO Auto-generated method stub
			}
		};
		MenuItem setEntry = new Option(2,bundle.getString("newgamemenu_setup_setentry")) {
			@Override
			public void select() {
				// TODO Auto-generated method stub
			}
		};
		MenuItem backToNewMenu = new Option(3,bundle.getString("newgamemenu_setup_back")) {
			@Override
			public void select() {
				// TODO Auto-generated method stub
			}
		};
		Menu subMenu = (SubMenu) setup;
		subMenu.getOptions().add(addUser);
		subMenu.getOptions().add(setEntry);
		subMenu.getOptions().add(backToNewMenu);
		
		
		MenuItem start = new Option(2,bundle.getString("newgamemenu_start")) {
			@Override
			public void select() {
				// TODO Auto-generated method stub
			}
		};
		
		MenuItem back = new Option(3,bundle.getString("newgamemenu_back")) {
			@Override
			public void select() {
				// TODO Auto-generated method stub
			}
		};
		
		newGameMenu.getOptions().add(subMenu);
		newGameMenu.getOptions().add(start);
		newGameMenu.getOptions().add(back);
	}

	/**
	 * 
	 */
	private void initialiseInGameMenu() {
		MenuItem call = new Option(1,bundle.getString("ingamemenu_call")) {
			@Override
			public void select() {
				// TODO Auto-generated method stub
			}
		};
		MenuItem check = new Option(2,bundle.getString("ingamemenu_check")) {
			@Override
			public void select() {
				// TODO Auto-generated method stub
			}
		};
		MenuItem raise = new Option(3,bundle.getString("ingamemenu_raise")) {
			@Override
			public void select() {
				// TODO Auto-generated method stub
			}
		};
		MenuItem fold = new Option(4,bundle.getString("ingamemenu_fold")) {
			@Override
			public void select() {
				// TODO Auto-generated method stub
			}
		};
		inGameMenu.getOptions().add(call);
		inGameMenu.getOptions().add(check);
		inGameMenu.getOptions().add(raise);
		inGameMenu.getOptions().add(fold);
	}

}
