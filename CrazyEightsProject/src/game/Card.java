package game;

public class Card {
	// card's suit and denomination
	private char suit;
	private int denom;
	private char wildSuit = 'N';
	
	// generic constructor
	public Card() {
		this.suit = 'S';
		this.denom = 1;
	}
	
	// card constructor
	public Card(char suit, int denom) {
		this.suit = suit;
		this.denom = denom;
	}
	// Get the regular suit of the card.
	public char getSuit() {
		return suit;
	}
	// Get the wild suit of the card, if it has one.
	public char getSuitWilds() {
		if(wildSuit != 'N') {
			return wildSuit;
		} else return suit;
	}
	// Get the Card's Denomination (number value)
	public int getDenom() {
		return denom;
	}
	
	// Get the Deck index of the card. This is used for sorting hands.
	public int getDeckIndex() {
		// Calculate the position the card would be in if we sorted the deck from low number to high,
		// grouping by suit, in the order Spades, Hearts, Clubs, Diamonds.
		int deckIndex = 0;
		
		// we add the denomination of the card to it's index.
		deckIndex += getDenom();
		
		if (getSuit() == 'H') {
			// If the card is a heart, we Know the ace of hearts should be card number 14. The two of hearts
			// should be card number 15, etc. Therefore, we add a value of 13 for all hearts.
			deckIndex += 13;
		}
		else if(getSuit()=='C') {
			// If the card is a club, we want the ace of clubs to be the 27th card.
			// therefore, we add a value of 26.
			deckIndex += 26;
			
		}else if(getSuit()=='D') {
			// if we have a diamond, ace should have a value of 40. Therefore we add 39.
			deckIndex += 39;
		}
		
		return deckIndex;
	}
	
	// A method for printing the card to text.
	public String display() {
		return(suit + "" + denom);
	}
	// A method for printing the card to text when we also want to see the wild suit (if it exists).
	public String displayWilds() {
		if(wildSuit != 'N') {
			return(suit + "" + denom + " wild suit: " + wildSuit);
		}else {
			return(suit + "" + denom);
		}
	}
	// A method for Setting the card's wild suit. This is called on 8's when they are played.
	public void setWildSuit(char wildSuit) {
		this.wildSuit = wildSuit;
	}

}
