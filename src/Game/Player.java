package Game;

/**
 * 
 * Create a player.
 * 
 * @author DUGAT Ghislain
 * 
 * @version 1.0
 *
 */
public class Player {
		
	private final String pseudo;
	private int position = 0;
	private int turn;
	
	/**
	 * Constructor of the player.
	 * @param pseudo
	 * @param turn
	 */
	public Player(String pseudo, int turn) {
		this.pseudo = pseudo;
		this.turn = turn;
	}

	/**
	 * Get the pseudo.
	 * @return this.pseudo
	 */
	public String getPseudo() {
		return this.pseudo;
	}

	/**
	 * Get the position of the player.
	 * @return this.position
	 */
	public int getPosition() {
		return this.position;
	}
	
	/**
	 * Get the rank of the player (when he plays).
	 * @return
	 */
	public int getTurn() {
		return this.turn;
	}

	/**
	 * Can go to the position @param position.
	 * @param position
	 */
	public void goTo(int position) {
		this.position = position;	
	}

	/**
	 * Go back of @param i cases.
	 * @param i
	 */
	public void goBack(int i) {
		if (this.position > i) this.position -= i;
		else this.goTo(0);
	}
	
	/**
	 * Go forward of @param i cases.
	 * @param i
	 */
	public void goForward(int i) {
		this.position += i;
	}
	
}