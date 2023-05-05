
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class MyWindow extends JPanel implements ChangeListener {
	JSlider redSlider;
    JSlider greenSlider;
    JSlider blueSlider;

    JLabel redLabel;
    JLabel greenLabel;
    JLabel blueLabel;
    
    JButton blueBT,blackbT,whiteBT, redBT, greenBt, yellowBT; 
    
    public Color pencil;
    
    protected Color[] colors = { Color.BLACK, Color.WHITE, Color.RED, Color.ORANGE, Color.YELLOW, Color.GREEN, Color.BLUE, Color.CYAN, Color.MAGENTA, Color.PINK };
    public Color selectedColor;

    public void Colores() {
    	pencil = getCurrColor(0,0,0);
        setLayout(null);

        redSlider = new JSlider(0, 255, 0);
        redSlider.setBounds(300, 600, 150, 20);
        redSlider.addChangeListener(this);
        add(redSlider);
        redLabel = new JLabel("0");
        redLabel.setBounds(460, 600, 30, 30);
        add(redLabel);
        redSlider.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
                int red = redSlider.getValue();
                redVal = redSlider.getValue();
                int green = greenSlider.getValue();
                greenVal = greenSlider.getValue();
                int blue = blueSlider.getValue();
                blueVal = blueSlider.getValue();
                getCurrColor(red, green, blue);
                updateColorSquare(red, green, blue);
            }
        });
        
        greenSlider = new JSlider(0, 255, 0);
        greenSlider.setBounds(300, 650, 150, 20);
        greenSlider.addChangeListener(this);
        add(greenSlider);
        greenLabel = new JLabel("0");
        greenLabel.setBounds(460, 650, 30, 30);
        add(greenLabel);
        greenSlider.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
                int red = redSlider.getValue();
                redVal = redSlider.getValue();
                int green = greenSlider.getValue();
                greenVal = greenSlider.getValue();
                int blue = blueSlider.getValue();
                blueVal = blueSlider.getValue();
                getCurrColor(red, green, blue);
                updateColorSquare(red, green, blue);
            }
        });
        
        
        blueSlider = new JSlider(0, 255, 0);
        blueSlider.setBounds(300, 700, 150, 20);
        blueSlider.addChangeListener(this);
        add(blueSlider);
        blueLabel = new JLabel("0");
        blueLabel.setBounds(460, 700, 30, 30);
        add(blueLabel);
        blueSlider.addChangeListener(new ChangeListener() {
        	public void stateChanged(ChangeEvent e) {
                int red = redSlider.getValue();
                redVal = redSlider.getValue();
                int green = greenSlider.getValue();
                greenVal = greenSlider.getValue();
                int blue = blueSlider.getValue();
                blueVal = blueSlider.getValue();
                getCurrColor(red, green, blue);
                updateColorSquare(red, green, blue);
            }
        });
        
        JFrame frame = new JFrame("Color Picker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setSize(500, 800);
        frame.setVisible(true);
        
        for (Color c : colors) {
            JButton colorButton = new JButton();
            colorButton.setPreferredSize(new Dimension(20, 20));
            colorButton.setBackground(c);
            colorButton.addActionListener(new ActionListener() {
              @Override
              public void actionPerformed(ActionEvent e) {
                  // set the selected color to the button's background color
                  selectedColor = c;
                  smallLoop = true;
                  if (smallLoop) {
                    updateBlueSilder(selectedColor);
                    updateRedSlider(selectedColor);
                    updateGreenSlider(selectedColor);
                    smallLoop = false;
                  }
              }

    		public void actionPerformedC(ActionEvent e2) {
    			// TODO Auto-generated method stub
    			
    		}
          });
          defaultColorsPanel.add(colorButton);
          }
    	//@Override
    	//public void stateChanged(ChangeEvent e) {
    		// TODO Auto-generated method stub
    		
    	//}
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // blanco
        whiteBT.setPreferredSize(new Dimension(40,40));
        whiteBT.setBackground(Color.white);
        whiteBT.addActionListener((ActionListener) this);
        g.setColor(Color.WHITE);
        g.fillRect(20, 600, 40, 40);

        // negro
        g.setColor(Color.BLACK);
        g.fillRect(80, 600, 40, 40);

        // azul
        g.setColor(Color.BLUE);
        g.fillRect(140, 600, 40, 40);

        // rojo
        g.setColor(Color.RED);
        g.fillRect(20, 650, 40, 40);

        // verde
        g.setColor(Color.GREEN);
        g.fillRect(80, 650, 40, 40);

        // amarillo
        g.setColor(Color.YELLOW);
        g.fillRect(140, 650, 40, 40);

        // cuadro de color actual
        g.setColor(new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue()));
        g.fillRect(200, 600, 30, 90);
    }

    public void updateColorSquare(int red, int green, int blue) {
        // actualiza las etiquetas con los valores actuales de los sliders
        redLabel.setText(Integer.toString(redSlider.getValue()));
        greenLabel.setText(Integer.toString(greenSlider.getValue()));
        blueLabel.setText(Integer.toString(blueSlider.getValue()));        
        
        repaint();
    }    
    
    public Color getCurrColor(int red, int green, int blue) {
    	Color drawingColor = new Color(red, green,blue);
    	pencil = drawingColor;
    	return drawingColor;
    }
    
    
    public void funcionesColores() {
        redSlider.setBackground(Color.RED);
        greenSlider.setBackground(Color.GREEN);
        blueSlider.setBackground(Color.BLUE);
        
        redSlider.setPaintTrack(true);
        redSlider.setPaintTicks(true);
        redSlider.setPaintLabels(true);
        
        greenSlider.setPaintTrack(true);
        greenSlider.setPaintTicks(true);
        greenSlider.setPaintLabels(true);
        
        blueSlider.setPaintTrack(true);
        blueSlider.setPaintTicks(true);
        blueSlider.setPaintLabels(true);
        
        redSlider.addChangeListener(this);
        greenSlider.addChangeListener(this);
        blueSlider.addChangeListener(this);
        
        setBackground(Color.GRAY);
    }
}
