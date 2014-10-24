package Cases;
import java.util.Scanner;

import Game.Player;
import Game.Set;

/**
 * 
 * Create a case which asks the player with a random question.
 * 
 * @author DUGAT Ghislain
 * 
 * @version 1.0
 *
 */
public class QuestionCase extends Case {

	private Scanner sc;

	/**
	 * Constructor of the case type question.
	 * @param position
	 * @param set
	 */
	public QuestionCase(int position, Set set) {
		super(position, set);
		this.display = "?";
	}

	@Override
	/**
	 * Pick a question, go back of two cases if the answer is wrong.
	 * @return boolean
	 */
	public boolean doSomething(Player player) {
			System.out.println(this.set.getQuestions().get(0).getQuestion());
			sc = new Scanner (System.in);
			String answer = sc.nextLine();
			System.out.println("The answer was : " + this.set.getQuestions().get(0).getAnswer() + ".");
			if(answer.toUpperCase().contains(this.set.getQuestions().get(0).getAnswer().toUpperCase())){
				System.out.println("Well done.");
				this.set.getQuestions().add(this.set.getQuestions().get(0));
				this.set.getQuestions().remove(0);
				return false;
			}
			else {
				System.out.println("You failed. Go back of 2 cases.");
				player.goBack(2);
				this.set.getQuestions().add(this.set.getQuestions().get(0));
				this.set.getQuestions().remove(0);
			}
			return true;
	}

}
