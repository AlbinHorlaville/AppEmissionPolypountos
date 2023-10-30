package graphics;

import java.awt.Graphics;
import java.awt.event.KeyListener;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public interface GameCanvasListener extends MouseListener, MouseMotionListener, KeyListener{
	/*
	 * Called the first time the window becomes visible on the screen. This is the
	 * real start of the game, from now on, the execution is solely about reacting
	 * to events
	 */
	public void windowOpened();

	/*
	 * Called at the period specified in GameCanvas.TICK_PERIOD
	 */
	public void tick(long elapsed);

	/*
	 * Usually called 30 times per second, unless you modified GameCanvas.FPS.
	 */
	public void paint(Graphics g);

	/*
	 * Last callback, the window has been closed, this is the end of the game, after
	 * this call, the Java Runtime Environment will exit.
	 */
	public void exit();

	/*
	 * The music that was playing stopped playing, because the player reached the
	 * end of the music and looping was not requested.
	 */
	public void endOfPlay(String name);

	/*
	 * Timer set up on the canvas expired.
	 */
	public void expired();
}
