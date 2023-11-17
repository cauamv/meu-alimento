package br.com.senai.gestaoDeCadastroFront.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

public class TelaGestor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaGestor frame = new TelaGestor();
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
	public TelaGestor() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1176, 698);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCupons = new JButton("Cupons");
		btnCupons.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCupons.setBackground(new Color(255, 255, 255));
		btnCupons.setBorder(null);
		btnCupons.setBounds(761, 210, 328, 78);
		contentPane.add(btnCupons);
		
		JButton btnPedidos = new JButton("Pedidos");
		btnPedidos.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnPedidos.setBackground(new Color(255, 255, 255));
		btnPedidos.setBorder(null);
		btnPedidos.setBounds(97, 210, 328, 78);
		contentPane.add(btnPedidos);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(TelaGestor.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/telaGestor.png")));
		lblNewLabel.setBounds(0, 0, 1162, 671);
		contentPane.add(lblNewLabel);
	}
}
