package Game;
import java.util.ArrayList;

import Cases.Case;
import Cases.GoBackCase;
import Cases.QuestionCase;
import Cases.ReturnCase;

/**
 * 
 * Create a set.
 * 
 * @author DUGAT Ghislain
 * 
 * @version 1.0
 *
 */
public class Set {

	private ArrayList<Integer> casesInt;
	private ArrayList<Case> cases;
	private final ArrayList<Question> questions = Question.getRandomQuestions();
	
	/**
	 * Constructor, which generates a random list of cases.
	 * @param cases
	 */
	public Set(ArrayList<Integer> cases) {
		this.casesInt = cases;
		this.cases = createSet(casesInt);
	}
	

	/**
	 * Generate a random list of cases. According to the number of the list, it creates a specific type of case.
	 * @param list
	 * @return ArrayList<Case> cases
	 */
	private ArrayList<Case> createSet(ArrayList<Integer> list) {
		ArrayList<Case> cases = new ArrayList<Case>();
		int i = 0;
		for (Integer type : list) {
			switch (type) {
				case 0 :
					if (i == 0) {
						cases.add(new Case(i, this, "Start"));
					}
					else if (i == list.size() - 1) {
						cases.add(new Case(i, this, "End"));
					}
					else {
						cases.add(new Case(i, this));
					}
					break;
				case 1 :
					cases.add(new ReturnCase(i, this));
					break;
				case 2 :
					cases.add(new GoBackCase(i, this));
					break;
				case 3 :
					cases.add(new QuestionCase(i, this));
					break;
				default :
					System.out.println("There was a problem during the initialization of the set.");
					return null;
			}
			i++;
		}
		return cases;
	}
	
	/**
	 * Return the cases of the set.
	 * @return ArrayList<Question> this.cases
	 */
	public ArrayList<Case> getCases() {
		return this.cases;
	}
	
	/**
	 * Return the card package's questions of the game.
	 * @return ArrayList<Question> this.quesitons
	 */
	public ArrayList<Question> getQuestions() {
		return this.questions;
	}
	
}
