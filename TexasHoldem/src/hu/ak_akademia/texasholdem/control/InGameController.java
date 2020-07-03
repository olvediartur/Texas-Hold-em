/**
 * 
 */
package hu.ak_akademia.texasholdem.control;

import hu.ak_akademia.texasholdem.control.game.Game;
import hu.ak_akademia.texasholdem.control.game.Player;
import hu.ak_akademia.texasholdem.view.UI;
import hu.ak_akademia.texasholdem.view.consolemenu.Menu;
import hu.ak_akademia.texasholdem.view.consolemenu.MenuItem;
import hu.ak_akademia.texasholdem.view.consolemenu.Option;
import hu.ak_akademia.texasholdem.view.consolemenu.SubMenu;

/**
 * @author bnagy
 *
 */
public class InGameController extends ApplicationController {
	
	private Menu inGameMenu = new Menu(UI.bundle.getString("ingamemenu"));
	private Menu newGameMenu = new Menu(UI.bundle.getString("newgamemenu"));
	
	private Game game;
	
	public InGameController() {
		super();
		initialiseInGameMenu();
		initialiseNewGameMenu();
	}
	
	/**
	 * 
	 */
	@Override
	public void start() {
		game = new Game();
		game.addPlayer(new Player(ui.getLogedUser(),true));
		useMenu(newGameMenu);
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
				// TODO set the fields of game
			}
		};
		MenuItem setEntry = new Option(2, UI.bundle.getString("newgamemenu_setup_setentry")) {
			@Override
			public void select() {
				// TODO set the fields of game
			}
		};
		MenuItem backToNewMenu = new Option(3, UI.bundle.getString("newgamemenu_setup_back")) {
			@Override
			public void select() {
				useMenu(newGameMenu);
			}
		};
		Menu subMenu = (SubMenu) setup;
		subMenu.getOptions().add(addUser);
		subMenu.getOptions().add(setEntry);
		subMenu.getOptions().add(backToNewMenu);
	
		MenuItem start = new Option(2, UI.bundle.getString("newgamemenu_start")) {
			@Override
			public void select() {
				if(game.getPlayers().size() > 1) {
					game.start();
				}
				ui.showMessage(UI.bundle.getString("newgamemenu_start_notenughplayer"));
			}
		};
	
		MenuItem back = new Option(3, UI.bundle.getString("newgamemenu_back")) {
			@Override
			public void select() {
				new MainController().start();
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
		MenuItem call = new Option(1, UI.bundle.getString("ingamemenu_call")) {
			@Override
			public void select() {
				// TODO write game methods
			}
		};
		MenuItem check = new Option(2, UI.bundle.getString("ingamemenu_check")) {
			@Override
			public void select() {
				// TODO write game methods
			}
		};
		MenuItem raise = new Option(3, UI.bundle.getString("ingamemenu_raise")) {
			@Override
			public void select() {
				// TODO write game methods
			}
		};
		MenuItem fold = new Option(4, UI.bundle.getString("ingamemenu_fold")) {
			@Override
			public void select() {
				// TODO write game methods
			}
		};
		inGameMenu.getOptions().add(call);
		inGameMenu.getOptions().add(check);
		inGameMenu.getOptions().add(raise);
		inGameMenu.getOptions().add(fold);
	}

}
