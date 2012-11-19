package client;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;

import com.google.gson.JsonObject;

public class Candidato {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8490124344660939363L;
	
	JLabel nombre;
	boolean selected;
	JLabel photo; //Image is stored here.

	
	public Candidato(int width, int height,JsonObject information) throws IOException {
		nombre = new JLabel(information.get("Nombre").getAsString());
		//modify lo de scaled later.
		photo = new JLabel(new ImageIcon(ImageIO.read(new File(information.get("Foto").getAsString())).getScaledInstance(width/3, height*10, 0)));
		selected = false;
	}

	public void selected() {
		selected = true;
	}
	
	public void unselected() {
		selected = false;
	}
	
}
