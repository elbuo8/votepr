package client;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.google.gson.JsonObject;

public class Partido extends JPanel implements MouseListener {

	private HashMap<String, Candidato[]> posiciones;
	private int height;
	private int width;
	private JLabel logo;
	private String nombrePartido;
	private boolean integro;
	private JButton voteBox;
	
	
	public Partido(int height, int width, JsonObject posiciones) throws IOException {
		this.height = height;
		this.width = width;
		integro = false;
		voteBox = new JButton();
		voteBox.setAlignmentX(0);
		voteBox.setAlignmentY((int) (height*.30));
		voteBox.setSize(width, (int) (height*.30));
		
		voteBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				integro = true;
				//Loop pa change el partido a voted.
			}
		});
		
		nombrePartido = posiciones.get("Partido").getAsString();
		logo = new JLabel(new ImageIcon(ImageIO.read(new File(posiciones.get("Logo").getAsString())).getScaledInstance(width, (int) (height*.30), 0)));
		
		this.add(logo);
		this.add(voteBox);
		
		buildPanel(posiciones);
	}

	private void buildPanel(JsonObject posiciones) {
		String[] puestos = posiciones.get("Posiciones").getAsJsonArray().getAsString().split(",");
		for (int i = 0; i < puestos.length; i++) {
			Candidato[] candidatos = new Candidato[posiciones.get(puestos[i]).getAsJsonArray().size()];
			for (int j = 0; j < candidatos.length; j++) {
				candidatos[j] = new Candidato();
			}
		}
	}
	
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mousePressed(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	
}
