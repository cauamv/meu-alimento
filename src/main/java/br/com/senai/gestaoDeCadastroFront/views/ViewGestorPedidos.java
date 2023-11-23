package br.com.senai.gestaoDeCadastroFront.views;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Panel;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewGestorPedidos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ViewGestorPedidos() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1176, 722);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAceitar = new JButton("Aceitar");
		btnAceitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNumPedido = new JLabel("Pedido Realizado - N° 123");
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
		
		Panel panel_4 = new Panel();
		panel_4.setBackground(Color.WHITE);
		panel_4.setBounds(389, 533, 385, 72);
		contentPane.add(panel_4);
		GroupLayout gl_panel_4 = new GroupLayout(panel_4);
		gl_panel_4.setHorizontalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 385, Short.MAX_VALUE)
				.addGap(0, 385, Short.MAX_VALUE)
		);
		gl_panel_4.setVerticalGroup(
			gl_panel_4.createParallelGroup(Alignment.LEADING)
				.addGap(0, 86, Short.MAX_VALUE)
				.addGap(0, 57, Short.MAX_VALUE)
		);
		panel_4.setLayout(gl_panel_4);
		
		Panel panel_3 = new Panel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(389, 455, 385, 72);
		contentPane.add(panel_3);
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 385, Short.MAX_VALUE)
				.addGap(0, 385, Short.MAX_VALUE)
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 86, Short.MAX_VALUE)
				.addGap(0, 57, Short.MAX_VALUE)
		);
		panel_3.setLayout(gl_panel_3);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(389, 377, 385, 72);
		contentPane.add(panel_2);
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 385, Short.MAX_VALUE)
				.addGap(0, 385, Short.MAX_VALUE)
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGap(0, 86, Short.MAX_VALUE)
				.addGap(0, 57, Short.MAX_VALUE)
		);
		panel_2.setLayout(gl_panel_2);
		
		Panel panel_1 = new Panel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(389, 299, 385, 72);
		contentPane.add(panel_1);
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 385, Short.MAX_VALUE)
				.addGap(0, 385, Short.MAX_VALUE)
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 86, Short.MAX_VALUE)
				.addGap(0, 57, Short.MAX_VALUE)
		);
		panel_1.setLayout(gl_panel_1);
		
		Panel panel = new Panel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(389, 221, 385, 72);
		contentPane.add(panel);
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 385, Short.MAX_VALUE)
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 57, Short.MAX_VALUE)
		);
		panel.setLayout(gl_panel);
		
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
		lblFundo.setIcon(new ImageIcon(ViewGestorPedidos.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/Tela inicial após ter logado (cliente) (2).png")));
		lblFundo.setBounds(0, 0, 1162, 690);
		contentPane.add(lblFundo);
	}
}
