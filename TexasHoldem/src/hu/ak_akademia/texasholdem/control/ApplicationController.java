/**
 * 
 */
package hu.ak_akademia.texasholdem.control;

import hu.ak_akademia.texasholdem.exception.CantSelectException;
import hu.ak_akademia.texasholdem.view.UI;
import hu.ak_akademia.texasholdem.view.consolemenu.Menu;

/**
 * @author bnagy
 *
 */
public abstract class ApplicationController {
	
	public UI ui;
	public DbController dbc;
	
	public Menu menu;
	
	protected ApplicationController() {
		this.ui = UI.getUi();
		this.dbc = DbController.getDbc();
	}

	public void useMenu(Menu m) {
		ui.showMenu(m);
		try {
			m.selectOption(ui.getMenuChoice(m.getOptions().size()));
		} catch (CantSelectException e) {
			e.printStackTrace();
		}
	}
	
	Menu getMenu() {
		return menu;
	}
	public void start() {
		useMenu(menu);
	}

}