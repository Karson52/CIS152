package panels;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import game.Deck;
import game.Game;
import game.Player;
import listeners.DrawListener;
import listeners.PlayCardListener;
import listeners.SortHandListener;

public class PlayerTurn {
	JPanel playerTurn;
	JPanel playOrganizer;
	JPanel handOrganizer;
	
	JButton draw;
	JButton sortHand;
	
	JTextField text;
	JButton play;
	JLabel playerID;
	JLabel instructions1;
	JLabel instructions2;
	JLabel faceUpCard;
	JLabel hand;
	
	SortHandListener shl;
	DrawListener dl;
	PlayCardListener pcl;
	
	public PlayerTurn(Game game, Player player, Deck playedDeck, Deck drawDeck, int error) {
		// we want to know who is currently playing.
		int currentPlayer = game.getCurrentPlayer();
		
		// create the main JPanel
		playerTurn = new JPanel(new GridLayout(6,1,10,10));
		playerTurn.setOpaque(false);
		
		// create an additional Jpanel for organizing the text box and play button.
		playOrganizer = new JPanel(new GridLayout(1, 2, 5, 5));
		playOrganizer.setOpaque(false);
		
		// create an additional Jpanel for organizing the hand.
		handOrganizer = new JPanel(new GridLayout(1,2,5,5));
		handOrganizer.setOpaque(false);
		
		// create the Draw button
		draw = new JButton("Draw");
		// create and add the draw listener to the button
		dl = new DrawListener(game, player, playedDeck, drawDeck);
		draw.addActionListener(dl);
		

		// create the text box and play button for inputing the desired card.
		text = new JTextField(4);
		play = new JButton("Play");
		// create and add the play card listener to the play button
		pcl = new PlayCardListener(game, player, playedDeck, drawDeck, text);
		play.addActionListener(pcl);
		
		// create a label to display the player's hand.
		hand = new JLabel("Your hand: " + player.display(), SwingConstants.CENTER);
		// create a button for sorting the player's hand.
		sortHand = new JButton("Sort");
		sortHand.setPreferredSize(new Dimension(50,50));
		shl = new SortHandListener(game, player, playedDeck, drawDeck);
		sortHand.addActionListener(shl);
		
		
		// create a label to display the face- up card to play off of
		faceUpCard = new JLabel("Face up Card:" + playedDeck.peek().displayWilds(), SwingConstants.CENTER);
		// making the font a little bigger
		faceUpCard.setFont(new Font(faceUpCard.getFont().getName(), Font.PLAIN, 20));
		
		// creating labels for the player instructions.
		instructions1 = new JLabel("Please take your turn, Player " + (currentPlayer + 1) + ".", SwingConstants.CENTER);
		
		// this if-else block will let the player know if they enter any illegal moves or if their input is not accepted
		// error == 0 is the case where there is no errors, and it just gives the basic instructions
		if(error == 0) {
			instructions2 = new JLabel("To play a card, type the index of that card (1-"+player.getHandSize()+") and press the Play button.",
					SwingConstants.CENTER);
		}
		// this case is for when the player enters a non integer value
		else if(error == 1){
			instructions2 = new JLabel("Please type an integer for the card index. value should be between (1-"+player.getHandSize()+")",
					SwingConstants.CENTER);
		}
		// this case is for when the player enters a card index outside of the range of the cards
		else if(error== 2){
			instructions2 = new JLabel("The index you entered doesn't refer to one of your cards. Value should be between (1-"+player.getHandSize()+")",
					SwingConstants.CENTER);
		}
		// this case handles the situation where the player plays an illegal card.
		else if(error==3) {
			instructions2 = new JLabel("That card is not legal to play. Please pick a new card from 1-"+ player.getHandSize()+ ")",
					SwingConstants.CENTER);
		}
		// this is just here to make sure instructions 2 gets assigned.
		else {
			instructions2 = new JLabel("");
		}
		// add the text box and play button to the organizer
		playOrganizer.add(text);
		playOrganizer.add(play);
		
		// and hand and sorthand button to the Hand organizer
		handOrganizer.add(hand);
		handOrganizer.add(sortHand);
		
		// add all of the components to the JPannel
		playerTurn.add(instructions1);
		playerTurn.add(instructions2);
		playerTurn.add(faceUpCard);
		playerTurn.add(handOrganizer);
		playerTurn.add(playOrganizer);
		playerTurn.add(draw);
		
	}
	// this function returns the JPannel when it is requested.
	public JPanel getPanel() {
		return playerTurn;
	}

}
