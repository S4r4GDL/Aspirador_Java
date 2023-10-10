import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class Tela extends JFrame {
    JPanel espacoPanel;
    final int LINHAS = 5;
    ImageIcon sujeiraIcon = new ImageIcon("sujeira.png");
    ImageIcon chaoLimpoIcon = new ImageIcon("chaoLimpo.png");

    JLabel[][] ambienteLabels;

    public Tela() throws IOException {
        setLayout(new BorderLayout());
        espacoPanel = new JPanel(new GridLayout(LINHAS, LINHAS));
        criarEspaco();
        colocaAspirador(0,0, );
        sujar(5);
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

    public void colocaAspirador(int x, int y) {
        ambienteLabels[x][y].setIcon(aspiradorIcon);
    }

    public void montaFrame(String local, JPanel panel) {
        getContentPane().add(local, panel);
    }

    public void sujar(int qt) {
        Random aleatorio = new Random();
        int x, y;
        for (int i = 0; i <= qt; i++) {
            x = aleatorio.nextInt(qt);
            y = aleatorio.nextInt(qt);
            ambienteLabels[x][y].setIcon(aspirador.getIc());
        }

    }

    public void mostraTela() {
        setSize(800, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }


}
