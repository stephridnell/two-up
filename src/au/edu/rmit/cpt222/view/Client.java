package au.edu.rmit.cpt222.view;

import java.util.logging.Level;
import java.util.logging.Logger;

import au.edu.rmit.cpt222.model.GameEngineCallbackImpl;
import au.edu.rmit.cpt222.model.GameEngineImpl;
import au.edu.rmit.cpt222.model.SimplePlayer;
import au.edu.rmit.cpt222.model.exceptions.InsufficientFundsException;
import au.edu.rmit.cpt222.model.interfaces.Coin;
import au.edu.rmit.cpt222.model.interfaces.GameEngine;
import au.edu.rmit.cpt222.model.interfaces.Player;

/**
 * Simple console client for SADI Assignment 1 (Two Up)
 * 
 * @author Mikhail Perepletchikov
 * 
 */
public class Client {
	private static Logger logger = Logger.getLogger("assignment1");
	public final static int DEFAULT_BET1 = 10;
	public final static int DEFAULT_BET2 = 50;
	public final static int DEFAULT_FLIP_DELAY = 300;
	public final static int DEFAULT_COIN_DELAY = 500;
	public final static int DEFAULT_CREDIT_POINTS1 = 100;
	public final static int DEFAULT_CREDIT_POINTS2 = 110;

	public static void main(String args[]) {

		final GameEngine gameEngine = new GameEngineImpl();

		// create two test players
		Player[] players = new Player[] {
				new SimplePlayer("1", "The Shark", DEFAULT_CREDIT_POINTS1),
				new SimplePlayer("2", "The Loser", DEFAULT_CREDIT_POINTS2) };

		// attach GameEngineCallbackImpl to the GameEngine
		gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());

		// main loop to add players; place a bet; and receive hand
		for (Player player : players) {

			gameEngine.addPlayer(player);

			// set test bets
			try {
				players[0].placeBet(Coin.Face.heads, DEFAULT_BET1);
				players[1].placeBet(Coin.Face.tails, DEFAULT_BET2);
			}
			// test insufficient funds error
			catch (InsufficientFundsException e) {
				logger.log(Level.INFO, e.getMessage());
			}

			// test initial (pre-game) Player state as retrieved from the
			// GameEngine
			logger.log(Level.INFO, gameEngine.getPlayer(player.getPlayerId())
					.toString());
		}
		// play the game
		gameEngine.flip(DEFAULT_FLIP_DELAY, DEFAULT_COIN_DELAY);

		// log final player data (including updated balance) so we can check
		// correctness
		for (Player player : gameEngine.getAllPlayers())
			logger.log(Level.INFO, player.toString());
	}

}
