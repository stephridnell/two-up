package au.edu.rmit.cpt222.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import au.edu.rmit.cpt222.model.interfaces.Coin;
import au.edu.rmit.cpt222.model.interfaces.Coin.Face;
import au.edu.rmit.cpt222.view.NewGameDialog;

public class NewGameController implements ActionListener {
	
	private NewGameDialog dialog;
	private String betString;
	private int bet;
	private MainController controller;
	// Heads is selected by default so this is the default value
	private Coin.Face face = Face.heads;

	public NewGameController(NewGameDialog newGameDialog) {
		this.dialog = newGameDialog;
		this.controller = this.dialog.getMainView().getController();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case NewGameDialog.SUBMIT:
				betString = dialog.getBet().getText();
				
				// Make sure bet amount was entered
				if (betString.trim().length() > 0) {
					
					// Convert to number - will error if can't parse to int
					try {
						bet = Integer.parseInt(betString);
					} catch (NumberFormatException err) {
						JOptionPane.showMessageDialog(null, "Bet must be a whole number.", "Oops",
								JOptionPane.WARNING_MESSAGE);
						return;
					}
					
					// Make sure bet is greater than 0
					if (bet < 0) {
						JOptionPane.showMessageDialog(null, "Bet must be greater than 0.", "Oops",
								JOptionPane.WARNING_MESSAGE);
					} else {
						this.controller.play(bet, face);
						dialog.dispose();
					}
					
				
				} else {
					JOptionPane.showMessageDialog(null, "Must enter bet amount.", "Oops",
							JOptionPane.WARNING_MESSAGE);
				}
				break;
	
			case NewGameDialog.CANCEL:
				dialog.dispose();
				break;
				
			case NewGameDialog.HEADS:
				face = Face.heads;
				break;
			
			case NewGameDialog.TAILS:
				face = Face.tails;
				break;
		}
	}

}
