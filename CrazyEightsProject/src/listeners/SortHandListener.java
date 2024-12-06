package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Deck;
import game.Game;
import game.Player;
import panels.PlayerTurn;

// This is the Action Listener responsible for the "sort hand" button.
public class SortHandListener implements ActionListener {
	
	private Game game;
	private Player player;
	private Deck playedDeck;
	private Deck drawDeck;

	// The Constructor makes sure we have all of the objects we may need at the ready.
	public SortHandListener(Game game, Player player, Deck playedDeck, Deck drawDeck) {
		this.game = game;
		this.player = player;
		this.playedDeck = playedDeck;
		this.drawDeck = drawDeck;
	}

	// This is what we do when the sort hand button is pressed.
	public void actionPerformed(ActionEvent e) {
		player.sortHand();
		// Create the new Panel to display the sorted hand.
		PlayerTurn continueTurn = new PlayerTurn(game, player, playedDeck, drawDeck, 0);
		// Send the panel to game object for display.
		game.showNewPanel(continueTurn.getPanel());
		
	}

}
