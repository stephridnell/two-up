package au.edu.rmit.cpt222.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

import au.edu.rmit.cpt222.controller.NewGameController;

@SuppressWarnings("serial")
public class NewGameDialog extends JDialog {

	public static final String SUBMIT = "Flip";
	public static final String CANCEL = "Cancel";
	public static final String HEADS = "Heads";
	public static final String TAILS = "Tails";

	private JLabel betLabel, faceLabel;
	private JTextField bet;

	private JButton submit, cancel;
	private NewGameController controller;
	private MainView mainView;

	private ButtonGroup facePicker;
	private JRadioButton heads, tails;

	public NewGameDialog(MainView view) {
		super(view, "New Game");
		this.mainView = view;
		
		this.controller = new NewGameController(this);

		this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

		this.setLayout(new BorderLayout());

		bet = new JTextField(20);
		betLabel = new JLabel("Bet Amount: ");
		faceLabel = new JLabel("Face: ");
		submit = new JButton(SUBMIT);
		cancel = new JButton(CANCEL);

		submit.addActionListener(controller);
		cancel.addActionListener(controller);

		JPanel textBox = new JPanel(new BorderLayout());

		JPanel betBox = new JPanel(new FlowLayout());
		betBox.add(betLabel);
		betBox.add(bet);

		heads = new JRadioButton(HEADS);
		heads.setActionCommand(HEADS);
		heads.addActionListener(controller);
		heads.setSelected(true);

		tails = new JRadioButton(TAILS);
		tails.setActionCommand(TAILS);
		tails.addActionListener(controller);

		facePicker = new ButtonGroup();
		facePicker.add(heads);
		facePicker.add(tails);

		JPanel facePickButtons = new JPanel(new GridLayout(1, 0));
		facePickButtons.add(heads);
		facePickButtons.add(tails);

		JPanel facePickPanel = new JPanel(new BorderLayout());
		facePickPanel.add(faceLabel, BorderLayout.WEST);
		facePickPanel.add(facePickButtons, BorderLayout.EAST);

		textBox.add(betBox, BorderLayout.NORTH);
		textBox.add(facePickPanel, BorderLayout.CENTER);

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
	
	public JTextField getBet() {
		return bet;
	}
	
	public MainView getMainView() {
		return this.mainView;
	}

}
