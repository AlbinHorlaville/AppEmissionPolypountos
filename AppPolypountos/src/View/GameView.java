package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.Graphics;
import java.awt.GraphicsEnvironment;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.swing.JFrame;

import Controller.Controller;
import Controller.GameState;
import Modele.GameModele;
import graphics.GameCanvas;

public class GameView {
	
	JFrame frame;
	public GameCanvas canvas;
	GameModele game;
	private View currentView;
	Controller controller;
	
	public static HashMap<GameState, View> all_views;
	
	public static int screenWidth;
	public static int screenHeight;
	
	public static Font font;

	public GameView(GameModele game, Controller controller) throws IOException {
		this.game = game;

		this.controller = controller;
		canvas = new GameCanvas(controller);
		
		System.out.println("  - creating frame...");
		Dimension d = new Dimension(1024, 768);

		this.screenWidth = 1024;
		this.screenHeight = 768;

		frame = canvas.createFrame(d);
		frame.setResizable(false);
		//frame.setSize(frame.getToolkit().getScreenSize());
		
		System.out.println("  - Load font");
		String fontPath = "/Users/albin/eclipse-workspace/AppEmissionPolypountos/AppPolypountos/resources/font/Roboto-Medium.ttf";
		try {
			// Load the font file
			font = Font.createFont(Font.TRUETYPE_FONT, new File(fontPath));
			
			font = new Font("Arial", Font.PLAIN, 24);
					
			// Register the font with the graphics environment
			GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			ge.registerFont(font);

		} catch (FontFormatException | IOException e) {
			e.printStackTrace();
		}
		
		System.out.println("  - Init the view...");
		init_view();
		update_view(game.getCurrentState());
		
		setupFrame();
	}
	
	public GameModele getGame() {
		return game;
	}

	public void setGame(GameModele game) {
		this.game = game;
	}

	public View getCurrentView() {
		return currentView;
	}

	public void setCurrentView(View currentView) {
		this.currentView = currentView;
	}
	
	private void init_view() {
		this.all_views = new HashMap<GameState, View>();
		this.all_views.put(GameState.Menu, new MenuView(this));
		this.all_views.put(GameState.partie, new PartieView(this));
		this.all_views.put(GameState.Win, new WinView(this));
		this.all_views.put(GameState.Loose, new LooseView(this));
	}
	
	public void update_view(GameState state) {
		this.currentView = this.all_views.get(state);
	}

	public View getViewByName(GameState name) {
		return this.all_views.get(name);
	}
	
	private void setupFrame() {
		frame.setTitle("PolypountosLeJeu");
		
		frame.add(canvas, BorderLayout.CENTER);
		
		
		// center the window on the screen
		frame.setLocationRelativeTo(null);

		// make the vindow visible
		frame.setVisible(true);
	}
	
	public void tick(long elapsed) {

		currentView.tick(elapsed);
	}
	
	public void paint(Graphics g) {
		// get the size of the canvas
		int width = canvas.getWidth();
		int height = canvas.getHeight();

		g.setColor(Color.gray);
		g.fillRect(0, 0, width, height);
		
		this.currentView.paint(g, width, height);
	}
	
	public int getWidthCanvas() {
		return canvas.getWidth();
	}

	public int getHeightCanvas() {
		return canvas.getHeight();
	}
	
}
