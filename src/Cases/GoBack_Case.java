package Cases;
import Game.Player;
import Game.Set;


public class GoBack_Case extends Case {

	public GoBack_Case(int position, Set set) {
		super(position, set);
		this.display = '¬';
	}
	
	@Override
	public void doSomething(Player player) {
		player.goBack(1);
	}
}
