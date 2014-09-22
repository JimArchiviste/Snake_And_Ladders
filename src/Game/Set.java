package Game;
import java.util.ArrayList;

import Cases.Case;
import Cases.GoBack_Case;
import Cases.Question;
import Cases.Question_Case;
import Cases.Return_Case;


public class Set {

	private ArrayList<Integer> casesInt;
	private ArrayList<Case> cases;
	private final ArrayList<Question> questions = Question.getRandomQuestions();
	
	public Set(ArrayList<Integer> cases) {
		this.casesInt = cases;
		this.cases = createSet(casesInt);
	}
	

	private ArrayList<Case> createSet(ArrayList<Integer> list) {
		ArrayList<Case> cases = new ArrayList<Case>();
		int i = 0;
		for (Integer type : list) {
			switch (type) {
				case 0 :
					cases.add(new Case(i, this));
					break;
				case 1 :
					cases.add(new Return_Case(i, this));
					break;
				case 2 :
					cases.add(new GoBack_Case(i, this));
					break;
				case 3 :
					cases.add(new Question_Case(i, this));
					break;
				default :
					System.out.println("There was a problem during the initialization of the set.");
					return null;
			}
			i++;
		}
		return cases;
	}
	public ArrayList<Case> getCases() {
		return this.cases;
	}
	public ArrayList<Question> getQuestions() {
		return this.questions;
	}
	
}
