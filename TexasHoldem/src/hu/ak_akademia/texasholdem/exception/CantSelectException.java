/**
 * 
 */
package hu.ak_akademia.texasholdem.exception;

/**
 * @author bnagy
 *
 */
public class CantSelectException extends Exception {
	
	public CantSelectException() {
		super("This option is not avaiable");
	}
	
}
