/**
 * 
 */
package hu.ak_akademia.texasholdem.view.consolemenu;

import hu.ak_akademia.texasholdem.exception.CantSelectExeption;

/**
 * @author bnagy
 *
 */
public interface Selectable {
	void select() throws CantSelectExeption;
}
