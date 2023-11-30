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
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.gestaoDeCadastroFront.client.ClienteClient;
import br.com.senai.gestaoDeCadastroFront.components.RoundJTextField;
import br.com.senai.gestaoDeCadastroFront.dto.ClienteDto;
import br.com.senai.gestaoDeCadastroFront.dto.NovoClienteDto;
import jakarta.annotation.PostConstruct;
import javax.swing.ImageIcon;

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

	@PostConstruct
	public void inicializador() {

	}

	public void mostrarTela(NovoClienteDto cadastroDto) {
		this.cadastroDto = cadastroDto;
		this.setVisible(true);
	}

	public ViewSenha() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(667, 0, 683, 768);
		contentPane.add(panel);

		RoundJTextField txtfConfirmeSenha = new RoundJTextField(0);
		txtfConfirmeSenha.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblConfirmeSenha = new JLabel("Confirme sua senha:");
		lblConfirmeSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblConfirmeSenha.setForeground(Color.WHITE);
		lblConfirmeSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));

		RoundJTextField txtfSenha1 = new RoundJTextField(0);
		txtfSenha1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblSenha = new JLabel("Digite sua senha:");
		lblSenha.setForeground(new Color(255, 255, 255));
		lblSenha.setHorizontalAlignment(SwingConstants.LEFT);
		lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));

		JButton btnProximo = new JButton("Próximo");
		btnProximo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnProximo.setBorder(null);
		btnProximo.setBackground(Color.WHITE);
		btnProximo.setForeground(Color.BLACK);
		btnProximo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					if (!txtfConfirmeSenha.getText().equals(txtfSenha1.getText())) {
						JOptionPane.showMessageDialog(contentPane, "senhas não conferem. ");
					}
					cadastroDto.getUsuario().setSenha(txtfConfirmeSenha.getText());
					ClienteDto clienteDto =  clienteClient.inserir(cadastroDto);
					viewEndereco.abrirTela(clienteDto);
					dispose();
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(contentPane, ex.getMessage());
				}
			}
		});
		btnProximo.setRolloverEnabled(true);

		JLabel lblNewLabel = new JLabel("Minha Senha");
		lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 43));
		lblNewLabel.setForeground(Color.WHITE);
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
						.addGroup(gl_panel.createSequentialGroup().addGap(208).addComponent(lblNewLabel)))
				.addContainerGap(86, Short.MAX_VALUE)));
		gl_panel.setVerticalGroup(gl_panel.createParallelGroup(Alignment.LEADING).addGroup(Alignment.TRAILING, gl_panel
				.createSequentialGroup().addGap(60).addComponent(lblNewLabel)
				.addPreferredGap(ComponentPlacement.RELATED, 144, Short.MAX_VALUE)
				.addComponent(lblSenha, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE).addGap(26)
				.addComponent(txtfSenha1, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE).addGap(66)
				.addComponent(lblConfirmeSenha, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE).addGap(18)
				.addComponent(txtfConfirmeSenha, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE).addGap(108)
				.addComponent(btnProximo, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE).addGap(85)));
		panel.setLayout(gl_panel);

		JLabel lblMeuAlimento = new JLabel("Meu Alimento");
		lblMeuAlimento.setForeground(Color.BLACK);
		lblMeuAlimento.setFont(new Font("Dialog", Font.BOLD, 43));
		lblMeuAlimento.setBounds(154, 61, 344, 55);
		contentPane.add(lblMeuAlimento);
		
		JLabel lblImage1 = new JLabel("");
		lblImage1.setIcon(new ImageIcon(ViewSenha.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/hamburguer.png")));
		lblImage1.setHorizontalAlignment(SwingConstants.LEFT);
		lblImage1.setBounds(10, 127, 241, 215);
		contentPane.add(lblImage1);
		
		JLabel lblImage2 = new JLabel("");
		lblImage2.setIcon(new ImageIcon(ViewSenha.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/pizza.png")));
		lblImage2.setHorizontalAlignment(SwingConstants.LEFT);
		lblImage2.setBounds(315, 232, 273, 275);
		contentPane.add(lblImage2);
		
		JLabel lblImage3 = new JLabel("");
		lblImage3.setIcon(new ImageIcon(ViewSenha.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/brownie.png")));
		lblImage3.setHorizontalAlignment(SwingConstants.LEFT);
		lblImage3.setBounds(37, 403, 214, 191);
		contentPane.add(lblImage3);

		setLocationRelativeTo(null);
	}
}
