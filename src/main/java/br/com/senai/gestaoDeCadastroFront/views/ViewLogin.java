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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.senai.gestaoDeCadastroFront.components.RoundJTextField;

public class ViewLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewLogin frame = new ViewLogin();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ViewLogin() {
        setBounds(100, 100, 1366, 783);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnNovoAqui = new JButton("Novo aqui?");
        btnNovoAqui.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to switch to TelaCadastro
                ViewCadastro telaCadastro = new ViewCadastro();
                telaCadastro.setVisible(true);
            }
        });
        
        RoundJTextField roundEmail = new RoundJTextField(0);
        roundEmail.setForeground(new Color(255, 255, 255));
        roundEmail.setHorizontalAlignment(SwingConstants.CENTER);
        roundEmail.setBackground(Color.RED);
        roundEmail.setBounds(767, 288, 522, 74);
        contentPane.add(roundEmail);
        btnNovoAqui.setForeground(new Color(0, 128, 255));
        btnNovoAqui.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNovoAqui.setBorderPainted(false);
        btnNovoAqui.setBorder(null);
        btnNovoAqui.setBackground(new Color(255, 255, 255));
        btnNovoAqui.setBounds(1139, 697, 126, 39);
        contentPane.add(btnNovoAqui);

        JButton btnEntrar = new JButton("Entrar");
        btnEntrar.setForeground(new Color(255, 255, 255));
        btnEntrar.setBorder(null);
        btnEntrar.setBorderPainted(false);
        btnEntrar.setBackground(new Color(120, 116, 116));
        btnEntrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnEntrar.setBounds(1146, 519, 132, 39);
        contentPane.add(btnEntrar);

        RoundJTextField roundSenha = new RoundJTextField(0);
        roundSenha.setForeground(new Color(255, 255, 255));
        roundSenha.setHorizontalAlignment(SwingConstants.CENTER);
        roundSenha.setBackground(Color.RED);
        roundSenha.setBounds(767, 399, 522, 74);
        contentPane.add(roundSenha);

        JLabel lblSenha = new JLabel("Digite sua senha:");
        lblSenha.setHorizontalAlignment(SwingConstants.LEFT);
        lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblSenha.setBounds(777, 379, 184, 17);
        contentPane.add(lblSenha);

        JLabel lblUsuarioEmail = new JLabel("Digite seu usuário ou email:");
        lblUsuarioEmail.setHorizontalAlignment(SwingConstants.LEFT);
        lblUsuarioEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblUsuarioEmail.setBounds(777, 259, 184, 30);
        contentPane.add(lblUsuarioEmail);

        JLabel fundo = new JLabel("");
        fundo.setHorizontalAlignment(SwingConstants.CENTER);
        fundo.setForeground(new Color(255, 255, 255));
        fundo.setIcon(new ImageIcon(ViewLogin.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/telaLogin.png")));
        fundo.setBounds(0, 0, 1366, 746);
        contentPane.add(fundo);
        
        setLocationRelativeTo(null);
    }
}
