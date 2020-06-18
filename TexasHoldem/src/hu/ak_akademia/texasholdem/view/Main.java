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
	 * �tt�r�s p�ld�ny szintre
	 */
	private void run() {

		System.out.println("Hurrá");
		System.out.println(new ApplicationController().getFirstMenu().show());
	}

}
