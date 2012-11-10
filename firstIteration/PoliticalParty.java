/**
 * 
 */
package firstIteration;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @author yamilasusta
 *
 */
public class PoliticalParty {
	
	BufferedImage logo;
	String name;
	
	public PoliticalParty(String name) throws IOException {
		this.name = name;
		/*
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Political Party: " + this.name);
		chooser.setFileFilter(new utilities.ImageFilter());
		
		int exitValue = chooser.showOpenDialog(null);
		if(exitValue == JFileChooser.APPROVE_OPTION) logo = ImageIO.read(chooser.getSelectedFile());
		else logo = null;
		*/
		
		logo = ImageIO.read(new File(System.getenv(this.name)));
	}

}
