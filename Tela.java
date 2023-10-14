import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Tela extends JFrame {
    private static final int COLUNAS = 4;


    private static final int LINHAS = 5;
    JPanel espacoPanel;

    ImageIcon sujeiraIcon = new ImageIcon("sujeira.png");
    ImageIcon chaoLimpoIcon = new ImageIcon("chaoLimpo.png");

    JLabel[][] ambiente;

    public Tela() throws IOException {
        setLayout(new BorderLayout());
        espacoPanel = new JPanel(new GridLayout(LINHAS, LINHAS));
        criarEspaco();
        montaFrame("West", espacoPanel);

        mostraTela();
    }

    public void criarEspaco() {
        ambiente = new JLabel[LINHAS][COLUNAS];
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                ambiente[i][j] = new JLabel(chaoLimpoIcon);
                ambiente[i][j].setPreferredSize(new Dimension(80, 80));
                ambiente[i][j].setHorizontalAlignment(JLabel.CENTER);
                ambiente[i][j].setVerticalAlignment(JLabel.CENTER);
                ambiente[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                espacoPanel.add(ambiente[i][j]);
            }
        }
    }

    public void colocar(int x, int y, ImageIcon imagem) {
        ambiente[x][y].removeAll();
        ambiente[x][y].setIcon(imagem);
    }

    public JPanel getEspacoPanel() {
        return espacoPanel;
    }

    public ImageIcon getChaoLimpoIcon() {
        return chaoLimpoIcon;
    }

    public JLabel[][] getAmbiente() {
        return ambiente;
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

    public int getLinhas(){
        return LINHAS;
    }
    public int getColunas(){
        return COLUNAS;
    }
    public int getLimiteDeIndex() {
        if(LINHAS > COLUNAS)
            return LINHAS;
        return COLUNAS;
    }
}
