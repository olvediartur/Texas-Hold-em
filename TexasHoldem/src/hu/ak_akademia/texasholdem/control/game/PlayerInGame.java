/**
 * 
 */
package hu.ak_akademia.texasholdem.control.game;

/**
 * @author bnagy
 *
 */
public interface PlayerInGame {

	public void raise(int chip);
	public void call(int chip);
	public void check();
	public void fold();
	public void sitOut();
	
}
