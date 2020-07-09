/**
 * A program belépési pontja.
 */
package hu.ak_akademia.texasholdem.view;

import hu.ak_akademia.texasholdem.control.AdminController;
import hu.ak_akademia.texasholdem.control.ApplicationController;

/**
 * @author bnagy
 *
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Main().run();
	}

	/**
	 * Áttérés példány szintre
	 * Elindítja az alkalmazást.
	 */
	private void run() {
		ApplicationController appCtrl = new AdminController();
		System.out.println("Hurrá");
		appCtrl.start();
	}

}
