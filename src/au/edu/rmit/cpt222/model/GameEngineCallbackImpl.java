package au.edu.rmit.cpt222.model;

import au.edu.rmit.cpt222.model.interfaces.Coin.Face;
import au.edu.rmit.cpt222.model.interfaces.GameEngine;
import au.edu.rmit.cpt222.model.interfaces.GameEngine.GameStatus;
import au.edu.rmit.cpt222.model.interfaces.GameEngineCallback;
import au.edu.rmit.cpt222.model.interfaces.Player;

public class GameEngineCallbackImpl implements GameEngineCallback {

	@Override
	public void coinFlip(Face coinFace, GameEngine engine) {
		System.out.println(coinFace.toString());

	}

	@Override
	public void coinFlipOutcome(Face coinFace, GameEngine engine) {
		System.out.println("Coin landed on: " + coinFace.toString());
	}

	@Override
	public void gameResult(Player player, GameStatus result, GameEngine engine) {
		System.out.println("Player: " + player.getPlayerName() + ", Game Result: " + result.toString());
	}

}
