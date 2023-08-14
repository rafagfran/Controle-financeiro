package interfaces;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PanelTabela extends JPanel {

    private JTable tabela1;
    private DefaultTableModel modelo;

    public PanelTabela() {
        setLayout(new BorderLayout());

        // Criar o modelo da tabela com 3 colunas: data, origem e tipo
        modelo = new DefaultTableModel();
        modelo.addColumn("Data");
        modelo.addColumn("Origem");
        modelo.addColumn("Tipo");

        tabela1 = new JTable(modelo);
        JScrollPane scrollPane = new JScrollPane(tabela1);

        add(scrollPane, BorderLayout.CENTER);
    }

    public void adicionarLinha(Date data, String origem, String tipo) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String dataFormatada = dateFormat.format(data);
        modelo.addRow(new Object[]{dataFormatada, origem, tipo});
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Exemplo de Tabela Simulada");
            PanelTabela panel = new PanelTabela();

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(panel);
            frame.setSize(500, 300);
            frame.setVisible(true);

            // Exemplo de adição de linhas à tabela
            panel.adicionarLinha(new Date(), "Origem 1", "Tipo A");
            panel.adicionarLinha(new Date(), "Origem 2", "Tipo B");
            panel.adicionarLinha(new Date(), "Origem 3", "Tipo C");
        });
    }
}
//Neste exemplo, a classe PanelTabela estende JPanel e contém uma tabela criada usando o JTable da biblioteca Swing. A função adicionarLinha permite adicionar linhas à tabela com dados de data, origem e tipo. A função main cria uma janela Swing que exibe o painel de tabela e adiciona algumas linhas de exemplo.

//Lembre-se de que este é apenas um exemplo básico e que você pode personalizar a aparência e o comportamento da tabela conforme necessário. Certifique-se de ter a biblioteca Swing configurada corretamente em seu ambiente de desenvolvimento para executar o código.





