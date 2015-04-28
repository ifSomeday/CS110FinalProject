import java.util.ArrayList;

public class WarGame {

	private Deck deck1, deck2;
	private int count1, count2, length1, length2;
	private UI ui;
	private Card card1, card2;
	private boolean isWar = false;
	private int warCount = 0;
	private ArrayList<Card> cards1 = new ArrayList<Card>(),
			cards2 = new ArrayList<Card>();

	public WarGame(Deck deck, UI ui) {
		this.deck1 = deck;
		this.deck1.shuffle();
		this.deck2 = deck1.splitDeck();
		this.ui = ui;
		this.count1 = 0;
		this.count2 = 0;
		this.length1 = deck1.getLength();
		this.length2 = deck2.getLength();

	}

	public WarGame(Deck deck1, Deck deck2, UI ui) {
		this.deck1 = deck1;
		this.deck2 = deck2;
		this.ui = ui;
		this.count1 = 0;
		this.count2 = 0;
		this.length1 = deck1.getLength();
		this.length2 = deck2.getLength();
	}

	public void battle() {
		doWeShuffle();

		if (deck1.hasNext()) {
			card1 = deck1.nextCard();
			count1++;
			System.out.println(card1);
		}

		if (deck2.hasNext()) {
			card2 = deck2.nextCard();
			count2++;
			System.out.println(card2);
		}

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

		if (card1.getRank() == card2.getRank()) {
			System.out.println("equals");
			this.war();

		} else if (card1.getRank() > card2.getRank()) {
			ui.setWinner1();
			for (int i = 0; i < cards1.size(); i++) {
				deck1.addCard(cards1.get(i));
			}
			for (int j = 0; j < cards2.size(); j++) {
				deck1.addCard(cards2.get(j));
			}
		} else {
			ui.setWinner2();
			for (int i = 0; i < cards1.size(); i++) {
				deck2.addCard(cards1.get(i));
			}
			for (int j = 0; j < cards2.size(); j++) {
				deck2.addCard(cards2.get(j));
			}
		}

		cards1 = new ArrayList<Card>();
		cards2 = new ArrayList<Card>();
		warCount = 0;
		isWar = false;

	}

	private void war() {
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
		this.battle();
	}

	public Deck getDeck1() {
		return (this.deck1);
	}

	public Deck getDeck2() {
		return (this.deck2);
	}

	private void doWeShuffle() {
		if (count1 == length1) {
			System.out.println("oneheroes shuffled!");
			deck1.shuffle();
			count1 = 0;
			length1 = deck1.getLength();
		}
		if (count2 == length2) {
			System.out.println("two shuffled!");
			deck2.shuffle();
			count2 = 0;
			length2 = deck2.getLength();
		}
	}

}
