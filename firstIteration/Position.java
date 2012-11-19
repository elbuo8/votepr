package firstIteration;

import java.util.ArrayList;


public class Position {

	private ArrayList<Candidate> candidates;
	private String positionName;
	private int size;
	private int selectedIndex;

	public Position(String name, int size) {
		candidates = new ArrayList<Candidate>();
		this.size = size;
		positionName = name;

	}

	public boolean addCandidate(Candidate candidate) {
		if (size == candidates.size()) return false;
		candidates.add(candidate);
		return true;
	}
	
	public Candidate getCandidate(int index) {
		return candidates.get(index);
	}

	public int totalCandidates() {
		return size;
	}
	
	public void setVote(int index) {
		if(selectedIndex == index) return;
		candidates.get(selectedIndex).unselected();
		selectedIndex = index;
		candidates.get(selectedIndex).selected();
	}

}
