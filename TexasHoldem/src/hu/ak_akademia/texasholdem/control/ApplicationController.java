/**
 * 
 */
package hu.ak_akademia.texasholdem.control;

import java.util.ResourceBundle;

import hu.ak_akademia.texasholdem.view.UI;
import hu.ak_akademia.texasholdem.view.consolemenu.Menu;
import hu.ak_akademia.texasholdem.view.consolemenu.MenuItem;

/**
 * @author bnagy
 *
 */
public class ApplicationController {
	
	public ApplicationController() {
		initialiseFirstMenu();
	}
	public static final ResourceBundle bundle = ResourceBundle.getBundle("Bundle");
	
	private UI userInterface;
	private Menu firstMenu = new Menu(bundle.getString("firstmenu"));
	
	/**
	 * 
	 */
	private void initialiseFirstMenu() {
		MenuItem reg = new MenuItem(1,bundle.getString("register")) {
			@Override
			public void select() {
				// TODO Auto-generated method stub
			}
		};
		MenuItem login = new MenuItem(2,bundle.getString("login")) {
			@Override
			public void select() {
				// TODO Auto-generated method stub
			}
		};
		MenuItem shutDown = new MenuItem(3,bundle.getString("shutdown")) {
			@Override
			public void select() {
				System.exit(0);
			}
		};
		firstMenu.getOptions().add(reg);
		firstMenu.getOptions().add(login);
		firstMenu.getOptions().add(shutDown);
	}

	public Menu getFirstMenu() {
		return firstMenu;
	}
	
	
	
}
