package interfaces;

import java.awt.BorderLayout;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JComboBox;
import javax.swing.SwingUtilities;

public class TelaPrincipal {
    private JFrame frame;
    private JPanel pMenuLateral, pSaldo, pSaldoBanco, pSaldoDinheiro, pHistoricoEntradas, pHistoricoSaidas;
    private JButton bEntradas, bSaidas;
    private JLabel logo, saldoTotalTitulo, saldoTotal, saldoBancoTitulo, saldoBanco, saldoDinheiroTitulo, saldoDinheiro, tituloHistoricoEntradas, tituloHistoricoSaidas;
    private ImageIcon imageLogo, mainIcon;
    private JComboBox<String> listaMeses;
    private String[] meses = {"Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro",
    		"Novembro", "Dezembro"};
   
    public TelaPrincipal() {
        initializeComponents();
        configureComponents();
        createPanels();
        configFrame();
        createMenuBar();
        showFrame();
    }
    
    private void initializeComponents() {
        frame = new JFrame("Coincare - Controle financeiro");
        
        pMenuLateral = new JPanel();
        pSaldoBanco = new JPanel();
        pSaldoDinheiro = new JPanel();
        pSaldo = new JPanel();
        pHistoricoEntradas = new JPanel();
        pHistoricoSaidas= new JPanel();

        bEntradas = new JButton();
        bSaidas = new JButton();
        
        logo = new JLabel();
        saldoTotalTitulo = new JLabel();
        saldoTotal = new JLabel();
        tituloHistoricoEntradas = new JLabel();
        tituloHistoricoSaidas = new JLabel();
        saldoBancoTitulo = new JLabel();
        saldoBanco = new JLabel();
        
        saldoDinheiroTitulo = new JLabel();
        saldoDinheiro = new JLabel();
        
        listaMeses = new JComboBox<String>(meses);
        
        imageLogo = new ImageIcon(this.getClass().getResource("/logo.png"));
        mainIcon = new ImageIcon(this.getClass().getResource("/icon.png"));
    }
    
    private void configureComponents() {
    	logo.setIcon(imageLogo);
    	
    	listaMeses.setSelectedIndex(0);
    	listaMeses.setFont(new Font ("Arial", Font.BOLD, 18));
    	listaMeses.setBackground(Color.WHITE);
    	listaMeses.setForeground(Color.BLACK);
    	listaMeses.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
    	//listaMeses.addActionListener(this);
    
    	for(int x=0; x<5; x++) {		
    		JLabel labelTitulo = new JLabel();
    		JLabel labelSaldo = new JLabel();
    		
    		labelTitulo.setFont(new Font("ARIAL BLACK", Font.BOLD, 16));
    		labelTitulo.setForeground(Color.WHITE);
    		labelTitulo.setBackground(new Color(0,23,53));
    		labelTitulo.setOpaque(true);
    		labelTitulo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    		labelTitulo.setHorizontalAlignment(JLabel.CENTER);
        	labelSaldo.setFont(new Font("ARIAL BLACK", Font.BOLD, 24));
        	labelSaldo.setHorizontalAlignment(JLabel.CENTER);
    		
    		if (x == 0) {
    			labelTitulo.setText("SALDO TOTAL");
    			labelSaldo.setText("R$ 1000,00");
    			saldoTotalTitulo = labelTitulo;
    			saldoTotal = labelSaldo;
    		} else if (x==1) {
    			labelTitulo.setText("SALDO BANCO/PIX");
    			labelSaldo.setText("R$ 500,00");
    			saldoBancoTitulo = labelTitulo;
    			saldoBanco = labelSaldo;
    		} else if (x==2) {
    			labelTitulo.setText("SALDO EM DINHEIRO");
    			labelSaldo.setText("R$ 500,00");
    			saldoDinheiroTitulo = labelTitulo;
    			saldoDinheiro = labelSaldo;
    		} else if (x==3) {
        		labelTitulo.setText("ENTRADAS");
        		tituloHistoricoEntradas = labelTitulo;
        		labelTitulo.setBackground(Color.GREEN);
        		labelTitulo.setForeground(Color.black);
    		} else if (x==4) {
    			labelTitulo.setText("SAÍDAS");
        		tituloHistoricoSaidas= labelTitulo;
        		labelTitulo.setBackground(Color.RED);
        		labelTitulo.setForeground(Color.black);
    		}
    	}
    }
      
    private Component createButtons(JButton button, String text, int red, int green, int blue) {
    	button.setBackground(new Color(230,230,230));
    	button.setForeground(new Color(red, green, blue));
    	button.setFont(new Font("ARIAL BLACK", Font.BOLD, 16));
    	button.setText(text);
    	button.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.BLACK, Color.BLACK));

    	return button;
    }
    
    private void createPanels() {
    	createMenuLateralPanel();
    	createSaldoPanel(saldoTotalTitulo, saldoTotal);
    	createSaldoPanel(saldoBancoTitulo, saldoBanco);
    	createSaldoPanel(saldoDinheiroTitulo, saldoDinheiro);
    	createHistoricoPanel(tituloHistoricoEntradas);
    	createHistoricoPanel(tituloHistoricoSaidas);
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
        imageLogo.setImage(imageLogo.getImage().getScaledInstance(250, 250, 0));
        pMenuLateral.add(logo, gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0.3;
        gbc.insets = new Insets(0,30,0,30);
        pMenuLateral.add(listaMeses, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.weighty = 0.0;
        gbc.weightx = 1.0;
        gbc.gridy = 2;
        gbc.ipady = 10;
        gbc.insets = new Insets(0, 60, 15, 60);
        pMenuLateral.add(createButtons(bEntradas, "ENTRADAS",0,138,11), gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.weighty = 1.0;
        gbc.ipady = 10;
        gbc.insets = new Insets(0, 60, 0, 60);
        pMenuLateral.add(createButtons(bSaidas, "SAÍDAS",201,11,0), gbc);
    }
    
    private void createSaldoPanel(JLabel tituloLabel, JLabel saldoLabel) {
    	JPanel panel = new JPanel();
    	panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        panel.add(tituloLabel,BorderLayout.PAGE_START);
        panel.add(saldoLabel,BorderLayout.CENTER);
        
        if (tituloLabel == saldoTotalTitulo) {
        	pSaldo = panel;
        } else if (tituloLabel == saldoBancoTitulo) {
        	pSaldoBanco = panel;
        } else if (tituloLabel == saldoDinheiroTitulo) {
        	pSaldoDinheiro = panel;
        }
    }
    
    private void createHistoricoPanel(JLabel tituloDaTabela) {
    	
    	
    	JPanel panel = new JPanel();
    	
    	panel.setLayout(new BorderLayout());
    	panel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
    	panel.add(tituloDaTabela, BorderLayout.PAGE_START); 	

    	if (tituloDaTabela == tituloHistoricoEntradas) {
    		pHistoricoEntradas = panel;
    	} else if (tituloDaTabela == tituloHistoricoSaidas) {
    		pHistoricoSaidas = panel;
    	}
    }
    
    private void configFrame() {
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(new Color(0,37,74,235));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1360, 768);
        frame.setIconImage(mainIcon.getImage());
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
        gbc.insets = new Insets(20, 30, 0, 30);
        frame.add(pSaldo, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 30, 0, 10);
        frame.add(pSaldoDinheiro, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 2;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(10, 10, 0, 30);
        frame.add(pSaldoBanco, gbc);
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(15, 30, 20, 10);
        frame.add(pHistoricoEntradas,gbc);
        
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(15, 10, 20, 30);
        frame.add(pHistoricoSaidas,gbc);
    }
    
    private void createMenuBar() {
        JMenuBar menuBar = new JMenuBar();

        JMenu fileMenu = new JMenu("Arquivo");
        JMenuItem exitMenuItem = new JMenuItem("Sair");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitMenuItem);
        menuBar.add(fileMenu);

        JMenu helpMenu = new JMenu("Ajuda");
        JMenuItem aboutMenuItem = new JMenuItem("Sobre");
        aboutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Coincare - Controle Financeiro\nVersão 1.0", "Sobre", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        menuBar.setBackground(new Color(0,23,53));
        fileMenu.setForeground(Color.WHITE);
        helpMenu.setForeground(Color.WHITE);
        
        helpMenu.add(aboutMenuItem);
        menuBar.add(helpMenu);
        

        frame.setJMenuBar(menuBar);
    }
    
    private void showFrame() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
    	SwingUtilities.invokeLater(() -> new TelaPrincipal());    
    }
}