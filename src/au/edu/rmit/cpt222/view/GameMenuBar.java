package au.edu.rmit.cpt222.view;

import java.awt.event.KeyEvent;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import au.edu.rmit.cpt222.controller.MenuBarController;

@SuppressWarnings("serial")
public class GameMenuBar extends JMenuBar {
	
	public static final String EXIT = "Exit";
	public static final String ADD_PLAYER = "Add Player";
	public static final String NEW_GAME = "New Game";
	
	private MainView mainView;
	private MenuBarController controller;
	
	public GameMenuBar(MainView mainView) {
		this.mainView = mainView;
		this.controller = new MenuBarController(this);

		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		this.add(file);

		JMenuItem addPlayerItem = new JMenuItem(ADD_PLAYER);
		addPlayerItem.setMnemonic(KeyEvent.VK_A);
		addPlayerItem.setToolTipText(ADD_PLAYER);
		addPlayerItem.setActionCommand(ADD_PLAYER);
		addPlayerItem.addActionListener(controller);
		file.add(addPlayerItem);
		
		JMenuItem newGameItem = new JMenuItem(NEW_GAME);
		newGameItem.setMnemonic(KeyEvent.VK_N);
		newGameItem.setToolTipText(NEW_GAME);
		newGameItem.setActionCommand(NEW_GAME);
		newGameItem.addActionListener(controller);
		file.add(newGameItem);

		file.addSeparator();

		JMenuItem exit = new JMenuItem(EXIT);
		exit.setMnemonic(KeyEvent.VK_E);
		exit.setToolTipText(EXIT);
		exit.setActionCommand(EXIT);
		exit.addActionListener(controller);

		file.add(exit);

	}

	public MainView getView() {
		return this.mainView;
	}

}
