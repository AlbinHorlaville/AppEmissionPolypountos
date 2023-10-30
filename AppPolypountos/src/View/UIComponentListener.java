package View;

import java.awt.event.KeyEvent;

public interface UIComponentListener {
	void onComponentClicked(int x, int y); // when the UIComponent is clicked

	void onComponentMouseIn(int x, int y); // when the UICompoent is entered

	void onComponentMouseOut(int x, int y); // when the UIComponent is exited

	void onComponentPressed(int x, int y); // when the UIComponent is pressed

	void onKeyPressed(KeyEvent e); // when a key is pressed on the UIComponent
}
