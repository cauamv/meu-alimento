package br.com.senai.gestaoDeCadastroFront.views.pedidos.listagem;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class ViewListagemDePedidos extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	
	@PostConstruct
	public void initialize() {
		
	}
	
	public static void main(String[] args) {
		new ViewListagemDePedidos().setVisible(true);
	}
	
	public ViewListagemDePedidos() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(Color.LIGHT_GRAY);
		panelSuperior.setBounds(12, 0, 1389, 103);
		contentPane.add(panelSuperior);
		
		JLabel lblNewLabel = new JLabel("Gestor de Pedidos");
		lblNewLabel.setFont(new Font("Bitstream Charter", Font.BOLD, 38));
		panelSuperior.add(lblNewLabel);
		
		panelPedido();
		
		setLocationRelativeTo(null);
	}
	
	private java.awt.Component gerarPedido(JPanel panelPedido, String cliente, String endereco, String total) {
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
		
		JLabel lblCliente = new JLabel("Cliente: " + cliente);
		
		JLabel lblEndereo = new JLabel("Endereço: " + endereco);
		
		JLabel lblTotal = new JLabel("Total:" + total);
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
	
	private void panelPedido() {
		
		JPanel columnOrganizePanel = new JPanel();
		columnOrganizePanel.setBounds(22, 115, 1332, 559);
		contentPane.add(columnOrganizePanel);
		
		JPanel panelPedido = new JPanel();
		columnOrganizePanel.add(gerarPedido(panelPedido, "Kauan", "88703-656", "R$ 44,90"));
		JPanel panelPedido1 = new JPanel();
		columnOrganizePanel.add(gerarPedido(panelPedido1, "Eduarda", "88703-656", "R$ 45,90"));
		JPanel panelPedido2 = new JPanel();
		columnOrganizePanel.add(gerarPedido(panelPedido2, "philippe", "88703-656", "R$ 95,90"));
		JPanel panelPedido3 = new JPanel();
		columnOrganizePanel.add(gerarPedido(panelPedido3, "User 1", "88703-656", "R$ 9,90"));
		JPanel panelPedido4 = new JPanel();
		columnOrganizePanel.add(gerarPedido(panelPedido4, "User 2", "88703-656", "R$ 145,90"));
		JPanel panelPedido5 = new JPanel();
		columnOrganizePanel.add(gerarPedido(panelPedido5, "User 3", "88703-656", "R$ 78,50"));
		JPanel panelPedido6 = new JPanel();
		columnOrganizePanel.add(gerarPedido(panelPedido6, "User 4", "88703-656", "R$ 65,90"));
		
	}
}