/*
 * Will Rice
 * CS110
 * Part of the final project, to make a game of war
 */
import java.util.ArrayList;

/**
 * a class that drives the game of war
 * 
 * @author erza
 * 
 */
public class WarGame {

	// declarations
	private Deck deck1, deck2;
	private int count1, count2, length1, length2;
	private mainUI ui;
	private Card card1, card2;
	private boolean isWar = false;
	private int warCount = 0;
	private ArrayList<Card> cards1 = new ArrayList<Card>(),
			cards2 = new ArrayList<Card>();

	/**
	 * a creator that accepts one deck and a ui. The deck is split into 2 for
	 * use in the game.
	 * 
	 * @param deck
	 *            a deck
	 * @param ui
	 *            the ui that the game will be played from
	 */
	public WarGame(Deck deck, mainUI ui) {
		this.deck1 = deck;
		this.deck1.shuffle();
		this.deck2 = deck1.splitDeck();
		this.ui = ui;
		this.count1 = 0;
		this.count2 = 0;
		this.length1 = deck1.getLength();
		this.length2 = deck2.getLength();

	}

	/**
	 * a creator that accepts 2 decks and a ui
	 * 
	 * @param deck1
	 *            player one's deck
	 * @param deck2
	 *            player two's deck
	 * @param ui
	 *            the ui that the game will be played from
	 */
	public WarGame(Deck deck1, Deck deck2, mainUI ui) {
		this.deck1 = deck1;
		this.deck2 = deck2;
		this.ui = ui;
		this.count1 = 0;
		this.count2 = 0;
		this.length1 = deck1.getLength();
		this.length2 = deck2.getLength();
	}

	/**
	 * a function to cause a battle between the two decks
	 */
	public void battle() {
		doWeShuffle();

		// placing cards in play
		if (deck1.hasNext()) {
			card1 = deck1.nextCard();
			count1++;
		}

		if (deck2.hasNext()) {
			card2 = deck2.nextCard();
			count2++;
		}

		// update GUI
		if (!isWar) {
			ui.setCard1(card1.fileName());
			ui.setCard2(card2.fileName());
			ui.setCard1b("cards/b2fv.png");
			ui.setCard2b("cards/b1fv.png");
		} else {
			ui.setCard1b(card1.fileName());
			ui.setCard2b(card2.fileName());
		}

		cards1.add(card1);
		cards2.add(card2);

		// if war
		if (card1.getRank() == card2.getRank()) {
			this.war();

			// if player 1 wins
		} else if (card1.getRank() > card2.getRank()) {
			ui.setWinner1();
			for (int i = 0; i < cards1.size(); i++) {
				deck1.addCard(cards1.get(i));
			}
			for (int j = 0; j < cards2.size(); j++) {
				deck1.addCard(cards2.get(j));
			}

			// if player 2 wins
		} else {
			ui.setWinner2();
			for (int i = 0; i < cards1.size(); i++) {
				deck2.addCard(cards1.get(i));
			}
			for (int j = 0; j < cards2.size(); j++) {
				deck2.addCard(cards2.get(j));
			}
		}

		// resets for next time
		cards1 = new ArrayList<Card>();
		cards2 = new ArrayList<Card>();
		warCount = 0;
		isWar = false;

	}

	/**
	 * deals with wars caused by battles.
	 */
	private void war() {
		// prepares battle() for war
		isWar = true;
		warCount++;
		ui.setWar(warCount);
		doWeShuffle();
		if (deck1.hasNext()) {
			cards1.add(deck1.nextCard());
			count1++;
		}
		if (deck2.hasNext()) {
			cards2.add(deck2.nextCard());
			count2++;
		}
		// calls battle
		this.battle();
	}

	/**
	 * gets player 1's deck
	 * 
	 * @return deck1
	 */
	public Cards getDeck1() {
		return (this.deck1);
	}

	/**
	 * gets player 2's deck
	 * 
	 * @return deck2
	 */
	public Cards getDeck2() {
		return (this.deck2);
	}

	/**
	 * determines if shuffling is needed, and if it is, shuffles the deck.
	 */
	private void doWeShuffle() {
		if (count1 == length1) {
			deck1.shuffle();
			count1 = 0;
			length1 = deck1.getLength();
		}
		if (count2 == length2) {
			deck2.shuffle();
			count2 = 0;
			length2 = deck2.getLength();
		}
	}

}
