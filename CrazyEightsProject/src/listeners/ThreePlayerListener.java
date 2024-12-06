package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Game;
//this class is just like two playe action listener, except it handles the three player option.
public class ThreePlayerListener implements ActionListener{
	Game game;
	public ThreePlayerListener(Game game) {
		this.game = game;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		game.createPlayers(3);
		game.takeTurn();
	}

}
