package firstIteration;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Candidate {
	
	PoliticalParty party;
	String name;
	boolean selected;
	BufferedImage photo;
	
	public Candidate(String name, PoliticalParty party) throws IOException {
		this.name = name;
		this.party = party;
		selected = false;
		
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("jpg", "gif", "png"));
		
		int exitValue = chooser.showOpenDialog(null);
		if(exitValue == JFileChooser.APPROVE_OPTION) photo = ImageIO.read(chooser.getSelectedFile());
		else photo = null;
		
	}
	
}
