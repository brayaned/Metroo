package Vista;

import java.awt.*;
import static java.awt.Color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Invitado extends JFrame {

    public JPanel panel;
    JLabel e1 = new JLabel();
    JLabel e2 = new JLabel();
    JLabel e3 = new JLabel();
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JButton b1 = new JButton("Volver");
    JButton b2 = new JButton("Ingresar");
    Color dodgeblue = new Color(255, 122, 51);

    public Invitado() {
        setSize(500, 500);
        setTitle("Login");
        setLocationRelativeTo(null);
        setMinimumSize(new Dimension(500, 500));
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
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
        panel.setBackground(dodgeblue);
        this.getContentPane().add(panel);
    }

    private void colocarEtiquetas() {

        e1.setText("Metro de Bogotá");
        e1.setBounds(165, 60, 200, 100);
        e1.setHorizontalAlignment(SwingConstants.LEFT);
        e1.setFont(new Font("Impact", Font.BOLD, 20));
        e1.setForeground(white);
        panel.add(e1);
    }

    private void colocarCampos() {

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
