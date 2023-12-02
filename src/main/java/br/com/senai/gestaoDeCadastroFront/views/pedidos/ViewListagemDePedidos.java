package br.com.senai.gestaoDeCadastroFront.views.pedidos;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
    
    private String token;

    public void abrirTela(String token) {
        this.token = token;
        this.setVisible(true);
        gerarCards(token);
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
        panelSuperior.setBackground(Color.RED);
        panelSuperior.setBounds(0, 0, 1401, 103);
        contentPane.add(panelSuperior);
        
        JLabel lblNewLabel = new JLabel("Gestor de Pedidos");
        lblNewLabel.setForeground(Color.WHITE);
        lblNewLabel.setBackground(Color.BLACK);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Dialog", Font.BOLD, 43));
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
        panelPedido.setBorder(new TitledBorder(new LineBorder(new Color(250, 0, 0)), "N\u00B0 do pedido", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(250, 250, 250)));
        panelPedido.setBackground(Color.RED);
        
        JPanel panelInfo = new JPanel();
        panelInfo.setBackground(Color.RED);
        
        JPanel panel = new JPanel();
        panel.setBackground(Color.RED);
        
        GroupLayout gl_panelPedido = new GroupLayout(panelPedido);
        gl_panelPedido.setHorizontalGroup(
            gl_panelPedido.createParallelGroup(Alignment.CENTER)
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
        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0)); // Use FlowLayout
        
        JButton btnV = new JButton("Detalhes");
        panel.add(btnV);
        btnV.setVerticalAlignment(SwingConstants.CENTER);
        btnV.setPreferredSize(new Dimension(200, 25));
        btnV.setForeground(Color.RED);
        btnV.setBackground(Color.WHITE);
        
        btnV.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                viewDetalhesDeUmPedido.abrirTela(token, pedido);
                Container columnOrganizePanel = new Container();
                columnOrganizePanel.remove(panelPedido);
                columnOrganizePanel.revalidate();
                columnOrganizePanel.repaint();
                repaint();
                dispose();
                viewDetalhesDeUmPedido.abrirTela(token, pedido);
                gerarCards(token);
                System.gc();
            }
        });

        

        
        JLabel lblCliente = new JLabel("Cliente: " + pedido.getCliente().getNome());
        JLabel lblEndereco = new JLabel("Endereço: " + pedido.getEndereco().getRua());
        JLabel lblTotal = new JLabel("Total: R$" + pedido.getValorTotal().toString());
        lblCliente.setForeground(new Color(255, 255, 255));
        lblEndereco.setForeground(new Color(255, 255, 255));
        lblTotal.setForeground(new Color(255, 255, 255));
        
        GroupLayout gl_panelInfo = new GroupLayout(panelInfo);
        gl_panelInfo.setHorizontalGroup(
            gl_panelInfo.createParallelGroup(Alignment.LEADING)
                .addGroup(gl_panelInfo.createSequentialGroup()
                    .addGap(5)
                    .addGroup(gl_panelInfo.createParallelGroup(Alignment.LEADING)
                        .addComponent(lblCliente)
                        .addComponent(lblEndereco)
                        .addComponent(lblTotal))
                    .addContainerGap(115, Short.MAX_VALUE))
        );
        gl_panelInfo.setVerticalGroup(
            gl_panelInfo.createParallelGroup(Alignment.LEADING)
                .addGroup(Alignment.TRAILING, gl_panelInfo.createSequentialGroup()
                    .addContainerGap(18, Short.MAX_VALUE)
                    .addComponent(lblCliente)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(lblEndereco)
                    .addPreferredGap(ComponentPlacement.RELATED)
                    .addComponent(lblTotal))
        );
        panelInfo.setLayout(gl_panelInfo);
        panelPedido.setLayout(gl_panelPedido);
        return panelPedido;
    }
	
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
	
	
}
