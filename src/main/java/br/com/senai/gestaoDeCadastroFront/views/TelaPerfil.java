package br.com.senai.gestaoDeCadastroFront.views;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class TelaPerfil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;


	public TelaPerfil() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1176, 708);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		

		JButton btnSouUmAdimi = new JButton("Sou um administrador");
		btnSouUmAdimi.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSouUmAdimi.setBorder(null);
		btnSouUmAdimi.setBackground(Color.WHITE);
		btnSouUmAdimi.setBounds(745, 365, 277, 43);
		contentPane.add(btnSouUmAdimi);
		

		JButton btnSouUmCliente = new JButton("Sou um cliente");
		btnSouUmCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSouUmCliente.setBorder(null);
		btnSouUmCliente.setBackground(Color.WHITE);
		btnSouUmCliente.setBounds(743, 266, 277, 43);
		contentPane.add(btnSouUmCliente);
		

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaPerfil.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/telaPerfil.png")));
		lblNewLabel.setBounds(0, 0, 1162, 671);
		contentPane.add(lblNewLabel);
	}

}

