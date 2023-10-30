package Controller;

import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

import Modele.GameModele;
import View.GameView;
import View.UIComponent;
import graphics.GameCanvasListener;

public class Controller implements GameCanvasListener {

	private static GameModele gameModele;
	GameView gameView;
	UIComponent focus;

	public Controller() {
		try {
			gameModele = new GameModele();
			gameView = new GameView(gameModele, this);
			gameModele.setGameview(gameView);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (focus != null) {
			focus.pressed(e.getX(), e.getY()); // calls to the focus'pressed behavior
		}

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		UIComponent newFocus = gameView.getCurrentView().getHoveredComponent(e.getX(), e.getY());

		if (focus != newFocus) {
			if (focus != null) {
				focus.mouseOut(e.getX(), e.getY()); // calls to the focus'mouseOut behavior
			}
			if (newFocus != null) {
				newFocus.mouseIn(e.getX(), e.getY()); // calls to the focus'mouseIn behavior
			}
			focus = newFocus;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
	}

	@Override
	public void windowOpened() {
		if (gameModele != null && gameView != null) {
		}
	}

	@Override
	public void tick(long elapsed) {
		if (gameModele != null && gameView != null) {
			gameModele.tick(elapsed);
			gameView.tick(elapsed);
		}

	}

	@Override
	public void paint(Graphics g) {
		if (gameModele != null && gameView != null) {
			gameView.paint(g);
		}
	}

	@Override
	public void exit() {
	}

	@Override
	public void endOfPlay(String name) {
	}

	@Override
	public void expired() {
	}

	public static GameModele getGameModele() {
		return gameModele;
	}
}
