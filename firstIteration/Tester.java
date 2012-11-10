package firstIteration;

import java.awt.GridLayout;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.internal.bind.JsonTreeReader;

public class Tester {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		
		JsonObject environment = new JsonParser().parse(new FileReader("Properties.json")).getAsJsonObject();
		
		
		
		JFrame guiFrame = new JFrame("Voting");
		int totalParties = environment.get("Gobernador").getAsJsonArray().size();
		guiFrame.setLayout(new GridLayout(2, totalParties));
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Position gobernador = new Position("Gobernador", totalParties);
		for (int i = 0; i < totalParties; i++) 
			gobernador.addCandidate(new Candidate(environment.get("Gobernador").getAsJsonArray().get(i).getAsJsonObject()));
		
		for (int i = 0; i < gobernador.candidates.size(); i++) {
			guiFrame.getContentPane().add(new JLabel(new ImageIcon(gobernador.candidates.get(i).party.logo.getScaledInstance(200, 200, 0))));

		}
		for (int i = 0; i < gobernador.candidates.size(); i++) {
			guiFrame.getContentPane().add(new JLabel(new ImageIcon(gobernador.candidates.get(i).photo.getScaledInstance(200, 200, 0))));
		}
		guiFrame.pack();
		guiFrame.setVisible(true);
	}

}
