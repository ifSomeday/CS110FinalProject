import java.util.ArrayList;

public class WarGame {

	private Deck deck1, deck2;
	private Card card1, card2;
	private ArrayList<Card> cards1 = new ArrayList<Card>(), cards2 = new ArrayList<Card>();

	public WarGame(Deck deck) {
		this.deck1 = deck;
		this.deck1.shuffle();
		this.deck2 = deck1.splitDeck();

	}

	public WarGame(Deck deck1, Deck deck2) {
		this.deck1 = deck1;
		this.deck2 = deck2;
	}

	public void battle() {
		card1 = deck1.nextCard();
		card2 = deck2.nextCard();
		
		if(card1.equals(card2)){
			this.war();
		} else if(card1.getRank() > card2.getRank()){
			cards1.add(card1);
			cards1.add(card2);
		} else  {
			cards2.add(card1);
			cards2.add(card2);
		}
		
		if(cards1 != null){
			for(int i = 0; i < cards1.size(); i++){
				deck1.addCard(cards1.get(i));
			}
		}
		
		if(cards2 != null){
			for(int j = 0; j < cards2.size(); j++){
				deck2.addCard(cards2.get(j));
			}
		}
	}
	
	private void war(){
		cards1.add(card1);
		cards2.add(card2);
		this.battle();
	}

}
