package Cases;
import java.util.Scanner;

import Game.Player;
import Game.Set;


public class Question_Case extends Case {

	private Scanner sc;

	public Question_Case(int position, Set set) {
		super(position, set);
		this.display = '?';
	}
	
	@Override	
	public void doSomething(Player player) {
			System.out.println(this.set.getQuestions().get(0).getQuestion());
			sc = new Scanner (System.in);
			String answer = sc.nextLine();
			System.out.println("The answer was : " + this.set.getQuestions().get(0).getAnswer() + ".");
			if(answer.toUpperCase().contains(this.set.getQuestions().get(0).getAnswer().toUpperCase())){
				System.out.println("Well done.");
			}
			else {
				System.out.println("You failed. Go back of 2 cases.");
				player.goBack(2);
			}
			this.set.getQuestions().add(this.set.getQuestions().get(0));
			this.set.getQuestions().remove(0);
	}

}
