/**
 * 
 */
package hu.ak_akademia.texasholdem.control.bl;

import hu.ak_akademia.texasholdem.control.DbController;
import hu.ak_akademia.texasholdem.control.db.AbstractController;
import hu.ak_akademia.texasholdem.model.db.PlayerInGameEntity;
import hu.ak_akademia.texasholdem.model.db.PokerUserEntity;

/**
 * @author bnagy
 *
 */
public class WinnerPokerHand implements Comparable<WinnerPokerHand>{
	
	private PokerUser user;
	private Game game;
	private BestFive cards;
	
	public WinnerPokerHand(PlayerInGameEntity entity) {
		AbstractController<PokerUserEntity> puc = DbController.getDbc().getPokerUserController();
		puc.getById(entity.getPokerUserId());
		PokerUserEntity pue = puc.getSelected();
		user = new PokerUser(pue);
		DbController.getDbc().getGameController().getById(entity.getGameId());
		game = new Game(DbController.getDbc().getGameController().getSelected());
		cards = entity.getBestCombination();
	}
	
	public WinnerPokerHand(PokerUser user, Game game, BestFive cards) {
		this.user = user;
		this.game = game;
		this.cards = cards;
	}

	public PokerUser getUser() {
		return user;
	}

	public void setUser(PokerUser user) {
		this.user = user;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game gameGame) {
		this.game = gameGame;
	}

	public BestFive getCards() {
		return cards;
	}

	public void setCards(BestFive cards) {
		this.cards = cards;
	}

	@Override
	public int compareTo(WinnerPokerHand o) {
		return new BestFiveComparator().compare(this.cards, o.cards);
	}
	@Override
	public String toString() {
		String result = "";
		result = result + "Date=" + game.getDateOfGame().toString();
		result = result + " ; User=" + user.getName();
		result = result + " ; Cards=" + cards.toString();
		return result;
	}
	
	public PlayerInGameEntity getEntity() {
		return new PlayerInGameEntity(user.getId(), game.getId(), cards);
	}
	
}
