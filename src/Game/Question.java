package Game;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collections;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;

/**
 * 
 * List of the questions of the game.
 * 
 * @author DUGAT Ghislain
 * 
 * @version 1.0
 *
 */
public class Question {
	
	private String question = "";
	private String answer = "";
	
	/**
	 * Constructor of the question.
	 * @param question
	 * @param answer
	 */
	Question(String question, String answer) {
		this.question = question;
		this.answer = answer;
	}
	
	/**
	 * Create a random card package's questions by reading in a JSON file.
	 * @return ArrayList<Question> randomQuestions
	 */
	public static ArrayList<Question> getRandomQuestions() {
		ArrayList<Question> randomQuestions = new ArrayList<Question>();
		

		File file = new File("src/Game/questions.json");
		Reader reader;
		try {
			reader = new FileReader(file);
			JsonReader rdr = Json.createReader(reader);
			JsonObject obj = rdr.readObject();
			JsonArray results = obj.getJsonArray("questions");
			for (JsonObject result : results.getValuesAs(JsonObject.class)) {
		        Question pair = new Question(result.getJsonString("question").toString().substring(1, result.getJsonString("question").toString().length()-1), result.getJsonString("answer").toString().substring(1, result.getJsonString("answer").toString().length()-1)); //The construction is so long because I need to convert the JSON String to a normal String.
		        randomQuestions.add(pair);
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		Collections.shuffle(randomQuestions);
		return randomQuestions;
	}
	
	/**
	 * Get the question.
	 * @return String this.question
	 */
    public String getQuestion () {
		return this.question;
    }
    
    
    /**
     * Get the answer.
     * @return String this.answer
     */
    public String getAnswer () {
		return this.answer;
    }
    
}
