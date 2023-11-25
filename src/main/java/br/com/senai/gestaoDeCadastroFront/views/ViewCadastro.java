package br.com.senai.gestaoDeCadastroFront.views;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;

//import br.com.senai.gestaoDeCadastroFront.client.NovoClienteClient;
import br.com.senai.gestaoDeCadastroFront.components.RoundJTextField;
import br.com.senai.gestaoDeCadastroFront.dto.CadastroClienteDto;

public class ViewCadastro extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

//    @Autowired
//	private NovoClienteClient cliente;
    
    @Autowired
    private CadastroClienteDto clienteDto;

    public ViewCadastro() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1352, 764);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

                
                RoundJTextField roundTelefone = new RoundJTextField(0);
                roundTelefone.setHorizontalAlignment(SwingConstants.CENTER);
                roundTelefone.setBackground(Color.WHITE);
                roundTelefone.setBounds(794, 471, 517, 68);
                contentPane.add(roundTelefone);
                
                RoundJTextField roundEmail = new RoundJTextField(0);
                roundEmail.setHorizontalAlignment(SwingConstants.CENTER);
                roundEmail.setBackground(Color.WHITE);
                roundEmail.setBounds(794, 374, 517, 74);
                contentPane.add(roundEmail);
                
                RoundJTextField roundCpf = new RoundJTextField(0);
                roundCpf.setHorizontalAlignment(SwingConstants.CENTER);
                roundCpf.setBackground(Color.WHITE);
                roundCpf.setBounds(794, 279, 517, 68);
                contentPane.add(roundCpf);

        RoundJTextField roundNome = new RoundJTextField(0);
        roundNome.setHorizontalAlignment(SwingConstants.CENTER);
        roundNome.setBackground(new Color(255, 255, 255));
        roundNome.setBounds(794, 187, 517, 68);
        contentPane.add(roundNome);

        JLabel lblTelefone = new JLabel("Digite seu telefone:");
        lblTelefone.setForeground(new Color(255, 255, 255));
        lblTelefone.setHorizontalAlignment(SwingConstants.LEFT);
        lblTelefone.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblTelefone.setBounds(794, 443, 184, 30);
        contentPane.add(lblTelefone);

        JLabel lblEmail = new JLabel("Digite seu melhor email:");
        lblEmail.setForeground(new Color(255, 255, 255));
        lblEmail.setHorizontalAlignment(SwingConstants.LEFT);
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblEmail.setBounds(794, 351, 184, 30);
        contentPane.add(lblEmail);

        JLabel lblCpf = new JLabel("Digite seu CPF:");
        lblCpf.setForeground(new Color(255, 255, 255));
        lblCpf.setHorizontalAlignment(SwingConstants.LEFT);
        lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblCpf.setBounds(794, 251, 184, 30);
        contentPane.add(lblCpf);

        JLabel lblNome = new JLabel("Digite seu nome: ");
        lblNome.setForeground(new Color(255, 255, 255));
        lblNome.setHorizontalAlignment(SwingConstants.LEFT);
        lblNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblNome.setBounds(794, 158, 184, 30);
        contentPane.add(lblNome);
        JButton btnProximo = new JButton("Próximo");
        btnProximo.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnProximo.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
//        		try {
//        			String nome = roundNome.getText();
//        			String cpf = roundCpf.getText();
//        			String email = roundEmail.getText();
//        			String tel = roundTelefone.getText();
//        			clienteDto.setNome(nome);
//        			clienteDto.setCpf(cpf);
//        			clienteDto.setEmail(email);
//        			clienteDto.setTel(tel);
//        			cliente.inserir(clienteDto);
//        		} catch (Exception e2) {
//        			e2.getMessage();
//        		}
        	}
        });
        btnProximo.setBackground(new Color(255, 255, 255));
        btnProximo.setBorder(null);
        btnProximo.setBounds(1169, 647, 129, 47);
        contentPane.add(btnProximo);
        
                JLabel lblImagem = new JLabel("");
                lblImagem.setIcon(new ImageIcon(ViewCadastro.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/telaCadastro.png")));
                lblImagem.setBounds(0, 0, 1338, 727);
                contentPane.add(lblImagem);
                
                setLocationRelativeTo(null);
    }
}
