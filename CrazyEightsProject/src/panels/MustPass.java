package panels;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import game.Game;
import listeners.PassListener;
// this is where we go when the player tries to draw on an empty draw pile. in this case they must pass their turn.
public class MustPass {
	JPanel passPanel;
	JLabel notice1;
	JLabel notice2;
	JButton pass;
	Game game;
	PassListener pl;
	// constructor for the panel.
	public MustPass(Game game) {
		this.game = game;
		
		// create the turn pass info panel
		passPanel = new JPanel(new GridLayout(3,1,20,20));
		passPanel.setOpaque(false);
		// create the text notices
		notice1 = new JLabel("Sorry, there are no cards left in the draw pile.", SwingConstants.CENTER);
		notice2 = new JLabel("Cards will be shuffled back into the draw pile. Please Pass the turn.", SwingConstants.CENTER);
		// create a pass turn button and simple pass listener
		pass = new JButton("Pass Turn");
		pass.setPreferredSize(new Dimension(200,100));
		pl = new PassListener(game);
		pass.addActionListener(pl);
		
		// add the components to the JPanel
		passPanel.add(notice1);
		passPanel.add(notice2);
		passPanel.add(pass);
		
	}
	
	public JPanel getPanel() {
		return passPanel;
	}



}
