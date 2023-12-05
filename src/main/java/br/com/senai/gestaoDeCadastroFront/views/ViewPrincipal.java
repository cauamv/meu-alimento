package br.com.senai.gestaoDeCadastroFront.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.gestaoDeCadastroFront.client.authenticate.server.AutenticadorClient;
import br.com.senai.gestaoDeCadastroFront.client.authenticate.server.CredencialDeAcesso;
import br.com.senai.gestaoDeCadastroFront.client.decode.TokenDecoder;
import br.com.senai.gestaoDeCadastroFront.dto.enums.Role;
import br.com.senai.gestaoDeCadastroFront.views.cupons.ViewCupons;
import br.com.senai.gestaoDeCadastroFront.views.pedidos.ViewListagemDePedidos;

@Component
public class ViewPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	@Autowired
	private TokenDecoder decoder;
	
	private String role;
	
	@Autowired
	@Lazy
	private ViewCupons viewCupons;
	
	private String token;
	
	private CredencialDeAcesso credencialDeAcesso;
	
	@Autowired
	private AutenticadorClient autenticadorClient;
	
	@Autowired
	@Lazy
	private ViewListagemDePedidos viewListagemDePedidos;
	
	public void abrirTela(CredencialDeAcesso credencialDeAcesso) {
		this.credencialDeAcesso = credencialDeAcesso;
		this.token = autenticadorClient.getTokenPela(credencialDeAcesso).getValor();
		this.role = decoder.extrairIdRoleDo(token);
		this.setVisible(true);
	}

	public ViewPrincipal() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ViewPrincipal.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/pizza.png")));
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ViewPrincipal.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/brownie.png")));
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(ViewPrincipal.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/hamburguer.png")));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1357, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(10)
							.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
							.addGap(200)
							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 105, Short.MAX_VALUE)
							.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 344, GroupLayout.PREFERRED_SIZE)))
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 455, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
						.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNewLabel_1_1, GroupLayout.PREFERRED_SIZE, 250, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		
		JButton btnPedidos = new JButton("Pedidos");
		btnPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(role);
				if (role.equals(Role.Restaurante.toString())) {
					viewListagemDePedidos.abrirTela(token);
				} else {
					JOptionPane.showMessageDialog(contentPane, "Permissão negada. Apenas restaurantes podem acessar o espaço de pedidos.");
				}
			}
		});
		btnPedidos.setBackground(new Color(255, 255, 255));
		btnPedidos.setBorder(null);
		btnPedidos.setFont(new Font("Tahoma", Font.PLAIN, 22));
		
		JButton btnCupons = new JButton("Cupons");
		btnCupons.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewCupons.abrirTela(token, credencialDeAcesso);
			}
		});
		btnCupons.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCupons.setBorder(null);
		btnCupons.setBackground(Color.WHITE);
		
		JLabel lblMeuGestor = new JLabel("Meu Gestor");
		lblMeuGestor.setHorizontalAlignment(SwingConstants.CENTER);
		lblMeuGestor.setForeground(new Color(255, 255, 255));
		lblMeuGestor.setFont(new Font("Dialog", Font.BOLD, 43));
		
		JSeparator separator = new JSeparator();
		separator.setBackground(new Color(0, 0, 0));
		separator.setForeground(new Color(0, 0, 0));
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(93)
					.addComponent(btnPedidos, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 375, Short.MAX_VALUE)
					.addComponent(btnCupons, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
					.addGap(113))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(534)
					.addComponent(lblMeuGestor, GroupLayout.PREFERRED_SIZE, 285, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(538, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(556)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 242, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(559, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(100)
					.addComponent(lblMeuGestor, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
					.addGap(81)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnPedidos, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnCupons, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(377, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		setLocationRelativeTo(null);
		
		
	}
}
