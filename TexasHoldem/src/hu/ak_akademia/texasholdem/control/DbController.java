/**
 * 
 */
package hu.ak_akademia.texasholdem.control;

import hu.ak_akademia.texasholdem.control.db.AbstractController;
import hu.ak_akademia.texasholdem.control.db.PokerUserController;
import hu.ak_akademia.texasholdem.model.db.PokerUserEntity;

/**
 * @author bnagy
 *
 */
public class DbController {
	
	private AbstractController<PokerUserEntity> pokerUserController = new PokerUserController();

	public AbstractController<PokerUserEntity> getPokerUserController() {
		return pokerUserController;
	}
	
	
	
}
