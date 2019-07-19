package Vista;

import Conexion.Conexion;
import Metro.*;
import java.awt.*;
import static java.awt.Color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;

public class Login extends JFrame {

    public JPanel panel;
    JLabel e1 = new JLabel();
    JLabel e2 = new JLabel();
    JLabel e3 = new JLabel();
    JLabel e4 = new JLabel();
    JTextField t1 = new JTextField();
    JTextField t2 = new JTextField();
    JButton b1 = new JButton();
    JButton b2 = new JButton("Ingresar");
    JButton b3 =new JButton("Registrarse");
    Color dodgeblue = new Color(51, 186, 255);

    Conexion conexion = new Conexion();
    Connection con = conexion.realziarConexion();
    PreparedStatement ps = null;
    Usuario user = new Usuario();

    String id, pass;

    public Login() {
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

        e1.setText("Ingresar sin iniciar sesión");
        e1.setBounds(100, 330, 250, 100);
        e1.setHorizontalAlignment(SwingConstants.LEFT);
        e1.setFont(new Font("Impact", Font.BOLD, 20));
        e1.setForeground(white);
        panel.add(e1);

        e2.setText("Usuario: ");
        e2.setBounds(100, 100, 250, 100);
        e2.setHorizontalAlignment(SwingConstants.LEFT);
        e2.setFont(new Font("Impact", Font.BOLD, 20));
        e2.setForeground(black);
        panel.add(e2);

        e3.setText("Contraseña: ");
        e3.setBounds(100, 170, 250, 100);
        e3.setHorizontalAlignment(SwingConstants.LEFT);
        e3.setFont(new Font("Impact", Font.BOLD, 20));
        e3.setForeground(black);
        panel.add(e3);

        e4.setBounds(100, 320, 400, 50);
        e4.setForeground(Color.red);
        e4.setHorizontalAlignment(SwingConstants.LEFT);
        e4.setFont(new Font("Impact", Font.PLAIN, 15));
        panel.add(e4);
        
    }

    private void colocarCampos() {

        t1.setBounds(230, 139, 100, 20);
        panel.add(t1);
        t2.setBounds(230, 209, 100, 20);
        panel.add(t2);
    }

    private void colocarBotones() {

        b1.setBounds(350, 350, 60, 50);
        b1.setFont(new Font("Impact", Font.PLAIN, 20));
        panel.add(b1);
        ImageIcon flecha = new ImageIcon("32738.png");
        ImageIcon flecha1 = new ImageIcon(flecha.getImage().getScaledInstance(50, 50, java.awt.Image.SCALE_DEFAULT));
        b1.setIcon(flecha1);

        b2.setBounds(180, 270, 100, 50);
        b2.setFont(new Font("Impact", Font.PLAIN, 16));
        panel.add(b2);
        
        b3.setBounds(350,410,140,50);
        b3.setFont(new Font("Impact", Font.PLAIN, 16));
        panel.add(b3);
        
        
        ActionListener invitado = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                UsuarioVista us = new UsuarioVista(0);
                setVisible(false);
                us.setVisible(true);
            }
        };
        b1.addActionListener(invitado);

        ActionListener ingresar = new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                id = t1.getText();
                pass = t2.getText();
                int h = 0;
                h = user.verificarUsuario(h, user, id, pass);
                switch (h) {
                    case 2:
                        UsuarioVista us = new UsuarioVista(1);
                        setVisible(false);
                        us.setVisible(true);
                        break;
                    case 1:
                        JOptionPane.showMessageDialog(null, "Contraseña Incorrecta!");
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "Usuario y/o Contraseña Incorrectos!");
                        t1.setText("");
                        t2.setText("");
                }
            }
        };
        b2.addActionListener(ingresar);
        
        ActionListener registrarse=new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Registro rg=new Registro();
                rg.setVisible(true);
                setVisible(false);
            }
        };
        b3.addActionListener(registrarse);
        
    }

}
