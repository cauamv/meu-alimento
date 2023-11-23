package br.com.senai.gestaoDeCadastroFront.views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.senai.gestaoDeCadastroFront.components.RoundJTextField;

public class TelaLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public TelaLogin() {
        setBounds(100, 100, 1277, 769);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton btnNewButton_1 = new JButton("Novo aqui?");
        btnNewButton_1.setForeground(new Color(0, 128, 255));
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton_1.setBorderPainted(false);
        btnNewButton_1.setBorder(null);
        btnNewButton_1.setBackground(new Color(255, 255, 255));
        btnNewButton_1.setBounds(1046, 665, 126, 39);
        contentPane.add(btnNewButton_1);
        
        JButton btnNewButton = new JButton("Entrar");
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBorder(null);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setBackground(new Color(120,116,116));
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton.setBounds(1055, 499, 126, 39);
        contentPane.add(btnNewButton);
        
        RoundJTextField roundJTextField_1 = new RoundJTextField(0);
        roundJTextField_1.setHorizontalAlignment(SwingConstants.CENTER);
        roundJTextField_1.setBackground(Color.RED);
        roundJTextField_1.setBounds(713, 391, 480, 61);
        contentPane.add(roundJTextField_1);
        
        RoundJTextField roundJTextField = new RoundJTextField(0);
        roundJTextField.setHorizontalAlignment(SwingConstants.CENTER);
        roundJTextField.setBackground(new Color(255, 0, 0));
        roundJTextField.setBounds(713, 281, 480, 64);
        contentPane.add(roundJTextField);
        
        JLabel lblNewLabel_1_1 = new JLabel("Digite sua senha:");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1_1.setBounds(713, 371, 184, 17);
        contentPane.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1 = new JLabel("Digite seu usuário ou email:");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1.setBounds(713, 254, 184, 30);
        contentPane.add(lblNewLabel_1);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/telaLogin.png")));
        lblNewLabel.setBounds(0, 0, 1259, 729);
        contentPane.add(lblNewLabel);
    }
}
