package client;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.google.gson.JsonArray;

public class Papeleta extends JPanel implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = -203782894421891176L;
	private int totalColumns;
	private ArrayList<Partido> partidos;
	private int columnWidth;
	private int columnHeight;
	private JsonArray data;
	
	public Papeleta(JsonArray partidos) throws IOException {
		this.partidos = new ArrayList<Partido>();
		totalColumns = partidos.size() + 1; //Write in cuenta como columna
		data = partidos;
		
		Toolkit Tk = Toolkit.getDefaultToolkit();
		columnWidth = Tk.getScreenSize().width/totalColumns;
	    columnHeight = Tk.getScreenSize().height - 200;

	    buildPapeleta();
	    
	}
	
	private void buildPapeleta() throws IOException {
		for (int i = 0; i < totalColumns - 1; i++) 
			partidos.add(new Partido(columnHeight, columnWidth, data.get(i).getAsJsonObject())); 
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}

	
}
