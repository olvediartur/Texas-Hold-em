/**
 * 
 */
package hu.ak_akademia.texasholdem.control;

import hu.ak_akademia.texasholdem.control.game.Session;
import hu.ak_akademia.texasholdem.view.UI;
import hu.ak_akademia.texasholdem.view.consolemenu.Menu;
import hu.ak_akademia.texasholdem.view.consolemenu.MenuItem;
import hu.ak_akademia.texasholdem.view.consolemenu.Option;

/**
 * @author bnagy
 *
 */
public class InGameController extends ApplicationController {

	private Session session;

	public InGameController() {
		super();
		menu = new Menu(UI.bundle.getString("ingamemenu"));
		initialiseInGameMenu();
	}
	
	public InGameController(Session session) {
		super();
		menu = new Menu(UI.bundle.getString("ingamemenu"));
		initialiseInGameMenu();
		this.session = session;
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
		menu.getOptions().add(call);
		menu.getOptions().add(check);
		menu.getOptions().add(raise);
		menu.getOptions().add(fold);
		menu.getOptions().add(sitOut);
	}

}
