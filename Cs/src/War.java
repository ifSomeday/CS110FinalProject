
public class War {
	
	public static void main(String[] args){
		Deck deck = new Deck();
		Deck deck2 = new Deck();
		deck.createDeck();
		System.out.println(deck.getLength());
		System.out.println(deck.getLength()/2);
		deck2 = deck.splitDeck();
		System.out.println(deck.getLength());
		System.out.println(deck2.getLength());
	}

}
