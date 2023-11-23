package br.com.senai.gestaoDeCadastroFront.views;


import java.awt.Color;
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

public class TelaEndereco extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public TelaEndereco() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1177, 693);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel txtComplemento = new JLabel("Complemento (opcional):");
		txtComplemento.setForeground(Color.WHITE);
		txtComplemento.setBounds(678, 424, 439, 14);
		contentPane.add(txtComplemento);
		
		RoundJTextField txtfNumero_1 = new RoundJTextField(0);
		txtfNumero_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtfNumero_1.setBounds(678, 440, 439, 90);
		contentPane.add(txtfNumero_1);
		
		JCheckBox semNumer = new JCheckBox("Sem número");
		semNumer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		semNumer.setForeground(Color.WHITE);
		semNumer.setBackground(new Color(255, 52, 52));
		semNumer.setBounds(678, 387, 146, 38);
		contentPane.add(semNumer);
		
		JLabel txtNumero = new JLabel("Número:");
		txtNumero.setForeground(Color.WHITE);
		txtNumero.setBounds(678, 307, 439, 14);
		contentPane.add(txtNumero);
		
		JLabel txtLogradouro = new JLabel("Logradouro:");
		txtLogradouro.setForeground(Color.WHITE);
		txtLogradouro.setBounds(679, 227, 439, 14);
		contentPane.add(txtLogradouro);
		
		JLabel lblDigiteSeuCep = new JLabel("CEP:");
		lblDigiteSeuCep.setForeground(Color.WHITE);
		lblDigiteSeuCep.setBounds(678, 146, 439, 14);
		contentPane.add(lblDigiteSeuCep);
		
		RoundJTextField txtfNumero = new RoundJTextField(0);
		txtfNumero.setHorizontalAlignment(SwingConstants.CENTER);
		txtfNumero.setBounds(678, 323, 439, 53);
		contentPane.add(txtfNumero);
		
		JButton btnProximo = new JButton("Criar");
		btnProximo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnProximo.setBorder(null);
		btnProximo.setBounds(new Rectangle(10, 10, 10, 10));
		btnProximo.setBackground(Color.WHITE);
		btnProximo.setForeground(Color.BLACK);
		btnProximo.setBounds(992, 565, 114, 38);
		contentPane.add(btnProximo);
		btnProximo.setRolloverEnabled(true);
		
		RoundJTextField txtfCep = new RoundJTextField(0);
		txtfCep.setHorizontalAlignment(SwingConstants.CENTER);
		txtfCep.setBounds(678, 161, 439, 53);
		contentPane.add(txtfCep);
		
		RoundJTextField txtfLogradouro = new RoundJTextField(0);
		txtfLogradouro.setHorizontalAlignment(SwingConstants.CENTER);
		txtfLogradouro.setBounds(678, 242, 439, 53);
		contentPane.add(txtfLogradouro);
		
		JLabel fundo = new JLabel("");
		fundo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fundo.setBorder(null);
		fundo.setBackground(new Color(240, 240, 240));
		fundo.setHorizontalAlignment(SwingConstants.CENTER);
		fundo.setIcon(new ImageIcon(TelaEndereco.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/telaEndereco.png")));
		fundo.setBounds(0, 0, 1162, 654);
		contentPane.add(fundo);

	}
}
