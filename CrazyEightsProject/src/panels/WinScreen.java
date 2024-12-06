package panels;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class WinScreen {
	JPanel win;
	JLabel winMessage;
	int playerIndex;
	
	public WinScreen(int playerIndex){
		// Index to know which player won
		this.playerIndex = playerIndex;
		
		// Create the panel and our win message.
		win = new JPanel();
		winMessage = new JLabel("Congratulations to Player "+ (playerIndex+1) +". You Won!", SwingConstants.CENTER);
		
		// Add the message to the panel
		win.add(winMessage);
		
	}
	// Return the panel when it is requested.
	public JPanel getPanel() {
		return win;
	}
	
	

}
