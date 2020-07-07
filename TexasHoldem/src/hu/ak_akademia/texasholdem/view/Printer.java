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
	
	public void print(String str) {
		System.out.println(str);
	}
	
	public void print(File file) {
		StringBuilder sb = new StringBuilder();
		try {
			Scanner sc = new Scanner(file);
			while(sc.hasNext()) {
				sb.append(sc.nextLine());
				sb.append("\n");
			}
			sc.close();
		} catch (FileNotFoundException e) {
			//Nem történhet meg
			e.printStackTrace();
		}
		System.out.println(sb.toString());
	}

}

