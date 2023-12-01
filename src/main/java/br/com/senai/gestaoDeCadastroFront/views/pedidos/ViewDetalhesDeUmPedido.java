package br.com.senai.gestaoDeCadastroFront.views.pedidos;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.gestaoDeCadastroFront.client.pedidos.PedidosClient;
import br.com.senai.gestaoDeCadastroFront.dto.enums.Status;
import br.com.senai.gestaoDeCadastroFront.dto.pedidos.Pedido;

@Component
public class ViewDetalhesDeUmPedido extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private Pedido pedido;
	
	@Autowired
	private PedidosClient pedidosClient;
	
	public void abrirTela(String token, Pedido pedido) {
		this.pedido = pedido;
		this.setVisible(true);
		montarPedido(this.pedido);
	}
	
	public ViewDetalhesDeUmPedido() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
	
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setLocationRelativeTo(null);
	}
	
	private void montarPedido(Pedido pedido) {
		
		JLabel lblNumPedido = new JLabel("Pedido Realizado - N° " + pedido.getIdPedido().toString());
		lblNumPedido.setHorizontalAlignment(SwingConstants.LEFT);
		lblNumPedido.setForeground(Color.RED);
		lblNumPedido.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNumPedido.setBackground(new Color(248, 244, 244));
		lblNumPedido.setBounds(31, 301, 471, 27);
		contentPane.add(lblNumPedido);
		
		JLabel lblPremierCoffe = new JLabel(pedido.getRestaurante().getNome());
		lblPremierCoffe.setHorizontalAlignment(SwingConstants.LEFT);
		lblPremierCoffe.setFont(new Font("Tahoma", Font.BOLD, 43));
		lblPremierCoffe.setBackground(new Color(248, 244, 244));
		lblPremierCoffe.setBounds(31, 227, 549, 52);
		contentPane.add(lblPremierCoffe);
		
		JLabel lblCliente = new JLabel("Cliente:" + pedido.getCliente().getNome());
		lblCliente.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblCliente.setBounds(31, 373, 427, 27);
		contentPane.add(lblCliente);
		
		JLabel lblTotal = new JLabel("Total:" + pedido.getValorTotal().toString());
		lblTotal.setForeground(Color.BLACK);
		lblTotal.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblTotal.setBounds(31, 535, 427, 27);
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
		
		JLabel lblHorario = new JLabel("Data do pedido:" + pedido.getDataPedido().toString());
		lblHorario.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblHorario.setBounds(31, 339, 441, 23);
		contentPane.add(lblHorario);
		
		JLabel lblNumero = new JLabel("Número da residência: " + pedido.getEndereco().getNumero());
		lblNumero.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblNumero.setBounds(31, 411, 471, 27);
		contentPane.add(lblNumero);
		
		JLabel lblCep = new JLabel("CEP: " + pedido.getEndereco().getCep());
		lblCep.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblCep.setBounds(31, 449, 441, 27);
		contentPane.add(lblCep);
		
		JLabel lblRua = new JLabel("Rua: " + pedido.getEndereco().getRua());
		lblRua.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblRua.setBounds(31, 487, 441, 27);
		contentPane.add(lblRua);
		
		JLabel lblCupom = new JLabel("Cupom: " + pedido.getCupom().getCodigo());
		lblCupom.setForeground(Color.GRAY);
		lblCupom.setFont(new Font("Dialog", Font.BOLD, 20));
		lblCupom.setBounds(31, 588, 427, 27);
		contentPane.add(lblCupom);
		
		JLabel lblPagamento = new JLabel("Forma de Pagamento: " + pedido.getPagamento());
		lblPagamento.setFont(new Font("Dialog", Font.PLAIN, 20));
		lblPagamento.setBounds(31, 626, 549, 27);
		contentPane.add(lblPagamento);
		
		JButton btnAceitar = new JButton("Aceitar");
		btnAceitar.setForeground(Color.BLACK);
		btnAceitar.setBackground(new Color(127, 255, 0));
		btnAceitar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAceitar.setBounds(1048, 659, 126, 44);
		btnAceitar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				pedidosClient.atualizarPor(pedido.getIdPedido(), Status.ACEITO_PELO_RESTAURANTE);
				JOptionPane.showMessageDialog(contentPane, "Aceito");
			}
		});
		contentPane.add(btnAceitar);
		
		JButton btnRecusar = new JButton("Recusar");
		btnRecusar.setForeground(Color.WHITE);
		btnRecusar.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnRecusar.setBorder(null);
		btnRecusar.setBackground(Color.RED);
		btnRecusar.setBounds(1214, 659, 126, 44);
		contentPane.add(btnRecusar);
		
	}
}
