package au.edu.rmit.cpt222.controller;

import javax.swing.JOptionPane;

import au.edu.rmit.cpt222.model.GUICallbackImpl;
import au.edu.rmit.cpt222.model.SimplePlayer;
import au.edu.rmit.cpt222.model.exceptions.InsufficientFundsException;
import au.edu.rmit.cpt222.model.interfaces.Coin.Face;
import au.edu.rmit.cpt222.model.interfaces.GameEngine;
import au.edu.rmit.cpt222.model.interfaces.GameEngine.GameStatus;
import au.edu.rmit.cpt222.model.interfaces.GameEngineCallback;
import au.edu.rmit.cpt222.model.interfaces.Player;
import au.edu.rmit.cpt222.view.MainView;

public class MainController {

	public static final int DEFAULT_FLIP_DELAY = 300;
	public static final int DEFAULT_COIN_DELAY = 500;

	private GameEngine model;
	private MainView view;
	private Player currentPlayer;

	public MainController(MainView view) {
		this.view = view;
		this.model = view.getModel();
		GameEngineCallback callback = new GUICallbackImpl(this);
		this.model.addGameEngineCallback(callback);
	}

	public void updateView(Face coinFace) {
		this.view.updateGamePanel(coinFace);
	}

	public void flip() {
		new Thread() {
			@Override
			public void run() {
				model.flip(DEFAULT_FLIP_DELAY, DEFAULT_COIN_DELAY);
			}
		}.start();
	}

	public Player newPlayer(String playerName, int startingCredits) {
		Player player = new SimplePlayer(playerName, startingCredits);
		this.model.addPlayer(player);
		this.currentPlayer = player;
		return player;
	}

	public void updatePlayerStatusPanel(Player player) {
		this.view.updateStatusPanel(player);
	}

	public void play(int bet, Face face) {
		// Make sure a player has been added
		if (currentPlayer == null) {
			JOptionPane.showMessageDialog(null, "Must add a player before placing bets.", "Oops",
					JOptionPane.WARNING_MESSAGE);
		} else {
			try {
				currentPlayer.placeBet(face, bet);
			} catch (InsufficientFundsException e) {
				JOptionPane.showMessageDialog(null, "Insufficient funds.", "Oops", JOptionPane.WARNING_MESSAGE);
				return;
			}

			this.flip();
		}
	}

	public void appendHistory(Player player, GameStatus result) {
		this.view.appendHistory(player, result);
	}

}
