import javax.swing.JFrame;

public class War {

	// deck declarations
	static Deck deck1 = new Deck();
	static Deck deck2 = new Deck();

	public static void main(String[] args) {

		// creates the UI
		mainUI frame = new mainUI("War!");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);

		// creates the decks
		deck1.createDeck();
		deck2 = deck1.splitDeck();

		// creates the game and provides it to the UI
		frame.setGameRef(new WarGame(deck1, deck2, frame));

	}

}
