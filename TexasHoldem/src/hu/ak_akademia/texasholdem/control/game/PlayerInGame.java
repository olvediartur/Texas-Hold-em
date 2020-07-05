/**
 * 
 */
package hu.ak_akademia.texasholdem.control.game;

/**
 * @author bnagy
 *
 */
public interface PlayerInGame {

	public void raise(int credits);
	public void call();
	public void check();
	public void fold();
	public void sitOut();
	
}
