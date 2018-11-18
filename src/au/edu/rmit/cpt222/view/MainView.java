package au.edu.rmit.cpt222.view;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.WindowConstants;

import au.edu.rmit.cpt222.controller.MainController;
import au.edu.rmit.cpt222.model.interfaces.Coin.Face;
import au.edu.rmit.cpt222.model.interfaces.GameEngine;
import au.edu.rmit.cpt222.model.interfaces.GameEngine.GameStatus;
import au.edu.rmit.cpt222.model.interfaces.Player;

@SuppressWarnings("serial")
public class MainView extends JFrame {

	private GameEngine model;
	private MainController controller;

	private GameToolBar toolBar;
	private GamePanel gamePanel;
	private GameMenuBar menuBar;
	private GameHistory gameHistory;
	private GameStatusPanel gameStatusPanel;

	public MainView(GameEngine gameEngine, String title) {
		super(title);
		this.model = gameEngine;
		this.controller = new MainController(this);
		
		// Make sure application stops when GUI is closed
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		initComponents();

		initView();
	}

	private void initComponents() {
		toolBar = new GameToolBar(this);
		gamePanel = new GamePanel(this);
		menuBar = new GameMenuBar(this);
		gameHistory = new GameHistory(this);
		gameStatusPanel = new GameStatusPanel(this);
	}

	private void initView() {
		this.setSize(800, 250);

		this.setLocationRelativeTo(null);

		this.setMinimumSize(new Dimension(800, 250));

		this.setLayout(new BorderLayout());
		
		this.add(toolBar, BorderLayout.NORTH);
		this.add(gamePanel, BorderLayout.CENTER);
		this.add(gameHistory, BorderLayout.WEST);
		this.add(gameStatusPanel, BorderLayout.SOUTH);
		this.setJMenuBar(this.menuBar);
		
		this.pack();
	}

	public GameEngine getModel () {
		return this.model;
	}

	public void updateGamePanel(Face coinFace) {
		this.gamePanel.displayCoin(coinFace);
	}
	
	public MainController getController() {
		return this.controller;
	}

	public void updateStatusPanel(Player player) {
		this.gameStatusPanel.setCurrentCredits(player.getPoints());
		this.gameStatusPanel.setPlayerName(player.getPlayerName());
	}

	public void appendHistory(Player player, GameStatus result) {
		this.gameHistory.append(player, result);
	}

}
