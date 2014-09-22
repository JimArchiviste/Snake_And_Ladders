package Game;
public class Dice {

	private int faces;

	public Dice(int faces) {
		this.faces = faces;
	}
	
	public int randomNumber() {
		return (int) (Math.random() * this.faces + 1);
	}
	
}
