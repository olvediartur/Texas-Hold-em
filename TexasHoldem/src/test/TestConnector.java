/**
 * 
 */
package test;

import java.sql.SQLException;

import hu.ak_akademia.texasholdem.control.db.Connector;

/**
 * @author bnagy
 *
 */
public class TestConnector {

	public static void main(String[] args) {
		try {
			Connector.getInstance().getConnection();
			System.out.println("Sikeresen csatlakozott");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
