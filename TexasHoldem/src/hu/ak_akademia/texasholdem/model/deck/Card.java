/**
 * 
 */
package hu.ak_akademia.texasholdem.model.deck;

/**
 * @author Artúr Ölvedi
 * @author Iza
 *
 */
public class Card {

	private CardColor color;
	private Figure figure;

	/**
	 * @param color
	 * @param figure
	 */
	public Card(CardColor color,Figure figure) {
		super();
		this.color = color;
		this.figure = figure;
	}

	/**
	 * @return the color
	 */
	public CardColor getColor() {
		return color;
	}

	/**
	 * @return the figure
	 */
	public Figure getFigure() {
		return figure;
	}

	public String toString() {
		return  color.getSymbol()+figure.getSymbol();
	}

	public boolean equals(Card card) {
		return (color.equals(card.getColor()) && figure.equals(card.getFigure()));
	}
}
