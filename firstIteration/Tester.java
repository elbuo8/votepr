package firstIteration;

import java.awt.GridLayout;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Tester {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		JFrame guiFrame = new JFrame("Voting");
		guiFrame.setLayout(new GridLayout(0, 2));
		
		Position gobernador = new Position("Gobernador", 2);
		gobernador.addCandidate(new Candidate("Bernabe", new PoliticalParty("PPT")));
		gobernador.addCandidate(new Candidate("Fortuno", new PoliticalParty("PNP")));

		for (int i = 0; i < gobernador.candidates.size(); i++) {
			guiFrame.getContentPane().add(new JLabel(new ImageIcon(gobernador.candidates.get(i).party.logo.getScaledInstance(200, 200, 0))));
		}
		guiFrame.pack();
		for (int i = 0; i < gobernador.candidates.size(); i++) {
			guiFrame.getContentPane().add(new JLabel(new ImageIcon(gobernador.candidates.get(i).photo.getScaledInstance(200, 200, 0))));
		}
		guiFrame.pack();
		guiFrame.setVisible(true);
	}

}
