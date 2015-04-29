import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 * popup that displays when the game ends
 * 
 * @author erza
 *
 */
@SuppressWarnings("serial")
public class GameOver extends JFrame {

	// declarations
	mainUI ui;

	/**
	 * the creator for the popup
	 * 
	 * @param s
	 *            the title of the box
	 * @param winner
	 *            who won the game
	 * @param ui
	 *            the main ui
	 */
	public GameOver(String s, String winner, mainUI ui) {
		super(s);

		this.ui = ui;

		setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

		JButton mButton = new JButton("Exit");
		JLabel mLabel = new JLabel(winner);

		mLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		mLabel.setAlignmentX(CENTER_ALIGNMENT);
		mButton.setAlignmentX(Component.CENTER_ALIGNMENT);

		mButton.addActionListener(new ButtonListener());
		add(mLabel);
		add(mButton);

	}

	/**
	 * listens for the exit button
	 * 
	 * @author erza
	 *
	 */
	class ButtonListener implements ActionListener {

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent
		 * )
		 */
		@Override
		public void actionPerformed(ActionEvent e) {

			ui.setVisible(false);
			ui.dispose();

			setVisible(false);
			dispose();
		}

	}

}
