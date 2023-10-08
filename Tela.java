import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Tela extends JFrame {
    JPanel espacoPanel;
    final int LINHAS = 5;
    ImageIcon sujeiraIcon = new ImageIcon("sujeira.png");
    ImageIcon chaoLimpoIcon = new ImageIcon("chaoLimpo.png");
    ImageIcon aspiradorIcon = new ImageIcon("aspirador.png");
    JLabel[][] ambienteLabels;

    public Tela() throws IOException {
        setLayout(new BorderLayout());
        espacoPanel = new JPanel(new GridLayout(LINHAS, LINHAS));
        criarEspaco();
        criarAspirador(0,0);
        sujar(1, 3);
        sujar(4, 2);
        sujar(0, 1);
        sujar(2, 0);
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

    public void criarAspirador(int x, int y) {
        JLabel aspiradorLabel = new JLabel(aspiradorIcon);
        ambienteLabels[x][y].add(aspiradorLabel);
    }

    public void montaFrame(String local, JPanel panel) {
        getContentPane().add(local, panel);
    }

    public void sujar(int x, int y) {
        ambienteLabels[x][y].setIcon(sujeiraIcon);
    }

    public void mostraTela() {
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }


}
