package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Game;
// listener for the pass turn button on the must pass screen
public class PassListener implements ActionListener{
	Game game;
	public PassListener(Game game) {
		this.game = game;
	}

	@Override
	// when the button is pressed, we reshuffle the cards and take the next turn.
	public void actionPerformed(ActionEvent e) {
		game.reshuffle();
		game.takeTurn();
		
	}

}
