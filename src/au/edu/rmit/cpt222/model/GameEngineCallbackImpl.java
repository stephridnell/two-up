package au.edu.rmit.cpt222.model;

import au.edu.rmit.cpt222.model.interfaces.Coin.Face;
import au.edu.rmit.cpt222.model.interfaces.GameEngine;
import au.edu.rmit.cpt222.model.interfaces.GameEngine.GameStatus;
import au.edu.rmit.cpt222.model.interfaces.GameEngineCallback;
import au.edu.rmit.cpt222.model.interfaces.Player;

public class GameEngineCallbackImpl implements GameEngineCallback {

	@Override
	public void coinFlip(Face coinFace, GameEngine engine) {
		// TODO Auto-generated method stub

	}

	@Override
	public void coinFlipOutcome(Face coinFace, GameEngine engine) {
		// TODO Auto-generated method stub

	}

	@Override
	public void gameResult(Player player, GameStatus result, GameEngine engine) {
		// TODO Auto-generated method stub

	}

}
