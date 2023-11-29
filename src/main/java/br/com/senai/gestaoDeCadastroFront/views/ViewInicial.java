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
import br.com.senai.gestaoDeCadastroFront.views.cadastros.ViewCadastro;

public class ViewInicial extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewInicial frame = new ViewInicial();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ViewInicial() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1366, 763);
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
        btnCriarConta.setBounds(949, 49, 172, 43);
        btnCriarConta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to switch to TelaCadastro
                ViewCadastro telaCadastro = new ViewCadastro();
                telaCadastro.setVisible(true);
            }
        });
        contentPane.add(btnCriarConta);

        JButton btnLogin = new JButton("Login");
        btnLogin.setForeground(new Color(255, 255, 255));
        btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnLogin.setBorder(null);
        btnLogin.setBackground(new Color(255, 49, 49, 255));
        btnLogin.setBounds(1147, 49, 172, 43);
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to switch to TelaLogin
//                ViewLogin telaLogin = new ViewLogin();
//                telaLogin.setVisible(true);
            }
        });
        contentPane.add(btnLogin);

        btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 20));
        btnBuscar.setBorder(null);
        btnBuscar.setBackground(Color.WHITE);
        btnBuscar.setBounds(994, 425, 181, 49);
        contentPane.add(btnBuscar);

        RoundJTextField roundEndereco = new RoundJTextField(0);
        roundEndereco.setBackground(new Color(255, 255, 255));
        roundEndereco.setBounds(195, 411, 769, 70);
        contentPane.add(roundEndereco);

        JLabel Fundo = new JLabel("");
        Fundo.setIcon(new ImageIcon(ViewInicial.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/telaInicial.png")));
        Fundo.setBounds(0, 10, 1366, 719);
        contentPane.add(Fundo);
        
        setLocationRelativeTo(null);
    }
}
