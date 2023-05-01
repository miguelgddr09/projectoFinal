import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GuardarImagenGUI extends JFrame implements ActionListener {
    
    private BufferedImage imagen;
    private JFileChooser selectorArchivo;
    private JButton guardarJPG, guardarGIF, guardarPNG;
    private String rutaActual = System.getProperty("user.dir");

    public GuardarImagenGUI() {
        super("Guardar imagen");

        // Crear botones para guardar en JPG, GIF y PNG
        guardarJPG = new JButton("Guardar JPG");
        guardarJPG.addActionListener(this);

        guardarGIF = new JButton("Guardar GIF");
        guardarGIF.addActionListener(this);

        guardarPNG = new JButton("Guardar PNG");
        guardarPNG.addActionListener(this);

        // Añadir los botones a un panel
        JPanel panelBotones = new JPanel();
        panelBotones.add(guardarJPG);
        panelBotones.add(guardarGIF);
        panelBotones.add(guardarPNG);

        // Añadir el panel de botones al frame
        add(panelBotones, BorderLayout.SOUTH);

        // Crear un selector de archivo
        selectorArchivo = new JFileChooser(rutaActual);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == guardarJPG || e.getSource() == guardarGIF || e.getSource() == guardarPNG) {
            int resultado = selectorArchivo.showSaveDialog(this);

            if (resultado == JFileChooser.APPROVE_OPTION) {
                File archivo = selectorArchivo.getSelectedFile();

                try {
                    // Cargar la imagen desde un archivo
                    imagen = ImageIO.read(new File("ruta/de/la/imagen"));

                    // Guardar la imagen en el formato seleccionado
                    String formato = "";

                    if (e.getSource() == guardarJPG) {
                        formato = "jpg";
                    } else if (e.getSource() == guardarGIF) {
                        formato = "gif";
                    } else if (e.getSource() == guardarPNG) {
                        formato = "png";
                    }

                    // Crear la ruta completa del archivo de salida
                    String nombreArchivo = archivo.getName();
                    String rutaCompleta = rutaActual + File.separator + nombreArchivo;

                    ImageIO.write(imagen, formato, new File(rutaCompleta));

                } catch (IOException ex) {
                    System.out.println("Error al guardar la imagen: " + ex.getMessage());
                }
            }
        }
    }

    public static void main(String[] args) {
        GuardarImagenGUI ventana = new GuardarImagenGUI();
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 100);
        ventana.setVisible(true);
    }
}
