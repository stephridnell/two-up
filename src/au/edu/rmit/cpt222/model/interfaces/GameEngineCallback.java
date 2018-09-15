package au.edu.rmit.cpt222.model.interfaces;

import au.edu.rmit.cpt222.model.interfaces.GameEngine.GameStatus;

/**
 * Assignment interface for SADI to notify client of GameEngine events.
 * 
 * @author Mikhail Perepletchikov
 * 
 */
public interface GameEngineCallback {

	/**
	 * Called as the coin is "rotating" after a flip. Use this to update your
	 * GUI display for each coin flip or log to console.
	 * 
	 * @param coinFace
	 *            the current (up-facing) face of the "rotating" coin
	 * @param engine
	 *            a convenience reference to the engine so the receiver can call
	 *            engine methods if necessary
	 */
	public void coinFlip(Coin.Face coinFace, GameEngine engine);

	/**
	 * Called when the coin stopped "rotating". Use this to update your GUI
	 * display for each coin flip or log to console.
	 * 
	 * @param coinFace
	 *            the final coin face resulted from a "flip"
	 * @param engine
	 *            a convenience reference to the engine so the receiver can call
	 *            engine methods if necessary
	 */
	public void coinFlipOutcome(Coin.Face coinFace, GameEngine engine);

	/**
	 * Called for each Player to indicate the outcome of the current game. Use
	 * this to update your GUI display or log to console.
	 * 
	 * @param player
	 *            the Player who is playing the game
	 * @param result
	 *            indicates game outcome - won/lost/drew
	 * @param engine
	 *            a convenience reference to the engine so the receiver can call
	 *            engine methods if necessary
	 */
	public void gameResult(Player player, GameStatus result, GameEngine engine);
}
