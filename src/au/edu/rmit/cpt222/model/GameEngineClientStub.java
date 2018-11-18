package au.edu.rmit.cpt222.model;

import java.util.Collection;

import au.edu.rmit.cpt222.model.exceptions.InsufficientFundsException;
import au.edu.rmit.cpt222.model.interfaces.Coin.Face;
import au.edu.rmit.cpt222.model.interfaces.GameEngine;
import au.edu.rmit.cpt222.model.interfaces.GameEngineCallback;
import au.edu.rmit.cpt222.model.interfaces.Player;

public class GameEngineClientStub implements GameEngine {

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPlayer(Player player) {
		// TODO Auto-generated method stub

	}

	@Override
	public void calculateResult() {
		// TODO Auto-generated method stub

	}

	@Override
	public void flip(int flipDelay, int coinDelay) {
		// TODO Auto-generated method stub

	}

	@Override
	public Collection<Player> getAllPlayers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getPlayer(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void placeBet(Player player, Face face, int bet) throws InsufficientFundsException {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean removePlayer(Player player) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setPlayerPoints(Player player, int totalPoints) {
		// TODO Auto-generated method stub

	}

}
