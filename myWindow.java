import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class myWindow extends JFrame {

    public myWindow() {
        setTitle("My Window");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 800);

        Colores colores = new Colores();
        colores.funcionesColores();
}

    public static void main(String[] args) {
        new myWindow();
    }
}
