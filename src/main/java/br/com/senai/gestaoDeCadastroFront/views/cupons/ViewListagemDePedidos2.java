package br.com.senai.gestaoDeCadastroFront.views.cupons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JButton;

public class ViewListagemDePedidos2 extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        new ViewListagemDePedidos2().setVisible(true);
    }

    public ViewListagemDePedidos2() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1366, 768);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setResizable(false);
        setLocationRelativeTo(null);
        setContentPane(contentPane);

        JPanel cards = new JPanel(new GridLayout(0, 4, 10, 10));
        GroupLayout gl_contentPane = new GroupLayout(contentPane);
        gl_contentPane.setHorizontalGroup(
        	gl_contentPane.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(cards, GroupLayout.PREFERRED_SIZE, 1311, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(19, Short.MAX_VALUE))
        );
        gl_contentPane.setVerticalGroup(
        	gl_contentPane.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_contentPane.createSequentialGroup()
        			.addContainerGap(159, Short.MAX_VALUE)
        			.addComponent(cards, GroupLayout.PREFERRED_SIZE, 549, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap())
        );

        	JPanel panelPedido = new JPanel();
            cards.add(panelPedido);

            JLabel lblNumeroDoPedido = new JLabel("N° do pedido");
            lblNumeroDoPedido.setForeground(Color.WHITE);
            lblNumeroDoPedido.setFont(new Font("Arial", Font.BOLD, 14));
            
            JLabel lblLocalDeEntrega = new JLabel("Local de entrega");
            lblLocalDeEntrega.setForeground(Color.WHITE);
            lblLocalDeEntrega.setFont(new Font("Arial", Font.BOLD, 14));
            
            JLabel lblTotal = new JLabel("Total: ");
            lblTotal.setForeground(Color.WHITE);
            lblTotal.setFont(new Font("Arial", Font.BOLD, 14));
            
            JButton btnNewButton = new JButton("Detalhes ");
            
            JLabel lblStatusDoPedido = new JLabel("Status");
            lblStatusDoPedido.setForeground(Color.WHITE);
            lblStatusDoPedido.setFont(new Font("Arial", Font.BOLD, 14));

            GroupLayout gl_panelPedido = new GroupLayout(panelPedido);
            gl_panelPedido.setHorizontalGroup(
            	gl_panelPedido.createParallelGroup(Alignment.LEADING)
            		.addGroup(gl_panelPedido.createSequentialGroup()
            			.addContainerGap()
            			.addGroup(gl_panelPedido.createParallelGroup(Alignment.LEADING)
            				.addGroup(gl_panelPedido.createSequentialGroup()
            					.addComponent(lblNumeroDoPedido, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
            					.addContainerGap())
            				.addGroup(Alignment.TRAILING, gl_panelPedido.createSequentialGroup()
            					.addComponent(btnNewButton)
            					.addGap(121))
            				.addGroup(gl_panelPedido.createSequentialGroup()
            					.addComponent(lblTotal, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
            					.addContainerGap())
            				.addGroup(gl_panelPedido.createSequentialGroup()
            					.addComponent(lblStatusDoPedido, GroupLayout.PREFERRED_SIZE, 302, GroupLayout.PREFERRED_SIZE)
            					.addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            				.addGroup(gl_panelPedido.createSequentialGroup()
            					.addComponent(lblLocalDeEntrega, GroupLayout.DEFAULT_SIZE, 302, Short.MAX_VALUE)
            					.addContainerGap())))
            );
            gl_panelPedido.setVerticalGroup(
            	gl_panelPedido.createParallelGroup(Alignment.TRAILING)
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
            			.addComponent(btnNewButton)
            			.addGap(4))
            );

            panelPedido.setBackground(new Color(70, 130, 180)); 
            panelPedido.setPreferredSize(new Dimension(100, 120)); 
            panelPedido.setLayout(gl_panelPedido);

        contentPane.setLayout(gl_contentPane);
    }
}
