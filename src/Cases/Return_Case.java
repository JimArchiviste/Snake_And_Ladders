package Cases;
import Game.Player;
import Game.Set;


public class Return_Case extends Case {

	public Return_Case(int position, Set set) {
		super(position, set);
		this.display = '«';
	}
	
	@Override
	public void doSomething(Player player) {
		player.goTo(0);
	}
}
