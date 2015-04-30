/*
 * Will Rice
 * CS110
 * Part of the final project, to make a game of war
 */
import java.util.ArrayList;
import java.util.Collections;

/**
 * the Deck class is a structured extension of the Cards class
 * 
 * @author erza
 * 
 */
public class Deck extends Cards {

	// declarations
	private Card card = new Card();
	private final int SUITS = 4, RANKS = 13;

	/**
	 * default constructor
	 */
	public Deck() {

	}

	/**
	 * constructor that accepts
	 * 
	 * @param cards
	 *            an arraylist of cards to be turned into a deck
	 */
	public Deck(ArrayList<Card> cards) {
		this.cards = cards;
	}

	/**
	 * a method that shuffles the order of the cards in the arraylist
	 */
	public void shuffle() {
		Collections.shuffle(cards);
	}

	/**
	 * a method that clears the current arraylist and replaces it with a
	 * standard 52 card deck
	 */
	public void createDeck() {
		this.cards.clear();
		for (int i = 0; i < SUITS; i++) {
			for (int j = 0; j < RANKS; j++) {
				this.addCard(new Card((i + 1), (j + 2)));
			}
		}
		this.shuffle();
	}

	/**
	 * a method to remove the top card from the deck and return it
	 * 
	 * @return the top card in the deck
	 */
	public Card nextCard() {
		this.card = this.cards.get(0);
		cards.remove(0);
		return (this.card);
	}

	/**
	 * readds the card that was last removed
	 */
	public void readdCard() {
		if (card != null) {
			this.cards.add(this.card);
			this.card = null;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Deck [deck=" + cards + ", card=" + card + ", length=" + length
				+ "]";
	}

	/**
	 * splits the deck into two
	 * 
	 * @return half of the deck
	 */
	public Deck splitDeck() {
		Deck deck2 = new Deck();
		int len = this.getLength() / 2;
		for (int i = 0; i < (len); i++) {
			deck2.addCard(this.nextCard());
		}
		return (deck2);
	}

}
