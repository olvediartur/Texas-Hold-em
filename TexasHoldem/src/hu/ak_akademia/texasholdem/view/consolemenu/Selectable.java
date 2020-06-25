/**
 * 
 */
package hu.ak_akademia.texasholdem.view.consolemenu;

import hu.ak_akademia.texasholdem.exception.CantSelectException;

/**
 * @author bnagy
 *
 */
public interface Selectable {
	void select() throws CantSelectException;
}
