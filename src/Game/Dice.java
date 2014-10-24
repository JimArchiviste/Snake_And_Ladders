package Game;
/**
 * 
 * Create a Dice.
 * 
 * @author DUGAT Ghislain
 * 
 * @version 1.0
 *
 */
public class Dice {

	private int faces;

	/**
	 * Constructor of the dice.
	 * @param faces
	 */
	public Dice(int faces) {
		this.faces = faces;
	}
	
	/**
	 * Return a random number of the dice.
	 * @return int randomNumber
	 */
	public int randomNumber() {
		return (int) (Math.random() * this.faces + 1);
	}
	
}
