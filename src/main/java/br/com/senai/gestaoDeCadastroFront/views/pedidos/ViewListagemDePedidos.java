package br.com.senai.gestaoDeCadastroFront.views.pedidos;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.gestaoDeCadastroFront.client.decode.TokenDecoder;
import br.com.senai.gestaoDeCadastroFront.client.pedidos.PedidosClient;
import br.com.senai.gestaoDeCadastroFront.dto.Paginacao;
import br.com.senai.gestaoDeCadastroFront.dto.enums.Status;
import br.com.senai.gestaoDeCadastroFront.dto.pedidos.Pedido;

@Component
public class ViewListagemDePedidos extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	@Autowired
	private PedidosClient pedidosClient;
	
	@Autowired
	@Lazy
	private ViewDetalhesDeUmPedido viewDetalhesDeUmPedido;
	
	public void abrirTela(String token) {
		this.token = token;
		
		this.setVisible(true); 
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				gerarCards(token);
			}
		});
		thread.start();
	}
	
	private String token;
	
	public void gerarCards(String token) {
		JPanel columnOrganizePanel = new JPanel(); 
		columnOrganizePanel.setBounds(10, 115, 1344, 559);
		contentPane.add(columnOrganizePanel);
		
		try {
		
			TokenDecoder decoder = new TokenDecoder();
			Integer id = Integer.parseInt(decoder.extrairIdRestauranteDo(token));
			Paginacao<Pedido> paginas = pedidosClient.listarPor(id, 0, Status.REALIZADO);
			
			for (int i = 0; i < paginas.getListagem().size(); i++) {
				Pedido pedido = paginas.getListagem().get(i); 
				columnOrganizePanel.add(gerarPedido(new JPanel(), pedido));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Autowired
	public ViewListagemDePedidos() {
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.LIGHT_GRAY);
		panelSuperior.setBounds(0, 0, 1401, 103);
		contentPane.add(panelSuperior);
		
		JLabel lblNewLabel = new JLabel("Gestor de Pedidos");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Bitstream Charter", Font.BOLD, 38));
		GroupLayout gl_panelSuperior = new GroupLayout(panelSuperior);
		gl_panelSuperior.setHorizontalGroup(
			gl_panelSuperior.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelSuperior.createSequentialGroup()
					.addContainerGap(543, Short.MAX_VALUE)
					.addComponent(lblNewLabel)
					.addGap(538))
		);
		gl_panelSuperior.setVerticalGroup(
			gl_panelSuperior.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelSuperior.createSequentialGroup()
					.addGap(23)
					.addComponent(lblNewLabel)
					.addContainerGap(34, Short.MAX_VALUE))
		);
		panelSuperior.setLayout(gl_panelSuperior);
		
		setLocationRelativeTo(null);
	}
	
	private java.awt.Component gerarPedido(JPanel panelPedido, Pedido pedido) {
		panelPedido.setBorder(new TitledBorder(new LineBorder(new Color(184, 207, 229)), "N\u00B0 do pedido", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(51, 51, 51)));
		panelPedido.setBackground(Color.LIGHT_GRAY);
		
		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(Color.LIGHT_GRAY);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		GroupLayout gl_panelPedido = new GroupLayout(panelPedido);
		gl_panelPedido.setHorizontalGroup(
			gl_panelPedido.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPedido.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panelPedido.createParallelGroup(Alignment.LEADING)
						.addComponent(panel, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
						.addGroup(gl_panelPedido.createSequentialGroup()
							.addComponent(panelInfo, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
							.addGap(61))))
		);
		gl_panelPedido.setVerticalGroup(
			gl_panelPedido.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelPedido.createSequentialGroup()
					.addContainerGap()
					.addComponent(panelInfo, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE)
					.addContainerGap())
		);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnV = new JButton("V");
		panel.add(btnV);
		btnV.setForeground(Color.RED);
		btnV.setBackground(Color.LIGHT_GRAY);
		btnV.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewDetalhesDeUmPedido.abrirTela(token, pedido);
			}
		});
		
		
		JLabel lblCliente = new JLabel("Cliente: " + pedido.getCliente().getNome());
		
		JLabel lblEndereo = new JLabel("Endereço: " + pedido.getEndereco().getRua());
		
		JLabel lblTotal = new JLabel("Total:" + pedido.getValorTotal().toString());
		GroupLayout gl_panelInfo = new GroupLayout(panelInfo);
		gl_panelInfo.setHorizontalGroup(
			gl_panelInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelInfo.createSequentialGroup()
					.addGap(5)
					.addGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING)
						.addComponent(lblCliente)
						.addComponent(lblEndereo)
						.addComponent(lblTotal))
					.addContainerGap(115, Short.MAX_VALUE))
		);
		gl_panelInfo.setVerticalGroup(
			gl_panelInfo.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelInfo.createSequentialGroup()
					.addContainerGap(18, Short.MAX_VALUE)
					.addComponent(lblCliente)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblEndereo)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(lblTotal))
		);
		panelInfo.setLayout(gl_panelInfo);
		panelPedido.setLayout(gl_panelPedido);
		return panelPedido;
	}
	
}