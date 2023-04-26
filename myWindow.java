package proyectoFinal;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class myWindow extends JFrame {

    public myWindow() {
        setTitle("My Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 700);

        // Panel de colores
        Colores coloresPanel = new Colores();

        // Panel de colores predefinidos
        JPanel predefinedColorsPanel = new JPanel() {
            @Override
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
                g.setColor(new Color(coloresPanel.redSlider.getValue(), coloresPanel.greenSlider.getValue(), coloresPanel.blueSlider.getValue()));
                g.fillRect(200, 140, 30, 90);
            }
        };
        predefinedColorsPanel.setPreferredSize(new Dimension(260, 250));

        // Agrega los paneles al frame principal
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(coloresPanel, BorderLayout.WEST);
        mainPanel.add(predefinedColorsPanel, BorderLayout.CENTER);
        setContentPane(mainPanel);

        setVisible(true);
    }

    public static void main(String[] args) {
        new myWindow();
    }
}
