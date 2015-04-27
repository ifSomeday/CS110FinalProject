import java.util.ArrayList;


public class ReserveDeck extends Deck{
	
	private Deck superDeck;

	public ReserveDeck(Deck deck) {
		super();
		this.superDeck = deck;
	}

	public ReserveDeck(ArrayList<Card> deck) {
		super(deck);
		}
	
	public Deck dumpDeck(Deck superDeck){
		this.superDeck = superDeck;
		int length = superDeck.getLength();
		for(int i = 0; i < length; i ++){
			superDeck.addCard(super.nextCard());
		}
		return(superDeck);
	}

}
