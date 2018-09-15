package au.edu.rmit.cpt222.model;

import au.edu.rmit.cpt222.model.exceptions.InsufficientFundsException;
import au.edu.rmit.cpt222.model.interfaces.Coin.Face;
import au.edu.rmit.cpt222.model.interfaces.GameEngine.GameStatus;
import au.edu.rmit.cpt222.model.interfaces.Player;

public class SimplePlayer implements Player {
	
	private String id;
	private String name;
	private int bet;
	private Face facePick;
	private int points;
	private GameStatus result = GameStatus.DREW;

	public SimplePlayer(String id, String name, int defaultCreditPoints) {
		this.id = id;
		this.name = name;
		this.points = defaultCreditPoints;
	}

	@Override
	public int getBet() {
		return this.bet;
	}

	@Override
	public Face getFacePick() {
		return this.facePick;
	}

	@Override
	public String getPlayerId() {
		return this.id;
	}

	@Override
	public String getPlayerName() {
		return this.name;
	}

	@Override
	public int getPoints() {
		return this.points;
	}

	@Override
	public GameStatus getResult() {
		return this.result;
	}

	@Override
	public void placeBet(Face facePick, int bet) throws InsufficientFundsException {
		if (bet > this.points) {
			throw new InsufficientFundsException();
		}
		this.facePick = facePick;
		this.bet = bet;

	}

	@Override
	public void setPlayerId(String playerId) {
		this.id = playerId;

	}

	@Override
	public void setPlayerName(String playerName) {
		this.name = playerName;

	}

	@Override
	public void setPoints(int points) {
		this.points = points;

	}

	@Override
	public void setResult(GameStatus status) {
		this.result = status;

	}

}
