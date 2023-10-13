import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class Tela extends JFrame {
    private static final int COLUNAS = 4;
    private static final int LINHAS = 5;
    JPanel espacoPanel;

    ImageIcon sujeiraIcon = new ImageIcon("sujeira.png");
    ImageIcon chaoLimpoIcon = new ImageIcon("chaoLimpo.png");

    JLabel[][] ambienteLabels;

    public Tela() throws IOException {
        setLayout(new BorderLayout());
        espacoPanel = new JPanel(new GridLayout(LINHAS, LINHAS));
        criarEspaco();
        montaFrame("West", espacoPanel);

        mostraTela();
    }

    public void criarEspaco() {
        ambienteLabels = new JLabel[LINHAS][LINHAS];
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < LINHAS; j++) {
                ambienteLabels[i][j] = new JLabel(chaoLimpoIcon);
                ambienteLabels[i][j].setPreferredSize(new Dimension(80, 80));
                ambienteLabels[i][j].setHorizontalAlignment(JLabel.CENTER);
                ambienteLabels[i][j].setVerticalAlignment(JLabel.CENTER);
                ambienteLabels[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                espacoPanel.add(ambienteLabels[i][j]);
            }
        }
    }

    public void colocar(int x, int y, ImageIcon imagem) {
        ambienteLabels[x][y].setIcon(imagem);
    }

    public void montaFrame(String local, JPanel panel) {
        getContentPane().add(local, panel);
    }

    public void mostraTela() {
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public ImageIcon getSujeiraIcon() {
        return sujeiraIcon;
    }

    public int getLimiteDeIndex() {
        if(LINHAS > COLUNAS)
            return LINHAS;
        return COLUNAS;
    }
}
