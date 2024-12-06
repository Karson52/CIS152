package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Game;
//this class is just like two player action listener, except it handles the four player option.
public class FourPlayerListener implements ActionListener{
	Game game;
	public FourPlayerListener(Game game) {
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		game.createPlayers(4);
		game.takeTurn();
		
	}

}
