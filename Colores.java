import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Colores extends JPanel implements ChangeListener {

    JSlider redSlider;
    JSlider greenSlider;
    JSlider blueSlider;

    JLabel redLabel;
    JLabel greenLabel;
    JLabel blueLabel;

    public Colores() {
        setLayout(null);

        redSlider = new JSlider(0, 255, 0);
        redSlider.setBounds(300, 600, 150, 20);
        redSlider.addChangeListener(this);
        add(redSlider);

        greenSlider = new JSlider(0, 255, 0);
        greenSlider.setBounds(300, 650, 150, 20);
        greenSlider.addChangeListener(this);
        add(greenSlider);

        blueSlider = new JSlider(0, 255, 0);
        blueSlider.setBounds(300, 700, 150, 20);
        blueSlider.addChangeListener(this);
        add(blueSlider);

        redLabel = new JLabel("0");
        redLabel.setBounds(460, 600, 20, 20);
        add(redLabel);

        greenLabel = new JLabel("0");
        greenLabel.setBounds(460, 650, 20, 20);
        add(greenLabel);

        blueLabel = new JLabel("0");
        blueLabel.setBounds(460, 700, 20, 20);
        add(blueLabel);

        JFrame frame = new JFrame("Color Picker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setSize(500, 800);
        frame.setVisible(true);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // blanco
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

    public void stateChanged(ChangeEvent e) {
        // actualiza las etiquetas con los valores actuales de los sliders
        redLabel.setText(Integer.toString(redSlider.getValue()));
        greenLabel.setText(Integer.toString(greenSlider.getValue()));
        blueLabel.setText(Integer.toString(blueSlider.getValue()));

        repaint();
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
        
        setBackground(Color.WHITE);
    }

    public static void main(String[] args) {
        Colores colores = new Colores();
        colores.funcionesColores();
    }
}
