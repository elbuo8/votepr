package firstIteration;

public class Position {
	
	Candidate[] candidates;
	String positionName;
	int selected;
	
	public Position(String name, int size) {
		candidates = new Candidate[size];
		selected = 0;
		positionName = name;
	}

	public boolean addCandidate(Candidate candidate) {
		if (selected == candidates.length) return false;
		candidates[selected++] = candidate;
		return true;
	}
	
}
