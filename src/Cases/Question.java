package Cases;
import java.util.ArrayList;


public enum Question {
	
	Q1("Where is Myrcella Baratheon send, because of a Tyrion plan ?", "Sunspear"),
	Q2("Who killed Viserys and Daenerys' father ?", "Jaime Lannister"),
	Q3("Where does Talisa come from ?", "Volantis"),
	Q4("Why was Rob fiancé for ?", "Bridge");
	
	private String question = "";
	private String answer = "";
	
	Question(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}
	
	public static ArrayList<Question> getRandomQuestions() {
		ArrayList<Question> randomQuestions = new ArrayList<Question>();
		for (int i = 0; i < values().length; i++) {
			int randomRange = (int) (Math.random() * values().length);
			while (isInList(values()[randomRange], randomQuestions)) {
				randomRange = (int) (Math.random() * values().length);
			}
			randomQuestions.add(values()[randomRange]);
		}
		return randomQuestions;
	}
	
	private static boolean isInList(Question question, ArrayList<Question> list) {
		for (Question q : list) {
			if (q == question) return true;
		}
		return false;	
	}
    
    public String getQuestion () {
		return this.question;
    }
    
    public String getAnswer () {
		return this.answer;
    }
    
}
