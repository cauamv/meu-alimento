package br.com.senai.gestaoDeCadastroFront.views.pedidos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import br.com.senai.gestaoDeCadastroFront.client.authenticate.server.CredencialDeAcesso;
import br.com.senai.gestaoDeCadastroFront.client.decode.TokenDecoder;
import br.com.senai.gestaoDeCadastroFront.client.pedidos.PedidosClient;
import br.com.senai.gestaoDeCadastroFront.components.table.PedidosTableModel;
import br.com.senai.gestaoDeCadastroFront.dto.Paginacao;
import br.com.senai.gestaoDeCadastroFront.dto.enums.Status;
import br.com.senai.gestaoDeCadastroFront.dto.pedidos.Pedido;
import br.com.senai.gestaoDeCadastroFront.views.ViewPrincipal;
import javax.swing.JProgressBar;

@Component
public class ViewTablePedidos extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JTable tbPedidos;
	
	private JScrollPane scrollPane;
	
	private JLabel lblRestaurante;
	
	@Autowired
	private PedidosClient pedidosClient;
	
	private String token;
	
	@Autowired
	@Lazy
	private ViewPrincipal viewPrincipal;
	
	@Autowired
	private ViewDetalhesDeUmPedido viewDetalhesDeUmPedido;
	
	private CredencialDeAcesso credencial;
	
	private JProgressBar progressBar;
	
	public void abrirTela(String token, CredencialDeAcesso credencialDeAcesso) {
		this.token = token;
		this.credencial = credencialDeAcesso;
		this.setVisible(true);
		this.limparDadosAntigos();
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				listarPedidos();           
				
			}
		});
		
		thread.start();
	}
	
	public ViewTablePedidos() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 0, 1350, 104);
		contentPane.add(panel);
				panel.setLayout(null);
				
				JButton btnNewButton = new JButton("Atualizar");
				btnNewButton.setBorder(new EmptyBorder(0,0,0,0));
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						progressBar.setVisible(true);
						limparDadosAntigos();
						listarPedidos();
					}
				});
				btnNewButton.setForeground(Color.WHITE);
				btnNewButton.setFont(new Font("Dialog", Font.PLAIN, 11));
				btnNewButton.setBackground(Color.RED);
				btnNewButton.setBounds(1234, 39, 106, 37);
				panel.add(btnNewButton);
				
				JButton btnVoltar = new JButton("<");
				btnVoltar.setBounds(0, 40, 89, 23);
				panel.add(btnVoltar);
				btnVoltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						viewPrincipal.abrirTela(credencial);
						dispose();
					}
				});
				btnVoltar.setRolloverEnabled(true);
				btnVoltar.setForeground(Color.WHITE);
				btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 27));
				btnVoltar.setBorder(null);
				btnVoltar.setBackground(Color.RED);
				
				JButton bntDetalhes = new JButton("Detalhes");
				bntDetalhes.setBackground(Color.RED);
				bntDetalhes.setForeground(Color.WHITE);
				bntDetalhes.setBounds(1176, 683, 141, 35);
				bntDetalhes.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						int linhaSelecionada = tbPedidos.getSelectedRow();
						PedidosTableModel model = (PedidosTableModel) tbPedidos.getModel();
						Pedido pedidoSelecionado = model.getPor(linhaSelecionada);
						viewDetalhesDeUmPedido.abrirTela(pedidoSelecionado, pedidoSelecionado.getStatus());
						
					}
				});
				contentPane.add(bntDetalhes);
				
				lblRestaurante = new JLabel("");
				lblRestaurante.setBounds(26, 115, 1070, 49);
				contentPane.add(lblRestaurante);
				lblRestaurante.setForeground(Color.BLACK);
				lblRestaurante.setFont(new Font("Dialog", Font.PLAIN, 36));
				
				progressBar = new JProgressBar();
				progressBar.setIndeterminate(true);
				progressBar.setBounds(36, 354, 1281, 79);
				contentPane.add(progressBar);
				
		tbPedidos = new JTable(new PedidosTableModel());
		tbPedidos.setBackground(new Color(240, 240, 240));
		this.configurarCabecalhos(tbPedidos);
		setLocationRelativeTo(null);
		
	}
	
	private void configurarCabecalhos(JTable tbPedidos) {
		tbPedidos.getTableHeader().setOpaque(false);
		tbPedidos.getTableHeader().setBackground(Color.RED);
		tbPedidos.getTableHeader().setForeground(Color.WHITE);
		tbPedidos.getTableHeader().setReorderingAllowed(false);
		tbPedidos.getTableHeader().setResizingAllowed(false);
		tbPedidos.getTableHeader().setPreferredSize(new Dimension(tbPedidos.getTableHeader().getWidth(), 50));
	}
	
	private void listarPedidos() {
		List<Pedido> pedidos = new ArrayList<Pedido>();
		
		TokenDecoder decoder = new TokenDecoder();
        Integer id = Integer.parseInt(decoder.extrairIdRestauranteDo(token));

        Paginacao<Pedido> realizados = pedidosClient.listarPor(id, 0, Status.REALIZADO);
        pedidos.addAll(realizados.getListagem());
         
        Paginacao<Pedido> prontoParaColeta = pedidosClient.listarPor(id, 0, Status.PRONTO_PARA_COLETA);
        pedidos.addAll(prontoParaColeta.getListagem());
        
        Paginacao<Pedido> aceitoPeloRestaurante = pedidosClient.listarPor(id, 0, Status.ACEITO_PELO_RESTAURANTE);
        pedidos.addAll(aceitoPeloRestaurante.getListagem());
        
        for (int i = 0; i <= realizados.getTotalDePaginas(); i++) {
        	pedidos.addAll(pedidosClient.listarPor(id, i + 1, Status.REALIZADO).getListagem());
        }

        for (int i = 0; i <= prontoParaColeta.getTotalDePaginas(); i++) {
        	pedidos.addAll(pedidosClient.listarPor(id, i + 1, Status.PRONTO_PARA_COLETA).getListagem());
        }

        for (int i = 0; i <= aceitoPeloRestaurante.getTotalDePaginas(); i++) {
        	pedidos.addAll(pedidosClient.listarPor(id, i + 1, Status.ACEITO_PELO_RESTAURANTE).getListagem());
		}
        
        this.lblRestaurante.setText(pedidos.get(1).getRestaurante().getNome());
        progressBar.setVisible(false);
		PedidosTableModel model = new PedidosTableModel(pedidos);
		tbPedidos.setModel(model);

		DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment(JLabel.CENTER);
		tbPedidos.setDefaultRenderer(Object.class, centerRenderer);

		tbPedidos.setRowHeight(40);

		tbPedidos.setBackground(new Color(240, 240, 240));
		tbPedidos.setFont(new Font("Arial", Font.PLAIN, 18));
		tbPedidos.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));

		tbPedidos.getTableHeader().setBackground(new Color(255, 52, 52));
		tbPedidos.getTableHeader().setForeground(Color.WHITE);

		scrollPane = new JScrollPane(tbPedidos);
		scrollPane.setBackground(new Color(255, 52, 52));
		scrollPane.setBorder(null);
		scrollPane.setBounds(40, 305, 1284, 314);
		contentPane.add(scrollPane);
	}
	
	private void limparDadosAntigos() {
		if (scrollPane != null) {
			contentPane.remove(scrollPane);
		}
		contentPane.remove(tbPedidos);
	    tbPedidos.setModel(new PedidosTableModel());
	}
}
