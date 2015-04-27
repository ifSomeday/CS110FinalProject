
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
	
	public String fileName(){
		return("cards/" + this.rankString().toLowerCase() + this.suitString().toLowerCase().charAt(0) + ".png");
	}
	
	public String suitString(){
		switch(this.suit){
		case 1: return("Diamonds");
		case 2: return("Clubs");
		case 3: return("Hearts");
		case 4: return("Spades");
		}
		return(null);
	}
	
	public String rankString(){
		if(this.rank >= 2 && this.rank <= 10){
			return(String.valueOf(this.rank));
		} else {
			switch(this.rank){
			case 11: return("Jack");
			case 12: return("Queen");
			case 13: return("King");
			case 14: return("Ace");
			}
		}
		return(null);
	}
	
	

}
