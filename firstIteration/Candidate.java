package firstIteration;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.gson.JsonObject;

public class Candidate {
	
	PoliticalParty party;
	String name;
	boolean selected;
	BufferedImage photo;
	JsonObject enviroment;
	
	public Candidate(String name, PoliticalParty party, JsonObject enviroment) throws IOException {
		this.name = name;
		this.party = party;
		selected = false;
		this.enviroment = enviroment;
		/*
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Candidate:" + this.name);
		chooser.setFileFilter(new utilities.ImageFilter());
		
		int exitValue = chooser.showOpenDialog(null);
		if(exitValue == JFileChooser.APPROVE_OPTION) photo = ImageIO.read(chooser.getSelectedFile());
		else photo = null;
		*/
		
		photo = ImageIO.read(new File(this.enviroment.get(name).getAsString()));
		
	}
	
}
