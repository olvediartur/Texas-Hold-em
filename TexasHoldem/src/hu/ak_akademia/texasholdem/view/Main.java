/**
 * Ez egy minta class, hogy ne legyen �res a package
 * A program bel�p�si pontja.
 */
package hu.ak_akademia.texasholdem.view;

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
	 */
	private void run() {
		ApplicationController appCtrl = new ApplicationController();
		System.out.println("Hurrá");
		appCtrl.start();
	}

}
