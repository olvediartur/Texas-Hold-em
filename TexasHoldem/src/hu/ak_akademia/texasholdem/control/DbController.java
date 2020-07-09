/**
 * 
 */
package hu.ak_akademia.texasholdem.control;

import hu.ak_akademia.texasholdem.control.db.AbstractController;
import hu.ak_akademia.texasholdem.control.db.CardsInGameController;
import hu.ak_akademia.texasholdem.control.db.GameController;
import hu.ak_akademia.texasholdem.control.db.HandController;
import hu.ak_akademia.texasholdem.control.db.PlayerInGameController;
import hu.ak_akademia.texasholdem.control.db.PokerUserController;
import hu.ak_akademia.texasholdem.model.db.CardsInGameEntity;
import hu.ak_akademia.texasholdem.model.db.GameEntity;
import hu.ak_akademia.texasholdem.model.db.HandEntity;
import hu.ak_akademia.texasholdem.model.db.PlayerInGameEntity;
import hu.ak_akademia.texasholdem.model.db.PokerUserEntity;

/**
 * @author bnagy
 *
 */
public final class DbController {
	
	private static final DbController dbc = new DbController();
	
	private DbController() {
	}

	public static DbController getDbc() {
		return dbc;
	}
	
	private final AbstractController<PokerUserEntity> pokerUserController = new PokerUserController();
	private final AbstractController<PlayerInGameEntity> playerInGameController = new PlayerInGameController();
	private final AbstractController<CardsInGameEntity> cardsIngameController = new CardsInGameController();
	private final AbstractController<GameEntity> gameController = new GameController();
	private final AbstractController<HandEntity> handController = new HandController();
	
	public AbstractController<PokerUserEntity> getPokerUserController() {
		return pokerUserController;
	}

	public AbstractController<PlayerInGameEntity> getPlayerInGameController() {
		return playerInGameController;
	}

	public AbstractController<CardsInGameEntity> getCardsIngameController() {
		return cardsIngameController;
	}

	public AbstractController<GameEntity> getGameController() {
		return gameController;
	}

	public AbstractController<HandEntity> getHandController() {
		return handController;
	}
	
}
