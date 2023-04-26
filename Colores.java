import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Colores extends JPanel implements ChangeListener {

    private JSlider redSlider;
    private JSlider greenSlider;
    private JSlider blueSlider;

    public Colores() {
        setLayout(new BorderLayout());

        redSlider = new JSlider(0, 255, 0);
        greenSlider = new JSlider(0, 255, 0);
        blueSlider = new JSlider(0, 255, 0);
        
        redSlider.addChangeListener(this);
        greenSlider.addChangeListener(this);
        blueSlider.addChangeListener(this);

        JBox box = Box.createHorizontalBox();
        box.add(redSlider);
        box.add(greenSlider);
        box.add(blueSlider);

        add(box, BorderLayout.SOUTH);

        JFrame frame = new JFrame("Color Picker");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setSize(250, 220);
        frame.setVisible(true);
       }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        // blanco
        g.setColor(Color.WHITE);
        g.fillRect(20, 140, 40, 40);

        // negro
        g.setColor(Color.BLACK);
        g.fillRect(80, 140, 40, 40);

        // azul
        g.setColor(Color.BLUE);
        g.fillRect(140, 140, 40, 40);

        // rojo
        g.setColor(Color.RED);
        g.fillRect(20, 190, 40, 40);

        // verde
        g.setColor(Color.GREEN);
        g.fillRect(80, 190, 40, 40);

        // amarillo
        g.setColor(Color.YELLOW);
        g.fillRect(140, 190, 40, 40);

        // cuadro de color actual
        g.setColor(new Color(redSlider.getValue(), greenSlider.getValue(), blueSlider.getValue()));
        g.fillRect(200, 140, 30, 90);
    }

    public void stateChanged(ChangeEvent e) {
        repaint();
    }

    public static void main(String[] args) {
        new ColorPickerApp();
    }

}
