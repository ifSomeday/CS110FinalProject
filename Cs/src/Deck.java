import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> deck = new ArrayList<Card>();
	private Card card = new Card();
	private int length;
	private final int SUITS = 4, RANKS = 13;

	public Deck() {

	}

	public Deck(ArrayList<Card> deck) {
		this.deck = deck;
	}

	public void shuffle() {
		Collections.shuffle(deck);
	}

	public void addCard(Card card) {
		deck.add(card);
	}

	public void createDeck() {
		for (int i = 0; i < SUITS; i++) {
			for (int j = 0; j < RANKS; j++) {
				System.out.println((i + 1) + "," + (j + 2));
				this.addCard(new Card((i + 1), (j + 2)));
			}
		}
		this.shuffle();
	}

	public Card nextCard() {
		this.card = this.deck.get(0);
		deck.remove(0);
		return (this.card);
	}

	public void readdCard() {
		if (card != null) {
			this.deck.add(this.card);
			this.card = null;
		}
	}

	public boolean hasNext() {
		return (!deck.isEmpty());
	}

	@Override
	public String toString() {
		return "Deck [deck=" + deck + ", card=" + card + ", length=" + length
				+ "]";
	}

	public Deck splitDeck() {
		Deck deck2 = new Deck();
		int len = this.getLength() / 2;
		for (int i = 0; i < (len); i++) {
			deck2.addCard(this.nextCard());
		}
		return (deck2);
	}

	public int getLength() {
		this.length = deck.size();
		return (length);
	}

}
