import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

public class Canvas extends JPanel  {
	
	static BufferedImage imagen;
	static Graphics gfx;
	int pixelSize=40;
	private final int TAMANIO_CASILLA = 10;
   	private final int FILAS = 50;
    	private final int COLUMNAS = 50;
    	private Color[][] casillas = new Color[FILAS][COLUMNAS];
	
	public Canvas() {
		setBackground(Color.black);
		imagen = new BufferedImage(500, 500, BufferedImage.TYPE_INT_RGB);
		gfx=imagen.createGraphics();
	}
	
	private void paintPixel(int x, int y, Color color) {
		gfx.setColor(color);
		gfx.fillRect(x * pixelSize, y * pixelSize, pixelSize, pixelSize);
	}
	
	  public Cuadricula() {
        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                casillas[fila][columna] = Color.WHITE;
            }
        }
    }

    public void setColor(int fila, int columna, Color color) {
        casillas[fila][columna] = color;
        repaint();
    }
	
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int fila = 0; fila < FILAS; fila++) {
            for (int columna = 0; columna < COLUMNAS; columna++) {
                g.setColor(casillas[fila][columna]);
                g.fillRect(columna * TAMANIO_CASILLA, fila * TAMANIO_CASILLA, TAMANIO_CASILLA, TAMANIO_CASILLA);
                g.setColor(Color.BLACK);
                g.drawRect(columna * TAMANIO_CASILLA, fila * TAMANIO_CASILLA, TAMANIO_CASILLA, TAMANIO_CASILLA);
            }
        }
    }

    @Override
    public int getPreferredSize() {
        return new Dimension(COLUMNAS * TAMANIO_CASILLA, FILAS * TAMANIO_CASILLA);
    }
}
	
	public void setImage(BufferedImage imgagenSet) {
		imagen=imgagenSet;
	}
	
	public Graphics getGraphic() {
		return gfx;
	}
	
}
