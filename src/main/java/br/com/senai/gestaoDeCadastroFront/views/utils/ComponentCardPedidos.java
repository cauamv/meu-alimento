package br.com.senai.gestaoDeCadastroFront.views.utils;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ComponentCardPedidos extends JPanel {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public ComponentCardPedidos() {
		
		JPanel cardPanel = new JPanel();
		cardPanel.setBounds(0, 0, 434, 261);
		contentPane.add(cardPanel);
		cardPanel.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 11, 46, 14);
		cardPanel.add(lblNome);
		
		JLabel lblNewLabel = new JLabel("Nome:");
		
	}
}
