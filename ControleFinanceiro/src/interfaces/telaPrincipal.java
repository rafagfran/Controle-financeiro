package interfaces;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class TelaPrincipal {

    private JFrame frame;
    private JPanel pMenuLateral, pSaldo, pSaldoBanco, pSaldoDinheiro;
    private JButton bEntradas, bSaidas;
    private JLabel logo;
    private ImageIcon img;

    public TelaPrincipal() {
        initComponentes();
        confComponentes();
        confPanel();
        confFrame();
        addPanel();
        addFrame();
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
        img = new ImageIcon("/umaderp.png");
    }

    private void confComponentes() {
        // Aqui você pode configurar propriedades adicionais dos componentes, se necessário.;
    	logo.setIcon(img);
    	logo.setBorder(BorderFactory.createTitledBorder(null, "LOGO", 0, 0, null, Color.white));

    }

    private void confPanel() {
        pMenuLateral.setLayout(new GridBagLayout());
        pMenuLateral.setBackground(Color.BLACK);

        pSaldo.setLayout(new GridBagLayout());
        //pSaldo.setBackground(Color.GREEN);
        pSaldo.setBorder(BorderFactory.createTitledBorder("SALDO TOTAL"));

        pSaldoBanco.setLayout(new GridBagLayout());
       // pSaldoBanco.setBackground(Color.BLUE);
        pSaldoBanco.setBorder(BorderFactory.createTitledBorder("SALDO BANCO"));

        pSaldoDinheiro.setLayout(new GridBagLayout());
        //pSaldoDinheiro.setBackground(Color.RED);
        pSaldoDinheiro.setBorder(BorderFactory.createTitledBorder("SALDO DINHEIRO"));
    }

    private void confFrame() {
        frame.setLayout(new GridBagLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
    }

    private void addPanel() {
        GridBagConstraints gbc = new GridBagConstraints();
        
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.ipady = 150;
        gbc.anchor = GridBagConstraints.PAGE_START;
        gbc.weighty = 0.5;
        gbc.ipadx = 150;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 0, 0, 0);
        pMenuLateral.add(logo, gbc);
        
        // botão entrada
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.weighty = 0.0;
        gbc.gridy = 1;
        gbc.ipady = 10;
        gbc.ipadx = 80;
        pMenuLateral.add(bEntradas, gbc);
        
        // botão saida]
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.weighty = 1.0;
        gbc.ipady = 10;
        gbc.ipadx = 80;
        pMenuLateral.add(bSaidas, gbc);
    }

    private void addFrame() {
        GridBagConstraints gbc = new GridBagConstraints();
        // Menu lateral
        gbc.fill = GridBagConstraints.VERTICAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.ipadx = 100;
        gbc.weighty = 0.5;
        gbc.gridheight = 3;
        gbc.insets = new Insets(30, 0, 0, 0);
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