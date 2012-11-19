package firstIteration;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

import com.google.gson.JsonObject;

public class Candidate {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8490124344660939363L;
	
	PoliticalParty party;
	String name;
	boolean selected;
	JLabel photo; //Image is stored here.
	JsonObject environment;
	int id;
	
	public Candidate(JsonObject environment) throws IOException {
		this.id = id;
		this.environment = environment;
		name = environment.get("Candidato").getAsString();
		party = new PoliticalParty(environment.get("Partido").getAsString(), environment.get("Logo").getAsString());
		//modify lo de scaled later.
		photo = new JLabel(new ImageIcon(ImageIO.read(new File(environment.get("Foto").getAsString())).getScaledInstance(200, 200, 0)));
		selected = false;
		photo.setName(name);
	}

	public void selected() {
		selected = true;
	}
	
	public void unselected() {
		selected = false;
	}
	
}
