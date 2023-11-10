package views;

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

import components.RoundJTextField;
import java.awt.Rectangle;

public class TelaSenha extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel digiteSuaSenha = new JLabel("Digite sua senha:");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaSenha frame = new TelaSenha();
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
	public TelaSenha() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1177, 693);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnProximo = new JButton("Próximo");
		btnProximo.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnProximo.setBorder(null);
		btnProximo.setBounds(new Rectangle(10, 10, 10, 10));
		btnProximo.setBackground(Color.WHITE);
		btnProximo.setForeground(Color.BLACK);
		btnProximo.setBounds(993, 569, 114, 38);
		contentPane.add(btnProximo);
		btnProximo.setRolloverEnabled(true);
		
		RoundJTextField txtfSenha1 = new RoundJTextField(0);
		txtfSenha1.setHorizontalAlignment(SwingConstants.CENTER);
		txtfSenha1.setBounds(678, 253, 439, 53);
		contentPane.add(txtfSenha1);
		
		RoundJTextField txtfSenha2 = new RoundJTextField(0);
		txtfSenha2.setHorizontalAlignment(SwingConstants.CENTER);
		txtfSenha2.setBounds(678, 374, 439, 53);
		contentPane.add(txtfSenha2);
		
		
		JLabel confirmeSuaSenha = new JLabel("Confirme sua senha:");
		confirmeSuaSenha.setForeground(Color.WHITE);
		confirmeSuaSenha.setBounds(678, 358, 127, 14);
		contentPane.add(confirmeSuaSenha);
		digiteSuaSenha.setForeground(new Color(255, 255, 255));
		digiteSuaSenha.setBounds(678, 237, 98, 14);
		contentPane.add(digiteSuaSenha);
		
		JLabel fundo = new JLabel("");
		fundo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fundo.setBorder(null);
		fundo.setBackground(new Color(240, 240, 240));
		fundo.setHorizontalAlignment(SwingConstants.CENTER);
		fundo.setIcon(new ImageIcon(TelaSenha.class.getResource("/img/telaSenha.png")));
		fundo.setBounds(0, 0, 1162, 654);
		contentPane.add(fundo);

	}
}
