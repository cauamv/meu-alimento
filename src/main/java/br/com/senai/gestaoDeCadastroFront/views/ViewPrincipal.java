package br.com.senai.gestaoDeCadastroFront.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.gestaoDeCadastroFront.client.authenticate.server.CredencialDeAcesso;
import br.com.senai.gestaoDeCadastroFront.client.decode.TokenDecoder;
import br.com.senai.gestaoDeCadastroFront.dto.enums.Role;
import br.com.senai.gestaoDeCadastroFront.views.cupons.ViewCupons;

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
	
	public void abrirTela(String token, CredencialDeAcesso credencialDeAcesso) {
		this.token = token;
		this.credencialDeAcesso = credencialDeAcesso;
		this.role = decoder.extrairIdRoleDo(token);
		this.setVisible(true);
	}

	public ViewPrincipal() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 1357, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_contentPane.createSequentialGroup()
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 596, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(125, Short.MAX_VALUE))
		);
		
		JButton btnPedidos = new JButton("Pedidos");
		btnPedidos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (role.equals(Role.Administrador.toString()) || role.equals(Role.Restaurante.toString())) {
					JOptionPane.showMessageDialog(contentPane, "Permitido");
				} else {
					JOptionPane.showMessageDialog(contentPane, "Permissão negada.");
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
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addGap(95)
					.addComponent(btnPedidos, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 339, Short.MAX_VALUE)
					.addComponent(btnCupons, GroupLayout.PREFERRED_SIZE, 388, GroupLayout.PREFERRED_SIZE)
					.addGap(147))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(219)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnCupons, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnPedidos, GroupLayout.PREFERRED_SIZE, 93, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(162, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
		contentPane.setLayout(gl_contentPane);
		
		setLocationRelativeTo(null);
		
		
	}
}
