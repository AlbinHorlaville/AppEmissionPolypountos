package View;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JLabel;

public class UIButton extends UIComponent {

	private Color backgroundColor;
	private Color foregroundColor;
	
	UILabel label;

	// Implémente un bouton de taille, label et couleur adaptable
	public UIButton(int x, int y, String txt) {
		super(x, y, 100, 200);
		foregroundColor = Color.blue;
		backgroundColor = Color.blue;
		label = new UILabel(y, y, txt, GameView.font, Color.black);
	}

	// Le texte est centré sur le bouton
	@Override
	public void paint(Graphics g) {
		
		//g.setFont();

		g.setColor(backgroundColor);

		g.fillRoundRect(getPositionX(), getPositionY(), getWidth(), getHeight(), 40, 40);
		
		g.setFont(GameView.font);
		g.setColor(Color.black);

		if (label.getText().contains("\n")) {
			int marginY = 0;
			for (String line : label.getText().split("\n")) {
				int labelHeight = g.getFontMetrics().getHeight();
				int labelWidth = g.getFontMetrics().stringWidth(line);
				int rectHeight = labelHeight + label.getFont().getSize();
				int centerX = this.getPositionX() + (getWidth() - labelWidth) / 2;
				int centerY = this.getPositionY() + rectHeight - labelHeight + marginY * 35;
				g.drawString(line, centerX, centerY);
				marginY++;
			}
		} else {
			int labelHeight = g.getFontMetrics().getHeight();
			int labelWidth = g.getFontMetrics().stringWidth(label.getText());
			int rectHeight = labelHeight + label.getFont().getSize();
			int centerX = this.getPositionX() + (getWidth() - labelWidth) / 2;
			int centerY = this.getPositionY() + rectHeight - labelHeight;
			g.drawString(label.getText(), centerX, centerY);
		}
	}

	void drawString(Graphics g, String text, int x, int y) {
		for (String line : text.split("\n"))
			g.drawString(line, x, y += g.getFontMetrics().getHeight());
	}
/*
	public UILabel getLabel() {
		return label;
	}

	public void setLabel(UILabel label) {
		this.label = label;
	}
*/
	public Color getBackgroundColor() {
		return backgroundColor;
	}

	public Color getForegroundColor() {
		return foregroundColor;
	}

	// Change la couleur de fond du bouton
	public void setBackgroundColor(Color backgroundColor) {
		this.backgroundColor = backgroundColor;
	}

	// Change la couleur du texte
	public void setForegroundColor(Color foregroundColor) {
		this.foregroundColor = foregroundColor;
	}

}