package au.edu.rmit.cpt222.view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import au.edu.rmit.cpt222.model.interfaces.GameEngine.GameStatus;
import au.edu.rmit.cpt222.model.interfaces.Player;

@SuppressWarnings("serial")
public class GameHistory extends JPanel {
	
	private MainView mainView;
	private JLabel lastGame;
	
	public GameHistory(MainView mainView) {
		this.setBackground(Color.CYAN);
		this.mainView = mainView;
		this.lastGame = new JLabel("LAST GAME: No games played yet");
		this.add(lastGame);
		
	}
	
	public MainView getView () {
		return this.mainView;
	}

	public void append(Player player, GameStatus result) {
		this.lastGame.setText("LAST GAME: Selected Face: " + player.getFacePick() + ", Bet Amount: " + player.getBet() + ", Result: " + result.toString());
	}

}
