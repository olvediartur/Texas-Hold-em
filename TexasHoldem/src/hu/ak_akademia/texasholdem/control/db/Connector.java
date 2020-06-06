/**
 * Ez az osztály biztosítja a kapcsolatot a DB-hez.
 * Ha valamit módosítani szeretnénk az adatbázisban,
 * akkor ettõl kell elkérni a connection-t.
 */
package hu.ak_akademia.texasholdem.control.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author bnagy
 * Ez az objektum biztosítja a kapcsolatott.
 * Az egész programban, mindig ezt az egy objektumot
 * fogjuk használni. Ez a Singleton lényege.
 */

public final class Connector {

	private static Connector instance;
	private static final String URL = "jdbc:oracle:thin:@localhost:1521/orclpdb";
	private static final String USER = "texas_holdem";
	private static final String PASS = "admin";

	private Connector() {
	}

	/**
	 * @return a megnyitott kapcsolattal tér vissza.
	 * @throws SQLException
	 * 
	 */
	public Connection getConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(URL, USER, PASS);
		return conn;
	}

	/**
	 * @return
	 * A singleton disegn pattern értelmében:
	 * Mindig a magában tárolt egyetlen példányával
	 * tér vissza.
	 */
	synchronized public static Connector getInstance() {
		if (instance == null) {
			instance = new Connector();
		}
		return instance;
	}
	
	/*
	 * Ez a tesztelés-hez kell.
	 * Jobb klik ebben az osztályban.
	 * Run As>Java Application
	 * Ha megjelenic amegfelõ üzenet, akkor ez a metódus törölhetõ.
	 * Ha nem törlöd, akkor is ki kell kommentelni.
	 */	
	/*
	 public static void main(String[] args) {
	 	try {
	 		getInstance().getConnection();
	 		System.out.println("Sikeresen csatlakozott");
	 	} catch (SQLException e) {
	 		e.printStackTrace();
	 	}
	 }
	 */
}
