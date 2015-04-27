import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JFrame;


public class War {
	
	static Deck deck1 = new Deck();
	static Deck deck2 = new Deck();
	
	public static void main(String[] args){
		
		UI frame = new UI("New Frame ...");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		//frame.setSize(350,550);
		frame.setVisible(true);
		
		Scanner scanner = new Scanner(System.in);
		
		deck1.createDeck();
		deck2 = deck1.splitDeck();
		System.out.println(deck1);
		
		WarGame game = new WarGame(deck1, deck2, frame);
		frame.setGameRef(game);
		

		
	while(deck1.getLength() > 10 && deck2.getLength() > 10){
			game.battle();
			System.out.println(game.getDeck1().getLength());
			System.out.println(game.getDeck2().getLength());
			scanner.next();
		
			
		}
		

		
		//((UI)frame).setCard1();

	}
	
	

}
