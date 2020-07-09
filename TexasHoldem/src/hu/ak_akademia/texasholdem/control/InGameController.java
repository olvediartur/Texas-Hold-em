/**
 * 
 */
package hu.ak_akademia.texasholdem.control;

import hu.ak_akademia.texasholdem.control.game.Game;
import hu.ak_akademia.texasholdem.control.game.Player;
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
public class InGameController extends ApplicationController {

	private Menu inGameMenu = new Menu(UI.bundle.getString("ingamemenu"));
	private Game game;

	public InGameController() {
		super();
		initialiseInGameMenu();
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
		MenuItem sitOut = new Option(5, UI.bundle.getString("ingamemenu_sitout")) {
			@Override
			public void select() {
				// TODO write game methods
			}
		};
		inGameMenu.getOptions().add(call);
		inGameMenu.getOptions().add(check);
		inGameMenu.getOptions().add(raise);
		inGameMenu.getOptions().add(fold);
		inGameMenu.getOptions().add(sitOut);
	}

}
