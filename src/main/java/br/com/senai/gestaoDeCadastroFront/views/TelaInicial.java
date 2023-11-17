package br.com.senai.gestaoDeCadastroFront.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.senai.gestaoDeCadastroFront.components.RoundJTextField;

public class TelaInicial extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TelaInicial frame = new TelaInicial();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public TelaInicial() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1273, 731);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnBuscar = new JButton("Buscar");
        btnBuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code for handling the "Buscar" button click
            }
        });

        JButton btnCriarConta = new JButton("Criar conta");
        btnCriarConta.setForeground(new Color(255, 0, 0));
        btnCriarConta.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnCriarConta.setBorder(null);
        btnCriarConta.setBackground(new Color(242, 242, 242, 255));
        btnCriarConta.setBounds(871, 49, 164, 43);
        btnCriarConta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to switch to TelaCadastro
                TelaCadastro telaCadastro = new TelaCadastro();
                telaCadastro.setVisible(true);
            }
        });
        contentPane.add(btnCriarConta);

        JButton btnLogin = new JButton("Login");
        btnLogin.setForeground(new Color(255, 255, 255));
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnLogin.setBorder(null);
        btnLogin.setBackground(new Color(255, 49, 49, 255));
        btnLogin.setBounds(1059, 50, 158, 43);
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to switch to TelaLogin
                TelaLogin telaLogin = new TelaLogin();
                telaLogin.setVisible(true);
            }
        });
        contentPane.add(btnLogin);

        btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnBuscar.setBorder(null);
        btnBuscar.setBackground(Color.WHITE);
        btnBuscar.setBounds(917, 400, 164, 43);
        contentPane.add(btnBuscar);

        RoundJTextField roundJTextField = new RoundJTextField(0);
        roundJTextField.setBackground(new Color(255, 255, 255));
        roundJTextField.setBounds(181, 390, 706, 64);
        contentPane.add(roundJTextField);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon(TelaInicial.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/telaInicial.png")));
        lblNewLabel.setBounds(0, 10, 1250, 674);
        contentPane.add(lblNewLabel);
    }
}
