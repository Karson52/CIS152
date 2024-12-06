package game;

import java.util.Collections;
import java.util.Iterator;
import java.util.Stack;

public class Deck {
	private Stack<Card> deck = new Stack<>();
	private final String suits = "SHCD";
	
	// deck constructor
	public Deck(boolean fill) {
		if(fill){
			
			for(int i = 0; i < suits.length(); i++) {
				for(int j = 1; j <= 13; j++) {
					deck.push(new Card(suits.charAt(i),j));
				}
			}
		}
	}
	// draws the top card off the deck.
	public Card draw() {
		return deck.pop();
	}
	// adds a card to the top of the deck to play a card
	public void play(Card card) {
		deck.push(card);
	}
	// look at the top card in the deck.
	public Card peek() {
		return deck.peek();
	}
	
	public Boolean isEmpty() {
		return deck.isEmpty();
	}
	public int length() {
		return deck.size();
	}
	// for displaying the deck. mostly for testing (or cheating! >:) )
	
	public String display() {
		String deckStr = "";
		Iterator<Card> iter = deck.iterator();
		while(iter.hasNext()){
			deckStr += iter.next().display();
			deckStr += "\n";
		}
		return deckStr;
	}
	
	
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	

}
