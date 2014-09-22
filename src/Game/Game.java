package Game;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

import Cases.Case;

public class Game {

	private ArrayList<Player> players;
	private Dice dice;
	private Set set;
	private Scanner sc;
	
	Game() {
		this.players = new ArrayList<Player>();
	}
	
	private void initialplayer() {
		int nb_players = 0;
		while(true){
			try {
				System.out.println("How many players want to play ?");
				sc = new Scanner (System.in);
				nb_players = Integer.parseInt(sc.nextLine());
				if (nb_players < 1 || nb_players > 20) throw new NumberFormatException();
				break;
			} catch(NumberFormatException e) {
				System.out.println("You must indicate an int between 1 and 20 includes.");
			}
		}
		for (int i = 0; i < nb_players; i++ ) {
			System.out.println("What is the name of player " + (i+1) + " ?");
			sc = new Scanner (System.in);
			String name = sc.nextLine();
			this.players.add(new Player(name, i+1));
		}
	}
	
	public void initialSet() {
		int length = 0;
		while(true){
			try {
				System.out.println("With how many cases in the set do want to play ?");
				sc = new Scanner (System.in);
				length = Integer.parseInt(sc.nextLine());
				if (length < 10 || length > 1000) throw new NumberFormatException();
				break;
			} catch(NumberFormatException e) {
				System.out.println("You must indicate an int between 10 and 1000 includes.");
			}
		}
		HashMap<Integer, Double> probas = new HashMap<Integer, Double>();
		ArrayList<Integer> list = new ArrayList<Integer>();
		probas.put(0, 50.0);
		probas.put(1, 10.0);
		probas.put(2, 10.0);
		probas.put(3, 30.0);
		for (int i = 0; i < (int) (probas.get(0) * (length) / 100); i++) {
			list.add(0);
		}
		for (int i = 0; i < (int) (probas.get(1) * (length) / 100); i++) {
			list.add(1);
		}
		for (int i = 0; i < (int) (probas.get(2) * (length) / 100); i++) {
			list.add(2);
		}
		for (int i = 0; i < (int) (probas.get(3) * (length) / 100); i++) {
			list.add(3);
		}
		if (list.size() != length) list.remove(0);
		else {
			list.remove(0);
			list.remove(0);
		}
		Collections.shuffle(list);
		list.add(0);
		list.add(0, 0);
		this.set = new Set(list);
	}
	
	private void initialDice(){
		
		int nb_faces = 0;
		while(true){
			try {
				System.out.println("How many faces of dice do you want ?");
				sc = new Scanner (System.in);
				nb_faces = Integer.parseInt(sc.nextLine());
				if (nb_faces < 1 || nb_faces > 20) throw new NumberFormatException();
				break;
			} catch(NumberFormatException e) {
				System.out.println("You must indicate an int between 1 and 20 includes.");
			}
		}
		this.dice = new Dice(nb_faces);
	}
	
	private void initialize(){

		initialSet();
		initialDice();
		initialplayer();
		
	}
	
	private void start() {
		int i = 1;
		while(true) {
			System.out.println("");
			System.out.println("Turn " + i + " :");
			System.out.println("");
			if(makeTurn()) break;
			i++;
		}
	}
	
	private boolean makeTurn(){
		ArrayList<Player> winners = new ArrayList<Player>();
		for (Player p : this.players) {
			this.displaySet();
			int current_dice = this.dice.randomNumber();
			System.out.println(p.getPseudo() + " is throwing a dice : " + current_dice);
			p.goOn(current_dice);
			if (p.getPosition() >= this.set.getCases().size()){
				winners.add(p);
			}
			else {
				this.set.getCases().get(p.getPosition()).doSomething(p);;
			}
		}
		if (!winners.isEmpty()) {
			if (winners.size() == 1) {
				System.out.println("The winner is " + winners.get(0).getPseudo() + " ! Congratulations !");
			}
			else {
				String congrat = "The winners are ";
				for (int i = 0; i < winners.size() - 2; i++) {
					congrat += winners.get(i).getPseudo();
					congrat += ", ";
				}
				congrat += winners.get(winners.size() - 2).getPseudo() + " and " + winners.get(winners.size() - 1).getPseudo() + " ! Congratulations !";
				System.out.println(congrat);
			}
			return true;
		}
		else {
			return false;
		}
	}
	
	private void displaySet() {
		System.out.println("");
		String disSet = "";
		int i = 0;
		for (Case c : this.set.getCases()) {
			disSet += "[";
			for (Player p : this.players) {
				if (p.getPosition() == c.getPosition()) disSet += "(" + p.getTurn() + ")";
			}
			disSet += c.getDisplay() + "]";
			if ( i%20 == 17 ) {
				disSet += "\n";
			}
			i++;
		}
		System.out.println(disSet);
		System.out.println("");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args){
		Game game = new Game();
		game.initialize();
		game.start();
	}
	
}
