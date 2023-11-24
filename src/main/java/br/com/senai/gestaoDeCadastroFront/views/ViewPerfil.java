package br.com.senai.gestaoDeCadastroFront.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class ViewPerfil extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewPerfil frame = new ViewPerfil();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ViewPerfil() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1373, 788);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnSouUmAdmin = new JButton("Sou um administrador");
		btnSouUmAdmin.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSouUmAdmin.setBorder(null);
		btnSouUmAdmin.setBackground(Color.WHITE);
		btnSouUmAdmin.setBounds(886, 415, 307, 58);
		contentPane.add(btnSouUmAdmin);

		JButton btnSouUmCliente = new JButton("Sou um cliente");
		btnSouUmCliente.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnSouUmCliente.setBorder(null);
		btnSouUmCliente.setBackground(Color.WHITE);
		btnSouUmCliente.setBounds(886, 297, 313, 58);
		contentPane.add(btnSouUmCliente);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ViewPerfil.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/telaPerfil.png")));
		lblNewLabel.setBounds(0, 0, 1376, 768);
		contentPane.add(lblNewLabel);
		
		setLocationRelativeTo(null);
	}
}