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
	
	public PoliticalParty(String name, String image) throws IOException {
		this.name = name;
		logo = ImageIO.read(new File(image));
	}

	

}
