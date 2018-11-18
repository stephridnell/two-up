package au.edu.rmit.cpt222.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import au.edu.rmit.cpt222.view.AddPlayerDialog;
import au.edu.rmit.cpt222.view.GameMenuBar;
import au.edu.rmit.cpt222.view.NewGameDialog;

public class MenuBarController implements ActionListener {
	
	private GameMenuBar gameMenuBar;

	public MenuBarController(GameMenuBar gameMenuBar) {
		this.gameMenuBar = gameMenuBar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
			case GameMenuBar.ADD_PLAYER:
				new AddPlayerDialog(this.gameMenuBar.getView());
				break;
			case GameMenuBar.NEW_GAME:
				new NewGameDialog(this.gameMenuBar.getView());
				break;
			case GameMenuBar.EXIT:
				String ObjButtons[] = { "Yes", "No" };
				int PromptResult = JOptionPane.showOptionDialog(null, "Are you sure you wish to exit?", "Confirm",
						JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, ObjButtons, ObjButtons[1]);
				if (PromptResult == JOptionPane.YES_OPTION) {
					System.exit(0);
				}
				break;
		}
	}

}
