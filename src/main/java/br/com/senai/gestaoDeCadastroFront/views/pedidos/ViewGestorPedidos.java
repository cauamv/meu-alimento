package br.com.senai.gestaoDeCadastroFront.views.pedidos;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;

@Component
public class ViewGestorPedidos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	public void abrirTela(String token) {
		this.setVisible(true);
	}

	public ViewGestorPedidos() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumPedido = new JLabel("Pedido Realizado - N° ");
		lblNumPedido.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumPedido.setForeground(Color.RED);
		lblNumPedido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumPedido.setBackground(new Color(248, 244, 244));
		lblNumPedido.setBounds(33, 117, 221, 27);
		contentPane.add(lblNumPedido);
		
		JLabel lblPremierCoffe = new JLabel("Nome do restaurante");
		lblPremierCoffe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPremierCoffe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPremierCoffe.setBackground(new Color(248, 244, 244));
		lblPremierCoffe.setBounds(12, 84, 279, 40);
		contentPane.add(lblPremierCoffe);
		
		setLocationRelativeTo(null);
	}
}
