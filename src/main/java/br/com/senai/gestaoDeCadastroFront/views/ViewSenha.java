package br.com.senai.gestaoDeCadastroFront.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import br.com.senai.gestaoDeCadastroFront.components.RoundJTextField;

public class ViewSenha extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    ViewSenha frame = new ViewSenha();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public ViewSenha() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1386, 803);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        JButton btnProximo = new JButton("Próximo");
        btnProximo.setFont(new Font("Tahoma", Font.PLAIN, 19));
        btnProximo.setBorder(null);
        btnProximo.setBackground(Color.WHITE);
        btnProximo.setForeground(Color.BLACK);
        btnProximo.setBounds(1179, 670, 114, 55);
        btnProximo.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Code to switch to TelaEndereco
                ViewEndereco telaEndereco = new ViewEndereco();
                telaEndereco.setVisible(true);
                dispose(); // Close the current TelaSenha screen if needed
            }
        });
        
        JLabel lblConfirmeSenha = new JLabel("Confirme sua senha:");
        lblConfirmeSenha.setHorizontalAlignment(SwingConstants.LEFT);
        lblConfirmeSenha.setForeground(Color.WHITE);
        lblConfirmeSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblConfirmeSenha.setBounds(799, 413, 184, 30);
        contentPane.add(lblConfirmeSenha);
        
        JLabel lblSenha = new JLabel("Digite sua senha:");
        lblSenha.setForeground(new Color(255, 255, 255));
        lblSenha.setHorizontalAlignment(SwingConstants.LEFT);
        lblSenha.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblSenha.setBounds(799, 276, 184, 30);
        contentPane.add(lblSenha);
        contentPane.add(btnProximo);
        btnProximo.setRolloverEnabled(true);

        RoundJTextField txtfSenha1 = new RoundJTextField(0);
        txtfSenha1.setHorizontalAlignment(SwingConstants.CENTER);
        txtfSenha1.setBounds(799, 302, 516, 66);
        contentPane.add(txtfSenha1);
        
        RoundJTextField txtfConfirmeSenha = new RoundJTextField(0);
        txtfConfirmeSenha.setHorizontalAlignment(SwingConstants.CENTER);
        txtfConfirmeSenha.setBounds(799, 443, 516, 66);
        contentPane.add(txtfConfirmeSenha);
        
                JLabel fundo = new JLabel("");
                fundo.setFont(new Font("Tahoma", Font.PLAIN, 14));
                fundo.setBorder(null);
                fundo.setBackground(new Color(240, 240, 240));
                fundo.setHorizontalAlignment(SwingConstants.CENTER);
                
                        fundo.setIcon(new ImageIcon(ViewSenha.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/telaSenha.png")));
                        fundo.setBounds(0, 0, 1372, 780);
                        contentPane.add(fundo);
                        
                        setLocationRelativeTo(null);
    }
}
