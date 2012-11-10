package firstIteration;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Candidate {
	
	PoliticalParty party;
	String name;
	boolean selected;
	BufferedImage photo;
	
	public Candidate(String name, PoliticalParty party) throws IOException {
		this.name = name;
		this.party = party;
		selected = false;
		
		/*
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Candidate:" + this.name);
		chooser.setFileFilter(new utilities.ImageFilter());
		
		int exitValue = chooser.showOpenDialog(null);
		if(exitValue == JFileChooser.APPROVE_OPTION) photo = ImageIO.read(chooser.getSelectedFile());
		else photo = null;
		*/
		
		photo = ImageIO.read(new File(System.getenv(name.toUpperCase())));
		
	}
	
}
