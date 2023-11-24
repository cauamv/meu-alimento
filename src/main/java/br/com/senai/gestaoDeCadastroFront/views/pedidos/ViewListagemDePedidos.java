package br.com.senai.gestaoDeCadastroFront.views.pedidos;

import java.awt.Color;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class ViewListagemDePedidos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ViewListagemDePedidos() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1172, 722);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumPedido_1_1_1 = new JLabel("Pedido Realizado - N° 123");
		lblNumPedido_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumPedido_1_1_1.setForeground(Color.RED);
		lblNumPedido_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNumPedido_1_1_1.setBackground(new Color(248, 244, 244));
		lblNumPedido_1_1_1.setBounds(884, 186, 127, 17);
		contentPane.add(lblNumPedido_1_1_1);
		
		JLabel lblNomeCliente_1_1_1 = new JLabel("Mateus Bitencourt");
		lblNomeCliente_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCliente_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNomeCliente_1_1_1.setBackground(new Color(248, 244, 244));
		lblNomeCliente_1_1_1.setBounds(875, 218, 122, 17);
		contentPane.add(lblNomeCliente_1_1_1);
		
		JLabel lblCliente_1_1_1 = new JLabel("Cliente:");
		lblCliente_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCliente_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblCliente_1_1_1.setBackground(new Color(248, 244, 244));
		lblCliente_1_1_1.setBounds(830, 218, 43, 17);
		contentPane.add(lblCliente_1_1_1);
		
		JLabel lblEnderecoCliente_1_1_1 = new JLabel("Rua Governador Souza, 345");
		lblEnderecoCliente_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnderecoCliente_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblEnderecoCliente_1_1_1.setBackground(new Color(248, 244, 244));
		lblEnderecoCliente_1_1_1.setBounds(884, 236, 122, 17);
		contentPane.add(lblEnderecoCliente_1_1_1);
		
		JLabel lblEndereo_1_1_1 = new JLabel("Endereço:");
		lblEndereo_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndereo_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblEndereo_1_1_1.setBackground(new Color(248, 244, 244));
		lblEndereo_1_1_1.setBounds(830, 237, 49, 17);
		contentPane.add(lblEndereo_1_1_1);
		
		JLabel lblPremierCoffe_1_1_1 = new JLabel("Premier Coffe");
		lblPremierCoffe_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPremierCoffe_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPremierCoffe_1_1_1.setBackground(new Color(248, 244, 244));
		lblPremierCoffe_1_1_1.setBounds(884, 166, 113, 25);
		contentPane.add(lblPremierCoffe_1_1_1);
		
		JButton btnNewButton_1_1_1 = new JButton("V");
		btnNewButton_1_1_1.setForeground(Color.RED);
		btnNewButton_1_1_1.setBorder(null);
		btnNewButton_1_1_1.setBackground(new Color(242, 242, 242));
		btnNewButton_1_1_1.setBounds(851, 289, 133, 17);
		contentPane.add(btnNewButton_1_1_1);
		
		JLabel lblR_1_1_1 = new JLabel("R$ 10,00");
		lblR_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblR_1_1_1.setForeground(Color.RED);
		lblR_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblR_1_1_1.setBackground(new Color(248, 244, 244));
		lblR_1_1_1.setBounds(865, 259, 132, 17);
		contentPane.add(lblR_1_1_1);
		
		JLabel lblTotal_1_1_1 = new JLabel("Total:");
		lblTotal_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal_1_1_1.setForeground(Color.RED);
		lblTotal_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTotal_1_1_1.setBackground(new Color(248, 244, 244));
		lblTotal_1_1_1.setBounds(830, 260, 34, 17);
		contentPane.add(lblTotal_1_1_1);
		
		JLabel lblEndereo_1_1 = new JLabel("Endereço:");
		lblEndereo_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndereo_1_1.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblEndereo_1_1.setBackground(new Color(248, 244, 244));
		lblEndereo_1_1.setBounds(594, 239, 49, 17);
		contentPane.add(lblEndereo_1_1);
		
		JLabel lblEnderecoCliente_1_1 = new JLabel("Rua Governador Souza, 345");
		lblEnderecoCliente_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnderecoCliente_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblEnderecoCliente_1_1.setBackground(new Color(248, 244, 244));
		lblEnderecoCliente_1_1.setBounds(648, 238, 122, 17);
		contentPane.add(lblEnderecoCliente_1_1);
		
		JLabel lblR_1_1 = new JLabel("R$ 10,00");
		lblR_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblR_1_1.setForeground(Color.RED);
		lblR_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblR_1_1.setBackground(new Color(248, 244, 244));
		lblR_1_1.setBounds(629, 261, 132, 17);
		contentPane.add(lblR_1_1);
		
		JLabel lblPremierCoffe_1_1 = new JLabel("Premier Coffe");
		lblPremierCoffe_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPremierCoffe_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPremierCoffe_1_1.setBackground(new Color(248, 244, 244));
		lblPremierCoffe_1_1.setBounds(648, 168, 113, 25);
		contentPane.add(lblPremierCoffe_1_1);
		
		JLabel lblNumPedido_1_1 = new JLabel("Pedido Realizado - N° 123");
		lblNumPedido_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumPedido_1_1.setForeground(Color.RED);
		lblNumPedido_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNumPedido_1_1.setBackground(new Color(248, 244, 244));
		lblNumPedido_1_1.setBounds(648, 188, 127, 17);
		contentPane.add(lblNumPedido_1_1);
		
		JLabel lblNomeCliente_1_1 = new JLabel("Mateus Bitencourt");
		lblNomeCliente_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCliente_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNomeCliente_1_1.setBackground(new Color(248, 244, 244));
		lblNomeCliente_1_1.setBounds(639, 220, 122, 17);
		contentPane.add(lblNomeCliente_1_1);
		
		JButton btnNewButton_1_1 = new JButton("V");
		btnNewButton_1_1.setForeground(Color.RED);
		btnNewButton_1_1.setBorder(null);
		btnNewButton_1_1.setBackground(new Color(242, 242, 242));
		btnNewButton_1_1.setBounds(615, 291, 133, 17);
		contentPane.add(btnNewButton_1_1);
		
		JLabel lblCliente_1_1 = new JLabel("Cliente:");
		lblCliente_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCliente_1_1.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblCliente_1_1.setBackground(new Color(248, 244, 244));
		lblCliente_1_1.setBounds(594, 220, 43, 17);
		contentPane.add(lblCliente_1_1);
		
		JLabel lblTotal_1_1 = new JLabel("Total:");
		lblTotal_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal_1_1.setForeground(Color.RED);
		lblTotal_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTotal_1_1.setBackground(new Color(248, 244, 244));
		lblTotal_1_1.setBounds(594, 262, 34, 17);
		contentPane.add(lblTotal_1_1);
		
		JLabel lblEnderecoCliente_1 = new JLabel("Rua Governador Souza, 345");
		lblEnderecoCliente_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnderecoCliente_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblEnderecoCliente_1.setBackground(new Color(248, 244, 244));
		lblEnderecoCliente_1.setBounds(412, 238, 122, 17);
		contentPane.add(lblEnderecoCliente_1);
		
		JButton btnNewButton_1 = new JButton("V");
		btnNewButton_1.setForeground(Color.RED);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color(242, 242, 242));
		btnNewButton_1.setBounds(379, 289, 133, 17);
		contentPane.add(btnNewButton_1);
		
		JLabel lblEndereo_1 = new JLabel("Endereço:");
		lblEndereo_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndereo_1.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblEndereo_1.setBackground(new Color(248, 244, 244));
		lblEndereo_1.setBounds(358, 239, 49, 17);
		contentPane.add(lblEndereo_1);
		
		JLabel lblPremierCoffe_1 = new JLabel("Premier Coffe");
		lblPremierCoffe_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPremierCoffe_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPremierCoffe_1.setBackground(new Color(248, 244, 244));
		lblPremierCoffe_1.setBounds(412, 168, 113, 25);
		contentPane.add(lblPremierCoffe_1);
		
		JLabel lblNomeCliente_1 = new JLabel("Mateus Bitencourt");
		lblNomeCliente_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCliente_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNomeCliente_1.setBackground(new Color(248, 244, 244));
		lblNomeCliente_1.setBounds(403, 220, 122, 17);
		contentPane.add(lblNomeCliente_1);
		
		JLabel lblTotal_1 = new JLabel("Total:");
		lblTotal_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal_1.setForeground(Color.RED);
		lblTotal_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTotal_1.setBackground(new Color(248, 244, 244));
		lblTotal_1.setBounds(358, 262, 34, 17);
		contentPane.add(lblTotal_1);
		
		JLabel lblCliente_1 = new JLabel("Cliente:");
		lblCliente_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCliente_1.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblCliente_1.setBackground(new Color(248, 244, 244));
		lblCliente_1.setBounds(358, 220, 43, 17);
		contentPane.add(lblCliente_1);
		
		JLabel lblNumPedido_1 = new JLabel("Pedido Realizado - N° 123");
		lblNumPedido_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumPedido_1.setForeground(Color.RED);
		lblNumPedido_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNumPedido_1.setBackground(new Color(248, 244, 244));
		lblNumPedido_1.setBounds(412, 188, 127, 17);
		contentPane.add(lblNumPedido_1);
		
		JLabel lblR_1 = new JLabel("R$ 10,00");
		lblR_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblR_1.setForeground(Color.RED);
		lblR_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblR_1.setBackground(new Color(248, 244, 244));
		lblR_1.setBounds(393, 261, 132, 17);
		contentPane.add(lblR_1);
		
		JLabel lblEnderecoCliente = new JLabel("Rua Governador Souza, 345");
		lblEnderecoCliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnderecoCliente.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblEnderecoCliente.setBackground(new Color(248, 244, 244));
		lblEnderecoCliente.setBounds(178, 238, 122, 17);
		contentPane.add(lblEnderecoCliente);
		
		JLabel lblNomeCliente = new JLabel("Mateus Bitencourt");
		lblNomeCliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCliente.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNomeCliente.setBackground(new Color(248, 244, 244));
		lblNomeCliente.setBounds(169, 220, 122, 17);
		contentPane.add(lblNomeCliente);
		
		JLabel lblR = new JLabel("R$ 10,00");
		lblR.setHorizontalAlignment(SwingConstants.LEFT);
		lblR.setForeground(Color.RED);
		lblR.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblR.setBackground(new Color(248, 244, 244));
		lblR.setBounds(159, 261, 132, 17);
		contentPane.add(lblR);
		
		JButton btnNewButton = new JButton("V");
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color(242, 242, 242));
		btnNewButton.setForeground(Color.RED);
		btnNewButton.setBounds(145, 289, 133, 17);
		contentPane.add(btnNewButton);
		
		JLabel lblTotal = new JLabel("Total:");
		lblTotal.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal.setForeground(Color.RED);
		lblTotal.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTotal.setBackground(new Color(248, 244, 244));
		lblTotal.setBounds(124, 262, 34, 17);
		contentPane.add(lblTotal);
		
		JLabel lblEndereo = new JLabel("Endereço:");
		lblEndereo.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndereo.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblEndereo.setBackground(new Color(248, 244, 244));
		lblEndereo.setBounds(124, 239, 49, 17);
		contentPane.add(lblEndereo);
		
		JLabel lblCliente = new JLabel("Cliente:");
		lblCliente.setHorizontalAlignment(SwingConstants.LEFT);
		lblCliente.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblCliente.setBackground(new Color(248, 244, 244));
		lblCliente.setBounds(124, 220, 43, 17);
		contentPane.add(lblCliente);
		
		JLabel lblNumPedido = new JLabel("Pedido Realizado - N° 123");
		lblNumPedido.setBounds(178, 188, 127, 17);
		lblNumPedido.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumPedido.setForeground(Color.RED);
		lblNumPedido.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNumPedido.setBackground(new Color(248, 244, 244));
		contentPane.add(lblNumPedido);
		
		JLabel lblPremierCoffe = new JLabel("Premier Coffe");
		lblPremierCoffe.setBounds(178, 168, 113, 25);
		lblPremierCoffe.setHorizontalAlignment(SwingConstants.LEFT);
		lblPremierCoffe.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPremierCoffe.setBackground(new Color(248, 244, 244));
		contentPane.add(lblPremierCoffe);
		
		JLabel lblTempoMedio = new JLabel("30 minutos");
		lblTempoMedio.setBounds(1018, 48, 113, 25);
		lblTempoMedio.setHorizontalAlignment(SwingConstants.CENTER);
		lblTempoMedio.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTempoMedio.setBackground(new Color(248, 244, 244));
		contentPane.add(lblTempoMedio);
		
		JLabel lblNumPedidosEntregues = new JLabel("0");
		lblNumPedidosEntregues.setBounds(96, 43, 16, 31);
		lblNumPedidosEntregues.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumPedidosEntregues.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNumPedidosEntregues.setBackground(new Color(248, 244, 244));
		contentPane.add(lblNumPedidosEntregues);
		
		JLabel lblNumPedidosNaoEntregues = new JLabel("0");
		lblNumPedidosNaoEntregues.setBounds(237, 43, 16, 31);
		lblNumPedidosNaoEntregues.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumPedidosNaoEntregues.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNumPedidosNaoEntregues.setBackground(Color.WHITE);
		contentPane.add(lblNumPedidosNaoEntregues);
		
		JLabel lblNaoEntregues = new JLabel("Não Entregues");
		lblNaoEntregues.setBounds(57, 74, 103, 17);
		lblNaoEntregues.setHorizontalAlignment(SwingConstants.CENTER);
		lblNaoEntregues.setForeground(Color.RED);
		lblNaoEntregues.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNaoEntregues.setBackground(new Color(248, 244, 244));
		contentPane.add(lblNaoEntregues);
		
		JLabel lblEntregues = new JLabel("Entregues");
		lblEntregues.setBounds(207, 74, 71, 17);
		lblEntregues.setForeground(Color.RED);
		lblEntregues.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntregues.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEntregues.setBackground(new Color(248, 244, 244));
		contentPane.add(lblEntregues);
		
		JLabel lblNaoEntregue = new JLabel("");
		lblNaoEntregue.setBounds(668, 25, 0, 0);
		contentPane.add(lblNaoEntregue);
		
		JLabel lblEntregue = new JLabel("");
		lblEntregue.setBounds(673, 25, 0, 0);
		contentPane.add(lblEntregue);
		
		JLabel lblTempoEntrega = new JLabel("Tempo médio de entrega");
		lblTempoEntrega.setBounds(991, 86, 153, 15);
		lblTempoEntrega.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTempoEntrega.setHorizontalAlignment(SwingConstants.CENTER);
		lblTempoEntrega.setBackground(new Color(248,244,244));
		contentPane.add(lblTempoEntrega);
		
		JLabel lblPremierCoffe_2 = new JLabel("Premier Coffe");
		lblPremierCoffe_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblPremierCoffe_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPremierCoffe_2.setBackground(new Color(248, 244, 244));
		lblPremierCoffe_2.setBounds(178, 338, 113, 25);
		contentPane.add(lblPremierCoffe_2);
		
		JLabel lblNumPedido_2 = new JLabel("Pedido Realizado - N° 123");
		lblNumPedido_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumPedido_2.setForeground(Color.RED);
		lblNumPedido_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNumPedido_2.setBackground(new Color(248, 244, 244));
		lblNumPedido_2.setBounds(178, 358, 127, 17);
		contentPane.add(lblNumPedido_2);
		
		JLabel lblCliente_2 = new JLabel("Cliente:");
		lblCliente_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblCliente_2.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblCliente_2.setBackground(new Color(248, 244, 244));
		lblCliente_2.setBounds(124, 390, 43, 17);
		contentPane.add(lblCliente_2);
		
		JLabel lblNomeCliente_2 = new JLabel("Mateus Bitencourt");
		lblNomeCliente_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCliente_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNomeCliente_2.setBackground(new Color(248, 244, 244));
		lblNomeCliente_2.setBounds(169, 390, 122, 17);
		contentPane.add(lblNomeCliente_2);
		
		JLabel lblEndereo_2 = new JLabel("Endereço:");
		lblEndereo_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndereo_2.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblEndereo_2.setBackground(new Color(248, 244, 244));
		lblEndereo_2.setBounds(124, 409, 49, 17);
		contentPane.add(lblEndereo_2);
		
		JLabel lblEnderecoCliente_2 = new JLabel("Rua Governador Souza, 345");
		lblEnderecoCliente_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnderecoCliente_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblEnderecoCliente_2.setBackground(new Color(248, 244, 244));
		lblEnderecoCliente_2.setBounds(178, 408, 122, 17);
		contentPane.add(lblEnderecoCliente_2);
		
		JLabel lblTotal_2 = new JLabel("Total:");
		lblTotal_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal_2.setForeground(Color.RED);
		lblTotal_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTotal_2.setBackground(new Color(248, 244, 244));
		lblTotal_2.setBounds(124, 432, 34, 17);
		contentPane.add(lblTotal_2);
		
		JLabel lblR_2 = new JLabel("R$ 10,00");
		lblR_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblR_2.setForeground(Color.RED);
		lblR_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblR_2.setBackground(new Color(248, 244, 244));
		lblR_2.setBounds(159, 431, 132, 17);
		contentPane.add(lblR_2);
		
		JButton btnNewButton_2 = new JButton("V");
		btnNewButton_2.setForeground(Color.RED);
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setBackground(new Color(242, 242, 242));
		btnNewButton_2.setBounds(145, 459, 133, 17);
		contentPane.add(btnNewButton_2);
		
		JLabel lblPremierCoffe_1_2 = new JLabel("Premier Coffe");
		lblPremierCoffe_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblPremierCoffe_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPremierCoffe_1_2.setBackground(new Color(248, 244, 244));
		lblPremierCoffe_1_2.setBounds(412, 338, 113, 25);
		contentPane.add(lblPremierCoffe_1_2);
		
		JLabel lblNumPedido_1_2 = new JLabel("Pedido Realizado - N° 123");
		lblNumPedido_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumPedido_1_2.setForeground(Color.RED);
		lblNumPedido_1_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNumPedido_1_2.setBackground(new Color(248, 244, 244));
		lblNumPedido_1_2.setBounds(412, 358, 127, 17);
		contentPane.add(lblNumPedido_1_2);
		
		JLabel lblCliente_1_2 = new JLabel("Cliente:");
		lblCliente_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblCliente_1_2.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblCliente_1_2.setBackground(new Color(248, 244, 244));
		lblCliente_1_2.setBounds(358, 390, 43, 17);
		contentPane.add(lblCliente_1_2);
		
		JLabel lblNomeCliente_1_2 = new JLabel("Mateus Bitencourt");
		lblNomeCliente_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCliente_1_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNomeCliente_1_2.setBackground(new Color(248, 244, 244));
		lblNomeCliente_1_2.setBounds(403, 390, 122, 17);
		contentPane.add(lblNomeCliente_1_2);
		
		JLabel lblEndereo_1_2 = new JLabel("Endereço:");
		lblEndereo_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndereo_1_2.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblEndereo_1_2.setBackground(new Color(248, 244, 244));
		lblEndereo_1_2.setBounds(358, 409, 49, 17);
		contentPane.add(lblEndereo_1_2);
		
		JLabel lblEnderecoCliente_1_2 = new JLabel("Rua Governador Souza, 345");
		lblEnderecoCliente_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnderecoCliente_1_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblEnderecoCliente_1_2.setBackground(new Color(248, 244, 244));
		lblEnderecoCliente_1_2.setBounds(412, 408, 122, 17);
		contentPane.add(lblEnderecoCliente_1_2);
		
		JLabel lblTotal_1_2 = new JLabel("Total:");
		lblTotal_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal_1_2.setForeground(Color.RED);
		lblTotal_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTotal_1_2.setBackground(new Color(248, 244, 244));
		lblTotal_1_2.setBounds(358, 432, 34, 17);
		contentPane.add(lblTotal_1_2);
		
		JLabel lblR_1_2 = new JLabel("R$ 10,00");
		lblR_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblR_1_2.setForeground(Color.RED);
		lblR_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblR_1_2.setBackground(new Color(248, 244, 244));
		lblR_1_2.setBounds(393, 431, 132, 17);
		contentPane.add(lblR_1_2);
		
		JButton btnNewButton_1_2 = new JButton("V");
		btnNewButton_1_2.setForeground(Color.RED);
		btnNewButton_1_2.setBorder(null);
		btnNewButton_1_2.setBackground(new Color(242, 242, 242));
		btnNewButton_1_2.setBounds(379, 459, 133, 17);
		contentPane.add(btnNewButton_1_2);
		
		JButton btnNewButton_1_1_2 = new JButton("V");
		btnNewButton_1_1_2.setForeground(Color.RED);
		btnNewButton_1_1_2.setBorder(null);
		btnNewButton_1_1_2.setBackground(new Color(242, 242, 242));
		btnNewButton_1_1_2.setBounds(615, 461, 133, 17);
		contentPane.add(btnNewButton_1_1_2);
		
		JLabel lblR_1_1_2 = new JLabel("R$ 10,00");
		lblR_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblR_1_1_2.setForeground(Color.RED);
		lblR_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblR_1_1_2.setBackground(new Color(248, 244, 244));
		lblR_1_1_2.setBounds(629, 431, 132, 17);
		contentPane.add(lblR_1_1_2);
		
		JLabel lblTotal_1_1_2 = new JLabel("Total:");
		lblTotal_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal_1_1_2.setForeground(Color.RED);
		lblTotal_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTotal_1_1_2.setBackground(new Color(248, 244, 244));
		lblTotal_1_1_2.setBounds(594, 432, 34, 17);
		contentPane.add(lblTotal_1_1_2);
		
		JLabel lblEndereo_1_1_2 = new JLabel("Endereço:");
		lblEndereo_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndereo_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblEndereo_1_1_2.setBackground(new Color(248, 244, 244));
		lblEndereo_1_1_2.setBounds(594, 409, 49, 17);
		contentPane.add(lblEndereo_1_1_2);
		
		JLabel lblEnderecoCliente_1_1_2 = new JLabel("Rua Governador Souza, 345");
		lblEnderecoCliente_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnderecoCliente_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblEnderecoCliente_1_1_2.setBackground(new Color(248, 244, 244));
		lblEnderecoCliente_1_1_2.setBounds(648, 408, 122, 17);
		contentPane.add(lblEnderecoCliente_1_1_2);
		
		JLabel lblNomeCliente_1_1_2 = new JLabel("Mateus Bitencourt");
		lblNomeCliente_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCliente_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNomeCliente_1_1_2.setBackground(new Color(248, 244, 244));
		lblNomeCliente_1_1_2.setBounds(639, 390, 122, 17);
		contentPane.add(lblNomeCliente_1_1_2);
		
		JLabel lblCliente_1_1_2 = new JLabel("Cliente:");
		lblCliente_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblCliente_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblCliente_1_1_2.setBackground(new Color(248, 244, 244));
		lblCliente_1_1_2.setBounds(594, 390, 43, 17);
		contentPane.add(lblCliente_1_1_2);
		
		JLabel lblNumPedido_1_1_2 = new JLabel("Pedido Realizado - N° 123");
		lblNumPedido_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumPedido_1_1_2.setForeground(Color.RED);
		lblNumPedido_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNumPedido_1_1_2.setBackground(new Color(248, 244, 244));
		lblNumPedido_1_1_2.setBounds(648, 358, 127, 17);
		contentPane.add(lblNumPedido_1_1_2);
		
		JLabel lblPremierCoffe_1_1_2 = new JLabel("Premier Coffe");
		lblPremierCoffe_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblPremierCoffe_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPremierCoffe_1_1_2.setBackground(new Color(248, 244, 244));
		lblPremierCoffe_1_1_2.setBounds(648, 338, 113, 25);
		contentPane.add(lblPremierCoffe_1_1_2);
		
		JLabel lblPremierCoffe_1_1_1_1 = new JLabel("Premier Coffe");
		lblPremierCoffe_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblPremierCoffe_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPremierCoffe_1_1_1_1.setBackground(new Color(248, 244, 244));
		lblPremierCoffe_1_1_1_1.setBounds(884, 336, 113, 25);
		contentPane.add(lblPremierCoffe_1_1_1_1);
		
		JLabel lblNumPedido_1_1_1_1 = new JLabel("Pedido Realizado - N° 123");
		lblNumPedido_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumPedido_1_1_1_1.setForeground(Color.RED);
		lblNumPedido_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNumPedido_1_1_1_1.setBackground(new Color(248, 244, 244));
		lblNumPedido_1_1_1_1.setBounds(884, 356, 127, 17);
		contentPane.add(lblNumPedido_1_1_1_1);
		
		JLabel lblCliente_1_1_1_1 = new JLabel("Cliente:");
		lblCliente_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblCliente_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblCliente_1_1_1_1.setBackground(new Color(248, 244, 244));
		lblCliente_1_1_1_1.setBounds(830, 388, 43, 17);
		contentPane.add(lblCliente_1_1_1_1);
		
		JLabel lblNomeCliente_1_1_1_1 = new JLabel("Mateus Bitencourt");
		lblNomeCliente_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCliente_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNomeCliente_1_1_1_1.setBackground(new Color(248, 244, 244));
		lblNomeCliente_1_1_1_1.setBounds(875, 388, 122, 17);
		contentPane.add(lblNomeCliente_1_1_1_1);
		
		JLabel lblEndereo_1_1_1_1 = new JLabel("Endereço:");
		lblEndereo_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndereo_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblEndereo_1_1_1_1.setBackground(new Color(248, 244, 244));
		lblEndereo_1_1_1_1.setBounds(830, 407, 49, 17);
		contentPane.add(lblEndereo_1_1_1_1);
		
		JLabel lblEnderecoCliente_1_1_1_1 = new JLabel("Rua Governador Souza, 345");
		lblEnderecoCliente_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnderecoCliente_1_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblEnderecoCliente_1_1_1_1.setBackground(new Color(248, 244, 244));
		lblEnderecoCliente_1_1_1_1.setBounds(884, 406, 122, 17);
		contentPane.add(lblEnderecoCliente_1_1_1_1);
		
		JLabel lblTotal_1_1_1_1 = new JLabel("Total:");
		lblTotal_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal_1_1_1_1.setForeground(Color.RED);
		lblTotal_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTotal_1_1_1_1.setBackground(new Color(248, 244, 244));
		lblTotal_1_1_1_1.setBounds(830, 430, 34, 17);
		contentPane.add(lblTotal_1_1_1_1);
		
		JLabel lblR_1_1_1_1 = new JLabel("R$ 10,00");
		lblR_1_1_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblR_1_1_1_1.setForeground(Color.RED);
		lblR_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblR_1_1_1_1.setBackground(new Color(248, 244, 244));
		lblR_1_1_1_1.setBounds(865, 429, 132, 17);
		contentPane.add(lblR_1_1_1_1);
		
		JButton btnNewButton_1_1_1_1 = new JButton("V");
		btnNewButton_1_1_1_1.setForeground(Color.RED);
		btnNewButton_1_1_1_1.setBorder(null);
		btnNewButton_1_1_1_1.setBackground(new Color(242, 242, 242));
		btnNewButton_1_1_1_1.setBounds(851, 459, 133, 17);
		contentPane.add(btnNewButton_1_1_1_1);
		
		JLabel lblPremierCoffe_3 = new JLabel("Premier Coffe");
		lblPremierCoffe_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblPremierCoffe_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPremierCoffe_3.setBackground(new Color(248, 244, 244));
		lblPremierCoffe_3.setBounds(173, 502, 113, 25);
		contentPane.add(lblPremierCoffe_3);
		
		JLabel lblNumPedido_3 = new JLabel("Pedido Realizado - N° 123");
		lblNumPedido_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumPedido_3.setForeground(Color.RED);
		lblNumPedido_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNumPedido_3.setBackground(new Color(248, 244, 244));
		lblNumPedido_3.setBounds(173, 522, 127, 17);
		contentPane.add(lblNumPedido_3);
		
		JLabel lblCliente_3 = new JLabel("Cliente:");
		lblCliente_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblCliente_3.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblCliente_3.setBackground(new Color(248, 244, 244));
		lblCliente_3.setBounds(119, 554, 43, 17);
		contentPane.add(lblCliente_3);
		
		JLabel lblNomeCliente_3 = new JLabel("Mateus Bitencourt");
		lblNomeCliente_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCliente_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNomeCliente_3.setBackground(new Color(248, 244, 244));
		lblNomeCliente_3.setBounds(164, 554, 122, 17);
		contentPane.add(lblNomeCliente_3);
		
		JLabel lblEndereo_3 = new JLabel("Endereço:");
		lblEndereo_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndereo_3.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblEndereo_3.setBackground(new Color(248, 244, 244));
		lblEndereo_3.setBounds(119, 573, 49, 17);
		contentPane.add(lblEndereo_3);
		
		JLabel lblEnderecoCliente_3 = new JLabel("Rua Governador Souza, 345");
		lblEnderecoCliente_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnderecoCliente_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblEnderecoCliente_3.setBackground(new Color(248, 244, 244));
		lblEnderecoCliente_3.setBounds(173, 572, 122, 17);
		contentPane.add(lblEnderecoCliente_3);
		
		JLabel lblTotal_3 = new JLabel("Total:");
		lblTotal_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal_3.setForeground(Color.RED);
		lblTotal_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTotal_3.setBackground(new Color(248, 244, 244));
		lblTotal_3.setBounds(119, 596, 34, 17);
		contentPane.add(lblTotal_3);
		
		JLabel lblR_3 = new JLabel("R$ 10,00");
		lblR_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblR_3.setForeground(Color.RED);
		lblR_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblR_3.setBackground(new Color(248, 244, 244));
		lblR_3.setBounds(154, 595, 132, 17);
		contentPane.add(lblR_3);
		
		JButton btnNewButton_3 = new JButton("V");
		btnNewButton_3.setForeground(Color.RED);
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setBackground(new Color(242, 242, 242));
		btnNewButton_3.setBounds(140, 623, 133, 17);
		contentPane.add(btnNewButton_3);
		
		JLabel lblPremierCoffe_1_3 = new JLabel("Premier Coffe");
		lblPremierCoffe_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblPremierCoffe_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPremierCoffe_1_3.setBackground(new Color(248, 244, 244));
		lblPremierCoffe_1_3.setBounds(407, 502, 113, 25);
		contentPane.add(lblPremierCoffe_1_3);
		
		JLabel lblNumPedido_1_3 = new JLabel("Pedido Realizado - N° 123");
		lblNumPedido_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumPedido_1_3.setForeground(Color.RED);
		lblNumPedido_1_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNumPedido_1_3.setBackground(new Color(248, 244, 244));
		lblNumPedido_1_3.setBounds(407, 522, 127, 17);
		contentPane.add(lblNumPedido_1_3);
		
		JLabel lblCliente_1_3 = new JLabel("Cliente:");
		lblCliente_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblCliente_1_3.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblCliente_1_3.setBackground(new Color(248, 244, 244));
		lblCliente_1_3.setBounds(353, 554, 43, 17);
		contentPane.add(lblCliente_1_3);
		
		JLabel lblNomeCliente_1_3 = new JLabel("Mateus Bitencourt");
		lblNomeCliente_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCliente_1_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNomeCliente_1_3.setBackground(new Color(248, 244, 244));
		lblNomeCliente_1_3.setBounds(398, 554, 122, 17);
		contentPane.add(lblNomeCliente_1_3);
		
		JLabel lblEndereo_1_3 = new JLabel("Endereço:");
		lblEndereo_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndereo_1_3.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblEndereo_1_3.setBackground(new Color(248, 244, 244));
		lblEndereo_1_3.setBounds(353, 573, 49, 17);
		contentPane.add(lblEndereo_1_3);
		
		JLabel lblEnderecoCliente_1_3 = new JLabel("Rua Governador Souza, 345");
		lblEnderecoCliente_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnderecoCliente_1_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblEnderecoCliente_1_3.setBackground(new Color(248, 244, 244));
		lblEnderecoCliente_1_3.setBounds(407, 572, 122, 17);
		contentPane.add(lblEnderecoCliente_1_3);
		
		JLabel lblTotal_1_3 = new JLabel("Total:");
		lblTotal_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal_1_3.setForeground(Color.RED);
		lblTotal_1_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTotal_1_3.setBackground(new Color(248, 244, 244));
		lblTotal_1_3.setBounds(353, 596, 34, 17);
		contentPane.add(lblTotal_1_3);
		
		JLabel lblR_1_3 = new JLabel("R$ 10,00");
		lblR_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblR_1_3.setForeground(Color.RED);
		lblR_1_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblR_1_3.setBackground(new Color(248, 244, 244));
		lblR_1_3.setBounds(388, 595, 132, 17);
		contentPane.add(lblR_1_3);
		
		JButton btnNewButton_1_3 = new JButton("V");
		btnNewButton_1_3.setForeground(Color.RED);
		btnNewButton_1_3.setBorder(null);
		btnNewButton_1_3.setBackground(new Color(242, 242, 242));
		btnNewButton_1_3.setBounds(374, 623, 133, 17);
		contentPane.add(btnNewButton_1_3);
		
		JButton btnNewButton_1_1_3 = new JButton("V");
		btnNewButton_1_1_3.setForeground(Color.RED);
		btnNewButton_1_1_3.setBorder(null);
		btnNewButton_1_1_3.setBackground(new Color(242, 242, 242));
		btnNewButton_1_1_3.setBounds(610, 625, 133, 17);
		contentPane.add(btnNewButton_1_1_3);
		
		JLabel lblR_1_1_3 = new JLabel("R$ 10,00");
		lblR_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblR_1_1_3.setForeground(Color.RED);
		lblR_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblR_1_1_3.setBackground(new Color(248, 244, 244));
		lblR_1_1_3.setBounds(624, 595, 132, 17);
		contentPane.add(lblR_1_1_3);
		
		JLabel lblTotal_1_1_3 = new JLabel("Total:");
		lblTotal_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal_1_1_3.setForeground(Color.RED);
		lblTotal_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTotal_1_1_3.setBackground(new Color(248, 244, 244));
		lblTotal_1_1_3.setBounds(589, 596, 34, 17);
		contentPane.add(lblTotal_1_1_3);
		
		JLabel lblEndereo_1_1_3 = new JLabel("Endereço:");
		lblEndereo_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndereo_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblEndereo_1_1_3.setBackground(new Color(248, 244, 244));
		lblEndereo_1_1_3.setBounds(589, 573, 49, 17);
		contentPane.add(lblEndereo_1_1_3);
		
		JLabel lblEnderecoCliente_1_1_3 = new JLabel("Rua Governador Souza, 345");
		lblEnderecoCliente_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnderecoCliente_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblEnderecoCliente_1_1_3.setBackground(new Color(248, 244, 244));
		lblEnderecoCliente_1_1_3.setBounds(643, 572, 122, 17);
		contentPane.add(lblEnderecoCliente_1_1_3);
		
		JLabel lblNomeCliente_1_1_3 = new JLabel("Mateus Bitencourt");
		lblNomeCliente_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCliente_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNomeCliente_1_1_3.setBackground(new Color(248, 244, 244));
		lblNomeCliente_1_1_3.setBounds(634, 554, 122, 17);
		contentPane.add(lblNomeCliente_1_1_3);
		
		JLabel lblCliente_1_1_3 = new JLabel("Cliente:");
		lblCliente_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblCliente_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblCliente_1_1_3.setBackground(new Color(248, 244, 244));
		lblCliente_1_1_3.setBounds(589, 554, 43, 17);
		contentPane.add(lblCliente_1_1_3);
		
		JLabel lblNumPedido_1_1_3 = new JLabel("Pedido Realizado - N° 123");
		lblNumPedido_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumPedido_1_1_3.setForeground(Color.RED);
		lblNumPedido_1_1_3.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNumPedido_1_1_3.setBackground(new Color(248, 244, 244));
		lblNumPedido_1_1_3.setBounds(643, 522, 127, 17);
		contentPane.add(lblNumPedido_1_1_3);
		
		JLabel lblPremierCoffe_1_1_3 = new JLabel("Premier Coffe");
		lblPremierCoffe_1_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblPremierCoffe_1_1_3.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPremierCoffe_1_1_3.setBackground(new Color(248, 244, 244));
		lblPremierCoffe_1_1_3.setBounds(643, 502, 113, 25);
		contentPane.add(lblPremierCoffe_1_1_3);
		
		JLabel lblPremierCoffe_1_1_1_2 = new JLabel("Premier Coffe");
		lblPremierCoffe_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblPremierCoffe_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblPremierCoffe_1_1_1_2.setBackground(new Color(248, 244, 244));
		lblPremierCoffe_1_1_1_2.setBounds(879, 500, 113, 25);
		contentPane.add(lblPremierCoffe_1_1_1_2);
		
		JLabel lblNumPedido_1_1_1_2 = new JLabel("Pedido Realizado - N° 123");
		lblNumPedido_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumPedido_1_1_1_2.setForeground(Color.RED);
		lblNumPedido_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNumPedido_1_1_1_2.setBackground(new Color(248, 244, 244));
		lblNumPedido_1_1_1_2.setBounds(879, 520, 127, 17);
		contentPane.add(lblNumPedido_1_1_1_2);
		
		JLabel lblCliente_1_1_1_2 = new JLabel("Cliente:");
		lblCliente_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblCliente_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblCliente_1_1_1_2.setBackground(new Color(248, 244, 244));
		lblCliente_1_1_1_2.setBounds(825, 552, 43, 17);
		contentPane.add(lblCliente_1_1_1_2);
		
		JLabel lblNomeCliente_1_1_1_2 = new JLabel("Mateus Bitencourt");
		lblNomeCliente_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNomeCliente_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblNomeCliente_1_1_1_2.setBackground(new Color(248, 244, 244));
		lblNomeCliente_1_1_1_2.setBounds(870, 552, 122, 17);
		contentPane.add(lblNomeCliente_1_1_1_2);
		
		JLabel lblEndereo_1_1_1_2 = new JLabel("Endereço:");
		lblEndereo_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblEndereo_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 9));
		lblEndereo_1_1_1_2.setBackground(new Color(248, 244, 244));
		lblEndereo_1_1_1_2.setBounds(825, 571, 49, 17);
		contentPane.add(lblEndereo_1_1_1_2);
		
		JLabel lblEnderecoCliente_1_1_1_2 = new JLabel("Rua Governador Souza, 345");
		lblEnderecoCliente_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblEnderecoCliente_1_1_1_2.setFont(new Font("Tahoma", Font.PLAIN, 9));
		lblEnderecoCliente_1_1_1_2.setBackground(new Color(248, 244, 244));
		lblEnderecoCliente_1_1_1_2.setBounds(879, 570, 122, 17);
		contentPane.add(lblEnderecoCliente_1_1_1_2);
		
		JLabel lblTotal_1_1_1_2 = new JLabel("Total:");
		lblTotal_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblTotal_1_1_1_2.setForeground(Color.RED);
		lblTotal_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTotal_1_1_1_2.setBackground(new Color(248, 244, 244));
		lblTotal_1_1_1_2.setBounds(825, 594, 34, 17);
		contentPane.add(lblTotal_1_1_1_2);
		
		JLabel lblR_1_1_1_2 = new JLabel("R$ 10,00");
		lblR_1_1_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblR_1_1_1_2.setForeground(Color.RED);
		lblR_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblR_1_1_1_2.setBackground(new Color(248, 244, 244));
		lblR_1_1_1_2.setBounds(860, 593, 132, 17);
		contentPane.add(lblR_1_1_1_2);
		
		JButton btnNewButton_1_1_1_2 = new JButton("V");
		btnNewButton_1_1_1_2.setForeground(Color.RED);
		btnNewButton_1_1_1_2.setBorder(null);
		btnNewButton_1_1_1_2.setBackground(new Color(242, 242, 242));
		btnNewButton_1_1_1_2.setBounds(846, 623, 133, 17);
		contentPane.add(btnNewButton_1_1_1_2);
		
		JLabel lblFundo = new JLabel("");
		lblFundo.setBorder(null);
		lblFundo.setHorizontalAlignment(SwingConstants.LEFT);
		lblFundo.setBounds(0, 0, 1156, 683);
		lblFundo.setBackground(Color.WHITE);
		lblFundo.setIcon(new ImageIcon(ViewPedidoAceito.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/Tela de pedidos aceitos 1.png")));
		contentPane.add(lblFundo);
	}
}
