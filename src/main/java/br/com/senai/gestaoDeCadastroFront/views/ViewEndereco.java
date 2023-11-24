package br.com.senai.gestaoDeCadastroFront.views;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.senai.gestaoDeCadastroFront.components.RoundJTextField;

public class ViewEndereco extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEndereco frame = new ViewEndereco();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewEndereco() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1387, 836);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		RoundJTextField txtfCep = new RoundJTextField(0);
		txtfCep.setHorizontalAlignment(SwingConstants.CENTER);
		txtfCep.setBounds(794, 198, 516, 68);
		contentPane.add(txtfCep);
		
		RoundJTextField txtfLogradouro = new RoundJTextField(0);
		txtfLogradouro.setHorizontalAlignment(SwingConstants.CENTER);
		txtfLogradouro.setBounds(794, 292, 516, 68);
		contentPane.add(txtfLogradouro);
		
		JLabel txtComplemento = new JLabel("Complemento (opcional):");
		txtComplemento.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtComplemento.setForeground(Color.WHITE);
		txtComplemento.setBounds(794, 507, 439, 14);
		contentPane.add(txtComplemento);
		
		RoundJTextField txtfComplemento = new RoundJTextField(0);
		txtfComplemento.setHorizontalAlignment(SwingConstants.CENTER);
		txtfComplemento.setBounds(794, 524, 516, 113);
		contentPane.add(txtfComplemento);
		
		JCheckBox semNumer = new JCheckBox("Sem número");
		semNumer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		semNumer.setForeground(Color.WHITE);
		semNumer.setBackground(new Color(255, 52, 52));
		semNumer.setBounds(794, 463, 174, 38);
		contentPane.add(semNumer);
		
		JLabel txtNumero = new JLabel("Número:");
		txtNumero.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtNumero.setForeground(Color.WHITE);
		txtNumero.setBounds(794, 370, 439, 14);
		contentPane.add(txtNumero);
		
		JLabel txtLogradouro = new JLabel("Logradouro:");
		txtLogradouro.setFont(new Font("Tahoma", Font.PLAIN, 12));
		txtLogradouro.setForeground(Color.WHITE);
		txtLogradouro.setBounds(794, 276, 439, 14);
		contentPane.add(txtLogradouro);
		
		JLabel lblDigiteSeuCep = new JLabel("CEP:");
		lblDigiteSeuCep.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblDigiteSeuCep.setForeground(Color.WHITE);
		lblDigiteSeuCep.setBounds(794, 179, 439, 14);
		contentPane.add(lblDigiteSeuCep);
		
		RoundJTextField txtfNumero = new RoundJTextField(0);
		txtfNumero.setHorizontalAlignment(SwingConstants.CENTER);
		txtfNumero.setBounds(794, 389, 516, 68);
		contentPane.add(txtfNumero);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnCriar.setBorder(null);
		btnCriar.setBounds(new Rectangle(10, 10, 10, 10));
		btnCriar.setBackground(Color.WHITE);
		btnCriar.setForeground(Color.BLACK);
		btnCriar.setBounds(1175, 670, 114, 53);
		contentPane.add(btnCriar);
		btnCriar.setRolloverEnabled(true);
		
		JLabel fundo = new JLabel("");
		fundo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fundo.setBorder(null);
		fundo.setBackground(new Color(240, 240, 240));
		fundo.setHorizontalAlignment(SwingConstants.CENTER);
		fundo.setIcon(new ImageIcon(ViewEndereco.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/telaEndereco.png")));
		fundo.setBounds(0, 0, 1363, 789);
		contentPane.add(fundo);
		
		setLocationRelativeTo(null);

	}
}
