package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Deck;
import game.Game;
import game.Player;
import panels.MustPass;
import panels.PlayerTurn;

public class DrawListener implements ActionListener{
	private Game game;
	private Player player;
	private Deck playedDeck;
	private Deck drawDeck;
	
	public DrawListener(Game game, Player player, Deck playedDeck, Deck drawDeck) {
		this.game = game;
		this.player = player;
		this.playedDeck = playedDeck;
		this.drawDeck = drawDeck;
	}


	public void actionPerformed(ActionEvent e) {
		// this is where we draw a card.
		// check if the draw deck is empty. if it isn't, draw a card.
		// then it is still this players turn.
		if(!drawDeck.isEmpty()) {
			player.draw(drawDeck);
			// still this players turn, so create a new player turn panel
			PlayerTurn newTurn = new PlayerTurn(game, player, playedDeck, drawDeck, 0);
			game.showNewPanel(newTurn.getPanel());
		}else {
			// pass the turn if there is nothing to draw.
			System.out.println("passing");
			
			// create the must pass panel and display it
			MustPass passPanel = new MustPass(game);
			game.showNewPanel(passPanel.getPanel());

		}
		
	}

}
