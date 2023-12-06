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

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
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
	
	@Autowired
	@Lazy
	private ViewCadastro viewCadastro;

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

		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);

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
				String senha1 = new String(txtfSenha1.getPassword());
				String senha2 = new String(txtfConfirmeSenha.getPassword());
				boolean isSenha1Invalida = senha1.isBlank() || senha1.length() < 3;
				boolean isSenha2Invalida = senha2.isBlank() || senha2.length() < 3;
				if (isSenha1Invalida || isSenha2Invalida) {
					JOptionPane.showMessageDialog(contentPane, "As senhas são obrigatórias.");
				} else {
					if (txtfSenha1.getPassword() != null && txtfConfirmeSenha.getPassword() != null) {
						if (!String.valueOf(txtfConfirmeSenha.getPassword()).equals(String.valueOf(txtfSenha1.getPassword()))) {
							JOptionPane.showMessageDialog(contentPane, "senhas não conferem. ");
						}
						cadastroDto.getUsuario().setSenha(String.valueOf(txtfConfirmeSenha.getPassword()));
						ClienteDto clienteDto = clienteClient.inserir(cadastroDto);
						viewEndereco.abrirTela(clienteDto);
						dispose();
					} else {
						JOptionPane.showMessageDialog(contentPane, "Todos os campos são obrigatórios");
					}
				}
				
				
				
			}
		});

		JLabel lblNewLabel = new JLabel("Minha Senha");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 43));
		lblNewLabel.setForeground(Color.WHITE);

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
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewCadastro.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setForeground(Color.BLACK);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnVoltar.setBorder(null);
		btnVoltar.setBackground(Color.WHITE);
		
		JLabel label = new JLabel("");

		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(208)
							.addComponent(lblNewLabel))
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(81)
							.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
								.addComponent(lblConfirmeSenha, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtfSenha1, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
								.addComponent(label)
								.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
										.addComponent(btnProximo, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
									.addComponent(txtfConfirmeSenha, GroupLayout.PREFERRED_SIZE, 516, GroupLayout.PREFERRED_SIZE)
									.addComponent(chkMostrarSenha2, Alignment.LEADING))
								.addComponent(chkMostrarSenha1))))
					.addContainerGap(86, Short.MAX_VALUE))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(60)
							.addComponent(lblNewLabel)
							.addGap(38)
							.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_panel.createSequentialGroup()
							.addContainerGap()
							.addComponent(label)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtfSenha1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(chkMostrarSenha1)
					.addGap(69)
					.addComponent(lblConfirmeSenha, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtfConfirmeSenha, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(chkMostrarSenha2)
					.addGap(160)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnProximo, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
					.addGap(82))
		);
		panel.setLayout(gl_panel);

		JLabel lblMeuAlimento = new JLabel("Meu Alimento");
		lblMeuAlimento.setForeground(Color.BLACK);
		lblMeuAlimento.setFont(new Font("Tahoma", Font.BOLD, 43));

		JLabel lblImage1 = new JLabel("");
		lblImage1.setIcon(
				new ImageIcon(ViewSenha.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/hamburguer.png")));
		lblImage1.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblImage2 = new JLabel("");
		lblImage2.setIcon(
				new ImageIcon(ViewSenha.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/pizza.png")));
		lblImage2.setHorizontalAlignment(SwingConstants.LEFT);

		JLabel lblImage3 = new JLabel("");
		lblImage3.setIcon(
				new ImageIcon(ViewSenha.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/brownie.png")));
		lblImage3.setHorizontalAlignment(SwingConstants.LEFT);
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(144)
							.addComponent(lblMeuAlimento, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
								.addComponent(lblImage1, GroupLayout.PREFERRED_SIZE, 241, GroupLayout.PREFERRED_SIZE)
								.addGroup(gl_contentPane.createSequentialGroup()
									.addGap(27)
									.addComponent(lblImage3, GroupLayout.PREFERRED_SIZE, 214, GroupLayout.PREFERRED_SIZE)))
							.addGap(64)
							.addComponent(lblImage2, GroupLayout.PREFERRED_SIZE, 273, GroupLayout.PREFERRED_SIZE)))
					.addGap(79)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(61)
					.addComponent(lblMeuAlimento, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblImage1, GroupLayout.PREFERRED_SIZE, 215, GroupLayout.PREFERRED_SIZE)
							.addGap(61)
							.addComponent(lblImage3, GroupLayout.PREFERRED_SIZE, 191, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGap(105)
							.addComponent(lblImage2, GroupLayout.PREFERRED_SIZE, 275, GroupLayout.PREFERRED_SIZE))))
				.addComponent(panel, GroupLayout.PREFERRED_SIZE, 768, GroupLayout.PREFERRED_SIZE)
		);
		contentPane.setLayout(gl_contentPane);

		setLocationRelativeTo(null);
	}
}