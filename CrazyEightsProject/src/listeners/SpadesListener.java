package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Card;
import game.Deck;
import game.Game;

public class SpadesListener implements ActionListener {
	Game game;
	Deck playedDeck;
	Card playedCard;
	
	public SpadesListener(Game game, Deck playedDeck, Card playedCard) {
		this.game = game;
		this.playedDeck = playedDeck;
		this.playedCard = playedCard;
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		playedCard.setWildSuit('S');
		playedDeck.play(playedCard);
		game.takeTurn();
		
	}
}
