import javax.swing.JFrame;

public class War {

	static Deck deck1 = new Deck();
	static Deck deck2 = new Deck();

	public static void main(String[] args) {

		mainUI frame = new mainUI("War!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		deck1.createDeck();
		deck2 = deck1.splitDeck();
		System.out.println(deck1);

		WarGame game = new WarGame(deck1, deck2, frame);
		frame.setGameRef(game);

	}

}
