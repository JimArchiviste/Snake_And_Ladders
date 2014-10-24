package Cases;
import Game.Player;
import Game.Set;

/**
 * 
 * Create a normal case.
 * 
 * @author DUGAT Ghislain
 * 
 * @version 1.0
 *
 */
public class Case {

	protected final int position;
	protected final Set set;
	protected String display;

	/**
	 * First constructor.
	 * @param position
	 * @param set
	 */
	public Case(int position, Set set) {
		this.position = position;
		this.set = set;
		this.display = " ";
	}
	
	/**
	 * Second constructor.
	 * @param position
	 * @param set
	 * @param display
	 */
	public Case(int position, Set set, String display) {
		this.position = position;
		this.set = set;
		this.display = display;
	}
	
	/**
	 * Get the position of the case.
	 * @return int position
	 */
	public int getPosition() {
		return this.position;
	}

	/**
	 * Get the display of the case.
	 * @return String display
	 */
	public String getDisplay() {
		return this.display;
	}

	/**
	 * Do the action of the case. (Here nothing)
	 * @param player
	 * @return boolean
	 */
	public boolean doSomething(Player player) {
		return false;
	}
}
