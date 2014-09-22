package Cases;
import Game.Player;
import Game.Set;


public class Case {

	protected final int position;
	protected final Set set;
	protected char display;

	public Case(int position, Set set) {
		this.position = position;
		this.set = set;
		this.display = ' ';
	}
	
	public int getPosition() {
		return this.position;
	}

	public char getDisplay() {
		return this.display;
	}

	public void doSomething(Player player) {		
	}
}
