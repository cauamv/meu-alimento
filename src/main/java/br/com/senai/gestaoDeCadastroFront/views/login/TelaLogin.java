package br.com.senai.gestaoDeCadastroFront.views.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.gestaoDeCadastroFront.client.authenticate.AutenticadorClient;
import br.com.senai.gestaoDeCadastroFront.client.authenticate.Token;
import br.com.senai.gestaoDeCadastroFront.components.RoundJTextField;
import br.com.senai.gestaoDeCadastroFront.dto.CredencialDeAcesso;

@Component
public class TelaLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    @Autowired
    private AutenticadorClient autenticadorClient;
    
    public TelaLogin() {
        setBounds(100, 100, 1277, 769);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JButton bntCadastrar = new JButton("Novo aqui?");
        bntCadastrar.setForeground(new Color(0, 128, 255));
        bntCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        bntCadastrar.setBorderPainted(false);
        bntCadastrar.setBorder(null);
        bntCadastrar.setBackground(new Color(255, 255, 255));
        bntCadastrar.setBounds(1046, 665, 126, 39);
        contentPane.add(bntCadastrar);
        
        RoundJTextField txtSenha = new RoundJTextField(0);
        txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
        txtSenha.setBackground(Color.RED);
        txtSenha.setBounds(713, 391, 480, 61);
        contentPane.add(txtSenha);
        
        RoundJTextField txtEmail = new RoundJTextField(0);
        txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
        txtEmail.setBackground(new Color(255, 0, 0));
        txtEmail.setBounds(713, 281, 480, 64);
        contentPane.add(txtEmail);
        
        JButton bntEntrar = new JButton("Entrar");
        bntEntrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String email = txtEmail.getText();
        		String senha = txtSenha.getText();
        		try {
        			Token token = autenticadorClient.getTokenPela(new CredencialDeAcesso(email, senha));
        			System.out.println(token.getValor());
        		} catch (Exception e2) {
					JOptionPane.showMessageDialog(bntEntrar, "Email e/ou senha invalidos. ");
				}
        	}
        });
        bntEntrar.setForeground(new Color(255, 255, 255));
        bntEntrar.setBorder(null);
        bntEntrar.setBorderPainted(false);
        bntEntrar.setBackground(new Color(120,116,116));
        bntEntrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        bntEntrar.setBounds(1055, 499, 126, 39);
        contentPane.add(bntEntrar);
        
        JLabel lblNewLabel_1_1 = new JLabel("Digite sua senha:");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
        lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNewLabel_1_1.setBounds(713, 371, 184, 17);
        contentPane.add(lblNewLabel_1_1);
        
        JLabel lblEmail = new JLabel("Digite seu email:");
        lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblEmail.setBounds(713, 254, 184, 30);
        contentPane.add(lblEmail);

        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setForeground(new Color(255, 255, 255));
        lblNewLabel.setIcon(new ImageIcon(TelaLogin.class.getResource("./telaLogin.png")));
        lblNewLabel.setBounds(0, 0, 1259, 729);
        contentPane.add(lblNewLabel);
    }
}
