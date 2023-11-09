package telasCaua;

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

public class TelaCliente extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private final JLabel lblNewLabel_1 = new JLabel("Digite sua senha:");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCliente frame = new TelaCliente();
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
	public TelaCliente() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1177, 693);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Próximo");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBorder(null);
		btnNewButton.setBounds(new Rectangle(10, 10, 10, 10));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.setBounds(993, 569, 114, 38);
		contentPane.add(btnNewButton);
		btnNewButton.setRolloverEnabled(true);
		
		RoundJTextField txtfSenha1 = new RoundJTextField(0);
		txtfSenha1.setHorizontalAlignment(SwingConstants.CENTER);
		txtfSenha1.setBounds(678, 253, 439, 53);
		contentPane.add(txtfSenha1);
		
		RoundJTextField txtfSenha2 = new RoundJTextField(0);
		txtfSenha2.setHorizontalAlignment(SwingConstants.CENTER);
		txtfSenha2.setBounds(678, 374, 439, 53);
		contentPane.add(txtfSenha2);
		
		
		JLabel lblNewLabel_1_1 = new JLabel("Confirme sua senha:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setBounds(678, 358, 127, 14);
		contentPane.add(lblNewLabel_1_1);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBounds(678, 237, 98, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel.setBorder(null);
		lblNewLabel.setBackground(new Color(240, 240, 240));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\caua_m_vieira\\Desktop\\telas caua\\telaCliente.png"));
		lblNewLabel.setBounds(0, 0, 1162, 654);
		contentPane.add(lblNewLabel);

	}
}
