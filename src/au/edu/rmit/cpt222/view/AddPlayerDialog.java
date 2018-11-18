package au.edu.rmit.cpt222.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import au.edu.rmit.cpt222.controller.AddPlayerController;

@SuppressWarnings("serial")
public class AddPlayerDialog extends JDialog {
	
	public static final String SUBMIT = "Submit";
	public static final String CANCEL = "Cancel";

	private JLabel nameLabel, creditsLabel;
	private JTextField playerName, startingCredits;
	private JButton submit, cancel;
	private AddPlayerController controller;
	private MainView mainView;

	public AddPlayerDialog(MainView view) {
		super(view, "Add New Player");
		this.mainView = view;
		
		this.controller = new AddPlayerController(this);

		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		this.setLayout(new BorderLayout());

		playerName = new JTextField(20);
		startingCredits = new JTextField(20);
		nameLabel = new JLabel("Player Name: ");
		creditsLabel = new JLabel("Starting Credits:  ");
		submit = new JButton(SUBMIT);
		cancel = new JButton(CANCEL);

		submit.addActionListener(controller);
		cancel.addActionListener(controller);

		JPanel textBox = new JPanel(new BorderLayout());

		JPanel nameBox = new JPanel(new FlowLayout());
		nameBox.add(nameLabel);
		nameBox.add(playerName);

		JPanel creditBox = new JPanel(new FlowLayout());
		creditBox.add(creditsLabel);
		creditBox.add(startingCredits);

		textBox.add(nameBox, BorderLayout.NORTH);
		textBox.add(creditBox, BorderLayout.CENTER);

		JPanel clickButtons = new JPanel(new FlowLayout());
		clickButtons.add(submit);
		clickButtons.add(cancel);

		this.add(textBox, BorderLayout.NORTH);
		this.add(clickButtons, BorderLayout.CENTER);

		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(mainView);
		this.setModal(true);
		this.setVisible(true);
	}

	public JTextField getPlayerName() {
		return playerName;
	}

	public JTextField getStartingCredits() {
		return startingCredits;
	}

	public MainView getMainView() {
		return mainView;
	}

}
