package firstIteration;

import java.util.ArrayList;


public class Position {

	ArrayList<Candidate> candidates;
	String positionName;
	int size;
	
	public Position(String name, int size) {
		candidates = new ArrayList<Candidate>();
		this.size = size;
		positionName = name;
		
	}

	public boolean addCandidate(Candidate candidate) {
		if (size == candidates.size()+1) return false;
		candidates.add(candidate);
		return true;
	}
	
	
	
}
