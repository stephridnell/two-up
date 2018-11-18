package au.edu.rmit.cpt222.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import au.edu.rmit.cpt222.model.interfaces.Player;
import au.edu.rmit.cpt222.view.AddPlayerDialog;

public class AddPlayerController implements ActionListener {

	private AddPlayerDialog dialog;
	private MainController controller;

	private int startingCredits;
	private String playerName, creditsString;

	public AddPlayerController(AddPlayerDialog addPlayerDialog) {
		this.dialog = addPlayerDialog;
		this.controller = this.dialog.getMainView().getController();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case AddPlayerDialog.SUBMIT:
	
				playerName = dialog.getPlayerName().getText();
				creditsString = dialog.getStartingCredits().getText();
				
				// Check if there was actually input
	
				if (playerName.trim().length() > 0 && creditsString.trim().length() > 0) {
	
					// Convert to numeric - throw error if can't be parsed to int
					try {
						startingCredits = Integer.parseInt(creditsString);
					} catch (NumberFormatException err) {
						JOptionPane.showMessageDialog(null, "Starting credits must be a number.", "Oops",
								JOptionPane.WARNING_MESSAGE);
						return;
					}
					
					// Make sure they enter positive number
					if (startingCredits < 0) {
						JOptionPane.showMessageDialog(null, "Starting credits must be greater than 0.", "Oops",
								JOptionPane.WARNING_MESSAGE);
					} else {
						Player newPlayer = this.controller.newPlayer(playerName.trim(), startingCredits);
						this.controller.updatePlayerStatusPanel(newPlayer);
						dialog.dispose();
					}
	
				} else {
					JOptionPane.showMessageDialog(null, "Must enter player name and credits.", "Oops",
							JOptionPane.WARNING_MESSAGE);
				}
				break;
	
			case AddPlayerDialog.CANCEL:
				dialog.dispose();
				break;
		}

	}

}
