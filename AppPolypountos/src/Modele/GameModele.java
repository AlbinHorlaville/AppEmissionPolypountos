package Modele;

import java.io.IOException;

import Controller.GameState;
import View.GameView;

public class GameModele {
	
	GameView gameview;
	
	GameState currentState;
	
	public GameModele() {
		this.currentState = GameState.Menu;
	}
	
	public void setGameview(GameView gameview) {
		this.gameview = gameview;
	}
	
	public void tick(long elapsed) {
		if (currentState==GameState.Menu) {
			
		}else if (currentState==GameState.partie) {
			
		}else if (currentState==GameState.Win) {
			
		}else if (currentState==GameState.Loose) {
			
		}
	}
	
	public GameState getCurrentState() {
		return currentState;
	}

	public void setCurrentState(GameState state) {
		this.currentState = state;
		this.gameview.update_view(state);
	}
	
	public void start() throws Exception {
		// Charger les questions, les joueurs, les images
	}
	
	public void menu() throws IOException {
		if (currentState==GameState.Loose || currentState==GameState.Win) {
			setCurrentState(GameState.Menu);
		}
	}
	
	public void partie() throws IOException {
		if (currentState==GameState.Menu) {
			setCurrentState(GameState.partie);
		}
	}
	
	public void win() throws IOException {
		if (currentState==GameState.partie) {
			setCurrentState(GameState.Win);
		}
	}
	
	public void loose() throws IOException {
		if (currentState==GameState.partie) {
			setCurrentState(GameState.Loose);
		}
	}
	
	public void gameover() {
	}
	
	public void victory() {
	}
}
