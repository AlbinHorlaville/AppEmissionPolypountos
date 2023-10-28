import Controller.Controller;
import Modele.GameModele;
import View.GameView;

public class Main {
	
	static GameModele game;
	static GameView view;
	static Controller controller;
	
	public static void main(String[] args) {
		System.out.println("Loading...");
		try {
			System.out.println("Game starting...");
			controller = new Controller();
			System.out.println("Game started.");
		} catch (Throwable th) {
			th.printStackTrace(System.err);
		}
	}
}
