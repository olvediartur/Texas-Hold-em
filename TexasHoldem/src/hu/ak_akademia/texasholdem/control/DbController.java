/**
 * 
 */
package hu.ak_akademia.texasholdem.control;

import hu.ak_akademia.texasholdem.control.db.AbstractController;
import hu.ak_akademia.texasholdem.control.db.PlayerInGameController;
import hu.ak_akademia.texasholdem.control.db.PokerUserController;
import hu.ak_akademia.texasholdem.model.db.PlayerInGameEntity;
import hu.ak_akademia.texasholdem.model.db.PokerUserEntity;

/**
 * @author bnagy
 *
 */
public final class DbController {
	
	private static DbController dbc = new DbController();
	
	private DbController() {
	}

	public static DbController getDbc() {
		return dbc;
	}
	
	private final AbstractController<PokerUserEntity> pokerUserController = new PokerUserController();
	private final AbstractController<PlayerInGameEntity> playerInGameController = new PlayerInGameController();
	
	public AbstractController<PokerUserEntity> getPokerUserController() {
		return pokerUserController;
	}

	public AbstractController<PlayerInGameEntity> getPlayerInGameController() {
		return playerInGameController;
	}
	
	
	
}
