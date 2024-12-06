package game;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Player {
	private LinkedList<Card> hand;
	/*
	 *  Constructor for player class. Player class functions as a kind of container for the Linked list which holds
	 *  a players hand. It also provides some useful methods we might want to use on the players hand, such as
	 *  sorting the hand, or checking a played card's legality. These are processes that would be done by the player
	 *  in a real game of Crazy Eights, which is why I put them here.
	 */
	public Player() {
		hand = new LinkedList<Card>();
	}
	
	// A Method for drawing a card.
	public void draw(Deck deck) {
		hand.add(deck.draw());
	}
	
	// A Method for checking if a given card can be legally played onto the played cards deck.
	public boolean checkLegality(Card cardA, Card cardB) {
		if (cardA.getSuit() == cardB.getSuitWilds()) {
			return true;
		}
		else if(cardA.getDenom() == cardB.getDenom()){
			return true;
		}
		else {
			return false;
		}	
	}
	
	// Methods for getting or removing a card from the player's hand.
	public Card getCard(int index) {
		return hand.get(index);
	}
	
	public void removeCard(int index) {
		hand.remove(index);
	}
	
	// a method for determining the size of the player's hand.
	public int getHandSize() {
		return hand.size();
	}

	// A method for creating a Text string for the player's hand.
	public String display() {
		
		// A string to be returned later
		String displayStr = "";
		
		// Iterate over all of the cards in the hand
		ListIterator<Card> iter = hand.listIterator();
		while (iter.hasNext()) {
			// Call the card's display function and add that result to the string.
			displayStr += iter.next().display();
			displayStr += " ";
		}
		// After iterating over everything, we return the string.
		return displayStr;
	}
	
	// a Boolean for checking if the player has won the game.
	public Boolean hasWon() {
		if(hand.isEmpty()) {
			return true;
			}
		else {
			return false;
		}
	}
	
	// a sorting function for the player's hand. Because hand sizes can never be over 51, I used a simple insertion sort.
	public void sortHand() {
		
		int currentIndex = 0;
		
		// start at the beginning, and each time we move to the next element in the hand.
		for(int i = currentIndex; i < hand.size(); i++) {
			
			// index will be the index of the element later in the hand that we check the element at currentIndex against.
			int index = currentIndex + 1;
			
			// assume that the element we are currently on is the minimum value in the linked ist
			int minIndex = currentIndex;
			
			// for each element after our current element, we check if it's deck index value is smaller than current minimum element.
			for(int j = index; j<hand.size();j++) {
				if(hand.get(j).getDeckIndex() < hand.get(minIndex).getDeckIndex()) {
					// if it is smaller, we keep track of that.
					minIndex = j;
				}
			}
			
			// swap the current element with the minimum element. 
			Card temp = hand.get(currentIndex);
			hand.set(currentIndex, hand.get(minIndex));
			hand.set(minIndex, temp);
			
			// now we do the same thing for the second element in the linked list.
			currentIndex += 1;
		}
		
	}

}
