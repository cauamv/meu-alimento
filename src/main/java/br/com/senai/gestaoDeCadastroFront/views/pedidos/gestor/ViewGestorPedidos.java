package br.com.senai.gestaoDeCadastroFront.views.pedidos.gestor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ImageIcon;
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
	
	private ViewGestorPedidos viewGestorPedidos;
	
	public void abrirTela() {
		viewGestorPedidos.setVisible(true);
	}

	public ViewGestorPedidos() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAceitar = new JButton("Aceitar");
		btnAceitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNumPedido = new JLabel("Pedido Realizado - N° ");
		lblNumPedido.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumPedido.setForeground(Color.RED);
		lblNumPedido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumPedido.setBackground(new Color(248, 244, 244));
		lblNumPedido.setBounds(454, 188, 221, 27);
		contentPane.add(lblNumPedido);
		
		JLabel lblPremierCoffe = new JLabel("Premier Coffe");
		lblPremierCoffe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPremierCoffe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPremierCoffe.setBackground(new Color(248, 244, 244));
		lblPremierCoffe.setBounds(433, 161, 180, 40);
		contentPane.add(lblPremierCoffe);
		
		JButton btnRecusar = new JButton("Recusar");
		btnRecusar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRecusar.setBorder(null);
		btnRecusar.setBackground(new Color(255, 169, 168));
		btnRecusar.setBounds(641, 622, 100, 35);
		contentPane.add(btnRecusar);
		btnAceitar.setBorder(null);
		btnAceitar.setBackground(new Color(183, 249, 188));
		btnAceitar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAceitar.setBounds(433, 622, 100, 35);
		contentPane.add(btnAceitar);
		
		Panel panelInfoPagamento = new Panel();
		panelInfoPagamento.setBackground(Color.WHITE);
		panelInfoPagamento.setBounds(389, 533, 385, 72);
		contentPane.add(panelInfoPagamento);
		GroupLayout gl_panelInfoPagamento = new GroupLayout(panelInfoPagamento);
		gl_panelInfoPagamento.setHorizontalGroup(
			gl_panelInfoPagamento.createParallelGroup(Alignment.LEADING)
				.addGap(0, 385, Short.MAX_VALUE)
				.addGap(0, 385, Short.MAX_VALUE)
		);
		gl_panelInfoPagamento.setVerticalGroup(
			gl_panelInfoPagamento.createParallelGroup(Alignment.LEADING)
				.addGap(0, 86, Short.MAX_VALUE)
				.addGap(0, 57, Short.MAX_VALUE)
		);
		panelInfoPagamento.setLayout(gl_panelInfoPagamento);
		
		Panel panelInfoOpcoesDoPedido = new Panel();
		panelInfoOpcoesDoPedido.setBackground(Color.WHITE);
		panelInfoOpcoesDoPedido.setBounds(389, 455, 385, 72);
		contentPane.add(panelInfoOpcoesDoPedido);
		GroupLayout gl_panelInfoOpcoesDoPedido = new GroupLayout(panelInfoOpcoesDoPedido);
		gl_panelInfoOpcoesDoPedido.setHorizontalGroup(
			gl_panelInfoOpcoesDoPedido.createParallelGroup(Alignment.LEADING)
				.addGap(0, 385, Short.MAX_VALUE)
				.addGap(0, 385, Short.MAX_VALUE)
		);
		gl_panelInfoOpcoesDoPedido.setVerticalGroup(
			gl_panelInfoOpcoesDoPedido.createParallelGroup(Alignment.LEADING)
				.addGap(0, 86, Short.MAX_VALUE)
				.addGap(0, 57, Short.MAX_VALUE)
		);
		panelInfoOpcoesDoPedido.setLayout(gl_panelInfoOpcoesDoPedido);
		
		Panel panelInfoEndereco = new Panel();
		panelInfoEndereco.setBackground(Color.WHITE);
		panelInfoEndereco.setBounds(389, 377, 385, 72);
		contentPane.add(panelInfoEndereco);
		GroupLayout gl_panelInfoEndereco = new GroupLayout(panelInfoEndereco);
		gl_panelInfoEndereco.setHorizontalGroup(
			gl_panelInfoEndereco.createParallelGroup(Alignment.LEADING)
				.addGap(0, 385, Short.MAX_VALUE)
				.addGap(0, 385, Short.MAX_VALUE)
		);
		gl_panelInfoEndereco.setVerticalGroup(
			gl_panelInfoEndereco.createParallelGroup(Alignment.LEADING)
				.addGap(0, 86, Short.MAX_VALUE)
				.addGap(0, 57, Short.MAX_VALUE)
		);
		panelInfoEndereco.setLayout(gl_panelInfoEndereco);
		
		Panel panelInfoCliente = new Panel();
		panelInfoCliente.setBackground(Color.WHITE);
		panelInfoCliente.setBounds(389, 299, 385, 72);
		contentPane.add(panelInfoCliente);
		GroupLayout gl_panelInfoCliente = new GroupLayout(panelInfoCliente);
		gl_panelInfoCliente.setHorizontalGroup(
			gl_panelInfoCliente.createParallelGroup(Alignment.LEADING)
				.addGap(0, 385, Short.MAX_VALUE)
				.addGap(0, 385, Short.MAX_VALUE)
		);
		gl_panelInfoCliente.setVerticalGroup(
			gl_panelInfoCliente.createParallelGroup(Alignment.LEADING)
				.addGap(0, 86, Short.MAX_VALUE)
				.addGap(0, 57, Short.MAX_VALUE)
		);
		panelInfoCliente.setLayout(gl_panelInfoCliente);
		
		Panel panelInfoPedidos = new Panel();
		panelInfoPedidos.setBackground(Color.WHITE);
		panelInfoPedidos.setBounds(389, 221, 385, 72);
		contentPane.add(panelInfoPedidos);
		GroupLayout gl_panelInfoPedidos = new GroupLayout(panelInfoPedidos);
		gl_panelInfoPedidos.setHorizontalGroup(
			gl_panelInfoPedidos.createParallelGroup(Alignment.LEADING)
				.addGap(0, 385, Short.MAX_VALUE)
		);
		gl_panelInfoPedidos.setVerticalGroup(
			gl_panelInfoPedidos.createParallelGroup(Alignment.LEADING)
				.addGap(0, 57, Short.MAX_VALUE)
		);
		panelInfoPedidos.setLayout(gl_panelInfoPedidos);
		
		JLabel lblTempoMedio = new JLabel("30 minutos");
		lblTempoMedio.setHorizontalAlignment(SwingConstants.CENTER);
		lblTempoMedio.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTempoMedio.setBackground(new Color(248, 244, 244));
		lblTempoMedio.setBounds(970, 45, 180, 40);
		contentPane.add(lblTempoMedio);
		
		JLabel lblNumPedidosEntregues = new JLabel("0");
		lblNumPedidosEntregues.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumPedidosEntregues.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNumPedidosEntregues.setBackground(new Color(248, 244, 244));
		lblNumPedidosEntregues.setBounds(230, 43, 111, 40);
		contentPane.add(lblNumPedidosEntregues);
		
		JLabel lblNumPedidosNaoEntregues = new JLabel("0");
		lblNumPedidosNaoEntregues.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumPedidosNaoEntregues.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNumPedidosNaoEntregues.setBackground(Color.WHITE);
		lblNumPedidosNaoEntregues.setBounds(47, 43, 111, 40);
		contentPane.add(lblNumPedidosNaoEntregues);
		
		JLabel lblNaoEntregues = new JLabel("Não Entregues");
		lblNaoEntregues.setHorizontalAlignment(SwingConstants.CENTER);
		lblNaoEntregues.setForeground(Color.RED);
		lblNaoEntregues.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNaoEntregues.setBackground(new Color(248, 244, 244));
		lblNaoEntregues.setBounds(47, 81, 111, 27);
		contentPane.add(lblNaoEntregues);
		
		JLabel lblEntregues = new JLabel("Entregues");
		lblEntregues.setForeground(Color.RED);
		lblEntregues.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntregues.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEntregues.setBackground(new Color(248, 244, 244));
		lblEntregues.setBounds(230, 81, 100, 27);
		contentPane.add(lblEntregues);
		
		JLabel lblNaoEntregue = new JLabel("");
		lblNaoEntregue.setBounds(91, 55, 46, 35);
		contentPane.add(lblNaoEntregue);
		
		JLabel lblEntregue = new JLabel("");
		lblEntregue.setBounds(284, 55, 46, 35);
		contentPane.add(lblEntregue);
		
		JLabel lblTempoEntrega = new JLabel("Tempo médio de entrega");
		lblTempoEntrega.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTempoEntrega.setHorizontalAlignment(SwingConstants.CENTER);
		lblTempoEntrega.setBackground(new Color(248,244,244));
		lblTempoEntrega.setBounds(948, 82, 187, 27);
		contentPane.add(lblTempoEntrega);
		
		JLabel lblFundo = new JLabel("");
		lblFundo.setBackground(Color.WHITE);
		lblFundo.setIcon(new ImageIcon(ViewGestorPedidos.class.getResource("./imageGestor.png")));
		lblFundo.setBounds(0, 0, 1162, 690);
		contentPane.add(lblFundo);
		
		setLocationRelativeTo(null);
	}
}
