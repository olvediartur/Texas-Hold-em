/**
 * 
 */
package hu.ak_akademia.texasholdem.control;

import hu.ak_akademia.texasholdem.control.game.Player;
import hu.ak_akademia.texasholdem.control.game.Session;
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
public class NewGameController extends ApplicationController {
	
	private Session session;//Session
	
	public NewGameController() {
		super();
		menu = new Menu(UI.bundle.getString("newgamemenu"));
		initialiseNewGameMenu();
	}
	
	/**
	 * 
	 */
	private void initialiseNewGameMenu() {
		MenuItem setup = new SubMenu(1, UI.bundle.getString("newgamemenu_setup")) {
			@Override
			public void select() {
				useMenu(this);
			}
		};
		MenuItem addUser = new Option(1, UI.bundle.getString("newgamemenu_setup_adduser")) {
			@Override
			public void select() {
				String[] dataFromUser;
				dataFromUser = ui.login();
				for (PokerUserEntity user : dbc.getPokerUserController().getAll()) {
					if (user.getName().equals(dataFromUser[0])) {
						if (user.getPassword().equals(dataFromUser[1])) {
							ui.showMessage(session.addPlayer(new Player(user, false)));
							useMenu((SubMenu) setup);
						} else {
							ui.showMessage("newgamemenu_setup_adduser_failed");
							useMenu((SubMenu) setup);
						}
					}
				}
				ui.showMessage("newgamemenu_setup_adduser_failed");
				
				useMenu((SubMenu) setup);
			}
		};
		MenuItem setEntry = new Option(2, UI.bundle.getString("newgamemenu_setup_setentry")) {
			@Override
			public void select() {
				int buyIn = UI.getUi().getIntFromUser("newgamemenu_setup_setentry_msg");
				session.setBuyIn(buyIn);
				//Felhasználóbarát üzenet
				useMenu((SubMenu) setup);
			}
		};
		MenuItem backToNewMenu = new Option(3, UI.bundle.getString("newgamemenu_setup_back")) {
			@Override
			public void select() {
				useMenu(menu);
			}
		};
		Menu subMenu = (SubMenu) setup;
		subMenu.getOptions().add(addUser);
		subMenu.getOptions().add(setEntry);
		subMenu.getOptions().add(backToNewMenu);

		MenuItem start = new Option(2, UI.bundle.getString("newgamemenu_start")) {
			@Override
			public void select() {
				if (session.getPlayers().size() <= 1) {
					ui.showMessage(UI.bundle.getString("newgamemenu_start_notenoughplayer"));
					useMenu(subMenu);
				}
				if (session.getBuyIn() == 0) {
					ui.showMessage(UI.bundle.getString("newgamemenu_start_noentry"));
					useMenu(subMenu);
				}
				for(Player p : session.getPlayers()) {
					p.sitIn(session.getBuyIn());
					dbc.getPokerUserController().setSelected(p.getUser());
					dbc.getPokerUserController().update();
				}
				session.start();
				useMenu(menu);
			}
		};

		MenuItem back = new Option(3, UI.bundle.getString("newgamemenu_back")) {
			@Override
			public void select() {
				new MainController().start();
			}
		};

		menu.getOptions().add(subMenu);
		menu.getOptions().add(start);
		menu.getOptions().add(back);
	}
	
	/**
	 * 
	 */
	@Override
	public void start() {
		session = new Session();
		session.addPlayer(new Player(ui.getLogedUser(), true));
		useMenu(menu);
	}
	
}
