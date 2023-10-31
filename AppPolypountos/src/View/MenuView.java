package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JLayer;
import java.awt.BorderLayout;

import Modele.Player;

public class MenuView extends View{
	
	UIButton b1;
	
	public MenuView(GameView gv) {
		super(gv);
		b1 = new UIButton(GameView.screenWidth/2 - 100, GameView.screenHeight/2 - 50, "Player 1");
		
		b1.setUIComponentListener(new UIComponentListener() {

			@Override
			public void onComponentClicked(int x, int y) {
				System.out.println("test1");
			}

			@Override
			public void onComponentMouseIn(int x, int y) {
				b1.setBackgroundColor(Color.yellow);
			}

			@Override
			public void onComponentMouseOut(int x, int y) {
				b1.setBackgroundColor(Color.blue);
			}

			public void onComponentPressed(int x, int y) {
				System.out.println("test2");
			}

			@Override
			public void onKeyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		addComponent(b1);
	}

	@Override
	public void tick(long elapsed) {
	}
	
	public void paint(Graphics g, int width, int height) {
		b1.paint(g);
	}
	
}
