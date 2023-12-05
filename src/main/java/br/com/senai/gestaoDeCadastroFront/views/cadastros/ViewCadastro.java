package br.com.senai.gestaoDeCadastroFront.views.cadastros;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.DefaultComboBoxModel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.gestaoDeCadastroFront.components.RoundJTextField;
import br.com.senai.gestaoDeCadastroFront.dto.NovoClienteDto;
import br.com.senai.gestaoDeCadastroFront.dto.UsuarioDto;
import br.com.senai.gestaoDeCadastroFront.views.login.ViewLogin;

@Component
public class ViewCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	@Autowired
	@Lazy
	ViewSenha telaSenha;

	@Autowired
	private ViewLogin viewLogin;
	
	private MaskFormatter dateFormatter;

	public ViewCadastro() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
 
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panelDireito = new JPanel();
		panelDireito.setBackground(Color.RED);
		panelDireito.setBounds(667, 0, 683, 768);
		contentPane.add(panelDireito);

		RoundJTextField txtNome = new RoundJTextField(0);
		txtNome.setHorizontalAlignment(SwingConstants.CENTER);
		txtNome.setForeground(Color.BLACK);
		txtNome.setBackground(Color.WHITE);

		JLabel lblNome = new JLabel("Digite seu nome:");
		lblNome.setForeground(new Color(255, 255, 255));
		lblNome.setHorizontalAlignment(SwingConstants.LEFT);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JLabel lblMeuCadastro = new JLabel("Meu Cadastro");
		lblMeuCadastro.setForeground(Color.WHITE);
		lblMeuCadastro.setHorizontalAlignment(SwingConstants.CENTER);
		lblMeuCadastro.setFont(new Font("Tahoma", Font.BOLD, 43));

		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setHorizontalAlignment(SwingConstants.LEFT);
		lblSexo.setForeground(Color.WHITE);
		lblSexo.setFont(new Font("Tahoma", Font.PLAIN, 14));

		JComboBox<String> cbxSexo = new JComboBox<String>();
		cbxSexo.setModel(new DefaultComboBoxModel<String>(new String[] { "", "F", "M" }));
		cbxSexo.setFont(new Font("Arial", Font.PLAIN, 16));
		cbxSexo.setForeground(Color.BLACK);

		JLabel lblDataNascimento = new JLabel("Digite sua data de nascimento:");
		lblDataNascimento.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataNascimento.setForeground(Color.WHITE);
		lblDataNascimento.setFont(new Font("Tahoma", Font.PLAIN, 14));

		try {
			dateFormatter = new MaskFormatter("##/##/####");
		} catch (Exception e) {
			e.printStackTrace();
		}
		JFormattedTextField txtDataNascimento = new JFormattedTextField(dateFormatter);
		txtDataNascimento.setHorizontalAlignment(SwingConstants.CENTER);
		txtDataNascimento.setForeground(Color.BLACK);
		txtDataNascimento.setBackground(Color.WHITE);

		JLabel lblDigiteSeuEmail = new JLabel("Digite seu email:");
		lblDigiteSeuEmail.setHorizontalAlignment(SwingConstants.LEFT);
		lblDigiteSeuEmail.setForeground(Color.WHITE);
		lblDigiteSeuEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));

		RoundJTextField txtEmail = new RoundJTextField(0);
		txtEmail.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmail.setForeground(Color.BLACK);
		txtEmail.setBackground(Color.WHITE);

		JLabel lblNomeObrigatorio = new JLabel("O nome é obrigatório.");
		lblNomeObrigatorio.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeObrigatorio.setForeground(Color.WHITE);
		lblNomeObrigatorio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNomeObrigatorio.setVisible(false);
		
		JLabel lblSexoObrigatorio = new JLabel("O sexo é obrigatório.");
		lblSexoObrigatorio.setHorizontalAlignment(SwingConstants.LEFT);
		lblSexoObrigatorio.setForeground(Color.WHITE);
		lblSexoObrigatorio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSexoObrigatorio.setVisible(false);
		
		JLabel lblDataNascimentoObrigatorio = new JLabel("A data de nascimento é obrigatória.");
		lblDataNascimentoObrigatorio.setHorizontalAlignment(SwingConstants.LEFT);
		lblDataNascimentoObrigatorio.setForeground(Color.WHITE);
		lblDataNascimentoObrigatorio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblDataNascimentoObrigatorio.setVisible(false);
		
		JLabel lblEmailObrigatorio = new JLabel("O e-mail é obrigatório.");
		lblEmailObrigatorio.setHorizontalAlignment(SwingConstants.LEFT);
		lblEmailObrigatorio.setForeground(Color.WHITE);
		lblEmailObrigatorio.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblEmailObrigatorio.setVisible(false);
		
		JButton btnProximo = new JButton("Próximo");
		btnProximo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					String nome = txtNome.getText();
					String sexo = cbxSexo.getSelectedItem().toString();
			        DateTimeFormatter formatterEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					DateTimeFormatter formatterSaida = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					String dataString = LocalDate.parse(txtDataNascimento.getText().toString(), formatterEntrada).format(formatterSaida);
					LocalDate data = LocalDate.parse(dataString);
					String email = txtEmail.getText();
					
					if (nome.isBlank()) {
						lblNomeObrigatorio.setVisible(true);
					} else {
						lblNomeObrigatorio.setVisible(false);
					}
					if (sexo == null) {
						lblSexoObrigatorio.setVisible(true);
					} else {
						lblSexoObrigatorio.setVisible(false);
					}
					if (data == null) {
						lblDataNascimentoObrigatorio.setVisible(true);
					} else {
						lblDataNascimentoObrigatorio.setVisible(false);
					}
					if (email.isBlank()) {
						lblEmailObrigatorio.setVisible(true);
					} else {
						lblEmailObrigatorio.setVisible(false);
					}
					
					if (nome != null
					&& !nome.isBlank()
					&& sexo != null
					&& data != null
					&& email != null) {
						UsuarioDto usuarioDto = new UsuarioDto();
						usuarioDto.setEmail(email);
						usuarioDto.setRole("Administrador");
						NovoClienteDto cadastroDto = new NovoClienteDto(nome, sexo, data, usuarioDto);

						telaSenha.mostrarTela(cadastroDto);
						dispose();
					} 
					
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, "Todos os campos são obrigatórios. ");
					ex.printStackTrace();
				}

			}
		});
		btnProximo.setBackground(new Color(255, 255, 255));
		btnProximo.setBorder(null);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewLogin.setVisible(true);
				dispose();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnVoltar.setBorder(null);
		btnVoltar.setBackground(Color.WHITE);

		GroupLayout gl_panelDireito = new GroupLayout(panelDireito);
		gl_panelDireito.setHorizontalGroup(
			gl_panelDireito.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panelDireito.createSequentialGroup()
					.addContainerGap(191, Short.MAX_VALUE)
					.addComponent(lblMeuCadastro)
					.addGap(193))
				.addGroup(gl_panelDireito.createSequentialGroup()
					.addGap(60)
					.addGroup(gl_panelDireito.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_panelDireito.createSequentialGroup()
							.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED, 307, Short.MAX_VALUE)
							.addComponent(btnProximo, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE))
						.addComponent(lblNome, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtNome, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
						.addComponent(lblSexo, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
						.addComponent(cbxSexo, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 151, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDataNascimento, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 551, Short.MAX_VALUE)
						.addComponent(txtDataNascimento, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDigiteSeuEmail, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
						.addComponent(txtEmail, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblNomeObrigatorio, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblSexoObrigatorio, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 184, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblDataNascimentoObrigatorio, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE)
						.addComponent(lblEmailObrigatorio, Alignment.LEADING, GroupLayout.PREFERRED_SIZE, 551, GroupLayout.PREFERRED_SIZE))
					.addGap(72))
		);
		gl_panelDireito.setVerticalGroup(
			gl_panelDireito.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelDireito.createSequentialGroup()
					.addGap(49)
					.addComponent(lblMeuCadastro)
					.addGap(18)
					.addComponent(lblNome, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtNome, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblNomeObrigatorio, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSexo, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(cbxSexo, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblSexoObrigatorio, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDataNascimento, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addComponent(txtDataNascimento, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDataNascimentoObrigatorio, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblDigiteSeuEmail, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEmailObrigatorio, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
					.addGap(64)
					.addGroup(gl_panelDireito.createParallelGroup(Alignment.LEADING)
						.addComponent(btnProximo, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnVoltar, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addContainerGap(13, Short.MAX_VALUE))
		);
		panelDireito.setLayout(gl_panelDireito);

		JLabel lblMeuAlimento = new JLabel("Meu Alimento");
		lblMeuAlimento.setHorizontalAlignment(SwingConstants.CENTER);
		lblMeuAlimento.setForeground(Color.BLACK);
		lblMeuAlimento.setFont(new Font("Tahoma", Font.BOLD, 43));
		lblMeuAlimento.setBounds(135, 42, 344, 55);
		contentPane.add(lblMeuAlimento);
		
		JLabel lblImage1 = new JLabel("");
		lblImage1.setHorizontalAlignment(SwingConstants.LEFT);
		lblImage1.setIcon(new ImageIcon(ViewCadastro.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/hamburguer.png")));
		lblImage1.setBounds(78, 135, 223, 204);
		contentPane.add(lblImage1);
		
		JLabel lblImage2 = new JLabel("");
		lblImage2.setIcon(new ImageIcon(ViewCadastro.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/pizza.png")));
		lblImage2.setHorizontalAlignment(SwingConstants.LEFT);
		lblImage2.setBounds(313, 280, 299, 265);
		contentPane.add(lblImage2);
		
		JLabel lblImage3 = new JLabel("");
		lblImage3.setIcon(new ImageIcon(ViewCadastro.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/brownie.png")));
		lblImage3.setHorizontalAlignment(SwingConstants.LEFT);
		lblImage3.setBounds(78, 434, 241, 190);
		contentPane.add(lblImage3);

		setLocationRelativeTo(null);
	}
}