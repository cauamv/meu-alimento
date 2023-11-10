package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import components.table.CupomTableModel;

public class TelaCupons extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	
	private JScrollPane scrollPane;
	
	private JTable tbCupons;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCupons frame = new TelaCupons();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	private void configurarCabecalhos(JTable tbCupons) {
		tbCupons.getTableHeader().setOpaque(false);
		tbCupons.getTableHeader().setBackground(Color.RED);
		tbCupons.getTableHeader().setForeground(Color.WHITE);
		tbCupons.getTableHeader().setPreferredSize(new Dimension(tbCupons.getTableHeader().getWidth(), 50));
	}

	/**
	 * Create the frame.
	 */
	public TelaCupons() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1177, 693);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel_1.setForeground(Color.DARK_GRAY);
		panel_1.setBorder(null);
		panel_1.setBackground(new Color(242, 242, 242));
		panel_1.setBounds(648, 97, 505, 33);
		contentPane.add(panel_1);
		
		JLabel lblLogadoComo_1 = new JLabel("Logado como:");
		lblLogadoComo_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblLogadoComo_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogadoComo_1.setForeground(Color.BLACK);
		lblLogadoComo_1.setFont(new Font("Arial", Font.BOLD, 17));
		panel_1.add(lblLogadoComo_1);
		
		JLabel lblLogin_1 = new JLabel("administador");
		lblLogin_1.setVerticalAlignment(SwingConstants.BOTTOM);
		lblLogin_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblLogin_1.setForeground(Color.BLACK);
		lblLogin_1.setFont(new Font("Arial", Font.PLAIN, 15));
		panel_1.add(lblLogin_1);
		
		tbCupons = new JTable(new CupomTableModel());
		tbCupons.setBackground(new Color(255, 255, 255));
		scrollPane = new JScrollPane(tbCupons);
		scrollPane.setBackground(new Color(255, 52, 52));
		scrollPane.setBorder(null);
		scrollPane.setBounds(32, 268, 1109, 345);
		contentPane.add(scrollPane);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setRolloverEnabled(true);
		btnCriar.setForeground(Color.WHITE);
		btnCriar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnCriar.setBounds(new Rectangle(10, 10, 10, 10));
		btnCriar.setBorder(null);
		btnCriar.setBackground(new Color(255, 52, 52));
		btnCriar.setBounds(40, 191, 114, 38);
		contentPane.add(btnCriar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setRolloverEnabled(true);
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnBuscar.setBounds(new Rectangle(10, 10, 10, 10));
		btnBuscar.setBorder(null);
		btnBuscar.setBackground(new Color(255, 52, 52));
		btnBuscar.setBounds(191, 191, 114, 38);
		contentPane.add(btnBuscar);
		
		JLabel fundo = new JLabel("");
		fundo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		fundo.setBorder(null);
		fundo.setBackground(new Color(240, 240, 240));
		fundo.setHorizontalAlignment(SwingConstants.CENTER);
		fundo.setIcon(new ImageIcon(TelaCupons.class.getResource("/img/telaCupons.png")));
		fundo.setBounds(0, 0, 1162, 654);
		contentPane.add(fundo);
		this.configurarCabecalhos(tbCupons);

	}
}
