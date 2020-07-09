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

	public MainController() {
		super();
		menu = new Menu(UI.bundle.getString("mainmenu"));
		initialiseMainMenu();
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
				ui.showMessage(dbc.getPokerUserController().update());
				useMenu(menu);
			}
		};
		MenuItem payOff = new Option(2, UI.bundle.getString("mainmenu_edit_payoff")) {
			@Override
			public void select() {
				int amountToPayIn = ui.getIntFromUser("mainmenu_edit_payoff_msg");
				PokerUserEntity user = ui.getLogedUser();
				user.setCredits(user.getCredits() - amountToPayIn);
				dbc.getPokerUserController().setSelected(user);
				ui.showMessage(dbc.getPokerUserController().update());
				useMenu(menu);
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
				ui.showMessage(dbc.getPokerUserController().update());
				useMenu(menu);
			}
		};
		MenuItem backToMain = new Option(5, UI.bundle.getString("mainmenu_edit_back")) {
			@Override
			public void select() {
				useMenu(menu);
			}
		};
		Menu subMenu = (Menu) editProfile;
		subMenu.getOptions().add(payIn);
		subMenu.getOptions().add(payOff);
		subMenu.getOptions().add(stats);
		subMenu.getOptions().add(changePW);
		subMenu.getOptions().add(backToMain);

		MenuItem quit = new Option(3, UI.bundle.getString("mainmenu_quit")) {
			@Override
			public void select() {
				ui.setLogedUser(null);
				new AdminController().start();
			}
		};

		menu.getOptions().add(start);
		menu.getOptions().add(subMenu);
		menu.getOptions().add(quit);
	}

}