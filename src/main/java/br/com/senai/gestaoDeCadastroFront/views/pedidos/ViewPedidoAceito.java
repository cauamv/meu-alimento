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

import jakarta.annotation.PostConstruct;

@Component
public class ViewPedidoAceito extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	@PostConstruct
	public void initialize() {
		
	}
	
	public ViewPedidoAceito() {

		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1176, 722);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
		JButton btnAceitar = new JButton("Aceitar");
		btnAceitar.setBounds(104, 622, 100, 35);
		btnAceitar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.setLayout(null);
		
		Panel panel_4_1 = new Panel();
		panel_4_1.setBackground(Color.WHITE);
		panel_4_1.setBounds(694, 533, 385, 72);
		contentPane.add(panel_4_1);
		GroupLayout gl_panel_4_1 = new GroupLayout(panel_4_1);
		gl_panel_4_1.setHorizontalGroup(
			gl_panel_4_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 385, Short.MAX_VALUE)
				.addGap(0, 385, Short.MAX_VALUE)
		);
		gl_panel_4_1.setVerticalGroup(
			gl_panel_4_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 72, Short.MAX_VALUE)
				.addGap(0, 72, Short.MAX_VALUE)
		);
		panel_4_1.setLayout(gl_panel_4_1);
		
		JButton btnAceitar_1 = new JButton("Aceitar");
		btnAceitar_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnAceitar_1.setBorder(null);
		btnAceitar_1.setBackground(new Color(183, 249, 188));
		btnAceitar_1.setBounds(729, 622, 100, 35);
		contentPane.add(btnAceitar_1);
		
		Panel panel_5 = new Panel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(694, 221, 385, 72);
		contentPane.add(panel_5);
		GroupLayout gl_panel_5 = new GroupLayout(panel_5);
		gl_panel_5.setHorizontalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 385, Short.MAX_VALUE)
				.addGap(0, 385, Short.MAX_VALUE)
		);
		gl_panel_5.setVerticalGroup(
			gl_panel_5.createParallelGroup(Alignment.LEADING)
				.addGap(0, 72, Short.MAX_VALUE)
				.addGap(0, 72, Short.MAX_VALUE)
		);
		panel_5.setLayout(gl_panel_5);
		
		JButton btnRecusar_1 = new JButton("Recusar");
		btnRecusar_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRecusar_1.setBorder(null);
		btnRecusar_1.setBackground(new Color(255, 169, 168));
		btnRecusar_1.setBounds(955, 622, 100, 35);
		contentPane.add(btnRecusar_1);
		
		Panel panel_3_1 = new Panel();
		panel_3_1.setBackground(Color.WHITE);
		panel_3_1.setBounds(694, 455, 385, 72);
		contentPane.add(panel_3_1);
		GroupLayout gl_panel_3_1 = new GroupLayout(panel_3_1);
		gl_panel_3_1.setHorizontalGroup(
			gl_panel_3_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 385, Short.MAX_VALUE)
				.addGap(0, 385, Short.MAX_VALUE)
		);
		gl_panel_3_1.setVerticalGroup(
			gl_panel_3_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 72, Short.MAX_VALUE)
				.addGap(0, 72, Short.MAX_VALUE)
		);
		panel_3_1.setLayout(gl_panel_3_1);
		
		Panel panel_2_1 = new Panel();
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(694, 377, 385, 72);
		contentPane.add(panel_2_1);
		GroupLayout gl_panel_2_1 = new GroupLayout(panel_2_1);
		gl_panel_2_1.setHorizontalGroup(
			gl_panel_2_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 385, Short.MAX_VALUE)
				.addGap(0, 385, Short.MAX_VALUE)
		);
		gl_panel_2_1.setVerticalGroup(
			gl_panel_2_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 72, Short.MAX_VALUE)
				.addGap(0, 72, Short.MAX_VALUE)
		);
		panel_2_1.setLayout(gl_panel_2_1);
		
		Panel panel_1_1 = new Panel();
		panel_1_1.setBackground(Color.WHITE);
		panel_1_1.setBounds(694, 299, 385, 72);
		contentPane.add(panel_1_1);
		GroupLayout gl_panel_1_1 = new GroupLayout(panel_1_1);
		gl_panel_1_1.setHorizontalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 385, Short.MAX_VALUE)
				.addGap(0, 385, Short.MAX_VALUE)
		);
		gl_panel_1_1.setVerticalGroup(
			gl_panel_1_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 72, Short.MAX_VALUE)
				.addGap(0, 72, Short.MAX_VALUE)
		);
		panel_1_1.setLayout(gl_panel_1_1);
		
		JLabel lblNumPedido_2 = new JLabel("Pedido Realizado - N° 123");
		lblNumPedido_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumPedido_2.setForeground(Color.RED);
		lblNumPedido_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumPedido_2.setBackground(new Color(248, 244, 244));
		lblNumPedido_2.setBounds(759, 194, 221, 27);
		contentPane.add(lblNumPedido_2);
		
		JLabel lblPremierCoffe_2 = new JLabel("Premier Coffe");
		lblPremierCoffe_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblPremierCoffe_2.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPremierCoffe_2.setBackground(new Color(248, 244, 244));
		lblPremierCoffe_2.setBounds(738, 162, 180, 40);
		contentPane.add(lblPremierCoffe_2);
		
		JLabel lblNumPedido = new JLabel("Pedido Realizado - N° 123");
		lblNumPedido.setBounds(115, 194, 221, 27);
		lblNumPedido.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumPedido.setForeground(Color.RED);
		lblNumPedido.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNumPedido.setBackground(new Color(248, 244, 244));
		contentPane.add(lblNumPedido);
		
		JLabel lblPremierCoffe = new JLabel("Premier Coffe");
		lblPremierCoffe.setBounds(93, 162, 180, 40);
		lblPremierCoffe.setHorizontalAlignment(SwingConstants.CENTER);
		lblPremierCoffe.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblPremierCoffe.setBackground(new Color(248, 244, 244));
		contentPane.add(lblPremierCoffe);
		
		JButton btnRecusar = new JButton("Recusar");
		btnRecusar.setBounds(330, 622, 100, 35);
		btnRecusar.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnRecusar.setBorder(null);
		btnRecusar.setBackground(new Color(255, 169, 168));
		contentPane.add(btnRecusar);
		btnAceitar.setBorder(null);
		btnAceitar.setBackground(new Color(183, 249, 188));
		btnAceitar.setFont(new Font("Tahoma", Font.BOLD, 15));
		contentPane.add(btnAceitar);
		
		Panel panel_4 = new Panel();
		panel_4.setBounds(69, 533, 385, 72);
		panel_4.setBackground(Color.WHITE);
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
		panel_3.setBounds(69, 455, 385, 72);
		panel_3.setBackground(Color.WHITE);
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
		panel_2.setBounds(69, 377, 385, 72);
		panel_2.setBackground(Color.WHITE);
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
		panel_1.setBounds(69, 299, 385, 72);
		panel_1.setBackground(Color.WHITE);
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
		
		Panel panelInformacoesPedido = new Panel();
		panelInformacoesPedido.setBounds(69, 221, 385, 72);
		panelInformacoesPedido.setBackground(Color.WHITE);
		contentPane.add(panelInformacoesPedido);
		GroupLayout gl_panelInformacoesPedido = new GroupLayout(panelInformacoesPedido);
		gl_panelInformacoesPedido.setHorizontalGroup(
			gl_panelInformacoesPedido.createParallelGroup(Alignment.LEADING)
				.addGap(0, 385, Short.MAX_VALUE)
		);
		gl_panelInformacoesPedido.setVerticalGroup(
			gl_panelInformacoesPedido.createParallelGroup(Alignment.LEADING)
				.addGap(0, 57, Short.MAX_VALUE)
		);
		panelInformacoesPedido.setLayout(gl_panelInformacoesPedido);
		
		JLabel lblTempoMedio = new JLabel("30 minutos");
		lblTempoMedio.setBounds(992, 45, 180, 40);
		lblTempoMedio.setHorizontalAlignment(SwingConstants.CENTER);
		lblTempoMedio.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblTempoMedio.setBackground(new Color(248, 244, 244));
		contentPane.add(lblTempoMedio);
		
		JLabel lblNumPedidosEntregues = new JLabel("0");
		lblNumPedidosEntregues.setBounds(230, 43, 111, 40);
		lblNumPedidosEntregues.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumPedidosEntregues.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNumPedidosEntregues.setBackground(new Color(248, 244, 244));
		contentPane.add(lblNumPedidosEntregues);
		
		JLabel lblNumPedidosNaoEntregues = new JLabel("0");
		lblNumPedidosNaoEntregues.setBounds(47, 43, 111, 40);
		lblNumPedidosNaoEntregues.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumPedidosNaoEntregues.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblNumPedidosNaoEntregues.setBackground(Color.WHITE);
		contentPane.add(lblNumPedidosNaoEntregues);
		
		JLabel lblNaoEntregues = new JLabel("Não Entregues");
		lblNaoEntregues.setBounds(47, 81, 111, 27);
		lblNaoEntregues.setHorizontalAlignment(SwingConstants.CENTER);
		lblNaoEntregues.setForeground(Color.RED);
		lblNaoEntregues.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNaoEntregues.setBackground(new Color(248, 244, 244));
		contentPane.add(lblNaoEntregues);
		
		JLabel lblEntregues = new JLabel("Entregues");
		lblEntregues.setBounds(230, 81, 100, 27);
		lblEntregues.setForeground(Color.RED);
		lblEntregues.setHorizontalAlignment(SwingConstants.CENTER);
		lblEntregues.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEntregues.setBackground(new Color(248, 244, 244));
		contentPane.add(lblEntregues);
		
		JLabel lblNaoEntregue = new JLabel("");
		lblNaoEntregue.setBounds(91, 55, 46, 35);
		contentPane.add(lblNaoEntregue);
		
		JLabel lblEntregue = new JLabel("");
		lblEntregue.setBounds(284, 55, 46, 35);
		contentPane.add(lblEntregue);
		
		JLabel lblTempoEntrega = new JLabel("Tempo médio de entrega");
		lblTempoEntrega.setBounds(948, 82, 187, 27);
		lblTempoEntrega.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTempoEntrega.setHorizontalAlignment(SwingConstants.CENTER);
		lblTempoEntrega.setBackground(new Color(248,244,244));
		contentPane.add(lblTempoEntrega);
		
		setLocationRelativeTo(null);
	}
}
