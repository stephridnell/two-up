package au.edu.rmit.cpt222.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import au.edu.rmit.cpt222.view.AddPlayerDialog;
import au.edu.rmit.cpt222.view.GameToolBar;
import au.edu.rmit.cpt222.view.NewGameDialog;

public class GameToolBarController implements ActionListener {

	private GameToolBar toolBar;

	public GameToolBarController(GameToolBar toolBar) {
		this.toolBar = toolBar;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch (e.getActionCommand()) {
		case GameToolBar.ADD_PLAYER_TEXT:
			new AddPlayerDialog(this.toolBar.getView());
			break;
		case GameToolBar.NEW_GAME_TEXT:
			new NewGameDialog(this.toolBar.getView());
			break;
		case GameToolBar.EXIT_TEXT:
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
