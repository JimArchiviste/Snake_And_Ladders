package Game;
public class Player {
		
	private final String pseudo;
	private int position = 0;
	private int turn;
	
	public Player(String pseudo, int turn) {
		this.pseudo = pseudo;
		this.turn = turn;
	}

	public String getPseudo() {
		return this.pseudo;
	}

	public int getPosition() {
		return this.position;
	}
	
	public int getTurn() {
		return this.turn;
	}

	public void goTo(int position) {
		this.position = position;	
	}

	public void goBack(int i) {
		if (this.position > i) this.position -= i;
		else this.goTo(0);
	}
	
	public void goOn(int i) {
		this.position += i;
	}
	
}