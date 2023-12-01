package br.com.senai.gestaoDeCadastroFront.views.cadastros;

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
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.gestaoDeCadastroFront.client.EnderecoClient;
import br.com.senai.gestaoDeCadastroFront.client.authenticate.server.CredencialDeAcesso;
import br.com.senai.gestaoDeCadastroFront.components.RoundJTextField;
import br.com.senai.gestaoDeCadastroFront.dto.ClienteDto;
import br.com.senai.gestaoDeCadastroFront.dto.NovoEnderecoDto;
import br.com.senai.gestaoDeCadastroFront.views.ViewPrincipal;

@Component
public class ViewEndereco extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private ClienteDto clienteDto;

	@Autowired
	private EnderecoClient enderecoClient;

	public void abrirTela(ClienteDto clienteDto) {
		this.clienteDto = clienteDto;
		this.setVisible(true);
	}

	@Autowired
	@Lazy
	private ViewPrincipal viewPrincipal;
	
	public ViewEndereco() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		RoundJTextField txtNome = new RoundJTextField(0);
		txtNome.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNome = new JLabel("Nome:");
		lblNome.setForeground(Color.WHITE);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 20));

		RoundJTextField txtCep = new RoundJTextField(0);
		txtCep.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblCep = new JLabel("Cep:");
		lblCep.setForeground(Color.WHITE);
		lblCep.setFont(new Font("Tahoma", Font.PLAIN, 20));

		RoundJTextField txtRua = new RoundJTextField(0);
		txtRua.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblRua = new JLabel("Rua:");
		lblRua.setForeground(Color.WHITE);
		lblRua.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setForeground(Color.WHITE);
		lblBairro.setFont(new Font("Tahoma", Font.PLAIN, 20));

		RoundJTextField txtBairro = new RoundJTextField(0);
		txtBairro.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setForeground(Color.WHITE);
		lblCidade.setFont(new Font("Tahoma", Font.PLAIN, 20));

		RoundJTextField txtCidade = new RoundJTextField(0);
		txtCidade.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblEstado = new JLabel("Estado:");
		lblEstado.setForeground(Color.WHITE);
		lblEstado.setFont(new Font("Tahoma", Font.PLAIN, 20));

		RoundJTextField txtEstado = new RoundJTextField(0);
		txtEstado.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNumeroDaCasa = new JLabel("Numero da casa:");
		lblNumeroDaCasa.setForeground(Color.WHITE);
		lblNumeroDaCasa.setFont(new Font("Tahoma", Font.PLAIN, 20));

		RoundJTextField txtNumeroDaCasa = new RoundJTextField(0);
		txtNumeroDaCasa.setHorizontalAlignment(SwingConstants.CENTER);

		JTextPane textComplemento = new JTextPane();

		JLabel lblComplemento = new JLabel("Complemento:");
		lblComplemento.setForeground(Color.WHITE);
		lblComplemento.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JButton btnSalvar = new JButton("Salvar");
		btnSalvar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnSalvar.setBackground(Color.WHITE);
		btnSalvar.setBorder(null);
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					NovoEnderecoDto dto = new NovoEnderecoDto();
					dto.setNome(txtNome.getText());
					dto.setCep(txtCep.getText());
					dto.setRua(txtRua.getText());
					dto.setBairro(txtBairro.getText());
					dto.setCidade(txtCidade.getText());
					dto.setEstado(txtEstado.getText());
					dto.setNumeroDaCasa(txtNumeroDaCasa.getText());
					dto.setComplemento(textComplemento.getText());
					dto.setClienteDto(clienteDto);
					enderecoClient.inserir(dto);
					CredencialDeAcesso credencialDeAcesso = new CredencialDeAcesso();
					credencialDeAcesso.setEmail(clienteDto.getUsuario().getEmail());
					credencialDeAcesso.setSenha(clienteDto.getUsuario().getSenha());
					viewPrincipal.abrirTela(credencialDeAcesso);
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}

			}
		});

		JLabel lblTitulo = new JLabel("Meu endereco");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 43));
		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane
				.setHorizontalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(
								Alignment.TRAILING,
								gl_contentPane
										.createSequentialGroup().addContainerGap(270, Short.MAX_VALUE)
										.addComponent(
												lblTitulo, GroupLayout.PREFERRED_SIZE, 812,
												GroupLayout.PREFERRED_SIZE)
										.addGap(258))
						.addGroup(gl_contentPane.createSequentialGroup().addGap(24).addGroup(gl_contentPane
								.createParallelGroup(Alignment.LEADING)
								.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, 617, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCidade, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 617, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblBairro, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblRua, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, 617, GroupLayout.PREFERRED_SIZE)
								.addComponent(lblCep, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, 617, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 617,
										GroupLayout.PREFERRED_SIZE)
								.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 193, GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
										.addComponent(lblComplemento, GroupLayout.PREFERRED_SIZE, 193,
												GroupLayout.PREFERRED_SIZE)
										.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
												.addComponent(textComplemento, Alignment.LEADING)
												.addGroup(Alignment.LEADING, gl_contentPane
														.createParallelGroup(Alignment.LEADING, false)
														.addComponent(txtEstado, GroupLayout.DEFAULT_SIZE, 617,
																Short.MAX_VALUE)
														.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 193,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(txtNumeroDaCasa, GroupLayout.DEFAULT_SIZE, 617,
																Short.MAX_VALUE)
														.addComponent(lblNumeroDaCasa, GroupLayout.PREFERRED_SIZE, 193,
																GroupLayout.PREFERRED_SIZE)
														.addComponent(btnSalvar, Alignment.TRAILING,
																GroupLayout.PREFERRED_SIZE, 133,
																GroupLayout.PREFERRED_SIZE))))
								.addGap(47)));
		gl_contentPane.setVerticalGroup(gl_contentPane.createParallelGroup(Alignment.LEADING).addGroup(gl_contentPane
				.createSequentialGroup().addGap(21).addComponent(lblTitulo).addGap(51)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE).addComponent(lblNome)
						.addComponent(lblEstado, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(lblCep, GroupLayout.PREFERRED_SIZE, 24,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(lblNumeroDaCasa, GroupLayout.PREFERRED_SIZE, 24,
												GroupLayout.PREFERRED_SIZE))
								.addGap(6)
								.addGroup(gl_contentPane.createParallelGroup(Alignment.BASELINE)
										.addComponent(txtCep, GroupLayout.PREFERRED_SIZE, 53,
												GroupLayout.PREFERRED_SIZE)
										.addComponent(txtNumeroDaCasa, GroupLayout.PREFERRED_SIZE, 53,
												GroupLayout.PREFERRED_SIZE)))
						.addComponent(txtEstado, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(ComponentPlacement.RELATED)
				.addGroup(
						gl_contentPane.createParallelGroup(Alignment.TRAILING)
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblRua, GroupLayout.PREFERRED_SIZE, 24,
												GroupLayout.PREFERRED_SIZE)
										.addGap(6))
								.addGroup(gl_contentPane.createSequentialGroup()
										.addComponent(lblComplemento, GroupLayout.PREFERRED_SIZE, 24,
												GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(ComponentPlacement.UNRELATED)))
				.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
						.addGroup(gl_contentPane.createSequentialGroup()
								.addComponent(txtRua, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblBairro, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtBairro, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(lblCidade, GroupLayout.PREFERRED_SIZE, 24, GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(ComponentPlacement.UNRELATED)
								.addComponent(txtCidade, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE))
						.addComponent(textComplemento))
				.addGap(42).addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
				.addGap(42)));
		contentPane.setLayout(gl_contentPane);

		setLocationRelativeTo(null);

	}
}
