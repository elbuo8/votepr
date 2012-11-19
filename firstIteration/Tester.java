package firstIteration;

import java.awt.GridLayout;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Tester {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		JsonObject environment = new JsonParser().parse(new FileReader("Properties.json")).getAsJsonObject();
		
		JFrame guiFrame = new JFrame("Voting");
		int totalParties = environment.get("Gobernador").getAsJsonArray().size();
		GridLayout layout = new GridLayout(2, totalParties);
		layout.setHgap(5);
		layout.setVgap(5);
		guiFrame.setLayout(layout);
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Position gobernador = new Position("Gobernador", totalParties);
		for (int i = 0; i < totalParties; i++) 
			gobernador.addCandidate(new Candidate(environment.get("Gobernador").getAsJsonArray().get(i).getAsJsonObject(), i));
		
		for (int i = 0; i < gobernador.totalCandidates(); i++) 
			guiFrame.getContentPane().add(new JLabel(new ImageIcon(gobernador.getCandidate(i).party.logo.getScaledInstance(200, 200, 0))));
			
		for (int i = 0; i < gobernador.totalCandidates(); i++) 
			guiFrame.getContentPane().add(gobernador.getCandidate(i).photo);
		
		guiFrame.pack();
		guiFrame.setVisible(true);
	}

}
