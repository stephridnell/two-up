package au.edu.rmit.cpt222.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GameStatusPanel extends JPanel {

	private JLabel playerNameLabel, currentCreditsLabel;
	private int currentCredits;
	private String playerName;
	private Color backgroundColour = Color.WHITE;

	public GameStatusPanel(MainView mainView) {
		this.playerName = "";
		this.currentCredits = 0;
		this.setBackground(backgroundColour);

		this.playerNameLabel = new JLabel("PLAYER: " + playerName + " | ");
		this.currentCreditsLabel = new JLabel("CURRENT CREDITS: " + currentCredits);

		this.setLayout(new BorderLayout());

		JPanel labelPanel = new JPanel(new FlowLayout());
		labelPanel.add(playerNameLabel);
		labelPanel.add(currentCreditsLabel);
		labelPanel.setBackground(backgroundColour);

		this.add(labelPanel, BorderLayout.WEST);
	}

	public void setCurrentCredits(int currentCredits) {
		this.currentCredits = currentCredits;
		this.currentCreditsLabel.setText("CURRENT CREDITS: " + currentCredits);
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
		this.playerNameLabel.setText("PLAYER: " + playerName + " | ");
	}

}
