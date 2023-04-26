package finalParcial;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel  {
	
	static BufferedImage imagen;
	static Graphics gfx;
	int pixelSize=40;
	
	public Canvas() {
		setBackground(Color.black);
		imagen = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
		gfx=imagen.createGraphics();
	}
	
	public void setGridSize(int size, Color color) {
		for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {                
                gfx.setColor(color);
                gfx.drawRect(i * pixelSize, j * pixelSize, pixelSize, pixelSize);
            }
        }
	}
	public void setImage(BufferedImage imgagenSet) {
		imagen=imgagenSet;
	}
	
	public Graphics getGraphic() {
		return gfx;
	}
	
}
