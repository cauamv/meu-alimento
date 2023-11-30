package br.com.senai.gestaoDeCadastroFront.views.cupons;


import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Rectangle;
import java.awt.FlowLayout;

public class ViewDetalhesCupom extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDetalhesCupom frame = new ViewDetalhesCupom();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ViewDetalhesCupom() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1384, 803);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelLogado = new JPanel();
		panelLogado.setBackground(new Color(242, 242, 242));
		panelLogado.setForeground(Color.DARK_GRAY);
		panelLogado.setBorder(null);
		FlowLayout fl_panelLogado = (FlowLayout) panelLogado.getLayout();
		fl_panelLogado.setAlignment(FlowLayout.RIGHT);
		fl_panelLogado.setAlignOnBaseline(true);
		panelLogado.setBounds(855, 121, 505, 33);
		contentPane.add(panelLogado);
		
		JLabel lblLogadoComo = new JLabel("Logado como:");
		panelLogado.add(lblLogadoComo);
		lblLogadoComo.setForeground(Color.BLACK);
		lblLogadoComo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblLogadoComo.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogadoComo.setFont(new Font("Arial", Font.BOLD, 17));
		
		JLabel lblLogin = new JLabel("administador");
		lblLogin.setVerticalAlignment(SwingConstants.BOTTOM);
		lblLogin.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogin.setForeground(Color.BLACK);
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 15));
		panelLogado.add(lblLogin);
		
		JButton btnExcluir = new JButton("Excluir");
		btnExcluir.setRolloverEnabled(true);
		btnExcluir.setForeground(Color.WHITE);
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnExcluir.setBounds(new Rectangle(10, 10, 10, 10));
		btnExcluir.setBorder(null);
		btnExcluir.setBackground(new Color(255, 52, 52));
		btnExcluir.setBounds(235, 680, 114, 53);
		contentPane.add(btnExcluir);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnAlterar.setBorder(null);
		btnAlterar.setBounds(new Rectangle(10, 10, 10, 10));
		btnAlterar.setBackground(new Color(242, 242, 242));
		btnAlterar.setForeground(Color.BLACK);
		btnAlterar.setBounds(55, 680, 114, 53);
		contentPane.add(btnAlterar);
		btnAlterar.setRolloverEnabled(true);
		
		JLabel lblStatus = new JLabel("Inativo");
		lblStatus.setForeground(Color.RED);
		lblStatus.setHorizontalAlignment(SwingConstants.LEFT);
		lblStatus.setFont(new Font("Arial", Font.PLAIN, 30));
		lblStatus.setBounds(155, 587, 205, 33);
		contentPane.add(lblStatus);
		
		JLabel lblCodigo = new JLabel("911OFF");
		lblCodigo.setHorizontalAlignment(SwingConstants.LEFT);
		lblCodigo.setFont(new Font("Arial", Font.PLAIN, 30));
		lblCodigo.setBounds(164, 500, 156, 33);
		contentPane.add(lblCodigo);
		
		JLabel lblValidade = new JLabel("09/11/2011");
		lblValidade.setHorizontalAlignment(SwingConstants.LEFT);
		lblValidade.setFont(new Font("Arial", Font.PLAIN, 30));
		lblValidade.setBounds(192, 409, 205, 33);
		contentPane.add(lblValidade);
		
		JLabel lblPorcentagem = new JLabel("100%");
		lblPorcentagem.setHorizontalAlignment(SwingConstants.LEFT);
		lblPorcentagem.setFont(new Font("Arial", Font.PLAIN, 30));
		lblPorcentagem.setBounds(136, 319, 114, 33);
		contentPane.add(lblPorcentagem);
		
		JLabel lblCupom = new JLabel("Cupom");
		lblCupom.setForeground(Color.BLACK);
		lblCupom.setFont(new Font("Calibri", Font.BOLD, 57));
		lblCupom.setBounds(31, 166, 1097, 99);
		contentPane.add(lblCupom);
		
		JLabel fundo = new JLabel("");
		fundo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fundo.setBorder(null);
		fundo.setBackground(new Color(240, 240, 240));
		fundo.setHorizontalAlignment(SwingConstants.CENTER);
		fundo.setIcon(new ImageIcon(ViewDetalhesCupom.class.getResource("/br/com/senai/gestaoDeCadastroFront/img/telaDetalhesCupom.png")));
		fundo.setBounds(0, 0, 1370, 766);
		contentPane.add(fundo);
		
		setLocationRelativeTo(null);

	}
}
