/**
 * 
 */
package hu.ak_akademia.texasholdem.control.game;

/**
 * @author bnagy
 * @author Artúr Ölvedi
 *
 */
public enum Round {
	PREFLOP(0), FLOP(3), TURN(1), RIVER(1);

	private int value;

	Round(int number) {
		this.value = number;
	}

	public int getValue() {
		return value;
	}
}
