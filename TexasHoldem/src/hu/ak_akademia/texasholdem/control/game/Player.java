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
	private boolean inHand = true;
	private Card card1;
	private Card card2;
	private int chips = 0;
	private int chipsInPot = 0;
	private InGameAction lastAction;

	public Player(PokerUserEntity entity, boolean isOwner) {
		super(entity);
		this.owner = isOwner;
	}

	public void buyIn(int entry) {
		setCredits(getCredits() - entry);
		chips = entry * 10;
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

	public int getChips() {
		return chips;
	}

	public void setChips(int chips) {
		this.chips = chips;
	}
	
	public int getChipsInPot() {
		return chipsInPot;
	}

	public InGameAction getLastAction() {
		return lastAction;
	}

	public void setLastAction(InGameAction lastAction) {
		this.lastAction = lastAction;
	}
	
}