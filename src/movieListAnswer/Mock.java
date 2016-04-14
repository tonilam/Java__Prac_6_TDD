package movieListAnswer;

import java.util.ArrayList;

public class Mock {
	private ArrayList<String> oscarsWinner;

	public Mock() {
		oscarsWinner = new ArrayList<String>();
		oscarsWinner.add("Casablanca");
		oscarsWinner.add("Star Wars");
		oscarsWinner.add("Citizen Kane");
	}
	
	public ArrayList<String> getMock() {
		return oscarsWinner;
	}

}
