package br.com.senai.gestaoDeCadastroFront.views.login;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
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
import javax.swing.JPasswordField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.gestaoDeCadastroFront.client.authenticate.server.CredencialDeAcesso;
import br.com.senai.gestaoDeCadastroFront.components.RoundJTextField;
import br.com.senai.gestaoDeCadastroFront.views.ViewPrincipal;
import br.com.senai.gestaoDeCadastroFront.views.cadastros.ViewCadastro;

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

	public ViewLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		lblEmail.setFont(new Font("Dialog", Font.BOLD, 18));

		RoundJTextField txtEmail = new RoundJTextField(0);
		txtEmail.setCaretColor(Color.RED);
		txtEmail.setBorder(null);
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setColumns(4);
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setBackground(Color.WHITE);

		JLabel lblSenha = new JLabel("Digite sua senha:");
		lblSenha.setForeground(Color.WHITE);
		lblSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenha.setFont(new Font("Dialog", Font.BOLD, 18));

		JPasswordField txtSenha = new RoundJPasswordField();
		txtSenha.setBorder(null);
		txtSenha.setForeground(Color.BLACK);
		txtSenha.setColumns(4);
		txtSenha.setHorizontalAlignment(SwingConstants.CENTER);
		txtSenha.setBackground(Color.WHITE);
		
		JLabel lblSenhaObrigatoria = new JLabel("A senha é obrigatória");
		lblSenhaObrigatoria.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblSenhaObrigatoria.setForeground(Color.WHITE);
		lblSenhaObrigatoria.setVisible(false);

		JLabel lblEmailObrigatorio = new JLabel("O email é obrigatório");
		lblEmailObrigatorio.setForeground(Color.WHITE);
		lblEmailObrigatorio.setFont(new Font("Dialog", Font.PLAIN, 14));
		lblEmailObrigatorio.setVisible(false);

		JButton bntEntrar = new JButton("Entrar");
		bntEntrar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				try {
					
					String email = txtEmail.getText();
					String senha = new String(txtSenha.getPassword());
					
					if (email.isBlank()) {
						lblEmailObrigatorio.setVisible(true);
					} else {
						lblEmailObrigatorio.setVisible(false);
					}
					if (senha.isBlank()) {
						lblSenhaObrigatoria.setVisible(true);
					} else {
						lblSenhaObrigatoria.setVisible(false);
					}
					
					if (!email.isBlank() && !senha.isBlank()) {
						viewGestor.abrirTela(new CredencialDeAcesso(email, senha));
						dispose();
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(contentPane, "Email e/ou senha incorretos");
				}
			}

		});
		bntEntrar.setForeground(Color.BLACK);
		bntEntrar.setBorder(null);
		bntEntrar.setBorderPainted(false);
		bntEntrar.setBackground(Color.WHITE);
		bntEntrar.setFont(new Font("Tahoma", Font.PLAIN, 18));

		JLabel lblMeuLogin = new JLabel("Meu Login");
		lblMeuLogin.setFont(new Font("Tahoma", Font.BOLD, 43));
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
		gl_rightPanel.setHorizontalGroup(gl_rightPanel.createParallelGroup(Alignment.LEADING).addGroup(gl_rightPanel
				.createSequentialGroup()
				.addGroup(gl_rightPanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_rightPanel.createSequentialGroup().addGap(170).addComponent(lblMeuLogin,
								GroupLayout.PREFERRED_SIZE, 357, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_rightPanel.createSequentialGroup().addGap(28).addGroup(gl_rightPanel
								.createParallelGroup(Alignment.LEADING)
								.addComponent(bntEntrar, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 126,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(btnNovoAqui, Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 126,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
								.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 406, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtSenha, GroupLayout.DEFAULT_SIZE, 629, Short.MAX_VALUE)
								.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblEmailObrigatorio, GroupLayout.PREFERRED_SIZE, 195,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblSenhaObrigatoria, GroupLayout.PREFERRED_SIZE, 195,
										GroupLayout.PREFERRED_SIZE))))
				.addContainerGap(26, Short.MAX_VALUE)));
		gl_rightPanel.setVerticalGroup(gl_rightPanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_rightPanel.createSequentialGroup().addGap(66).addComponent(lblMeuLogin).addGap(74)
						.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.UNRELATED)
						.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 64, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblEmailObrigatorio, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGap(27).addComponent(lblSenha).addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtSenha, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(lblSenhaObrigatoria, GroupLayout.PREFERRED_SIZE, 27, GroupLayout.PREFERRED_SIZE)
						.addGap(33).addComponent(bntEntrar, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addGap(104)
						.addComponent(btnNovoAqui, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
						.addGap(118)));
		rightPanel.setLayout(gl_rightPanel);

		JLabel lblMeuAlimento = new JLabel("Meu Alimento");
		lblMeuAlimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblMeuAlimento.setForeground(Color.BLACK);
		lblMeuAlimento.setFont(new Font("Tahoma", Font.BOLD, 43));
		lblMeuAlimento.setBounds(116, 49, 357, 55);
		contentPane.add(lblMeuAlimento);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(
				new ImageIcon(ViewLogin.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/hamburguer.png")));
		lblNewLabel.setBounds(37, 201, 229, 219);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(
				new ImageIcon(ViewLogin.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/pizza.png")));
		lblNewLabel_1.setBounds(296, 285, 279, 250);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(
				new ImageIcon(ViewLogin.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/brownie.png")));
		lblNewLabel_1_1.setBounds(39, 471, 279, 250);
		contentPane.add(lblNewLabel_1_1);
		setLocationRelativeTo(null);
	}
}

	class RoundJPasswordField extends JPasswordField {
	
		private static final long serialVersionUID = 1L;
	
		public RoundJPasswordField() {
			super();
			setOpaque(false);
		}
	
		@Override
		protected void paintComponent(Graphics g) {
			Graphics2D g2d = (Graphics2D) g.create();
			g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			g2d.setColor(getBackground());
			g2d.fillRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 40, 40);
			super.paintComponent(g2d);
			g2d.dispose();
		}
	}