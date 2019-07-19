package Vista;

import java.awt.*;
import static java.awt.Color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Informacion extends JFrame {

    public JPanel panel;
    JLabel e1 = new JLabel();
    JLabel e2 = new JLabel();
    JLabel e3 = new JLabel();
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JButton b1 = new JButton("Volver");
    JButton b2 = new JButton("Ingresar");
    JTextArea ta = new JTextArea();
    Color dodgeblue = new Color(255, 122, 51);

    String[] mensaje1 = {"Opcion1", "Opcion2", "Opcion3", "Opcion4"};
    String[] mensaje2 = {"Opcion1", "Opcion2", "Opcion3", "Opcion4"};
    String[] mensaje3 = {"Opcion1", "Opcion2", "Opcion3", "Opcion4"};
    String[] mensaje4 = {"Opcion1", "Opcion2", "Opcion3", "Opcion4"};

    JComboBox combo1 = new JComboBox(mensaje1);
    JComboBox combo2 = new JComboBox(mensaje2);
    JComboBox combo3 = new JComboBox(mensaje3);
    JComboBox combo4 = new JComboBox(mensaje4);

    public Informacion() {
        setSize(500, 500);
        setTitle("Login");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(1000, 500));
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    private void iniciarComponentes() {
        colocarPanel();
        colocarEtiquetas();
        colocarCampos();
        colocarBotones();
        colocarComboBox();
    }

    private void colocarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(dodgeblue);
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
        e1.setBounds(300, 40, 200, 100);
        e1.setHorizontalAlignment(SwingConstants.LEFT);
        e1.setFont(new Font("Impact", Font.BOLD, 15));
        e1.setForeground(white);
        panel.add(e1);

        ta.setBounds(300, 100, 300, 300);
        ta.setBackground(Color.LIGHT_GRAY);
        ta.setFont(new Font("Impact", Font.PLAIN, 15));
        panel.add(ta);
    }

    private void colocarCampos() {

    }

    private void colocarComboBox() {
        combo1.setBounds(20, 50, 100, 40);
        panel.add(combo1);

        combo2.setBounds(20, 100, 100, 40);
        panel.add(combo2);

        combo3.setBounds(20, 150, 100, 40);
        panel.add(combo3);

        combo4.setBounds(20, 200, 100, 40);
        panel.add(combo4);

        ActionListener consultar = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == combo1) {
                    JComboBox cmb = (JComboBox) e.getSource();
                    String msg = (String) cmb.getSelectedItem();
                    switch (msg) {
                        case "Opcion3":
                            ta.setText("Que tal amigos de youtube");
                            break;
                        case "s":
                            break;
                        case "d":
                            break;
                    }
                } else if (e.getSource() == combo2) {
                    JComboBox cmb = (JComboBox) e.getSource();
                    String msg = (String) cmb.getSelectedItem();
                    switch (msg) {
                        case "Opcion2":
                            ta.setText("Que tal");
                            break;
                        case "s":
                            break;
                        case "d":
                            break;
                    }
                } else if (e.getSource() == combo3) {
                    JComboBox cmb = (JComboBox) e.getSource();
                    String msg = (String) cmb.getSelectedItem();
                    switch (msg) {
                        case "":
                            break;
                        case "s":
                            break;
                        case "d":
                            break;
                    }

                } else if (e.getSource() == combo4) {
                    JComboBox cmb = (JComboBox) e.getSource();
                    String msg = (String) cmb.getSelectedItem();
                    switch (msg) {
                        case "":
                            break;
                        case "s":
                            break;
                        case "d":
                            break;
                    }
                }
            }
        };
        combo1.addActionListener(consultar);
        combo2.addActionListener(consultar);
        combo3.addActionListener(consultar);
        combo4.addActionListener(consultar);
    }

    private void colocarBotones() {

        b1.setBounds(25, 300, 90, 50);
        b1.setFont(new Font("Impact", Font.PLAIN, 20));
        panel.add(b1);

        ActionListener regresar = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                setVisible(false);
                login.setVisible(true);
            }
        };
        b1.addActionListener(regresar);
    }
}
