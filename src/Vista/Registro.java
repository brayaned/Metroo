package Vista;

import Metro.Usuario;
import java.awt.*;
import static java.awt.Color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class Registro extends JFrame {

    public JPanel panel;
    JLabel e1 = new JLabel();
    JLabel e2 = new JLabel("Primer Nombre:");
    JLabel e3 = new JLabel("Primer Apellido:");
    JLabel e4 = new JLabel("Usuario:");
    JLabel e5 = new JLabel("Contraseña");
    JLabel e6 = new JLabel("Verifique Contraseña");

    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JTextField t3 = new JTextField();
    JTextField t4 = new JTextField();
    JTextField t5 = new JTextField();

    JButton b1 = new JButton("Confirmar");
    JButton b2 = new JButton("Volver");
    Color color = new Color(250, 50, 51);

    public Registro() {

        setTitle("Usuario");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(900, 500));
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        iniciarComponentes();
    }

    private void iniciarComponentes() {
        colocarPanel();
        colocarEtiquetas();
        colocarCampos();
        colocarBotones();
    }

    private void colocarPanel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(white);
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
        e1.setForeground(black);
        panel.add(e1);

        e2.setBounds(25, 170, 200, 30);
        e2.setHorizontalAlignment(SwingConstants.LEFT);
        e2.setFont(new Font("Impact", Font.BOLD, 20));
        e2.setForeground(black);
        panel.add(e2);

        e3.setBounds(350, 170, 200, 30);
        e3.setHorizontalAlignment(SwingConstants.LEFT);
        e3.setFont(new Font("Impact", Font.BOLD, 20));
        e3.setForeground(black);
        panel.add(e3);

        e4.setBounds(25, 220, 200, 30);
        e4.setHorizontalAlignment(SwingConstants.LEFT);
        e4.setFont(new Font("Impact", Font.BOLD, 20));
        e4.setForeground(black);
        panel.add(e4);

        e5.setBounds(25, 270, 200, 30);
        e5.setHorizontalAlignment(SwingConstants.LEFT);
        e5.setFont(new Font("Impact", Font.BOLD, 20));
        e5.setForeground(black);
        panel.add(e5);

        e6.setBounds(25, 320, 200, 30);
        e6.setHorizontalAlignment(SwingConstants.LEFT);
        e6.setFont(new Font("Impact", Font.BOLD, 20));
        e6.setForeground(black);
        panel.add(e6);
    }

    private void colocarCampos() {
        t1.setBounds(180, 170, 150, 30);
        panel.add(t1);

        t2.setBounds(510, 170, 150, 30);
        panel.add(t2);

        t3.setBounds(180, 220, 150, 30);
        panel.add(t3);

        t4.setBounds(180, 270, 150, 30);
        panel.add(t4);

        t5.setBounds(220, 320, 150, 30);
        panel.add(t5);

    }

    private void colocarBotones() {

        b1.setBounds(500, 350, 130, 50);
        b1.setFont(new Font("Impact", Font.PLAIN, 15));
        panel.add(b1);

        b2.setBounds(650, 350, 130, 50);
        b2.setFont(new Font("Impact", Font.PLAIN, 15));
        panel.add(b2);

        ActionListener regresar = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                setVisible(false);
                login.setVisible(true);
            }
        };
        b2.addActionListener(regresar);

        ActionListener confirmar = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String pn, ap, us, pass, vpass;
                pn = t1.getText();
                ap = t2.getText();
                us = t3.getText();
                pass = t4.getText();
                vpass = t5.getText();
                Usuario u = new Usuario();
                if (!pass.equals(vpass)) {
                    JOptionPane.showMessageDialog(null, "Error");
                } else {
                    int h = u.registrarUsuario(u, pn, ap, us, pass);
                    if (h == 0) {
                        JOptionPane.showMessageDialog(null, "Usuario Registrado");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error");

                    }
                }

            }
        };
        b1.addActionListener(confirmar);
    }

}
