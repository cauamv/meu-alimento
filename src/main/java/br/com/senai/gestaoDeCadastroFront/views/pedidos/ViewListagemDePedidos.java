package br.com.senai.gestaoDeCadastroFront.views.pedidos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.EmptyBorder;

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
    private ViewDetalhesDeUmPedido viewDetalhesDeUmPedido;

    @Autowired
    private PedidosClient pedidosClient;

    public ViewListagemDePedidos() {
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1366, 768);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setResizable(false);
        setLocationRelativeTo(null);
        setContentPane(contentPane);
    }

    private String token;

    public void abrirTela(String token) {
        this.token = token;
        this.setVisible(true);
        gerarCards();
    }

    public void gerarCards() {
        JPanel cards = new JPanel(new GridLayout(0, 4, 10, 10));
        cards.setBounds(10, 159, 1366, 768);

        List<Pedido> todosPedidos = new ArrayList<>();
        
        TokenDecoder decoder = new TokenDecoder();
        Integer id = Integer.parseInt(decoder.extrairIdRestauranteDo(token));

        Paginacao<Pedido> realizados = pedidosClient.listarPor(id, 0, Status.REALIZADO);
        Paginacao<Pedido> prontoParaColeta = pedidosClient.listarPor(id, 0, Status.PRONTO_PARA_COLETA);
        Paginacao<Pedido> aceitoPeloRestaurante = pedidosClient.listarPor(id, 0, Status.ACEITO_PELO_RESTAURANTE);
        
        for (int i = 0; i < realizados.getTotalDeItens(); i++) {
        	if (i < 4) {        		
        		todosPedidos.add(realizados.getListagem().get(i));
        	}
        }
        
        for (int i = 0; i < prontoParaColeta.getTotalDeItens(); i++) {
        	if (i < 4) {        		
        		todosPedidos.add(prontoParaColeta.getListagem().get(i));
        	}
        }
        
        for (int i = 0; i < aceitoPeloRestaurante.getTotalDeItens(); i++) {
        	if (i < 4) {        		
        		todosPedidos.add(aceitoPeloRestaurante.getListagem().get(i));
        	}
        }
        
        for (int i = 0; i < todosPedidos.size(); i++) {
        	JPanel panelPedido = criarCard(
        			new JPanel(),
        			new JLabel(),
        			new JLabel(),
        			new JLabel(),
        			new JButton(),
        			new JLabel(),
        			todosPedidos.get(i)
        			);
            cards.add(panelPedido);
        }

        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(cards, GroupLayout.PREFERRED_SIZE, 1330, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(19, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
                gl_contentPane.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(gl_contentPane.createSequentialGroup()
                                .addContainerGap(159, Short.MAX_VALUE)
                                .addComponent(cards, GroupLayout.PREFERRED_SIZE, 549, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())
        );

        contentPane.setLayout(gl_contentPane);
    }

    private JPanel criarCard(
    		JPanel panelPedido,
		    JLabel lblNumeroDoPedido,
		    JLabel lblLocalDeEntrega,
		    JLabel lblTotal,
    		JButton btnDetalhes,
    		JLabel lblStatusDoPedido,
    		Pedido pedido) {
    	
    	
        panelPedido = new JPanel();

        lblNumeroDoPedido = new JLabel("N° do pedido: " + pedido.getIdPedido());
        lblLocalDeEntrega = new JLabel("Local de entrega: " + pedido.getEndereco().getRua());
        lblTotal = new JLabel("Total: R$" + pedido.getValorTotal().toString());
        
        btnDetalhes = new JButton("Detalhes");
        btnDetalhes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
                viewDetalhesDeUmPedido.abrirTela(token, pedido, pedido.getStatus());
                contentPane.removeAll();
			}
		});
        
        lblStatusDoPedido = new JLabel("Status: " + pedido.getStatus().toString());

        GroupLayout gl_panelPedido = new GroupLayout(panelPedido);
        gl_panelPedido.setHorizontalGroup(
                gl_panelPedido.createParallelGroup(GroupLayout.Alignment.LEADING)
                        .addGroup(gl_panelPedido.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(gl_panelPedido.createParallelGroup(GroupLayout.Alignment.LEADING)
                                        .addComponent(lblNumeroDoPedido, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                                        .addGroup(GroupLayout.Alignment.TRAILING, gl_panelPedido.createSequentialGroup()
                                                .addComponent(btnDetalhes)
                                                .addGap(121))
                                        .addComponent(lblTotal, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
                                        .addComponent(lblStatusDoPedido, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(lblLocalDeEntrega, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE))
                                .addContainerGap())
        );
        gl_panelPedido.setVerticalGroup(
                gl_panelPedido.createParallelGroup(GroupLayout.Alignment.TRAILING)
                        .addGroup(gl_panelPedido.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lblNumeroDoPedido)
                                .addPreferredGap(ComponentPlacement.RELATED)
                                .addComponent(lblStatusDoPedido, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                                .addComponent(lblLocalDeEntrega, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(lblTotal, GroupLayout.PREFERRED_SIZE, 17, GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                .addComponent(btnDetalhes)
                                .addGap(4))
        );

        panelPedido.setBackground(new Color(70, 130, 180));
        panelPedido.setPreferredSize(new Dimension(100, 120));
        panelPedido.setLayout(gl_panelPedido);

        return panelPedido;
    }
}
