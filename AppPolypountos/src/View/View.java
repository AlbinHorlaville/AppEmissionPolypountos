package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public abstract class View {
	
	ArrayList<UIComponent> components;
	GameView gameView;
	
	protected int window_width;
	protected int window_height;
	
	protected Color c1;
	protected Color c2;
	protected Color c3;
	
	public View(GameView gv) {
		window_width = 1024;
		window_height = 768;
		
		c1 = new Color(255, 100, 100);
		c2 = new Color(255, 255, 102);
		c3 = new Color(255, 218, 185);
		
		gameView = gv;
		components = new ArrayList<>();
	}
	
	public abstract void tick(long elapsed);

	public void paint(Graphics g, int width, int height) {
		for (UIComponent c : components) {
			c.paint(g);
		}
	}

	public void addComponent(UIComponent c) {
		components.add(c);
	}

	public UIComponent getHoveredComponent(int x, int y) {
		for (UIComponent c : components) {
			if (c.mouseOnComponent(x, y)) {
				return c;
			}
		}
		return null;
	}
}
