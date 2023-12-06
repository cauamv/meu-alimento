package br.com.senai.gestaoDeCadastroFront.views.helpers;

import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.border.EmptyBorder;

import org.springframework.stereotype.Component;
import javax.swing.JLabel;

@Component
public class CarregamentoFrame extends JDialog {

    private static final long serialVersionUID = 1L;
    
    private JPanel contentPane;
    
    public CarregamentoFrame() {
        setBounds(100, 100, 300, 150);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        
    }

    public void exibirCarregamento(JProgressBar progressBar, JLabel lbl) {
    	
    	progressBar = new JProgressBar();
        progressBar.setIndeterminate(true);
        progressBar.setBounds(44, 48, 200, 25);
        contentPane.add(progressBar);
        
        lbl = new JLabel("Carregando. Aguarde...");
        lbl.setBounds(44, 24, 200, 14);
        contentPane.add(lbl);
        setLocationRelativeTo(null); 
        setVisible(true);
    }

    public void fecharCarregamento() {
        setVisible(false);
    }

}
