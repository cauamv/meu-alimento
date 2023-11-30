package br.com.senai.gestaoDeCadastroFront.views.cupons;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.senai.gestaoDeCadastroFront.client.CuponsClient;
import br.com.senai.gestaoDeCadastroFront.client.authenticate.server.CredencialDeAcesso;
import br.com.senai.gestaoDeCadastroFront.components.table.CupomTableModel;
import br.com.senai.gestaoDeCadastroFront.dto.Cupom;
import br.com.senai.gestaoDeCadastroFront.dto.Paginacao;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JSeparator;

@Component
public class ViewCupons extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JPanel contentPane;
	
	private JScrollPane scrollPane;
	
	private JTable tbCupons;
	
	private Paginacao<Cupom> paginacao;
	
	@Autowired
	private CuponsClient cuponsClient;
	private JLabel lblMeusCupons;
	private final JSeparator separator = new JSeparator();
	
	private void configurarCabecalhos(JTable tbCupons) {
		tbCupons.getTableHeader().setOpaque(false);
		tbCupons.getTableHeader().setBackground(Color.RED);
		tbCupons.getTableHeader().setForeground(Color.WHITE);
		tbCupons.getTableHeader().setReorderingAllowed(false);
        tbCupons.getTableHeader().setResizingAllowed(false);
		tbCupons.getTableHeader().setPreferredSize(new Dimension(tbCupons.getTableHeader().getWidth(), 50));
	}
	
	
	public void abrirTela(String token, CredencialDeAcesso credencialDeAcesso) {
		this.listarCuponsDa(1, credencialDeAcesso);
		this.setVisible(true);
	}
	
	private void listarCuponsDa(int pagina, CredencialDeAcesso credencialDeAcesso) {
		paginacao = cuponsClient.listarTodos(pagina, credencialDeAcesso);			
		CupomTableModel model = new CupomTableModel(paginacao.getListagem());
		tbCupons.setModel(model);			
	}

	public ViewCupons() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		separator.setForeground(new Color(0, 0, 0));
		separator.setBounds(0, 105, 1402, 36);
		contentPane.add(separator);
		
		tbCupons = new JTable(new CupomTableModel());
		tbCupons.setBackground(new Color(240, 240, 240));
		
		scrollPane = new JScrollPane(tbCupons);
		scrollPane.setBackground(new Color(255, 52, 52));
		scrollPane.setBorder(null);
		scrollPane.setBounds(40, 305, 1284, 314);
		contentPane.add(scrollPane);
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.setRolloverEnabled(true);
		btnCriar.setForeground(Color.WHITE);
		btnCriar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnCriar.setBounds(new Rectangle(10, 10, 10, 10));
		btnCriar.setBorder(null);
		btnCriar.setBackground(Color.RED);
		btnCriar.setBounds(40, 233, 132, 44);
		contentPane.add(btnCriar);
		
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.setRolloverEnabled(true);
		btnBuscar.setForeground(Color.WHITE);
		btnBuscar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnBuscar.setBounds(new Rectangle(10, 10, 10, 10));
		btnBuscar.setBorder(null);
		btnBuscar.setBackground(Color.RED);
		btnBuscar.setBounds(207, 235, 132, 41);
		contentPane.add(btnBuscar);
		this.configurarCabecalhos(tbCupons);
		
		lblMeusCupons = new JLabel("Meus Cupons");
		lblMeusCupons.setBackground(new Color(255, 255, 255));
		lblMeusCupons.setHorizontalAlignment(SwingConstants.CENTER);
		lblMeusCupons.setForeground(new Color(255, 0, 0));
		lblMeusCupons.setFont(new Font("Dialog", Font.BOLD, 43));
		lblMeusCupons.setBounds(0, 0, 1363, 104);
		contentPane.add(lblMeusCupons);
		
		setLocationRelativeTo(null);

	}
}