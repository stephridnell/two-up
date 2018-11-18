package au.edu.rmit.cpt222.driver;

import javax.swing.SwingUtilities;

import au.edu.rmit.cpt222.model.GameEngineImpl;
import au.edu.rmit.cpt222.model.interfaces.GameEngine;
import au.edu.rmit.cpt222.view.MainView;

public class Ass1Driver {

	public static void main(String[] args) {
		final GameEngine gameEngine = new GameEngineImpl();
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run () {
				MainView mainView = new MainView(gameEngine, "CPT222 Assignment 1: Two Up");
				mainView.setVisible(true);
			}
		});

	}

}
