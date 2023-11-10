package views;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import components.RoundJTextField;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;

public class telaCadastro extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					telaCadastro frame = new telaCadastro();
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
	public telaCadastro() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1262, 731);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Próximo");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel lblNewLabel_1_3 = new JLabel("Digite seu telefone:");
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_3.setBounds(725, 418, 184, 30);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_2 = new JLabel("Digite seu melhor email:");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(725, 332, 184, 30);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_1 = new JLabel("Digite seu CPF:");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(725, 245, 184, 30);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1 = new JLabel("Digite seu nome: ");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(725, 155, 184, 30);
		contentPane.add(lblNewLabel_1);
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(1074, 607, 114, 43);
		contentPane.add(btnNewButton);
		
		RoundJTextField roundJTextField_1_1_1 = new RoundJTextField(0);
		roundJTextField_1_1_1.setBackground(Color.WHITE);
		roundJTextField_1_1_1.setBounds(725, 443, 480, 63);
		contentPane.add(roundJTextField_1_1_1);
		
		RoundJTextField roundJTextField_1_1 = new RoundJTextField(0);
		roundJTextField_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		roundJTextField_1_1.setBackground(Color.WHITE);
		roundJTextField_1_1.setBounds(725, 357, 480, 63);
		contentPane.add(roundJTextField_1_1);
		
		RoundJTextField roundJTextField_1 = new RoundJTextField(0);
		roundJTextField_1.setHorizontalAlignment(SwingConstants.CENTER);
		roundJTextField_1.setBackground(Color.WHITE);
		roundJTextField_1.setBounds(725, 272, 480, 63);
		contentPane.add(roundJTextField_1);
		
		RoundJTextField roundJTextField = new RoundJTextField(0);
		roundJTextField.setHorizontalAlignment(SwingConstants.CENTER);
		roundJTextField.setBackground(new Color(255, 255, 255));
		roundJTextField.setBounds(725, 184, 480, 63);
		contentPane.add(roundJTextField);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(telaCadastro.class.getResource("/img/telaCadastro.png")));
		lblNewLabel.setBounds(0, 0, 1296, 694);
		contentPane.add(lblNewLabel);
	}
}
