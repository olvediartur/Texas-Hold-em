/**
 * 
 */
package hu.ak_akademia.texasholdem.control.game;

import hu.ak_akademia.texasholdem.control.bl.PokerUser;
import hu.ak_akademia.texasholdem.model.db.PokerUserEntity;
import hu.ak_akademia.texasholdem.model.deck.Card;

/**
 * @author bnagy
 * @author Artúr Ölvedi
 */
public class Player extends PokerUser implements PlayerInGame {

	private final boolean owner;
	private boolean dealer;
	private int creditsInGame;
	private boolean inHand;
	private Card card1;
	private Card card2;
	private boolean folded;
	private int chips=0;

	public Player(PokerUserEntity entity, boolean isOwner) {
		super(entity);
		this.owner = isOwner;
	}

	public void buyIn(int entry) {
		setCredits(getCredits() - entry);
		creditsInGame = entry;
	}

	public PokerUserEntity getUser() {
		return new PokerUserEntity(getId(), getName(), getPassword(), getCredits(), isDeleted());
	}

	public boolean isDealer() {
		return dealer;
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
	public void raise(int chip) {
		chips=chips-chip;
		//Itt kell egy ellenőrzés, hogy a beérkező int paraméter 
		//ne legyen nagyobb mint amennyi zsetonunk(chips) van.
	}

	@Override
	public void call(int chip) {
		chips=chips-chip;
	}

	@Override
	public void check() {
		// TODO Auto-generated method stub
		//nem történik semmi, ilyenkor a következő játékosra ugrunk
	}

	@Override
	public void fold() {
		inHand = false;
	}

	@Override
	public void sitOut() {
		chips = 0; 
	}

	@Override
	public String toString() {
		return "Player [name=" + getName() + ", credits=" + getCredits() + "]";
	}

	/**
	 * @return
	 */
	public boolean isRaised() {
		// TODO Auto-generated method stub
		// meg kell valósítani
		return false;
	}

	public int getChips() {
		return chips;
	}

	public void setChips(int chips) {
		this.chips = chips;
	}
}
