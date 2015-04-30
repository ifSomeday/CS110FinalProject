/*
 * Will Rice
 * CS110
 * Part of the final project, to make a game of war
 */

import java.util.ArrayList;

/**
 * An unorganized pile of cards
 * 
 * @author erza
 * 
 */
public class Cards {

	// declarations
	protected ArrayList<Card> cards = new ArrayList<Card>();
	protected int length;

	/**
	 * default constructor
	 */
	public Cards() {
		super();
	}

	/**
	 * adds a card to the pile
	 * 
	 * @param card the card to be added
	 */
	public void addCard(Card card) {
		cards.add(card);
	}

	/**
	 * checks if the pile is empty
	 * 
	 * @return true or false depending on if the pile is empty
	 */
	public boolean hasNext() {
		return (!cards.isEmpty());
	}

	/**
	 * gets the amount of cards in the pile
	 * 
	 * @return the amount of cards in the pile
	 */
	public int getLength() {
		this.length = cards.size();
		return (length);
	}

}