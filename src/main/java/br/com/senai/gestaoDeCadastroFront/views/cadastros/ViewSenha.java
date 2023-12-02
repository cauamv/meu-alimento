package br.com.senai.gestaoDeCadastroFront.views.cadastros;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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

import br.com.senai.gestaoDeCadastroFront.client.ClienteClient;
import br.com.senai.gestaoDeCadastroFront.dto.ClienteDto;
import br.com.senai.gestaoDeCadastroFront.dto.NovoClienteDto;
import jakarta.annotation.PostConstruct;

@Component
public class ViewSenha extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private NovoClienteDto cadastroDto;

	@Autowired
	@Lazy
	private ViewEndereco viewEndereco;

	@Autowired
	private ClienteClient clienteClient;

	private JPasswordField txtfConfirmeSenha;
	private JPasswordField txtfSenha1;

	@PostConstruct
	public void inicializador() {

	}

	public void mostrarTela(NovoClienteDto cadastroDto) {
		this.cadastroDto = cadastroDto;
		this.setVisible(true);
	}

	public ViewSenha() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(667, 0, 683, 768);
		contentPane.add(panel);

		txtfSenha1 = new JPasswordField();
		txtfSenha1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblSenha = new JLabel("Digite sua senha:");
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));

		txtfConfirmeSenha = new JPasswordField();
		txtfConfirmeSenha.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblConfirmeSenha = new JLabel("Confirme sua senha:");
		lblConfirmeSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmeSenha.setForeground(Color.WHITE);
		lblConfirmeSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnProximo = new JButton("Próximo");
		btnProximo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnProximo.setBorder(null);
		btnProximo.setBackground(Color.WHITE);
		btnProximo.setForeground(Color.BLACK);
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!String.valueOf(txtfConfirmeSenha.getPassword()).equals(String.valueOf(txtfSenha1.getPassword()))) {
					JOptionPane.showMessageDialog(contentPane, "senhas não conferem. ");
				}
				cadastroDto.getUsuario().setSenha(String.valueOf(txtfConfirmeSenha.getPassword()));
				ClienteDto clienteDto = clienteClient.inserir(cadastroDto);
				viewEndereco.abrirTela(clienteDto);
				dispose();

			}
		});

		JLabel lblNewLabel = new JLabel("Minha Senha");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 43));
		lblNewLabel.setForeground(Color.WHITE);

		// Checkboxes para mostrar/ocultar as senhas
		JCheckBox chkMostrarSenha1 = new JCheckBox("Mostrar senha");
		chkMostrarSenha1.setForeground(Color.WHITE);
		chkMostrarSenha1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chkMostrarSenha1.setOpaque(false);
		chkMostrarSenha1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCheckBox source = (JCheckBox) e.getSource();
				txtfSenha1.setEchoChar(source.isSelected() ? '\0' : '*');
			}
		});

		JCheckBox chkMostrarSenha2 = new JCheckBox("Mostrar senha");
		chkMostrarSenha2.setForeground(Color.WHITE);
		chkMostrarSenha2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		chkMostrarSenha2.setOpaque(false);
		chkMostrarSenha2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JCheckBox source = (JCheckBox) e.getSource();
				txtfConfirmeSenha.setEchoChar(source.isSelected() ? '\0' : '*');
			}
		});

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel
				.createSequentialGroup()
				.addGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(gl_panel.createSequentialGroup()
						.addGap(81)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
								.addComponent(btnProximo, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
										.addComponent(lblConfirmeSenha, GroupLayout.PREFERRED_SIZE, 184,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtfConfirmeSenha, GroupLayout.PREFERRED_SIZE, 516,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtfSenha1, GroupLayout.PREFERRED_SIZE, 516,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 184,
												GroupLayout.PREFERRED_SIZE))))
						.addGroup(gl_panel.createSequentialGroup().addGap(208).addComponent(lblNewLabel)).addGroup(
								gl_panel.createSequentialGroup().addGap(81)
										.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
												.addComponent(chkMostrarSenha1).addComponent(chkMostrarSenha2))))
				.addContainerGap(86, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup().addGap(60).addComponent(lblNewLabel)
						.addPreferredGap(ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
						.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE).addGap(26)
						.addComponent(txtfSenha1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(chkMostrarSenha1).addGap(60)
						.addComponent(lblConfirmeSenha, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED)
						.addComponent(txtfConfirmeSenha, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(ComponentPlacement.RELATED).addComponent(chkMostrarSenha2).addGap(60)
						.addComponent(btnProximo, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addGap(85)));
		panel.setLayout(gl_panel);

		JLabel lblMeuAlimento = new JLabel("Meu Alimento");
		lblMeuAlimento.setForeground(Color.BLACK);
		lblMeuAlimento.setFont(new Font("Tahoma", Font.BOLD, 43));
		lblMeuAlimento.setBounds(154, 61, 330, 55);
		contentPane.add(lblMeuAlimento);

		JLabel lblImage1 = new JLabel("");
		lblImage1.setIcon(
				new ImageIcon(ViewSenha.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/hamburguer.png")));
		lblImage1.setHorizontalAlignment(SwingConstants.LEFT);
		lblImage1.setBounds(10, 127, 241, 215);
		contentPane.add(lblImage1);

		JLabel lblImage2 = new JLabel("");
		lblImage2.setIcon(
				new ImageIcon(ViewSenha.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/pizza.png")));
		lblImage2.setHorizontalAlignment(SwingConstants.LEFT);
		lblImage2.setBounds(315, 232, 273, 275);
		contentPane.add(lblImage2);

		JLabel lblImage3 = new JLabel("");
		lblImage3.setIcon(
				new ImageIcon(ViewSenha.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/brownie.png")));
		lblImage3.setHorizontalAlignment(SwingConstants.LEFT);
		lblImage3.setBounds(37, 403, 214, 191);
		contentPane.add(lblImage3);

		setLocationRelativeTo(null);
	}
}