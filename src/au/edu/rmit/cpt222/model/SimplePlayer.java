package au.edu.rmit.cpt222.model;

import au.edu.rmit.cpt222.model.exceptions.InsufficientFundsException;
import au.edu.rmit.cpt222.model.interfaces.Coin.Face;
import au.edu.rmit.cpt222.model.interfaces.GameEngine.GameStatus;
import au.edu.rmit.cpt222.model.interfaces.Player;

public class SimplePlayer implements Player {
	
	private String id;
	private String name;
	private int credits;

	public SimplePlayer(String id, String name, int defaultCreditPoints) {
		this.id = id;
		this.name = name;
		this.credits = defaultCreditPoints;
	}

	@Override
	public int getBet() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Face getFacePick() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPlayerId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getPlayerName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public GameStatus getResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void placeBet(Face facePick, int bet) throws InsufficientFundsException {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPlayerId(String playerId) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPlayerName(String playerName) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setPoints(int points) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setResult(GameStatus status) {
		// TODO Auto-generated method stub

	}

}
