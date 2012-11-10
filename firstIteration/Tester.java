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
		
		JsonObject enviroment = new JsonParser().parse(new FileReader("Properties.json")).getAsJsonObject();
		
		
		JFrame guiFrame = new JFrame("Voting");
		guiFrame.setLayout(new GridLayout(2, enviroment.get("Partidos").getAsJsonObject().entrySet().size()));
		guiFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Position gobernador = new Position("Gobernador", 2);
		gobernador.addCandidate(new Candidate("Bernabe", new PoliticalParty("PPT", enviroment.get("Partidos").getAsJsonObject()), enviroment.get("Candidatos").getAsJsonObject()));
		gobernador.addCandidate(new Candidate("Fortuno", new PoliticalParty("PNP", enviroment.get("Partidos").getAsJsonObject()), enviroment.get("Candidatos").getAsJsonObject()));

		for (int i = 0; i < gobernador.candidates.size(); i++) {
			guiFrame.getContentPane().add(new JLabel(new ImageIcon(gobernador.candidates.get(i).party.logo.getScaledInstance(200, 200, 0))));
			guiFrame.getContentPane().add(new JLabel(new ImageIcon(gobernador.candidates.get(i).photo.getScaledInstance(200, 200, 0))));
		}

		guiFrame.pack();
		guiFrame.setVisible(true);
	}

}
