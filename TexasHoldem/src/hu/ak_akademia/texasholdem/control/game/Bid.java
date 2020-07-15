/**
 * 
 */
package hu.ak_akademia.texasholdem.control.game;

import hu.ak_akademia.texasholdem.model.CircularLinkedList;
import hu.ak_akademia.texasholdem.view.UI;

/**
 * @author bnagy
 *
 */
public class Bid {// licit
	private Player currentPlayer;
	private CircularLinkedList<Player> playersInHand = new CircularLinkedList<>();
	private Round round;
	private UI ui = UI.getUi();

	public Bid(CircularLinkedList<Player> players, Round round) {
		this.round = round;
		for (Player p : players) {
			if (p.isInHand()) {
				playersInHand.add(p);
			}
			/*
			 * if(round.equals(Round.PREFLOP)) { if(p.isBigBlind()) { currentPlayer =
			 * p.getNextPlayer(); } } else { if(p.isDealer()) { currentPlayer =
			 * p.getNextPlayer(); } }
			 */
		}
	}

	public void run() {
		Player lastRaiser = getBigBlind();
		//Megnézi, ha preflop vagyunk akkor a nagyvak utáni cselekszik elsőnek, 
		//különben a dealer utáni.
		if (round.getValue()==0) {
			currentPlayer=playersInHand.getNext(lastRaiser);
		} else {
			currentPlayer=playersInHand.getNext(getDealer());
		}
		//
		while (isEndOfBid(currentPlayer, lastRaiser)) {
			/*
			 * while(nincs vége a licitnek)
			 * mit csinál az akt játékos
			 * léptetni az aktuális játékost
			 * 
			 * addig tart, amíg players.getNext() vissza nem ér a lastRaiser-hez.
			 */
			
		}
		currentPlayer = stepTroughCurrentPlayer(currentPlayer);	
		
	}
	//Akkor van vége egy licitkörnek amikor az utolsó hand-ben lévő játékos
	//után az emelő következne ÉS az utolsó játékos nem emel vissza(vagyis csak megad vagy dob).
	private boolean isEndOfBid(Player raisingPlayer, Player actualPlayer) {
		if (playersInHand.getNext(actualPlayer) == raisingPlayer && !actualPlayer.isRaised()) {
			return true;
		}
		return false;
	}

	private Player stepTroughCurrentPlayer(Player currentPlayer) {
		ui.showMessage(currentPlayer + "is_your_turn");
		/*
		 * Player act = currentPlayer; while(act.getNextPlayer().isFolded()) { act =
		 * currentPlayer.getNextPlayer(); } return act.getNextPlayer();
		 */
		return playersInHand.getNext(currentPlayer);
	}

	private Player getDealer() {
		for (Player p : playersInHand) {
			if (p.isDealer()) {
				return p;
			}
		}
		return null;// Ilyen nem lehet.
	}

	private Player getSmallBlind() {
		return playersInHand.getNext(getDealer());
	}

	private Player getBigBlind() {
		return playersInHand.getNext(getSmallBlind());
	}

}
