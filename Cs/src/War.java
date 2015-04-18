import java.util.ArrayList;


public class War {
	
	static Deck deck1 = new Deck();
	static Deck deck2 = new Deck();
	static ArrayList<Card> deck1L = new ArrayList<Card>();
	static ArrayList<Card> deck2L= new ArrayList<Card>();
	
	public static void main(String[] args){
		deck1.createDeck();
		System.out.println(deck1.getLength());
		System.out.println(deck1.getLength()/2);
		deck2 = deck1.splitDeck();
		System.out.println(deck1.getLength());
		System.out.println(deck2.getLength());

	}

	
	public void battle(){
		deck1L.add(deck1.nextCard());
		deck2L.add(deck2.nextCard());
		if(deck1L.get(deck1L.size()-1).equals(deck2L.get(deck2L.size()-1))){
			war();
		} else if(deck1L.get(deck1L.size()-1).getRank() > deck2L.get(deck2L.size()-1).getRank()){
			deck1L.addAll(deck2L);
			deck2L = null;
		} else {
			deck2L.addAll(deck1L);
			deck1L = null;
		}
		if(deck1L != null){
			for(int i = 0; i < deck1L.size();i++){
				deck1.addCard(deck1L.get(i));
			}
			deck1L = null;
		}
		if(deck2L != null){
			for(int j = 0; j < deck2L.size();j++){
				deck2.addCard(deck2L.get(j));
			}
			deck2L = null;
		}
		
	}
	
	public void war(){
		deck1L.add(deck1.nextCard());
		deck2L.add(deck2.nextCard());
		battle();
	}
}
