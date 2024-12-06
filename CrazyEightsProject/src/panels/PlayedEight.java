package panels;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import game.Card;
import game.Deck;
import game.Game;
import game.Player;
import listeners.ClubsListener;
import listeners.DiamondsListener;
import listeners.HeartsListener;
import listeners.SpadesListener;
// the class for the screen which shows after an 8 is played. the player needs to chose the wild suit.
public class PlayedEight {
	JPanel mainPanel;
	JPanel buttonPanel;
	Game game;
	Player player;
	Deck playedDeck;
	Deck drawDeck;
	
	JLabel instructions;
	
	JButton spades;
	JButton hearts;
	JButton clubs;
	JButton diamonds;
	
	SpadesListener sl;
	HeartsListener hl;
	ClubsListener cl;
	DiamondsListener dl;
	
	public PlayedEight(Game game, Player player, Deck playedDeck, Card playedCard) {
		this.game=game;
		this.player = player;
		this.playedDeck=playedDeck;
		this.drawDeck = drawDeck;
		// create the main JPanel
		mainPanel = new JPanel(new GridLayout(2, 1, 20, 20));
		mainPanel.setOpaque(false);
		
		// create a button panel to organize the suit buttons neatly
		buttonPanel = new JPanel(new GridLayout(2, 2, 10, 10));
		buttonPanel.setSize(400,300);
		buttonPanel.setOpaque(false);
		
		// give the player some instructions with a JLabel
		instructions = new JLabel("Played an eight! Please select the suit", SwingConstants.CENTER);
		
		// creating the suit selection buttons
		spades = new JButton("Spades");
		hearts = new JButton("Hearts");
		clubs = new JButton("Clubs");
		diamonds = new JButton("Diamonds");
		
		// creating the Listeners for the buttons
		sl = new SpadesListener(game, playedDeck, playedCard);
		hl = new HeartsListener(game, playedDeck, playedCard);
		cl = new ClubsListener(game, playedDeck, playedCard);
		dl = new DiamondsListener(game, playedDeck, playedCard);
		
		// adding the listeners to the buttons
		spades.addActionListener(sl);
		hearts.addActionListener(hl);
		clubs.addActionListener(cl);
		diamonds.addActionListener(dl);
		
		// making the buttons a bit bigger
		spades.setPreferredSize(new Dimension(200,100));
		hearts.setPreferredSize(new Dimension(200,100));
		clubs.setPreferredSize(new Dimension(200,100));
		diamonds.setPreferredSize(new Dimension(200,100));
		
		// add the buttons to the button panel 
		buttonPanel.add(spades);
		buttonPanel.add(hearts);
		buttonPanel.add(clubs);
		buttonPanel.add(diamonds);
		
		// add instructions and button panel to the main frame.
		mainPanel.add(instructions);
		mainPanel.add(buttonPanel);

		
	}
	
	// returns the panel when it is requested.
	public JPanel getPanel() {
		return mainPanel;
	}

}
