package br.com.senai.gestaoDeCadastroFront.views.cupons;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.gestaoDeCadastroFront.client.CuponsClient;
import br.com.senai.gestaoDeCadastroFront.client.authenticate.server.CredencialDeAcesso;
import br.com.senai.gestaoDeCadastroFront.components.RoundJTextField;
import br.com.senai.gestaoDeCadastroFront.dto.Cupom;
import br.com.senai.gestaoDeCadastroFront.dto.NovoCupomDto;
import br.com.senai.gestaoDeCadastroFront.dto.enums.StatusDoCupom;

@Component
public class ViewFormularioCupom extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private MaskFormatter dateFormatter;

	private CredencialDeAcesso credencial;

	@Autowired
	private CuponsClient cuponsClient;

	public void abrirTela(CredencialDeAcesso credencial) {
		this.credencial = credencial;
		this.setVisible(true);
	}

	private JFormattedTextField txtValidade;

	private RoundJTextField txtCodigo;

	private RoundJTextField txtPercentual;
	
	private JButton btnSalvar;
	
	private JButton btnAlternarStatus;

	private Cupom cupom;

	public ViewFormularioCupom() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(Color.RED);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		JLabel lblTitulo = new JLabel("Meu Cupom");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setForeground(Color.WHITE);
		lblTitulo.setFont(new Font("Tahoma", Font.BOLD, 43));

		txtCodigo = new RoundJTextField(0);
		txtCodigo.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblCodigo = new JLabel("Código:");
		lblCodigo.setForeground(Color.WHITE);
		lblCodigo.setFont(new Font("Tahoma", Font.PLAIN, 20));

		JLabel lblValidade = new JLabel("Validade:");
		lblValidade.setForeground(Color.WHITE);
		lblValidade.setFont(new Font("Tahoma", Font.PLAIN, 20));

		try {
			dateFormatter = new MaskFormatter("##/##/####");
		} catch (Exception e) {
			e.printStackTrace();
		}

		txtValidade = new JFormattedTextField(dateFormatter);
		txtValidade.setHorizontalAlignment(SwingConstants.CENTER);
		txtValidade.setForeground(Color.BLACK);
		txtValidade.setBackground(Color.WHITE);

		JLabel lblPercentual = new JLabel("Percentual:");
		lblPercentual.setForeground(Color.WHITE);
		lblPercentual.setFont(new Font("Tahoma", Font.PLAIN, 20));

		txtPercentual = new RoundJTextField(0);
		txtPercentual.setHorizontalAlignment(SwingConstants.CENTER);

		btnSalvar = new JButton("Salvar");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (cupom == null) {
					NovoCupomDto novoCupomDto = new NovoCupomDto();
					novoCupomDto.setCodigo(txtCodigo.getText());
					DateTimeFormatter formatterEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					DateTimeFormatter formatterSaida = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					String dataString = LocalDate.parse(txtValidade.getText().toString(), formatterEntrada)
							.format(formatterSaida);
					LocalDate data = LocalDate.parse(dataString);
					novoCupomDto.setValidade(data);
					novoCupomDto.setPercentualDeDesconto(Double.parseDouble(txtPercentual.getText()));
					novoCupomDto.setStatus(StatusDoCupom.A);
					cuponsClient.inserir(novoCupomDto, credencial);
					JOptionPane.showMessageDialog(contentPane, "Salvou");
					dispose();
				} else {
					cupom.setCodigo(txtCodigo.getText());
					DateTimeFormatter formatterEntrada = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					DateTimeFormatter formatterSaida = DateTimeFormatter.ofPattern("yyyy-MM-dd");
					String dataString = LocalDate.parse(txtValidade.getText(), formatterEntrada).format(formatterSaida);
					LocalDate data = LocalDate.parse(dataString);
					cupom.setValidade(data);
					cupom.setPercentualDeDesconto(Double.parseDouble(txtPercentual.getText()));
					
					cupom.setId(cupom.getId());
					cuponsClient.alterar(cupom, credencial);
					JOptionPane.showMessageDialog(contentPane, "Alterado");
					dispose();
				}
			}
		});
		btnSalvar.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSalvar.setBorder(null);
		btnSalvar.setBackground(Color.WHITE);
		
		btnAlternarStatus = new JButton("");
		btnAlternarStatus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		        if (cupom == null) {
		            return;
		        }

		        int resposta = JOptionPane.showConfirmDialog(contentPane,
		                "Tem certeza que deseja alterar o status do cupom?", "Confirmação",
		                JOptionPane.YES_NO_OPTION);

		        if (resposta == JOptionPane.YES_OPTION) {
		            if (cupom.getStatus() == StatusDoCupom.A) {
		                cupom.setStatus(StatusDoCupom.I);
		                cuponsClient.atualizarPor(cupom.getId(), StatusDoCupom.I, credencial);
		                btnAlternarStatus.setText("Ativar");
		            } else {
		                cupom.setStatus(StatusDoCupom.A);
		            	cuponsClient.atualizarPor(cupom.getId(), StatusDoCupom.A, credencial);
		            	btnAlternarStatus.setText("Inativar");
		            }

		            if (cupom.getStatus() == StatusDoCupom.I) {
		            	dispose();
		                JOptionPane.showMessageDialog(contentPane, "Cupom inativado com sucesso");
		            } else {
		            	dispose();
		            	JOptionPane.showMessageDialog(contentPane, "Cupom ativado com sucesso");
		            }
		        }
		    }
		});
		
		btnAlternarStatus.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnAlternarStatus.setBorder(null);
		btnAlternarStatus.setBackground(Color.WHITE);

		GroupLayout gl_contentPane = new GroupLayout(contentPane);
		gl_contentPane.setHorizontalGroup(
			gl_contentPane.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addContainerGap(367, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.TRAILING)
						.addGroup(gl_contentPane.createSequentialGroup()
							.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING, false)
								.addComponent(lblPercentual, GroupLayout.PREFERRED_SIZE, 617, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtPercentual, GroupLayout.PREFERRED_SIZE, 617, GroupLayout.PREFERRED_SIZE)
								.addComponent(txtValidade)
								.addComponent(txtCodigo, GroupLayout.DEFAULT_SIZE, 617, Short.MAX_VALUE)
								.addComponent(lblValidade, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(lblCodigo)
								.addGroup(Alignment.TRAILING, gl_contentPane.createSequentialGroup()
									.addComponent(btnAlternarStatus, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)
									.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 122, GroupLayout.PREFERRED_SIZE)))
							.addGap(356))
						.addGroup(gl_contentPane.createSequentialGroup()
							.addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 596, GroupLayout.PREFERRED_SIZE)
							.addGap(367))))
		);
		gl_contentPane.setVerticalGroup(
			gl_contentPane.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_contentPane.createSequentialGroup()
					.addGap(75)
					.addComponent(lblTitulo, GroupLayout.PREFERRED_SIZE, 82, GroupLayout.PREFERRED_SIZE)
					.addGap(75)
					.addComponent(lblCodigo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtCodigo, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblValidade, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(txtValidade, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblPercentual, GroupLayout.PREFERRED_SIZE, 25, GroupLayout.PREFERRED_SIZE)
					.addGap(6)
					.addComponent(txtPercentual, GroupLayout.PREFERRED_SIZE, 53, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 135, Short.MAX_VALUE)
					.addGroup(gl_contentPane.createParallelGroup(Alignment.LEADING)
						.addComponent(btnSalvar, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE)
						.addComponent(btnAlternarStatus, GroupLayout.PREFERRED_SIZE, 46, GroupLayout.PREFERRED_SIZE))
					.addGap(42))
		);
		setLocationRelativeTo(null);
		contentPane.setLayout(gl_contentPane);
	}

	public void colocarEmModoInsercao(CredencialDeAcesso credencial) {
		this.credencial = credencial;
		this.setVisible(true);
		this.limparCampos();
	}
	
	public void colocarEmModoDeEdicao(Cupom cupom) {
		this.setVisible(true);
		this.preencherFormularioCom(cupom);
		this.btnAlternarStatus.setVisible(true);
	}

	private void limparCampos() {
		this.cupom = cupom;
		this.txtCodigo.setText("");
		this.txtPercentual.setText("");
		this.txtValidade.setText("");
		this.btnAlternarStatus.setVisible(false);
	}

	private void preencherFormularioCom(Cupom cupom) {
		this.cupom = cupom;
		cupom.getStatus();
		this.txtCodigo.setText(cupom.getCodigo().toString());
		this.txtPercentual.setText(cupom.getPercentualDeDesconto().toString());
		DateTimeFormatter formatterSaida = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		this.txtValidade.setText(cupom.getValidade().format(formatterSaida));
		if (cupom.getStatus() == StatusDoCupom.I) {
	        this.txtCodigo.setEnabled(false);
	        this.txtPercentual.setEnabled(false);
	        this.txtValidade.setEnabled(false);
	        this.btnSalvar.setEnabled(false);
	        this.btnAlternarStatus.setText("Ativar");
	    } else {
	    	this.txtCodigo.setEnabled(true);
	        this.txtPercentual.setEnabled(true);
	        this.txtValidade.setEnabled(true);
	        this.btnSalvar.setEnabled(true);
	        this.btnAlternarStatus.setText("Inativar");
	    }
	}

}
