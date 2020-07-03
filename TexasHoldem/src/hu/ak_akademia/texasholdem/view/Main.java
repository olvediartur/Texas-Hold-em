/**
 * A program belépési pontja.
 */
package hu.ak_akademia.texasholdem.view;

import hu.ak_akademia.texasholdem.control.ApplicationController;
import hu.ak_akademia.texasholdem.control.MainController;

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
	 * Elindítja a MainController-t.
	 */
	private void run() {
		ApplicationController appCtrl = new MainController();
		System.out.println("Hurrá");
		appCtrl.start();
	}

}
