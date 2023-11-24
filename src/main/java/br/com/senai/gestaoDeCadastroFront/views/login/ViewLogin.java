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
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.gestaoDeCadastroFront.client.authenticate.AutenticadorClient;
import br.com.senai.gestaoDeCadastroFront.components.RoundJTextField;
import br.com.senai.gestaoDeCadastroFront.dto.CredencialDeAcesso;
import br.com.senai.gestaoDeCadastroFront.views.pedidos.gestor.ViewGestorPedidos;

@Component
public class ViewLogin extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    
    @Autowired
    @Lazy
    private ViewGestorPedidos viewGestorPedidos;
    
    @Autowired
    private AutenticadorClient autenticadorClient;
    
    public ViewLogin() {
        setBounds(100, 100, 1366, 768);
        setResizable(false);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        
        JPanel Leftpanel = new JPanel();
        Leftpanel.setBackground(Color.RED);
        Leftpanel.setForeground(Color.RED);
        Leftpanel.setBounds(-15, -21, 654, 782);
        contentPane.add(Leftpanel);
        
        JLabel lblMeuAlimento = new JLabel("Meu Alimento");
        lblMeuAlimento.setForeground(Color.WHITE);
        lblMeuAlimento.setHorizontalAlignment(SwingConstants.CENTER);
        lblMeuAlimento.setFont(new Font("Bitstream Charter", Font.BOLD, 43));
        GroupLayout gl_Leftpanel = new GroupLayout(Leftpanel);
        gl_Leftpanel.setHorizontalGroup(
        	gl_Leftpanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_Leftpanel.createSequentialGroup()
        			.addContainerGap(132, Short.MAX_VALUE)
        			.addComponent(lblMeuAlimento, GroupLayout.PREFERRED_SIZE, 488, GroupLayout.PREFERRED_SIZE)
        			.addGap(34))
        );
        gl_Leftpanel.setVerticalGroup(
        	gl_Leftpanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_Leftpanel.createSequentialGroup()
        			.addGap(51)
        			.addComponent(lblMeuAlimento)
        			.addContainerGap(678, Short.MAX_VALUE))
        );
        Leftpanel.setLayout(gl_Leftpanel);
        
        JPanel rightPanel = new JPanel();
        rightPanel.setBounds(773, 129, 529, 529);
        contentPane.add(rightPanel);
        
        JLabel lblEmail = new JLabel("Digite seu email:");
        lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        RoundJTextField txtEmail = new RoundJTextField(0);
        txtEmail.setForeground(Color.WHITE);
        txtEmail.setColumns(4);
        txtEmail.setHorizontalAlignment(SwingConstants.LEFT);
        txtEmail.setBackground(Color.RED);
        
        JLabel lblSenha = new JLabel("Digite sua senha:");
        lblSenha.setHorizontalAlignment(SwingConstants.LEFT);
        lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
        
        RoundJTextField txtSenha = new RoundJTextField(0);
        txtSenha.setForeground(Color.WHITE);
        txtSenha.setColumns(4);
        txtSenha.setHorizontalAlignment(SwingConstants.LEFT);
        txtSenha.setBackground(Color.RED);
        GroupLayout gl_rightPanel = new GroupLayout(rightPanel);
        
        
        JButton bntCadastrar = new JButton("Novo aqui?");
        bntCadastrar.setForeground(new Color(0, 128, 255));
        bntCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        bntCadastrar.setBorderPainted(false);
        bntCadastrar.setBorder(null);
        bntCadastrar.setBackground(new Color(255, 255, 255));
        
        JButton bntEntrar = new JButton("Entrar");
        bntEntrar.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		String email = txtEmail.getText();
        		String senha = txtSenha.getText();
        		try {
        			autenticadorClient.getTokenPela(new CredencialDeAcesso(email, senha));
        			viewGestorPedidos.abrirTela();
        		} catch (Exception e2) {
					JOptionPane.showMessageDialog(contentPane, "Email e/ou senha invalidos. ");
				}
        	}
        });
        bntEntrar.setForeground(new Color(255, 255, 255));
        bntEntrar.setBorder(null);
        bntEntrar.setBorderPainted(false);
        bntEntrar.setBackground(new Color(120,116,116));
        bntEntrar.setFont(new Font("Tahoma", Font.PLAIN, 18));
        
        gl_rightPanel.setHorizontalGroup(
        	gl_rightPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_rightPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(333, Short.MAX_VALUE))
        		.addGroup(gl_rightPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(37, Short.MAX_VALUE))
        		.addGroup(gl_rightPanel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(333, Short.MAX_VALUE))
        		.addGroup(gl_rightPanel.createSequentialGroup()
        			.addContainerGap()
        			.addGroup(gl_rightPanel.createParallelGroup(Alignment.TRAILING)
        				.addComponent(bntEntrar, GroupLayout.PREFERRED_SIZE, 126, GroupLayout.PREFERRED_SIZE)
        				.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, 480, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(37, Short.MAX_VALUE))
        		.addGroup(Alignment.TRAILING, gl_rightPanel.createSequentialGroup()
        			.addContainerGap(380, Short.MAX_VALUE)
        			.addComponent(bntCadastrar)
        			.addGap(49))
        );
        gl_rightPanel.setVerticalGroup(
        	gl_rightPanel.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_rightPanel.createSequentialGroup()
        			.addContainerGap(91, Short.MAX_VALUE)
        			.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
        			.addGap(28)
        			.addComponent(lblSenha)
        			.addGap(42)
        			.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
        			.addGap(55)
        			.addComponent(bntEntrar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        			.addGap(40)
        			.addComponent(bntCadastrar)
        			.addGap(22))
        );
        rightPanel.setLayout(gl_rightPanel);
        
        JLabel lblMeuLogin = new JLabel("Meu Login");
        lblMeuLogin.setHorizontalAlignment(SwingConstants.CENTER);
        lblMeuLogin.setFont(new Font("Bitstream Charter", Font.BOLD, 43));
        lblMeuLogin.setBounds(657, 24, 697, 58);
        contentPane.add(lblMeuLogin);
    }
}
