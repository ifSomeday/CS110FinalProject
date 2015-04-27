import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;



public class UI  extends JFrame{
	
	private JLabel mCard1, mCard2;
	
	private JPanel mPanel, mPanel1, mPanel2, mPanel1a, mPanel2a;
	
	private JButton button;
	
	private WarGame game;
	
	public UI(String s){
		
		super(s);
		
		setLayout(new FlowLayout());
		
		mCard1 = new JLabel(new ImageIcon("10c.jpg"));
		mCard2 = new JLabel(new ImageIcon());
		
		button = new JButton("Next Battle");
		
		mPanel1 = new JPanel();
		mPanel1.setBackground(Color.RED);
		mPanel1.setLayout(new FlowLayout());
		mPanel1a = new JPanel();
		mPanel1a.setBackground(Color.RED);
		mPanel1a.setLayout(new GridLayout(2,1));
		mPanel1a.add(new JLabel("Player 1"));
		mPanel1a.add(new JLabel("Cards Left: 26"));
		mPanel1.add(mPanel1a);
		mPanel1.add(mCard1);


		
		mPanel2 = new JPanel();
		mPanel2.setBackground(Color.BLUE);
		mPanel2.setLayout(new FlowLayout());
		mPanel2a = new JPanel();
		mPanel2a.setBackground(Color.BLUE);
		mPanel2a.setLayout(new GridLayout(2,1));
		mPanel2a.add(new JLabel("Player 2"));
		mPanel2a.add(new JLabel("Cards Left: 26"));
		mPanel2.add(mPanel2a);
		mPanel2.add(mCard2);
		
		
		
		mPanel = new JPanel();
		mPanel.setLayout(new GridLayout(2,1));
		mPanel.add(mPanel1);
		mPanel.add(mPanel2);
		
		add(mPanel);
		add(button);
		button.addActionListener(new ButtonListener());
		
		mCard2.setIcon(new ImageIcon("10c.jpg"));
		
	}
	
	public void setCard1(String filename){
		mCard1.setIcon(new ImageIcon(filename));
	}
	
	public void setGameRef(WarGame game){
		this.game = game;
	}
	
	public void setCard2(String filename){
		mCard2.setIcon(new ImageIcon(filename));
	}
	
	class ButtonListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			game.battle();
			System.out.println(game.getDeck1().getLength());
			System.out.println(game.getDeck2().getLength());
		}
		
	}

}
