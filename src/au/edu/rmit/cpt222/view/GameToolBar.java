package au.edu.rmit.cpt222.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import au.edu.rmit.cpt222.controller.GameToolBarController;

@SuppressWarnings("serial")
public class GameToolBar extends JPanel {
	
	public static final String ADD_PLAYER_TEXT = "Add Player";
	public static final String NEW_GAME_TEXT = "New Game";
	public static final String EXIT_TEXT = "Exit";
	
	private JButton addPlayer, newGame, exit;
	private GameToolBarController controller;
	private MainView mainView;
	
	public GameToolBar(MainView mainView) {
		this.mainView = mainView;
		this.setBackground(Color.GREEN);
		this.controller = new GameToolBarController(this);
		
		ImageIcon addPlayerIcon = new ImageIcon("resources/add_player.png");
		this.addPlayer = new JButton(addPlayerIcon);
		this.addPlayer.setToolTipText(ADD_PLAYER_TEXT);
		this.addPlayer.setActionCommand(ADD_PLAYER_TEXT);		
		this.add(this.addPlayer);
		this.addPlayer.addActionListener(this.controller);
		
		ImageIcon newGameIcon = new ImageIcon("resources/new_game.jpg");
		this.newGame = new JButton(newGameIcon);
		this.newGame.setToolTipText(NEW_GAME_TEXT);
		this.newGame.setActionCommand(NEW_GAME_TEXT);		
		this.add(this.newGame);
		this.newGame.addActionListener(this.controller);
		
		ImageIcon exitIcon = new ImageIcon("resources/exit_icon.png");
		this.exit = new JButton(exitIcon);
		this.exit.setToolTipText(EXIT_TEXT);
		this.exit.setActionCommand(EXIT_TEXT);		
		this.add(this.exit);
		this.exit.addActionListener(this.controller);
	}
	
	public MainView getView () {
		return this.mainView;
	}

}
