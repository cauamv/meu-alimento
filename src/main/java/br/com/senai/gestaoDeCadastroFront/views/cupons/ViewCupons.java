package br.com.senai.gestaoDeCadastroFront.views.cupons;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import br.com.senai.gestaoDeCadastroFront.client.CuponsClient;
import br.com.senai.gestaoDeCadastroFront.client.authenticate.server.CredencialDeAcesso;
import br.com.senai.gestaoDeCadastroFront.components.table.CupomTableModel;
import br.com.senai.gestaoDeCadastroFront.dto.Cupom;
import br.com.senai.gestaoDeCadastroFront.dto.Paginacao;

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
	
	@Autowired
	@Lazy
	private ViewFormularioCupom viewFormularioCupom;
	
	private CredencialDeAcesso credencial;
	
	
	private void configurarCabecalhos(JTable tbCupons) {
		tbCupons.getTableHeader().setOpaque(false);
		tbCupons.getTableHeader().setBackground(Color.RED);
		tbCupons.getTableHeader().setForeground(Color.WHITE);
		tbCupons.getTableHeader().setReorderingAllowed(false);
        tbCupons.getTableHeader().setResizingAllowed(false);
		tbCupons.getTableHeader().setPreferredSize(new Dimension(tbCupons.getTableHeader().getWidth(), 50));
	}
	
	
	public void abrirTela(String token, CredencialDeAcesso credencialDeAcesso) {
		this.credencial = credencialDeAcesso;
		this.listarCuponsDa(1, credencialDeAcesso);
		this.setVisible(true);
	}
	
	private void listarCuponsDa(int pagina, CredencialDeAcesso credencialDeAcesso) {
	    paginacao = cuponsClient.listarTodos(0, credencialDeAcesso);			
	    CupomTableModel model = new CupomTableModel(paginacao.getListagem());
	    tbCupons.setModel(model);

	    DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
	    centerRenderer.setHorizontalAlignment(JLabel.CENTER);
	    tbCupons.setDefaultRenderer(Object.class, centerRenderer);

	    tbCupons.setRowHeight(40);

	    tbCupons.setBackground(new Color(240, 240, 240));
	    tbCupons.setFont(new Font("Arial", Font.PLAIN, 18));
	    tbCupons.getTableHeader().setFont(new Font("Arial", Font.BOLD, 18));

	    tbCupons.getTableHeader().setBackground(new Color(255, 52, 52));
	    tbCupons.getTableHeader().setForeground(Color.WHITE);

	    scrollPane = new JScrollPane(tbCupons);
	    scrollPane.setBackground(new Color(255, 52, 52));
	    scrollPane.setBorder(null);
	    scrollPane.setBounds(40, 305, 1284, 314);
	    contentPane.add(scrollPane);
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
		
		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewFormularioCupom.abrirTela(credencial);
			}
		});
		btnCriar.setRolloverEnabled(true);
		btnCriar.setForeground(Color.WHITE);
		btnCriar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnCriar.setBounds(new Rectangle(10, 10, 10, 10));
		btnCriar.setBorder(null);
		btnCriar.setBackground(Color.RED);
		btnCriar.setBounds(40, 233, 132, 44);
		contentPane.add(btnCriar);
		
		this.configurarCabecalhos(tbCupons);
		
		lblMeusCupons = new JLabel("Meus Cupons");
		lblMeusCupons.setBackground(new Color(255, 255, 255));
		lblMeusCupons.setHorizontalAlignment(SwingConstants.CENTER);
		lblMeusCupons.setForeground(new Color(255, 0, 0));
		lblMeusCupons.setFont(new Font("Dialog", Font.BOLD, 43));
		lblMeusCupons.setBounds(0, 0, 1363, 104);
		contentPane.add(lblMeusCupons);
		
		JButton btnDesativar = new JButton("Desativar");
		btnDesativar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDesativar.setRolloverEnabled(true);
		btnDesativar.setForeground(Color.WHITE);
		btnDesativar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnDesativar.setBounds(new Rectangle(10, 10, 10, 10));
		btnDesativar.setBorder(null);
		btnDesativar.setBackground(Color.RED);
		btnDesativar.setBounds(324, 233, 132, 44);
		contentPane.add(btnDesativar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAlterar.setRolloverEnabled(true);
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnAlterar.setBounds(new Rectangle(10, 10, 10, 10));
		btnAlterar.setBorder(null);
		btnAlterar.setBackground(Color.RED);
		btnAlterar.setBounds(182, 233, 132, 44);
		contentPane.add(btnAlterar);
		
		setLocationRelativeTo(null);

	}
}
