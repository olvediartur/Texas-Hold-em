/**
 * 
 */
package hu.ak_akademia.texasholdem.model.deck;

/**
 * @author Artúr Ölvedi
 *
 */
public class Card {

	private CardColor color;
	private Figure figure;

	/**
	 * @param color
	 * @param figure
	 */
	public Card(Figure figure, CardColor color) {
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
		return figure.getSymbol() + color.getSymbol();
	}

	public boolean equals(Card card) {
		// HIÁNYOS
		return true;
	}
}
