package Vista;

import java.awt.*;
import static java.awt.Color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class UsuarioVista extends JFrame {

    public JPanel panel;
    JLabel e1 = new JLabel();
    JLabel e2 = new JLabel();
    JLabel e3 = new JLabel();
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JButton b1 = new JButton("Información");
    JButton b2 = new JButton("Planear Viaje");
    JButton b3 = new JButton("Sugerencia");
    JButton b4 = new JButton("Cargar Tarjeta");
    JButton b5 = new JButton("Volver");
    Color color = new Color(250, 50, 51);

    int b;

    public UsuarioVista(int i) {
        setSize(500, 500);
        setTitle("Usuario");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(900, 500));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        b = i;
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        colocarPanel();
        colocarEtiquetas();
        colocarCampos();
        colocarBotones(b);
    }

    private void colocarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(color);
        centerFrame();
        this.getContentPane().add(panel);
    }

    public void centerFrame() {
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();

        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;
        setLocation(dx, dy);
    }

    private void colocarEtiquetas() {

        e1.setText("Metro de Bogotá");
        e1.setBounds(165, 5, 200, 100);
        e1.setHorizontalAlignment(SwingConstants.LEFT);
        e1.setFont(new Font("Impact", Font.BOLD, 20));
        e1.setForeground(white);
        panel.add(e1);
    }

    private void colocarCampos() {

    }

    private void colocarBotones(int i) {

        if (i == 1) {

            b4.setBounds(25, 220, 130, 50);
            b4.setFont(new Font("Impact", Font.PLAIN, 15));
            panel.add(b4);

            b3.setBounds(25, 160, 130, 50);
            b3.setFont(new Font("Impact", Font.PLAIN, 15));
            panel.add(b3);
        }
        b1.setBounds(25, 40, 130, 50);
        b1.setFont(new Font("Impact", Font.PLAIN, 15));
        panel.add(b1);

        b2.setBounds(25, 100, 130, 50);
        b2.setFont(new Font("Impact", Font.PLAIN, 15));
        panel.add(b2);

        b5.setBounds(25, 280, 130, 50);
        b5.setFont(new Font("Impact", Font.PLAIN, 15));
        panel.add(b5);

        ActionListener regresar = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                setVisible(false);
                login.setVisible(true);
            }
        };
        b5.addActionListener(regresar);

        ActionListener informacion = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Informacion info = new Informacion();
                setVisible(false);
                info.setVisible(true);
            }
        };
        b1.addActionListener(informacion);
    }
}
