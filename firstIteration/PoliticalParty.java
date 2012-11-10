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
	JsonObject environment;
	
	public PoliticalParty(String name, JsonObject environment) throws IOException {
		this.name = name;
		this.environment = environment;
		/*
		JFileChooser chooser = new JFileChooser();
		chooser.setDialogTitle("Political Party: " + this.name);
		chooser.setFileFilter(new utilities.ImageFilter());
		
		int exitValue = chooser.showOpenDialog(null);
		if(exitValue == JFileChooser.APPROVE_OPTION) logo = ImageIO.read(chooser.getSelectedFile());
		else logo = null;
		*/
		logo = ImageIO.read(new File(this.environment.get(name).getAsString()));
	}
	
	public PoliticalParty(String name, String image) throws IOException {
		this.name = name;
		logo = ImageIO.read(new File(image));
	}

	/**
	 * @param enviroment the enviroment to set
	 */
	public void setEnviroment(JsonObject enviroment) {
		this.environment = enviroment;
	}
	
	

}
