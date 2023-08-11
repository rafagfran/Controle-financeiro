package interfaces;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
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
    private ImageIcon img;

    public TelaPrincipal() {
        initComponentes();
        configComponentes();
        panelMenuLateral();
        panelSaldo();
        panelSaldoBanco();
        panelSaldoDinheiro();
        configFrame();
        showFrame();
    }

    private void initComponentes() {
        frame = new JFrame();
        
        pMenuLateral = new JPanel();
        pSaldoBanco = new JPanel();
        pSaldoDinheiro = new JPanel();
        pSaldo = new JPanel();
        
        bEntradas = new JButton("ENTRADA");
        bSaidas = new JButton("SAIDA");
        
        logo = new JLabel();
        saldoTotalTitulo = new JLabel("SALDO TOTAL", JLabel.CENTER);
        saldoTotal = new JLabel("R$ 1000,00", JLabel.CENTER);
        
        saldoBancoTitulo = new JLabel("SALDO NO BANCO/ PIX", JLabel.CENTER);
        saldoBanco = new JLabel("R$ 500,00", JLabel.CENTER);
        
        saldoDinheiroTitulo = new JLabel("SALDO EM DINHEIRO", JLabel.CENTER);
        saldoDinheiro = new JLabel("R$ 500,00", JLabel.CENTER);
        
        img = new ImageIcon("C:/Users/ti2/Downloads/LOGO-UMADERP-MARCA-D'ÁGUA.png");
    }

    private void configComponentes() {
    	logo.setIcon(img);
 
    	saldoTotalTitulo.setFont(new Font("ARIAL BLACK", Font.BOLD, 16));
    	saldoTotalTitulo.setForeground(Color.WHITE);
    	saldoTotalTitulo.setBackground(new Color(0,23,53));
    	saldoTotalTitulo.setOpaque(true);
    	saldoTotalTitulo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    	saldoTotal.setFont(new Font("ARIAL BLACK", Font.BOLD, 24));
    	
    	saldoBancoTitulo.setFont(new Font("ARIAL BLACK", Font.BOLD, 16));
    	saldoBancoTitulo.setForeground(Color.WHITE);
    	saldoBancoTitulo.setBackground(new Color(0,23,53));
    	saldoBancoTitulo.setOpaque(true);
    	saldoBancoTitulo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    	saldoBanco.setFont(new Font("ARIAL BLACK", Font.BOLD, 24));
    	
    	saldoDinheiroTitulo.setFont(new Font("ARIAL BLACK", Font.BOLD, 16));
    	saldoDinheiroTitulo.setForeground(Color.WHITE);
    	saldoDinheiroTitulo.setBackground(new Color(0,23,53));
    	saldoDinheiroTitulo.setOpaque(true);
    	saldoDinheiroTitulo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
    	saldoDinheiro.setFont(new Font("ARIAL BLACK", Font.BOLD, 24));
    	
    	bEntradas.setBackground(Color.white);
    	bEntradas.setForeground(Color.BLACK);
    	bEntradas.setFont(new Font("ARIAL BLACK", Font.BOLD, 12));
    	bEntradas.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    	
    	bSaidas.setBackground(Color.white);
    	bSaidas.setForeground(Color.BLACK);
    	bSaidas.setFont(new Font("ARIAL BLACK", Font.BOLD, 12));
    	bSaidas.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
    	
  
    }

    private void panelMenuLateral() {
    	pMenuLateral.setLayout(new GridBagLayout());
        pMenuLateral.setBackground(new Color(0,23,53));
        pMenuLateral.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        //********add components on Panel**************
        GridBagConstraints gbc = new GridBagConstraints();
        
        //logo
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        img.setImage(img.getImage().getScaledInstance(250, 250, 0));
        pMenuLateral.add(logo, gbc);
        
        // botão entrada
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.weighty = 0.0;
        gbc.weightx = 1.0;
        gbc.gridy = 1;
        gbc.ipady = 10;
        gbc.insets = new Insets(0, 20, 15, 20);
        pMenuLateral.add(bEntradas, gbc);
        
        // botão saida
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.FIRST_LINE_START;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.ipady = 10;
        gbc.insets = new Insets(0, 20, 0, 20);
        pMenuLateral.add(bSaidas, gbc);
    }
    
    private void panelSaldo() {
    	pSaldo.setLayout(new GridBagLayout());
        //pSaldo.setBackground(Color.GREEN);
        pSaldo.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 5;
        gbc.weightx = 1.0;
        pSaldo.add(saldoTotalTitulo,gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0.5;
        pSaldo.add(saldoTotal,gbc);
    }
    
    private void panelSaldoBanco() {
    	pSaldoBanco.setLayout(new GridBagLayout());
        // pSaldoBanco.setBackground(Color.BLUE);
        pSaldoBanco.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 5;
        gbc.weightx = 1.0;
        pSaldoBanco.add(saldoBancoTitulo,gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0.5;
        pSaldoBanco.add(saldoBanco,gbc);
    }
 
 	private void panelSaldoDinheiro() {
 		pSaldoDinheiro.setLayout(new GridBagLayout());
        //pSaldoDinheiro.setBackground(Color.RED);
        pSaldoDinheiro.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipady = 5;
        gbc.weightx = 1.0;
        pSaldoDinheiro.add(saldoDinheiroTitulo,gbc);
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.weighty = 0.5;
        pSaldoDinheiro.add(saldoDinheiro,gbc);
 	}
    
    private void configFrame() {
        frame.setLayout(new GridBagLayout());
        frame.getContentPane().setBackground(new Color(0,37,74,235));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1360, 768);
        frame.setLocationRelativeTo(null);
        
        //*********Add componenests on frame*************
        GridBagConstraints gbc = new GridBagConstraints();
        // Menu lateral
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 100;
        gbc.weighty = 0.5;
        gbc.gridheight = 3;
        frame.add(pMenuLateral, gbc);

        // Menu saldo total
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

        // Menu saldo BANCO
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.gridheight = 1;
        gbc.insets = new Insets(30, 30, 0, 10);
        frame.add(pSaldoDinheiro, gbc);

        // Menu saldo DINHEIRO
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
        // Cria uma instância da classe TelaPrincipal ao executar o programa.
        TelaPrincipal tela = new TelaPrincipal();
    
    }
}