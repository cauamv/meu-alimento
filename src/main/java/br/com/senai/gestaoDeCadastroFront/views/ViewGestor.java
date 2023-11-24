package br.com.senai.gestaoDeCadastroFront.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;

public class ViewGestor extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewGestor frame = new ViewGestor();
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
	public ViewGestor() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1343, 773);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnCupons = new JButton("Cupons");
		btnCupons.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnCupons.setBorder(null);
		btnCupons.setBackground(Color.WHITE);
		btnCupons.setBounds(896, 239, 388, 93);
		contentPane.add(btnCupons);
		
		JButton btnPedidos = new JButton("Pedidos");
		btnPedidos.setBackground(new Color(255, 255, 255));
		btnPedidos.setBorder(null);
		btnPedidos.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnPedidos.setBounds(115, 239, 388, 93);
		contentPane.add(btnPedidos);
		
		JLabel fundo = new JLabel("");
		fundo.setIcon(new ImageIcon(ViewGestor.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/telaGestor.png")));
		fundo.setBounds(0, 0, 1366, 768);
		contentPane.add(fundo);
		
		setLocationRelativeTo(null);
		
		
	}
}
