import java.util.ArrayList;

import javax.swing.JFrame;

public class WarGame {

	private Deck deck1, deck2;
	private ReserveDeck resDeck1, resDeck2;
	private UI ui;
	private Card card1, card2;
	private ArrayList<Card> cards1 = new ArrayList<Card>(), cards2 = new ArrayList<Card>();

	public WarGame(Deck deck, UI ui) {
		this.deck1 = deck;
		this.deck1.shuffle();
		this.deck2 = deck1.splitDeck();
		this.ui = ui;

	}

	public WarGame(Deck deck1, Deck deck2, UI ui) {
		this.deck1 = deck1;
		this.deck2 = deck2;
		this.ui = ui;
	}

	public void battle() {
		card1 = deck1.nextCard();
		System.out.println(card1);
		ui.setCard1(card1.fileName());
		
		card2 = deck2.nextCard();
		System.out.println(card2);
		ui.setCard2(card2.fileName());
		
		cards1.add(card1);
		cards2.add(card2);
		
		if(card1.getRank() == card2.getRank()){
			System.out.println("equals");
			this.war();
			
		} else if(card1.getRank() > card2.getRank()){
			for(int i = 0; i < cards1.size(); i++){
				deck1.addCard(cards1.get(i));
			}
			for(int j = 0; j < cards2.size(); j++){
				deck1.addCard(cards2.get(j));
			}
		} else  {
			for(int i = 0; i < cards1.size(); i++){
				deck2.addCard(cards1.get(i));
			}
			for(int j = 0; j < cards2.size(); j++){
				deck2.addCard(cards2.get(j));
			}
		}

		cards1 = new ArrayList<Card>();
		cards2 = new ArrayList<Card>();
	}
	
	private void war(){
		cards1.add(deck1.nextCard());
		cards2.add(deck2.nextCard());
		this.battle();
	}
	
	public Deck getDeck1(){
		return(this.deck1);
	}
	
	public Deck getDeck2(){
		return(this.deck2);
	}
	


}
