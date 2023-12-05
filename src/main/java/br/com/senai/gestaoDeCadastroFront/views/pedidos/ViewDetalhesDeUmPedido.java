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

    @Autowired
    private ViewListagemDePedidos viewListagemDePedidos;

    private String token;

    private JLabel lblNumPedido;

    private JLabel lblNomeRestaurante;

    private JLabel lblCliente;

    private JLabel lblTotal;

    private JLabel lblHorario;

    private JLabel lblCep;

    private JLabel lblNumero;

    private JLabel lblRua;

    private JLabel lblCupom;

    private JLabel lblPagamento;

    private JButton btnAceitar;

    private JButton btnRecusar;

    private Status statusAtual;

    public void abrirTela(String token, Pedido pedido, Status status) {
        this.token = token;
        this.pedido = pedido;
        this.statusAtual = status;
        this.setVisible(true);
        montarPedido(this.pedido, status);
    }

    public ViewDetalhesDeUmPedido() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(100, 100, 1366, 768);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblNumPedido = new JLabel();
        lblNumPedido.setHorizontalAlignment(SwingConstants.LEFT);
        lblNumPedido.setForeground(Color.RED);
        lblNumPedido.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNumPedido.setBounds(31, 301, 471, 27);
        contentPane.add(lblNumPedido);

        lblNomeRestaurante = new JLabel();
        lblNomeRestaurante.setHorizontalAlignment(SwingConstants.LEFT);
        lblNomeRestaurante.setFont(new Font("Tahoma", Font.BOLD, 43));
        lblNomeRestaurante.setBounds(31, 227, 549, 52);
        contentPane.add(lblNomeRestaurante);

        lblCliente = new JLabel();
        lblCliente.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblCliente.setBounds(31, 373, 427, 27);
        contentPane.add(lblCliente);

        lblTotal = new JLabel();
        lblTotal.setForeground(Color.BLACK);
        lblTotal.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblTotal.setBounds(31, 535, 427, 27);
        contentPane.add(lblTotal);

        lblHorario = new JLabel();
        lblHorario.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblHorario.setBounds(31, 339, 441, 23);
        contentPane.add(lblHorario);

        lblNumero = new JLabel();
        lblNumero.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblNumero.setBounds(31, 411, 471, 27);
        contentPane.add(lblNumero);

        lblCep = new JLabel();
        lblCep.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblCep.setBounds(31, 449, 441, 27);
        contentPane.add(lblCep);

        lblRua = new JLabel();
        lblRua.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblRua.setBounds(31, 487, 441, 27);
        contentPane.add(lblRua);

        lblCupom = new JLabel();
        lblCupom.setForeground(Color.GRAY);
        lblCupom.setFont(new Font("Dialog", Font.BOLD, 20));
        lblCupom.setBounds(31, 588, 427, 27);
        contentPane.add(lblCupom);

        lblPagamento = new JLabel();
        lblPagamento.setFont(new Font("Dialog", Font.PLAIN, 20));
        lblPagamento.setBounds(31, 626, 549, 27);
        contentPane.add(lblPagamento);

        btnAceitar = new JButton();
        btnAceitar.setForeground(Color.BLACK);
        btnAceitar.setBackground(new Color(127, 255, 0));
        btnAceitar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnAceitar.setBounds(1048, 659, 126, 44);

        btnRecusar = new JButton();
        btnRecusar.setForeground(Color.WHITE);
        btnRecusar.setFont(new Font("Tahoma", Font.BOLD, 13));
        btnRecusar.setBorder(null);
        btnRecusar.setBackground(Color.RED);
        btnRecusar.setBounds(1214, 659, 126, 44);

        setLocationRelativeTo(null);

        atualizarStatus();
    }

    private void montarPedido(Pedido pedido, Status status) {
    	
        lblNumPedido.setText("Pedido Realizado - N° " + pedido.getIdPedido().toString());

        lblNomeRestaurante.setText(pedido.getRestaurante().getNome());

        lblCliente.setText("Cliente:" + pedido.getCliente().getNome());

        lblTotal.setText("Total:" + pedido.getValorTotal().toString());

        lblHorario.setText("Data do pedido:" + pedido.getDataPedido().toString());

        lblNumero.setText("Número da residência: " + pedido.getEndereco().getNumero());

        lblCep.setText("CEP: " + pedido.getEndereco().getCep());

        lblNumero.setText("Número da residência: " + pedido.getEndereco().getNumero());

        lblRua.setText("Rua: " + pedido.getEndereco().getRua());

        lblCupom.setText("Cupom: " + pedido.getCupom().getCodigo());

        lblPagamento.setText("Forma de Pagamento: " + pedido.getPagamento());

        if (status.equals(Status.REALIZADO)) {
        	this.statusAtual = Status.REALIZADO;
            btnAceitar.setText("Aceitar");
            contentPane.add(btnAceitar);
            btnRecusar.setText("Recusar");
            contentPane.add(btnRecusar);
            
        } else if (status.equals(Status.ACEITO_PELO_RESTAURANTE) && pedido.getTipoDeEntrega().equals("RETIRADA")) {
        	this.statusAtual = Status.ACEITO_PELO_RESTAURANTE;
        	contentPane.remove(btnRecusar);
            btnAceitar.setText("Entregue");
            contentPane.add(btnAceitar);
            
        } else if (status.equals(Status.ACEITO_PELO_RESTAURANTE) && pedido.getTipoDeEntrega().equals("DELIVERY")) {
        	contentPane.remove(btnRecusar);
            btnAceitar.setText("PRONTO PARA COLETA");
            contentPane.add(btnAceitar);
            
        } else if (status.equals(Status.PRONTO_PARA_COLETA) && pedido.getTipoDeEntrega().equals("DELIVERY")) {
        	this.statusAtual = Status.PRONTO_PARA_COLETA;
        	contentPane.remove(btnRecusar);
            btnAceitar.setText("Entregue");
            contentPane.add(btnAceitar);
        } else {
            contentPane.remove(btnAceitar);
            contentPane.remove(btnRecusar);
        }
    }

    private void atualizarStatus() {
        btnAceitar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    switch (statusAtual) {
                        case REALIZADO:
                            aceitarOuRecusarPedido();
                            break;
                        case ACEITO_PELO_RESTAURANTE:
                            if (pedido.getTipoDeEntrega().equals("RETIRADA")) {
                                atualizarStatusEFechar(Status.ENTREGUE);
                            } else {
                                atualizarStatusEFechar(Status.PRONTO_PARA_COLETA);
                            }
                            break;
                        case PRONTO_PARA_COLETA:
                            atualizarStatusEFechar(Status.ENTREGUE);
                            break;
                        default:
                            JOptionPane.showMessageDialog(contentPane, "Ação não permitida para o status atual.");
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(contentPane, "Ocorreu um erro ao atualizar o status: " + ex.getMessage());
                }
            }
        });

        btnRecusar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (statusAtual == Status.REALIZADO) {
                    aceitarOuRecusarPedido();
                } else {
                    JOptionPane.showMessageDialog(contentPane, "Ação não permitida para o status atual.");
                }
            }
        });
    }

    private void aceitarOuRecusarPedido() {
        int opcao = JOptionPane.showConfirmDialog(contentPane, "Deseja aceitar o pedido?", "Confirmação", JOptionPane.YES_NO_OPTION);
        if (opcao == JOptionPane.YES_OPTION) {
            atualizarStatusEFechar(Status.ACEITO_PELO_RESTAURANTE);
        } else {
            atualizarStatusEFechar(Status.CANCELADO);
        }
    }

    private void atualizarStatusEFechar(Status novoStatus) {
        pedidosClient.atualizarPor(pedido.getIdPedido(), novoStatus);
        JOptionPane.showMessageDialog(contentPane, "Status alterado para: " + novoStatus);
        dispose();
        viewListagemDePedidos.abrirTela(token);
    }

}
