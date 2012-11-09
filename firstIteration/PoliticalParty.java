/**
 * 
 */
package firstIteration;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 * @author yamilasusta
 *
 */
public class PoliticalParty {
	
	BufferedImage logo;
	String name;
	
	public PoliticalParty(String name) throws IOException {
		this.name = name;
		
		JFileChooser chooser = new JFileChooser();
		chooser.setFileFilter(new FileNameExtensionFilter("jpg", "gif", "png"));
		
		int exitValue = chooser.showOpenDialog(null);
		if(exitValue == JFileChooser.APPROVE_OPTION) logo = ImageIO.read(chooser.getSelectedFile());
		else logo = null;
	}

}
