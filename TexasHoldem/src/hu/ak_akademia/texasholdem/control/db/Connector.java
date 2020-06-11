/** 
 * Ez az oszt�ly biztos�tja a kapcsolatot a DB-hez. 
 * Ha valamit m�dos�tani szeretn�nk az adatb�zisban, 
 * akkor ett�l kell elk�rni a connection-t. 
 */
package hu.ak_akademia.texasholdem.control.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author bnagy Ez az objektum biztos�tja a kapcsolatott. Az eg�sz programban,
 *         mindig ezt az egy objektumot fogjuk haszn�lni. Ez a Singleton
 *         l�nyege.
 */

public final class Connector {

	private static Connector instance;
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/orclpdb";
	private static final String USER = "texas_holdem";
	private static final String PASS = "admin";

	private Connector() {
	}

	/**
	 * @return a megnyitott kapcsolattal t�r vissza.
	 * @throws SQLException
	 * 
	 */
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(URL, USER, PASS);
		return conn;
	}

	/**
	 * @return A singleton disegn pattern �rtelm�ben: Mindig a mag�ban t�rolt
	 *         egyetlen p�ld�ny�val t�r vissza.
	 */
	synchronized public static Connector getInstance() {
		if (instance == null) {
			instance = new Connector();
		}
		return instance;
	}

	/*
	 * Ez a tesztel�s-hez kell. Jobb klik ebben az oszt�lyban. Run As>Java
	 * Application Ha megjelenic amegfel� �zenet, akkor ez a met�dus t�r�lhet�. Ha
	 * nem t�rl�d, akkor is ki kell kommentelni.
	 */
	/*
	 * public static void main(String[] args) { try { getInstance().getConnection();
	 * System.out.println("Sikeresen csatlakozott"); } catch (SQLException e) {
	 * e.printStackTrace(); } }
	 */
}