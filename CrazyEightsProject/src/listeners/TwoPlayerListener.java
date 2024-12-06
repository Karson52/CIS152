package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Game;
// This action listener listens to the button that selects a two player game.
public class TwoPlayerListener implements ActionListener{
	Game game;
	public TwoPlayerListener(Game game) {
		this.game = game;
	}

	@Override
	// when the button is pressed, we create two players and take the first turn of the game.
	public void actionPerformed(ActionEvent e) {
		game.createPlayers(2);
		game.takeTurn();
	}

}
