package game;

import java.awt.*;
import javax.swing.*;

import game.Player;
import panels.PlayerMenu;
import panels.PlayerTurn;
import panels.WinScreen;

public class Game {
	// Display frame
	private JFrame f;
	// Decks to hold the game cards
	private Deck drawDeck;
	private Deck playedDeck;
	// Players
	private Player[] players = {};
	// turn count tracker
	private int turnCount = 0;
	private int currentPlayer = 0;
	private int previousPlayer = 0;
	private int playerCount;
	private Boolean gameEnded = false;
	
	// constructor for the game
	public Game() {
		// create two decks. one to draw new cards and another to play cards into.
		drawDeck = new Deck(true);
		playedDeck = new Deck(false);
		// set up the frame
		frameSetup();
	}
	
	// sets up the game at the beginning and starts it
	private void start() {
		
		// shuffle draw deck and deal 5 cards to each player
		drawDeck.shuffle();
		
		//A little loop to make sure that we don't start with an 8 as the top card.
		while(drawDeck.peek().getDenom()==8) {
			drawDeck.shuffle();
		}
		// flip a card face up from the draw deck, into the played deck.
		playedDeck.play(drawDeck.draw());
		
		// get the number of players
		PlayerMenu playerMenu = new PlayerMenu(this);
		f.add(playerMenu.getPanel());
		f.setVisible(true);
		
	}
	
	// creates the players at the start of the game. 
	// player count can be 2, 3, or 4 players.
	public void createPlayers(int playerCount) {
		this.playerCount = playerCount;
		System.out.println(playerCount);

		Player[] newPlayers = new Player[playerCount];
		// loop through and create all of the players.
		for(int i = 0; i< playerCount; i++) {
			newPlayers[i] = new Player();
		}
		// give the players to the game.
		this.players = newPlayers;
		// deal cards to our new players.
		deal();
	}
	
	// A method for triggering the next player to take their turn.
	public void takeTurn() {
		// Figure out which player is next to play
		currentPlayer = turnCount%playerCount;
		// Check if the previous player won the game
		if(players[previousPlayer].hasWon()){
			WinScreen win = new WinScreen(previousPlayer);
			showNewPanel(win.getPanel());
			
		}
		
		// If they didn't, trigger the next turn.
		else {
			// create a new PlayerTurn object
			PlayerTurn thisTurn = new PlayerTurn(this, players[currentPlayer], playedDeck, drawDeck, 0);
			
			// Display it's Panel
			showNewPanel(thisTurn.getPanel());	
			
			// Make the current player into the previous player, and count up the turn counter.
			previousPlayer = currentPlayer;
			turnCount += 1;
		}
	}
	
	// A method for dealing the cards at the start of the game.
	private void deal() {
		// initial hand size is 5
		final int initHandSize = 5;
		for(int i = 0; i < initHandSize; i++) {
			for(int j = 0; j < playerCount; j++) {
				players[j].draw(drawDeck);
			}
		}
	}
	
	// method for re-shuffling played cards back into the draw pile.
	public void reshuffle() {
		// take top card off the played deck
		Card topCard = playedDeck.draw();
		// shuffle the cards back into the draw deck
		drawDeck = playedDeck;
		drawDeck.shuffle();
		playedDeck = new Deck(false);
		// play the top card back on the table 
		playedDeck.play(topCard);
		
		drawDeck.display();
		playedDeck.display();
	}
	
	
	// simple method to set up the Jframe, I just separated it out for readability
	private void frameSetup() {
		f = new JFrame();
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		f.setSize(800,600);
		f.setTitle("Crazy Eights");
		f.getContentPane().setBackground(new Color(111, 130, 161));
	}
	
	// this just makes it much easier to display a new jframe from other parts of the code.
	// specifically I used this when displaying new frames from various action listeners.
	public void showNewPanel(JPanel panel) {
		f.getContentPane().removeAll();
		f.add(panel);
		f.getContentPane().invalidate();
		f.getContentPane().validate();
	}

	// Simple method for determining who the current player is
	public int getCurrentPlayer() {
		return currentPlayer;
	}
	
	// main method for my project, which starts up the game.
	public static void main(String[]args) {
		Game game = new Game();
		game.start();
	}
}
