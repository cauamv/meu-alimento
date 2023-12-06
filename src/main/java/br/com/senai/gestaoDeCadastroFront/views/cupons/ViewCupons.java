package br.com.senai.gestaoDeCadastroFront.views.cupons;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
import br.com.senai.gestaoDeCadastroFront.components.table.PedidosTableModel;
import br.com.senai.gestaoDeCadastroFront.dto.Cupom;
import br.com.senai.gestaoDeCadastroFront.dto.Paginacao;
import br.com.senai.gestaoDeCadastroFront.views.ViewPrincipal;

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
	
	@Autowired
	@Lazy
	private ViewPrincipal viewPrincipal;

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
		this.listarCuponsDa(credencialDeAcesso);
		this.setVisible(true);
	}

	private void listarCuponsDa(CredencialDeAcesso credencialDeAcesso) {
		List<Cupom> cupons = new ArrayList<Cupom>();
		paginacao = cuponsClient.listarTodos(0, credencialDeAcesso);
		
		cupons.addAll(cupons);
		for (int i = 0; i <= paginacao.getTotalDePaginas(); i++) {
        	cupons.addAll(cuponsClient.listarTodos(i, credencialDeAcesso).getListagem());
        }
		
		CupomTableModel model = new CupomTableModel(cupons);
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
	
	private void limparDadosAntigos() {
		if (scrollPane != null) {
			contentPane.remove(scrollPane);
		}
		contentPane.remove(tbCupons);
		tbCupons.setModel(new PedidosTableModel());
	}
	
	public ViewCupons() {
		
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);
		panel.setBounds(0, 0, 1350, 104);
		contentPane.add(panel);
				panel.setLayout(null);
				
				JButton btnVoltar = new JButton("<");
				btnVoltar.setBounds(10, 22, 77, 52);
				panel.add(btnVoltar);
				btnVoltar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						viewPrincipal.setVisible(true);
						dispose();
					}
				});
				btnVoltar.setRolloverEnabled(true);
				btnVoltar.setForeground(Color.WHITE);
				btnVoltar.setFont(new Font("Tahoma", Font.BOLD, 27));
				btnVoltar.setBorder(null);
				btnVoltar.setBackground(Color.RED);
		
				lblMeusCupons = new JLabel("Meus Cupons");
				lblMeusCupons.setBounds(226, 22, 945, 55);
				panel.add(lblMeusCupons);
				lblMeusCupons.setAutoscrolls(true);
				lblMeusCupons.setBackground(Color.RED);
				lblMeusCupons.setHorizontalAlignment(SwingConstants.CENTER);
				lblMeusCupons.setForeground(Color.WHITE);
				lblMeusCupons.setFont(new Font("Dialog", Font.BOLD, 43));
				
				JButton btnNewButton_1 = new JButton("Atualizar");
				btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						limparDadosAntigos();
						listarCuponsDa(credencial);
					}
				});
				btnNewButton_1.setBounds(1232, 36, 106, 37);
				panel.add(btnNewButton_1);
				btnNewButton_1.setForeground(Color.WHITE);
				btnNewButton_1.setFont(new Font("Dialog", Font.PLAIN, 11));
				btnNewButton_1.setBorder(new EmptyBorder(0,0,0,0));
				btnNewButton_1.setBackground(Color.RED);

		tbCupons = new JTable(new CupomTableModel());
		tbCupons.setBackground(new Color(240, 240, 240));

		JButton btnCriar = new JButton("Criar");
		btnCriar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				viewFormularioCupom.colocarEmModoInsercao(credencial);
			}
		});
		btnCriar.setRolloverEnabled(true);
		btnCriar.setForeground(Color.WHITE);
		btnCriar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnCriar.setBounds(new Rectangle(10, 10, 10, 10));
		btnCriar.setBorder(null);
		btnCriar.setBackground(Color.RED);
		btnCriar.setBounds(40, 141, 132, 44);
		contentPane.add(btnCriar);

		this.configurarCabecalhos(tbCupons);

		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int linhaSelecionada = tbCupons.getSelectedRow();
				CupomTableModel model = (CupomTableModel) tbCupons.getModel();
				Cupom cupomSelecionado = model.getPor(linhaSelecionada);
				viewFormularioCupom.colocarEmModoDeEdicao(cupomSelecionado);
			}
		});
		btnAlterar.setRolloverEnabled(true);
		btnAlterar.setForeground(Color.WHITE);
		btnAlterar.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnAlterar.setBounds(new Rectangle(10, 10, 10, 10));
		btnAlterar.setBorder(null);
		btnAlterar.setBackground(Color.RED);
		btnAlterar.setBounds(182, 141, 132, 44);
		contentPane.add(btnAlterar);

		setLocationRelativeTo(null);

	}
}
