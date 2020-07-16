/**
 * 
 */
package hu.ak_akademia.texasholdem.view;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * @author Iza
 * @author Enikő
 *
 */
public class Printer {

	public void printLine(String str) {
		System.out.println(str);
	}
	
	public void print(String str) {
		System.out.print(str);
	}

	public void print(File file) {
		StringBuilder sb = new StringBuilder();
		try {
			Scanner sc = new Scanner(file);
			while (sc.hasNext()) {
				sb.append(sc.nextLine());
				sb.append("\n");
			}
			sc.close();
		} catch (FileNotFoundException e) {
			// Nem történhet meg
			e.printStackTrace();
		}
		System.out.println(sb.toString());
	}

	/**
	 * 
	 */
	public final static void clearConsole() {
		if (System.console() == null) {
			for (int clear = 0; clear < 1000; clear++) {
				System.out.println("\b");
			}
			return;
		}
		try {
			final String os = System.getProperty("os.name");

			if (os.contains("Windows")) {
				new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
			} else {
				Runtime.getRuntime().exec("clear");
			}
		} catch (final Exception e) {
			e.printStackTrace();
		}

	}

}
