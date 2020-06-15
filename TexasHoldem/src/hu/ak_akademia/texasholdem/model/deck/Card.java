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
		return  color.getSymbol() + figure.getSymbol();
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((color == null) ? 0 : color.hashCode());
		result = prime * result + ((figure == null) ? 0 : figure.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Card other = (Card) obj;
		if (color != other.color) {
			return false;
		}
		if (figure != other.figure) {
			return false;
		}
		return true;
	}

	/*
	 * public boolean equals(Card card) { return (color.equals(card.getColor()) &&
	 * figure.equals(card.getFigure())); }
	 */
}
