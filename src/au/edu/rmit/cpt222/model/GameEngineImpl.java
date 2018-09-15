package au.edu.rmit.cpt222.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import au.edu.rmit.cpt222.model.exceptions.InsufficientFundsException;
import au.edu.rmit.cpt222.model.interfaces.Coin.Face;
import au.edu.rmit.cpt222.model.interfaces.GameEngine;
import au.edu.rmit.cpt222.model.interfaces.GameEngineCallback;
import au.edu.rmit.cpt222.model.interfaces.Player;

public class GameEngineImpl implements GameEngine {
	
	private List<Player> players = new ArrayList<Player>();

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addPlayer(Player player) {
		players.add(player);

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
		return Collections.unmodifiableList(this.players);
	}

	@Override
	public Player getPlayer(String id) {
		int indexToRemove = 0;
		boolean found = false;

		for(int i = 0; i < this.players.size(); i++) {
		    if (this.players.get(i).getPlayerId().equals(id)) {
		    	found = true;
		        indexToRemove = i;
		    }
		}
		
		if (!found) {
			return null;
		}
		
		return this.players.get(indexToRemove);
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
