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
		lblNumPedido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumPedido.setBackground(new Color(248, 244, 244));
		lblNumPedido.setBounds(31, 295, 221, 27);
		contentPane.add(lblNumPedido);
		
		JLabel lblPremierCoffe = new JLabel("Nome do restaurante");
		lblPremierCoffe.setHorizontalAlignment(SwingConstants.LEFT);
		lblPremierCoffe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPremierCoffe.setBackground(new Color(248, 244, 244));
		lblPremierCoffe.setBounds(31, 259, 221, 40);
		contentPane.add(lblPremierCoffe);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCliente.setBounds(31, 348, 55, 14);
		contentPane.add(lblCliente);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setForeground(new Color(255, 0, 0));
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblTotal.setBounds(31, 547, 47, 14);
		contentPane.add(lblTotal);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 0, 0));
		panel.setBounds(0, 0, 1340, 216);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Gestor de Pedidos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(0, 0, 1340, 216);
		panel.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 40));
		
		JLabel lblHorario = new JLabel("Horário:");
		lblHorario.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblHorario.setBounds(31, 323, 55, 14);
		contentPane.add(lblHorario);
		
		JLabel lblCpf = new JLabel("CPF:");
		lblCpf.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCpf.setBounds(31, 370, 37, 14);
		contentPane.add(lblCpf);
		
		JLabel lblNumero = new JLabel("Número:");
		lblNumero.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNumero.setBounds(31, 395, 55, 14);
		contentPane.add(lblNumero);
		
		JLabel lblCep = new JLabel("CEP:");
		lblCep.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCep.setBounds(31, 420, 37, 14);
		contentPane.add(lblCep);
		
		JLabel lblRua = new JLabel("Rua:");
		lblRua.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblRua.setBounds(31, 445, 37, 14);
		contentPane.add(lblRua);
		
		JLabel lblPedido = new JLabel("Pedido:");
		lblPedido.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPedido.setBounds(31, 470, 55, 14);
		contentPane.add(lblPedido);
		
		JLabel lblCupom = new JLabel("Cupom:");
		lblCupom.setForeground(Color.RED);
		lblCupom.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblCupom.setBounds(31, 573, 55, 14);
		contentPane.add(lblCupom);
		
		JLabel lblPagamento = new JLabel("Forma de Pagamento:");
		lblPagamento.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblPagamento.setBounds(31, 598, 147, 14);
		contentPane.add(lblPagamento);
		
		JButton btnAceitar = new JButton("Aceitar");
		btnAceitar.setBorder(null);
		btnAceitar.setForeground(Color.BLACK);
		btnAceitar.setBackground(Color.GREEN);
		btnAceitar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAceitar.setBounds(27, 623, 89, 23);
		contentPane.add(btnAceitar);
		
		JButton btnRecusar = new JButton("Recusar");
		btnRecusar.setForeground(Color.WHITE);
		btnRecusar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRecusar.setBorder(null);
		btnRecusar.setBackground(Color.RED);
		btnRecusar.setBounds(141, 623, 89, 23);
		contentPane.add(btnRecusar);
		
		setLocationRelativeTo(null);
	}
}
