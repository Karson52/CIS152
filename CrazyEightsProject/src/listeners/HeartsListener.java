package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Card;
import game.Deck;
import game.Game;

public class HeartsListener implements ActionListener {
	Game game;
	Deck playedDeck;
	Card playedCard;
	
	public HeartsListener(Game game, Deck playedDeck, Card playedCard) {
		this.game = game;
		this.playedDeck = playedDeck;
		this.playedCard = playedCard;
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		playedCard.setWildSuit('H');
		playedDeck.play(playedCard);
		game.takeTurn();
		
	}
}

