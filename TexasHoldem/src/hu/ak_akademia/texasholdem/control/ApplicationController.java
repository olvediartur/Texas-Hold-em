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
	
	UI ui;
	DbController dbc;
	
	protected ApplicationController() {
		this.ui = UI.getUi();
		this.dbc = DbController.getDbc();
	}

	void useMenu(Menu m) {
		ui.showMenu(m);
		try {
			m.selectOption(ui.getMenuChoice(m.getOptions().size()));
		} catch (CantSelectException e) {
			e.printStackTrace();
		}
	}
	
	public abstract void start();

}