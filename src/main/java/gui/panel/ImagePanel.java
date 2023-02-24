package gui.panel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import gui.Gui;

public class ImagePanel extends CustomPanel{
	private Image image;
	
	private JLabel imageLabel;
	
	private JLabel label = new JLabel();
	
	private int imageWidth = -1, imageHeight = -1;
	
	{ rootPanel.setLayout(new BorderLayout()); }

	public void setImage(Image image) {
		setImage(image, -1, -1);
	}

	public void setImage(Image image, int imageWidth, int imageHeight) {
		if(image == null) return; 
		if(imageWidth > 0 && imageHeight > 0) {
			this.imageWidth = imageWidth;
			this.imageHeight = imageHeight;
			image = Gui.getResizedImage(image, this.imageWidth, this.imageHeight);
		}
		this.image = image;
		if(imageLabel != null) rootPanel.remove(imageLabel);
		imageLabel = new JLabel(new ImageIcon(image));
		rootPanel.add(imageLabel, BorderLayout.CENTER);
	}
	
	public void setText(String text) {
		label = new JLabel(text);
		rootPanel.add(label, BorderLayout.SOUTH);
	}
	
	@Override
	public String toString() {
		return "ImagePanel [image=" + image + ", imageLabel=" + imageLabel + ", commentLabel=" + label + "]";
	}

	public void setAlignment(int alignment) {
		label.setHorizontalAlignment(alignment);
	}
	
	public void setFont(Font font) {
		label.setFont(font);
	}

	public JLabel getLabel() {
		return label;
	}
}
