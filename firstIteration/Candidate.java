package firstIteration;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.google.gson.JsonObject;

public class Candidate {
	
	PoliticalParty party;
	String name;
	boolean selected;
	BufferedImage photo;
	JsonObject environment;
	
	/*
	public Candidate(String name, PoliticalParty party, JsonObject environment) throws IOException {
		this.name = name;
		this.party = party;
		selected = false;
		this.environment = environment;
		photo = ImageIO.read(new File(this.environment.get(name).getAsString()));
		
	}
	*/
	
	public Candidate(JsonObject environment) throws IOException {
		this.environment = environment;
		name = environment.get("Candidato").getAsString();
		party = new PoliticalParty(environment.get("Partido").getAsString(), environment.get("Logo").getAsString());
		photo = ImageIO.read(new File(environment.get("Foto").getAsString()));
	}
	
}
