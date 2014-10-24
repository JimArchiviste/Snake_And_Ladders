package Cases;
import Game.Player;
import Game.Set;

/**
 * 
 * Create a case which make the player go back of one case.
 * 
 * @author DUGAT Ghislain
 * 
 * @version 1.0
 *
 */
public class GoBackCase extends Case {

	/**
	 * Constructor of the case which make return the player 1 case back.
	 * @param position
	 * @param set
	 */
	public GoBackCase(int position, Set set) {
		super(position, set);
		this.display = "¬";
	}
	
	@Override
	/**
	 * Return the player to 1 case back.
	 * @return boolean
	 */
	public boolean doSomething(Player player) {
		player.goBack(1);
		return true;
	}
}
