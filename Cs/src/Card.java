/*
 * Will Rice
 * CS110
 * Part of the final project, to make a game of war
 */
/**
 * Card is an object that represents a single card
 * 
 * @author erza
 * 
 */
public class Card {
	// declarations
	final int SPADES = 4, HEARTS = 3, CLUBS = 2, DIAMONDS = 1;

	private int suit, rank;

	/**
	 * Blank constructor
	 */
	public Card() {

	}

	/**
	 * @param suit
	 *            the suit of the card
	 * @param rank
	 *            the rank of the card
	 */
	public Card(int suit, int rank) {
		this.suit = suit;
		this.rank = rank;
	}

	/**
	 * a getter to retrieve the suit of the card
	 * 
	 * @return the suit of the card
	 */
	public int getSuit() {
		return (this.suit);
	}

	/**
	 * a getter to retrieve the rank of the card
	 * 
	 * @return the rank of the card
	 */
	public int getRank() {
		return (this.rank);
	}

	/**
	 * checks equality of two cards based on rank
	 * 
	 * @param card
	 *            the card to compare to
	 * @return true if the cards are equal rank, false if no
	 */
	public boolean equals(Card card) {
		return (this.rank == card.getRank());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Card [suit=" + suit + ", rank=" + rank + "]";
	}

	/**
	 * a method to get the file name of the card picture for the gui
	 * 
	 * @return the cards file name
	 */
	public String fileName() {
		return ("cards/" + this.rankString().toLowerCase()
				+ this.suitString().toLowerCase().charAt(0) + ".png");
	}

	/**
	 * a method to get the suit of the card as a string
	 * 
	 * @return the suit of the card
	 */
	public String suitString() {
		switch (this.suit) {
		case 1:
			return ("Diamonds");
		case 2:
			return ("Clubs");
		case 3:
			return ("Hearts");
		case 4:
			return ("Spades");
		}
		return (null);
	}

	/**
	 * a method to get the rank of a card as a string
	 * 
	 * @return the rank of the card
	 */
	public String rankString() {
		if (this.rank >= 2 && this.rank <= 10) {
			return (String.valueOf(this.rank));
		} else {
			switch (this.rank) {
			case 11:
				return ("Jack");
			case 12:
				return ("Queen");
			case 13:
				return ("King");
			case 14:
				return ("Ace");
			}
		}
		return (null);
	}

}
