import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class mainUI extends JFrame {

	private JLabel mCard1, mCard2, left1, left2, war1, war2, mCard1p, mCard2p,
			mCard1b, mCard2b, winner1, winner2;

	private JPanel mPanel, mPanel1, mPanel2, mPanel1a, mPanel2a;

	private JButton button;

	private WarGame game;

	public mainUI(String s) {

		super(s);

		setLayout(new FlowLayout());

		mCard1 = new JLabel(new ImageIcon("cards/b2fv.png"));
		mCard2 = new JLabel(new ImageIcon("cards/b1fv.png"));
		mCard1b = new JLabel(new ImageIcon("cards/b2fv.png"));
		mCard2b = new JLabel(new ImageIcon("cards/b1fv.png"));
		mCard1p = new JLabel(new ImageIcon("cards/b2pl.png"));
		mCard2p = new JLabel(new ImageIcon("cards/b1pl.png"));
		war1 = new JLabel();
		war2 = new JLabel();
		winner1 = new JLabel();
		winner2 = new JLabel();

		button = new JButton("Next Battle");

		mPanel1 = new JPanel();
		mPanel1.setBackground(Color.RED);
		mPanel1.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		mPanel1a = new JPanel();
		mPanel1a.setBackground(Color.RED);
		mPanel1a.setLayout(new GridLayout(4, 1));
		mPanel1a.add(new JLabel("Player 1              "));
		left1 = new JLabel("Cards Left: 26");
		mPanel1a.add(left1);
		mPanel1a.add(war1);
		mPanel1a.add(winner1);
		mPanel1.add(mPanel1a);
		mPanel1.add(mCard1);
		mPanel1.add(mCard1p);
		mPanel1.add(mCard1b);

		mPanel2 = new JPanel();
		mPanel2.setBackground(Color.BLUE);
		mPanel2.setLayout(new FlowLayout(FlowLayout.LEADING, 0, 0));
		mPanel2a = new JPanel();
		mPanel2a.setBackground(Color.BLUE);
		mPanel2a.setLayout(new GridLayout(4, 1));
		mPanel2a.add(new JLabel("Player 2              "));
		left2 = new JLabel("Cards Left: 26");
		mPanel2a.add(left2);
		mPanel2a.add(war2);
		mPanel2a.add(winner2);
		mPanel2.add(mPanel2a);
		mPanel2.add(mCard2);
		mPanel2.add(mCard2p);
		mPanel2.add(mCard2b);

		mPanel = new JPanel();
		mPanel.setLayout(new GridLayout(2, 1));
		mPanel.add(mPanel1);
		mPanel.add(mPanel2);

		add(mPanel);
		add(button);
		button.addActionListener(new ButtonListener());

	}

	public void setGameRef(WarGame game) {
		this.game = game;
	}

	public void setCard1(String filename) {
		mCard1.setIcon(new ImageIcon(filename));
	}

	public void setCard2(String filename) {
		mCard2.setIcon(new ImageIcon(filename));
	}

	public void setCard1b(String filename) {
		mCard1b.setIcon(new ImageIcon(filename));
	}

	public void setCard2b(String filename) {
		mCard2b.setIcon(new ImageIcon(filename));
	}

	public void setWinner1() {
		winner2.setText("");
		winner1.setText("Player 1 wins!");
	}

	public void setWinner2() {
		winner1.setText("");
		winner2.setText("Player 2 wins!");
	}

	class ButtonListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			setWar(0);
			game.battle();
			System.out.println(game.getDeck1().getLength());
			left1.setText("Cards Left: "
					+ Integer.toString(game.getDeck1().getLength()));
			System.out.println(game.getDeck2().getLength());
			left2.setText("Cards Left: "
					+ Integer.toString(game.getDeck2().getLength()));

			if (game.getDeck1().getLength() <= 0
					|| game.getDeck2().getLength() <= 0) {
				if (game.getDeck1().getLength() == 0) {
					winner("Player 2");
				} else {
					winner("Player 1");
				}
			}

		}

	}

	public void setWar(int num) {
		if (num == 0) {
			war1.setText("");
			war2.setText("");
		} else {
			war1.setText("War: " + num);
			war2.setText("War: " + num);
		}
	}

	private void winner(String winner) {
		gameOver gg = new gameOver("Game Over!", winner + " wins!", this);
		gg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gg.pack();
		gg.setVisible(true);
	}

	private class gameOver extends JFrame {

		mainUI ui;

		public gameOver(String s, String winner, mainUI ui) {
			super(s);

			this.ui = ui;

			setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
			// setLayout(new GridLayout(2,1));

			JButton mButton = new JButton("Exit");
			JLabel mLabel = new JLabel(winner);

			mLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

			mLabel.setAlignmentX(CENTER_ALIGNMENT);
			mButton.setAlignmentX(Component.CENTER_ALIGNMENT);

			mButton.addActionListener(new ButtonListener());
			add(mLabel);
			add(mButton);

		}

		class ButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {

				ui.setVisible(false);
				ui.dispose();

				setVisible(false);
				dispose();
			}

		}

	}

}
