/**
 * 
 */
package hu.ak_akademia.texasholdem.control.bl;

import hu.ak_akademia.texasholdem.control.DbController;
import hu.ak_akademia.texasholdem.model.db.PlayerInGameEntity;

/**
 * @author bnagy
 *
 */
public class WinnerPokerHand implements Comparable<WinnerPokerHand>{
	private PokerUser user;
	private GameGame gameGame;
	private BestFive cards;
	
	
	public WinnerPokerHand(PlayerInGameEntity entity) {
		DbController.getDbc().getPokerUserController().getById(entity.getPokerUserId());
		user = new PokerUser(DbController.getDbc().getPokerUserController().getSelected());
		DbController.getDbc().getGameController().getById(entity.getGameId());
		gameGame = new GameGame(DbController.getDbc().getGameController().getSelected());
		cards = entity.getBestCombination();
	}
	@Override
	public int compareTo(WinnerPokerHand o) {
		return new BestFiveComparator().compare(this.cards, o.cards);
	}
	@Override
	public String toString() {
		String result = "";
		result = result + "Date=" + gameGame.getDateOfGame().toString();
		result = result + " ; User=" + user.getName();
		result = result + " ; Cards=" + cards.toString();
		return result;
	}
	
	
	
}
