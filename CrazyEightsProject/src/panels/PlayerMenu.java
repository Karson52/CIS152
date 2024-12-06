package panels;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import game.Game;
import listeners.FourPlayerListener;
import listeners.ThreePlayerListener;
import listeners.TwoPlayerListener;

public class PlayerMenu{
	
	private JPanel menuPanel;
	
	private JLabel label;
	
	private JButton b2Player;
	private JButton b3Player;
	private JButton b4Player;
	
	private TwoPlayerListener l2Player;
	private ThreePlayerListener l3Player;
	private FourPlayerListener l4Player;
	

	// constructor to create the player count menu panel.
	public PlayerMenu(Game game) {
		// this is the main panel for the player count selection menu
		menuPanel = new JPanel(new GridLayout(4,1,10,10));
		
		// make the panel transparent
		menuPanel.setOpaque(false);
		
		// add a text box with instructions for user
		label = new JLabel("Welcome to Crazy 8's!\n Please select a player count:", SwingConstants.CENTER);
		// I wanted the font a bit bigger.
		label.setFont(new Font(label.getFont().getName(), Font.PLAIN, 30));

		menuPanel.add(label);
		
		// create the buttons for player count selection
		b2Player = new JButton("2 Players");
		b3Player = new JButton("3 Players");
		b4Player = new JButton("4 Players");
		
		// create the action listeners
		l2Player = new TwoPlayerListener(game);
		l3Player = new ThreePlayerListener(game);
		l4Player = new FourPlayerListener(game);
		
		// add action listeners to buttons
		b2Player.addActionListener(l2Player);
		b3Player.addActionListener(l3Player);
		b4Player.addActionListener(l4Player);
		
		// add the buttons to the panel.
		menuPanel.add(b2Player);
		menuPanel.add(b3Player);
		menuPanel.add(b4Player);
	}
	
	// this method returns the panel when it is requested.
	public JPanel getPanel() {
		return menuPanel;
	}
}

