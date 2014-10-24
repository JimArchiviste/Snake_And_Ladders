package Cases;
import Game.Player;
import Game.Set;

/**
 * 
 * Create a case which make the player go back to the start.
 * 
 * @author DUGAT Ghislain
 * 
 * @version 1.0
 *
 */
public class ReturnCase extends Case {

	/**
	 * Constructor of the case which return the player to the beginning.
	 * @param position
	 * @param set
	 */
	public ReturnCase(int position, Set set) {
		super(position, set);
		this.display = "«";
	}
	
	@Override
	/**
	 * Return the player to the first case.
	 * @return boolean
	 */
	public boolean doSomething(Player player) {
		player.goTo(0);
		return true;
	}
}
