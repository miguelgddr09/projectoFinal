package finalParcial;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel  {
	
	static BufferedImage imagen;
	static Graphics gfx;
	
	public Canvas() {
		setBackground(Color.black);
		imagen = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
		gfx=imagen.createGraphics();
	}
	
	public void setImage(BufferedImage imgagenSet) {
		imagen=imgagenSet;
	}
	
	public Graphics getGraphic() {
		return gfx;
	}
	
}
