package au.edu.rmit.cpt222.view;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import au.edu.rmit.cpt222.model.interfaces.Coin.Face;

@SuppressWarnings("serial")
public class GamePanel extends JPanel {
	
	private MainView mainView;
	private JLabel currentCoinFace;

	public GamePanel(MainView mainView) {
		this.mainView = mainView;
		this.setBackground(Color.YELLOW);
		this.currentCoinFace = new JLabel("Coin");
		this.add(this.currentCoinFace);
	}
	
	public MainView getView () {
		return this.mainView;
	}

	public void displayCoin(Face coinFace) {
		this.currentCoinFace.setText(coinFace.name());
	}

}
