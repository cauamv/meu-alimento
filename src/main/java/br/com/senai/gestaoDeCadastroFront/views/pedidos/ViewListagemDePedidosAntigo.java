package br.com.senai.gestaoDeCadastroFront.views.pedidos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle;
import javax.swing.SwingConstants;
import javax.swing.SwingWorker;
import javax.swing.Timer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.hibernate.validator.internal.util.stereotypes.Lazy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.gestaoDeCadastroFront.client.decode.TokenDecoder;
import br.com.senai.gestaoDeCadastroFront.client.pedidos.PedidosClient;
import br.com.senai.gestaoDeCadastroFront.dto.enums.Status;
import br.com.senai.gestaoDeCadastroFront.dto.pedidos.Pedido;

@Component
public class ViewListagemDePedidosAntigo extends JFrame {

    private static final long serialVersionUID = 1L;

    private JPanel contentPane;

    @Autowired
    private PedidosClient pedidosClient;

    @Autowired
    @Lazy
    private ViewDetalhesDeUmPedido viewDetalhesDeUmPedido;
    
    private JScrollPane scrollPane;

    private String token;

    public ViewListagemDePedidosAntigo(PedidosClient pedidosClient) {
        this.pedidosClient = pedidosClient;

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1366, 768);
        contentPane = new JPanel();
        contentPane.removeAll();
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
        panelSuperior.add(lblNewLabel);
        
        setLocationRelativeTo(null);
    }

    public void abrirTela(String token) {
        this.token = token;
        this.setVisible(true);
        gerarCards(token, new JPanel());
        Timer timer = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SwingWorker<Void, Void> worker = new SwingWorker<Void, Void>() {
                    @Override
                    protected Void doInBackground() throws Exception {
                        gerarCards(token, new JPanel());
                        return null;
                    }
                };
                worker.execute();
            }
        });
        timer.start();
    }

    public void gerarCards(String token, JPanel columnOrganizePanel) {
        int colunas = 4; 
        int espacoEntrePedidos = 10; 

        columnOrganizePanel.setLayout(new GridLayout(0, colunas, espacoEntrePedidos, espacoEntrePedidos));
        columnOrganizePanel.setBounds(10, 115, 1344, 559);

        try {
            TokenDecoder decoder = new TokenDecoder();
            Integer id = Integer.parseInt(decoder.extrairIdRestauranteDo(token));

            List<Pedido> todosPedidos = new ArrayList<>();
            todosPedidos.addAll(pedidosClient.listarPor(id, 0, Status.PRONTO_PARA_COLETA).getListagem());
            todosPedidos.addAll(pedidosClient.listarPor(id, 0, Status.ACEITO_PELO_RESTAURANTE).getListagem());
            todosPedidos.addAll(pedidosClient.listarPor(id, 0, Status.REALIZADO).getListagem());

            for (Pedido pedido : todosPedidos) {
                Color background = Color.RED;
                Color foreground = Color.WHITE;

                if (pedido.getTipoDeEntrega().equals(Status.ACEITO_PELO_RESTAURANTE)) {
                	background = Color.RED;
				}

                JPanel panelPedido = gerarPedido(
                        new JPanel(),
                        new JPanel(),
                        new JPanel(),
                        pedido,
                        new JLabel("Cliente: " + pedido.getCliente().getNome()),
                        new JLabel("Endereço: " + pedido.getEndereco().getRua()),
                        new JLabel("Total: R$" + pedido.getValorTotal().toString()),
                        new JButton("Detalhes"),
                        columnOrganizePanel,
                        background,
                        foreground,
                        pedido.getStatus().toString()
                );

                columnOrganizePanel.add(panelPedido);
            }

            scrollPane = new JScrollPane(columnOrganizePanel,
                    JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setBounds(10, 115, 1344, 559);
            scrollPane.setBorder(new EmptyBorder(10, 10, 10, 10));
            contentPane.add(scrollPane);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JPanel gerarPedido(
    		JPanel panelPedido,
    		JPanel panelInfo,
    		JPanel panel,
    		Pedido pedido,
    		JLabel lblCliente,
            JLabel lblEndereco,
            JLabel lblTotal,
            JButton btnDetalhes,
            JPanel columnOrganizePanel,
            Color backgoundColor,
            
            Color foregroundCOlor,
            String status
    		) {

        panelPedido.setBorder(new TitledBorder(new LineBorder(new Color(250, 0, 0)), "Tipo: " + status.toString() + " N° " + pedido.getIdPedido(),
                TitledBorder.CENTER, TitledBorder.TOP, null, new Color(250, 250, 250)));
        
        panelPedido.setBackground(backgoundColor);

        panelInfo.setBackground(backgoundColor);

        panel.setBackground(backgoundColor);

        GroupLayout gl_panelPedido = new GroupLayout(panelPedido);
        gl_panelPedido.setHorizontalGroup(gl_panelPedido.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGroup(gl_panelPedido.createSequentialGroup().addContainerGap()
                        .addGroup(gl_panelPedido.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addComponent(panel, GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE)
                                .addGroup(gl_panelPedido.createSequentialGroup()
                                        .addComponent(panelInfo, GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                                        .addGap(61)))));
        gl_panelPedido.setVerticalGroup(gl_panelPedido.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_panelPedido.createSequentialGroup().addContainerGap()
                        .addComponent(panelInfo, GroupLayout.PREFERRED_SIZE, 75, GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(panel, GroupLayout.PREFERRED_SIZE, 25, Short.MAX_VALUE).addContainerGap()));

        panel.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));

        btnDetalhes.setVerticalAlignment(SwingConstants.CENTER);
        btnDetalhes.setPreferredSize(new Dimension(200, 25));
        
        btnDetalhes.setForeground(backgoundColor);
        btnDetalhes.setBackground(foregroundCOlor);
        panel.add(btnDetalhes);

        btnDetalhes.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                viewDetalhesDeUmPedido.abrirTela(token, pedido, status);
                contentPane.remove(columnOrganizePanel);
                contentPane.remove(panelPedido);
                contentPane.remove(panelInfo);
                contentPane.remove(columnOrganizePanel);
                contentPane.remove(scrollPane);
            }
        });

        lblCliente.setForeground(new Color(255, 255, 255));
        lblEndereco.setForeground(new Color(255, 255, 255));
        lblTotal.setForeground(new Color(255, 255, 255));

        GroupLayout gl_panelInfo = new GroupLayout(panelInfo);
        gl_panelInfo.setHorizontalGroup(gl_panelInfo.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(gl_panelInfo.createSequentialGroup().addGap(5)
                        .addGroup(gl_panelInfo.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(lblCliente)
                                .addComponent(lblEndereco).addComponent(lblTotal))
                        .addContainerGap(115, Short.MAX_VALUE)));
        gl_panelInfo.setVerticalGroup(gl_panelInfo.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(GroupLayout.Alignment.TRAILING,
                        gl_panelInfo.createSequentialGroup().addContainerGap(18, Short.MAX_VALUE)
                                .addComponent(lblCliente).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblEndereco).addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblTotal)));
        panelInfo.setLayout(gl_panelInfo);
        panelPedido.setLayout(gl_panelPedido);
        return panelPedido;
    }
}