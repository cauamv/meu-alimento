package br.com.senai.gestaoDeCadastroFront.views.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.gestaoDeCadastroFront.client.authenticate.server.AutenticadorClient;
import br.com.senai.gestaoDeCadastroFront.client.authenticate.server.CredencialDeAcesso;
import br.com.senai.gestaoDeCadastroFront.components.RoundJTextField;
import br.com.senai.gestaoDeCadastroFront.views.ViewPrincipal;
import br.com.senai.gestaoDeCadastroFront.views.cadastros.ViewCadastro;
import javax.swing.ImageIcon;

@Component
public class ViewLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    @Autowired
    @Lazy
    private ViewPrincipal viewGestor;
    
    @Autowired
    @Lazy
    private ViewCadastro viewCadastro;
    
    @Autowired
    private AutenticadorClient autenticadorClient;
    
    public ViewLogin() {
        setBounds(100, 100, 1366, 768);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(Color.RED);
        rightPanel.setForeground(Color.RED);
        rightPanel.setBounds(667, 0, 683, 768);
        contentPane.add(rightPanel);
        
        JLabel lblEmail = new JLabel("Digite seu email:");
        lblEmail.setForeground(Color.WHITE);
        lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        RoundJTextField txtEmail = new RoundJTextField(0);
        txtEmail.setForeground(Color.BLACK);
        txtEmail.setColumns(4);
        txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
        txtEmail.setBackground(Color.WHITE);
        
        JLabel lblSenha = new JLabel("Digite sua senha:");
        lblSenha.setForeground(Color.WHITE);
        lblSenha.setHorizontalAlignment(SwingConstants.LEFT);
        lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        JPasswordField txtSenha = new JPasswordField();
        txtSenha.setForeground(Color.BLACK);
        txtSenha.setColumns(4);
        txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
        txtSenha.setBackground(Color.WHITE);
        
        JButton bntEntrar = new JButton("Entrar");
        bntEntrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
        			String email = txtEmail.getText();
        			String senha = new String(txtSenha.getPassword());
        			if (!email.isBlank() && !senha.isBlank()) {
        				String token = autenticadorClient.getTokenPela(new CredencialDeAcesso(email, senha)).getValor();
        				viewGestor.abrirTela(token, new CredencialDeAcesso(email, senha));
        				dispose();
					} else {
	        			JOptionPane.showMessageDialog(contentPane, "Email e senha são obrigatórios. ");
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(contentPane, "Email e/ou senha incorretos");
				}
        	}
        });
        bntEntrar.setForeground(new Color(255, 255, 255));
        bntEntrar.setBorder(null);
        bntEntrar.setBorderPainted(false);
        bntEntrar.setBackground(new Color(120,116,116));
        bntEntrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        JLabel lblMeuLogin = new JLabel("Meu Login");
        lblMeuLogin.setFont(new Font("Dialog", Font.BOLD, 43));
        lblMeuLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblMeuLogin.setForeground(Color.WHITE);
        
        JButton btnNovoAqui = new JButton("Novo aqui?");
        btnNovoAqui.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		viewCadastro.setVisible(true);
        		dispose();
        	}
        });
        btnNovoAqui.setForeground(Color.WHITE);
        btnNovoAqui.setFont(new Font("Tahoma", Font.ITALIC, 18));
        btnNovoAqui.setBorder(null);
        btnNovoAqui.setBackground(Color.RED);
        GroupLayout gl_rightPanel = new GroupLayout(rightPanel);
        gl_rightPanel.setHorizontalGroup(
        	gl_rightPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_rightPanel.createSequentialGroup()
        			.addGroup(gl_rightPanel.createParallelGroup(Alignment.LEADING)
        				.addGroup(gl_rightPanel.createSequentialGroup()
        					.addGap(170)
        					.addComponent(lblMeuLogin, GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE))
        				.addGroup(gl_rightPanel.createSequentialGroup()
        					.addGap(28)
        					.addGroup(gl_rightPanel.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(bntEntrar, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
        						.addComponent(btnNovoAqui, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
        						.addComponent(txtSenha, GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
        						.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
        						.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE))))
        			.addContainerGap(26, Short.MAX_VALUE))
        );
        gl_rightPanel.setVerticalGroup(
        	gl_rightPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_rightPanel.createSequentialGroup()
        			.addGap(66)
        			.addComponent(lblMeuLogin)
        			.addGap(67)
        			.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
        			.addGap(68)
        			.addComponent(lblSenha)
        			.addGap(18)
        			.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
        			.addGap(45)
        			.addComponent(bntEntrar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        			.addGap(104)
        			.addComponent(btnNovoAqui, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        			.addGap(118))
        );
        rightPanel.setLayout(gl_rightPanel);
        
        JLabel lblMeuAlimento = new JLabel("Meu Alimento");
        lblMeuAlimento.setHorizontalAlignment(SwingConstants.CENTER);
        lblMeuAlimento.setForeground(Color.BLACK);
        lblMeuAlimento.setFont(new Font("Dialog", Font.BOLD, 43));
        lblMeuAlimento.setBounds(116, 49, 357, 55);
        contentPane.add(lblMeuAlimento);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon(ViewLogin.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/hamburguer.png")));
        lblNewLabel.setBounds(37, 201, 229, 219);
        contentPane.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon(ViewLogin.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/pizza.png")));
        lblNewLabel_1.setBounds(296, 285, 279, 250);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("");
        lblNewLabel_1_1.setIcon(new ImageIcon(ViewLogin.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/brownie.png")));
        lblNewLabel_1_1.setBounds(39, 471, 279, 250);
        contentPane.add(lblNewLabel_1_1);
        setLocationRelativeTo(null);
    }
}
