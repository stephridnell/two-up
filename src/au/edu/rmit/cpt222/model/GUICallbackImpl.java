package au.edu.rmit.cpt222.model;

import au.edu.rmit.cpt222.model.interfaces.GameEngine;
import au.edu.rmit.cpt222.model.interfaces.Player;

import javax.swing.SwingUtilities;

import au.edu.rmit.cpt222.controller.MainController;
import au.edu.rmit.cpt222.model.interfaces.Coin.Face;
import au.edu.rmit.cpt222.model.interfaces.GameEngine.GameStatus;

public class GUICallbackImpl extends GameEngineCallbackImpl {

	private MainController controller;

	public GUICallbackImpl(MainController controller) {
		this.controller = controller;
	}

	@Override
	public void coinFlip(Face coinFace, GameEngine engine) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				controller.updateView(coinFace);
			}
		});
	}
	
	@Override
	public void coinFlipOutcome(Face coinFace, GameEngine engine) {
		System.out.println("Coin landed on: " + coinFace.toString());
	}
	
	@Override
	public void gameResult(Player player, GameStatus result, GameEngine engine) {
		this.controller.updatePlayerStatusPanel(player);
		this.controller.appendHistory(player, result);
	}

}
