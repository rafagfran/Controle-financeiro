package interfaces;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;

public class TelaPrincipal {

    private JFrame frame;
    private JPanel pMenuLateral, pSaldo, pSaldoBanco, pSaldoDinheiro;
    private JButton bEntradas, bSaidas;
    private JLabel logo, saldoTotalTitulo, saldoTotal, saldoBancoTitulo, saldoBanco, saldoDinheiroTitulo, saldoDinheiro;
    private ImageIcon image;

    public TelaPrincipal() {
        initializeComponents();
        configureComponents();
        createPanels();
        configFrame();
        showFrame();
    }

    private void initializeComponents() {
        frame = new JFrame();
        
        pMenuLateral = new JPanel();
        pSaldoBanco = new JPanel();
        pSaldoDinheiro = new JPanel();
        pSaldo = new JPanel();
        
        bEntradas = new JButton();
        bSaidas = new JButton();
        
        logo = new JLabel();
        saldoTotalTitulo = new JLabel();
        saldoTotal = new JLabel();
        
        saldoBancoTitulo = new JLabel();
        saldoBanco = new JLabel();
        
        saldoDinheiroTitulo = new JLabel();
        saldoDinheiro = new JLabel();
        
        image = new ImageIcon("C:/Users/ti2/Downloads/LOGO-UMADERP-MARCA-D'ÁGUA.png");
    }

    private void configureComponents() {
    	logo.setIcon(image);
    	
    	for(int x=0; x<3; x++) {		
    		JLabel labelSaldoTitulo = new JLabel();
    		JLabel labelSaldo = new JLabel();
    		
    		labelSaldoTitulo.setFont(new Font("ARIAL BLACK", Font.BOLD, 16));
    		labelSaldoTitulo.setForeground(Color.WHITE);
    		labelSaldoTitulo.setBackground(new Color(0,23,53));
    		labelSaldoTitulo.setOpaque(true);
    		labelSaldoTitulo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    		labelSaldoTitulo.setHorizontalAlignment(JLabel.CENTER);
        	labelSaldo.setFont(new Font("ARIAL BLACK", Font.BOLD, 24));
    		
    		if (x == 0) {
    			labelSaldoTitulo.setText("SALDO TOTAL");
    			saldoTotalTitulo = labelSaldoTitulo;
    			saldoTotal = labelSaldo;
    		} else if (x==1) {
    			labelSaldoTitulo.setText("SALDO EM DINHEIRO");
    			saldoBancoTitulo = labelSaldoTitulo;
    			saldoBanco = labelSaldo;
    		} else if (x==2) {
    			labelSaldoTitulo.setText("SALDO BANCO/PIX");
    			saldoDinheiroTitulo = labelSaldoTitulo;
    			saldoDinheiro = labelSaldo;
    		}
    	}
    }
    
    private Component createButtons(JButton button, String text) {
    	button.setBackground(Color.white);
    	button.setForeground(Color.BLACK);
    	button.setFont(new Font("ARIAL BLACK", Font.BOLD, 12));
    	button.setText(text);
    	button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    	return button;
    }
    
    private void createPanels() {
    	createMenuLateralPanel();
    	createSaldoPanel(saldoTotalTitulo, saldoTotal);
    	createSaldoPanel(saldoBancoTitulo, saldoBanco);
    	createSaldoPanel(saldoDinheiroTitulo, saldoDinheiro);
    }
    private void createMenuLateralPanel() {
    	pMenuLateral.setLayout(new GridBagLayout());
        pMenuLateral.setBackground(new Color(0,23,53));
        pMenuLateral.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        //Adicionar elcomponentes ao painel
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        image.setImage(image.getImage().getScaledInstance(250, 250, 0));
        pMenuLateral.add(logo, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.weighty = 0.0;
        gbc.weightx = 1.0;
        gbc.gridy = 1;
        gbc.ipady = 10;
        gbc.insets = new Insets(0, 20, 15, 20);
        pMenuLateral.add(createButtons(bEntradas, "ENTRADAS"), gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.ipady = 10;
        gbc.insets = new Insets(0, 20, 0, 20);
        pMenuLateral.add(createButtons(bSaidas, "SAÍDAS"), gbc);
    }
    
    private void createSaldoPanel(JLabel tituloLabel, JLabel saldoLabel) {
    	JPanel panel = new JPanel();
    	panel.setLayout(new GridBagLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        //Adicionar componentes ao painél
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 5;
        gbc.weightx = 1.0;
        panel.add(tituloLabel,gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0.5;
        panel.add(saldoLabel,gbc);
        
        if (tituloLabel == saldoTotalTitulo) {
        	pSaldo = panel;
        } else if (tituloLabel == saldoBancoTitulo) {
        	pSaldoBanco = panel;
        } else if (tituloLabel == saldoDinheiroTitulo) {
        	pSaldoDinheiro = panel;
        }
    }
    
    private void configFrame() {
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(new Color(0,37,74,235));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1360, 768);
        frame.setLocationRelativeTo(null);
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        //Adicionar painéis ao frame
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 100;
        gbc.weighty = 0.5;
        gbc.gridheight = 3;
        frame.add(pMenuLateral, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.ipady = 100;
        gbc.ipadx = 450;
        gbc.weightx = 0.5;
        gbc.weighty = 0.0;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        gbc.insets = new Insets(30, 30, 0, 30);
        frame.add(pSaldo, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(30, 30, 0, 10);
        frame.add(pSaldoDinheiro, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(30, 10, 0, 30);
        frame.add(pSaldoBanco, gbc);
    }

    private void showFrame() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        TelaPrincipal telaPrincipal = new TelaPrincipal();
    
    }
}