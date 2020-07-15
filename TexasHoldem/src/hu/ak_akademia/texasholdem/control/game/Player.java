/**
 * 
 */
package hu.ak_akademia.texasholdem.control.game;

import hu.ak_akademia.texasholdem.model.db.PokerUserEntity;
import hu.ak_akademia.texasholdem.model.deck.Card;

/**
 * @author bnagy
 *
 */
public class Player implements PlayerInGame {
	
	private final int id;
	private final String name;
	private final String pw;
	private final boolean deleted;
	private int credits;
	
	private final boolean owner;
	private boolean dealer;
	private int creditsInGame;
	private Player nextPlayer;
	private Player prevPlayer;
	private boolean inHand;
	
	private Card card1;
	private Card card2;
	
	private boolean folded;
	
	public Player(PokerUserEntity entity, boolean isOwner) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.pw = entity.getPassword();
		this.deleted = entity.isIs_deleted();
		this.credits = entity.getCredits();
		this.owner = isOwner;
	}
	public void sitIn(int entry) {
		credits -= entry;
		creditsInGame = entry;
	}
	public PokerUserEntity getUser() {
		return new PokerUserEntity(id,name,pw,credits,deleted);
	}
	public int getCredits() {
		return credits;
	}

	public void setCredits(int credits) {
		this.credits = credits;
	}

	public boolean isDealer() {
		return dealer;
	}
	
	public boolean isSmallBlind() {
		return prevPlayer.isDealer();
	}
	
	public boolean isBigBlind() {
		return prevPlayer.isSmallBlind();
	}
	
	public void setDealer(boolean dealer) {
		this.dealer = dealer;
	}

	public int getCreditsInGame() {
		return creditsInGame;
	}

	public void setCreditsInGame(int creditsInGame) {
		this.creditsInGame = creditsInGame;
	}

	public Player getNextPlayer() {
		return nextPlayer;
	}

	public void setNextPlayer(Player nextPlayer) {
		this.nextPlayer = nextPlayer;
	}

	public Player getPrevPlayer() {
		return prevPlayer;
	}

	public void setPrevPlayer(Player prevPlayer) {
		this.prevPlayer = prevPlayer;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public boolean isOwner() {
		return owner;
	}

	public Card getCard1() {
		return card1;
	}
	public void setCard1(Card card1) {
		this.card1 = card1;
	}
	public Card getCard2() {
		return card2;
	}
	public void setCard2(Card card2) {
		this.card2 = card2;
	}
	
	public boolean isInHand() {
		return inHand;
	}
	public void setInHand(boolean inHand) {
		this.inHand = inHand;
	}
	
	public boolean isFolded() {
		return folded;
	}
	public void setFolded(boolean folded) {
		this.folded = folded;
	}
	@Override
	public void raise(int credits) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void call() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void check() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void fold() {
		// TODO Auto-generated method stub
		inHand = false;
		
	}

	@Override
	public void sitOut() {
		// TODO Auto-generated method stub
		creditsInGame = 0;
		
	}
	@Override
	public String toString() {
		return "Player [name=" + name + ", credits=" + credits + "]";
	}
		
}
