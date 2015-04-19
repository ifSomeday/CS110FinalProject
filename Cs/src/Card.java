
public class Card {
	
	final int SPADES = 4, HEARTS = 3, CLUBS = 2, DIAMONDS = 1;
	
	private int suit, rank;
	
	public Card(){
		
	}
	
	public Card(int suit, int rank){
		this.suit = suit;
		this.rank = rank;
	}
	
	public int getSuit(){
		return(this.suit);
	}
	
	public int getRank(){
		return(this.rank);
	}
	
	public boolean equals(Card card){
		return(this.rank == card.getRank());
	}

	@Override
	public String toString() {
		return "Card [suit=" + suit + ", rank=" + rank + "]";
	}
	
	

}
