package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;

import game.Card;
import game.Deck;
import game.Game;
import game.Player;
import panels.PlayedEight;
import panels.PlayerTurn;

public class PlayCardListener implements ActionListener{
	
	private Game game;
	private Player player;
	private Deck playedDeck;
	private Deck drawDeck;
	private JTextField text;
	
	public PlayCardListener(Game game, Player player, Deck playedDeck, Deck drawDeck, JTextField text) {
		this.game = game;
		this.player = player;
		this.playedDeck =playedDeck;
		this.drawDeck = drawDeck;
		this.text = text;
		
	}

	public void actionPerformed(ActionEvent e) {
		// input validation to make sure a valid card option gets selected.
		try {
			// get the input and zero index it
			int cardIndex = Integer.parseInt(text.getText()) - 1;
			// check that this refers to a card which exists
			if(cardIndex <0 || cardIndex >= player.getHandSize()) {
				// if not, try to get input again with a message about what went wrong
				PlayerTurn error = new PlayerTurn(game, player, playedDeck, drawDeck, 2);
				game.showNewPanel(error.getPanel());
			}
			// otherwise try to play the card.
			else {
				Card cardChoice = player.getCard(cardIndex);
				// if its wild handle one way.
				if(cardChoice.getDenom() == 8) {
					player.removeCard(cardIndex);
					PlayedEight playedEight = new PlayedEight(game, player, playedDeck, cardChoice);
					game.showNewPanel(playedEight.getPanel());
				}
				// otherwise, we need to check legality.
				else {
					if(player.checkLegality(cardChoice, playedDeck.peek())){
						// if its legal, play the card
						player.removeCard(cardIndex);
						playedDeck.play(cardChoice);
						// Start the next player's turn.
						game.takeTurn();
						
					}else {
						// otherwise we need to try again with an error.
						PlayerTurn error = new PlayerTurn(game, player, playedDeck, drawDeck, 3);
						game.showNewPanel(error.getPanel());
					}
				}
			}	
		}
		
		catch (Exception ex){
			// this is where we go when the player doesn't enter an int. Display the turn screen again with the 
			// correct instructions based on the error made by the player
			PlayerTurn error = new PlayerTurn(game, player, playedDeck, drawDeck, 1);
			
			game.showNewPanel(error.getPanel());
		}
		
		
	}

}
