package au.edu.rmit.cpt222.model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

import au.edu.rmit.cpt222.model.exceptions.InsufficientFundsException;
import au.edu.rmit.cpt222.model.interfaces.Coin;
import au.edu.rmit.cpt222.model.interfaces.Coin.Face;
import au.edu.rmit.cpt222.model.interfaces.GameEngine;
import au.edu.rmit.cpt222.model.interfaces.GameEngineCallback;
import au.edu.rmit.cpt222.model.interfaces.Player;

public class GameEngineImpl implements GameEngine {
	
	private Map<String, Player> players = new ConcurrentHashMap<String, Player>();
	private List<Coin> coins = new ArrayList<Coin>();
	private Set<GameEngineCallback> callbacks = Collections.newSetFromMap(new ConcurrentHashMap<GameEngineCallback, Boolean>());
	private List<Face> flipResults;

	public GameEngineImpl () {
		for (int i = 0; i < GameEngine.NUM_OF_COINS; i++) {
			this.coins.add(new CoinImpl());
		}
	}
	
	public GameEngineImpl (int numOfCoins) {
		for (int i = 0; i < numOfCoins; i++) {
			this.coins.add(new CoinImpl());
		}
	}
	
	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		this.callbacks.add(gameEngineCallback);

	}

	@Override
	public void addPlayer(Player player) {
		this.players.put(player.getPlayerId(), player);

	}

	@Override
	public void calculateResult() {
		int heads = 0, tails = 0;
		boolean draw = false;
		Face winningFace = null;
		
		// Loop through results and add number of heads and tails
		for (Face face : flipResults) {
			if (face == Face.heads) {
				heads++;
			} else {
				tails++;
			}
		}
		
		// Determine winning face or draw
		if (heads > 0 && tails > 0) {
			draw = true;
		} else if (heads == flipResults.size()) {
			winningFace = Face.heads;
		} else {
			winningFace = Face.tails;
		}
		
		// Loop through players and update
		for (String id : players.keySet()) {
			Player player = players.get(id);
			GameStatus result = GameStatus.DREW;
			if (!draw) {
				if (winningFace == player.getFacePick()) {
					result = GameStatus.WON;
					player.setResult(result);
					player.setPoints(player.getPoints() + player.getBet());
				} else {
					result = GameStatus.LOST;
					player.setResult(result);
					player.setPoints(player.getPoints() - player.getBet());
				}
			}
			
			for (GameEngineCallback callback : this.callbacks) {
				callback.gameResult(player, result, this);
			}	
	    }
		
	}

	@Override
	public void flip(int flipDelay, int coinDelay) {
		assert flipDelay >= 0 && coinDelay >= 0 : "Invalid delay. Delay should be greater than 0.";
		this.flipResults = new ArrayList<Face>();
		for (int i = 0; i < this.coins.size(); i++) {
			// Generate random number of flips between 3 and 10
			int flips = new Random().nextInt(10 + 1 - 3) + 3;
			
			for (int j = 0; j <= flips; j++) {
				this.coins.get(i).swapFace();
				try {
					Thread.sleep(flipDelay);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				for (GameEngineCallback callback : this.callbacks) {
					callback.coinFlip(this.coins.get(i).getCurrentFace(), this);
				}
			}
			
			for (GameEngineCallback callback : this.callbacks) {
				callback.coinFlipOutcome(this.coins.get(i).getCurrentFace(), this);
			}
			
			this.flipResults.add(this.coins.get(i).getCurrentFace());
			
			try {
				Thread.sleep(coinDelay);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.calculateResult();
	}

	@Override
	public Collection<Player> getAllPlayers() {
		return Collections.unmodifiableList(new ArrayList<Player>(this.players.values()));
	}

	@Override
	public Player getPlayer(String id) {
		return this.players.get(id);
	}

	@Override
	public void placeBet(Player player, Face face, int bet) throws InsufficientFundsException {
		try {
			player.placeBet(face, bet);
		} catch (InsufficientFundsException ife) {
			throw ife;
		}

	}

	@Override
	public void removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		this.callbacks.remove(gameEngineCallback);

	}

	@Override
	public boolean removePlayer(Player player) {
		return this.players.remove(player.getPlayerId(), player);
	}

	@Override
	public void setPlayerPoints(Player player, int totalPoints) {
		player.setPoints(totalPoints);

	}

}
