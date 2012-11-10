/**
 * 
 */
package firstIteration;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.gson.JsonObject;

/**
 * @author yamilasusta
 *
 */
public class PoliticalParty {
	
	BufferedImage logo;
	String name;
	JsonObject enviroment;
	
	public PoliticalParty(String name, JsonObject enviroment) throws IOException {
		this.name = name;
		this.enviroment = enviroment;
		/*
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Political Party: " + this.name);
		chooser.setFileFilter(new utilities.ImageFilter());
		
		int exitValue = chooser.showOpenDialog(null);
		if(exitValue == JFileChooser.APPROVE_OPTION) logo = ImageIO.read(chooser.getSelectedFile());
		else logo = null;
		*/
		
		logo = ImageIO.read(new File(this.enviroment.get(name).getAsString()));
	}

	/**
	 * @param enviroment the enviroment to set
	 */
	public void setEnviroment(JsonObject enviroment) {
		this.enviroment = enviroment;
	}
	
	

}
