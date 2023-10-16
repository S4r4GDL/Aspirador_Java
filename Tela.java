import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Tela extends JFrame {
    private static final int COLUNAS = 5;


    private static final int LINHAS = 4;
    JPanel espacoPanel, controlePanel, bannerAsp;

    ImageIcon sujeiraIcon = new ImageIcon("sujeira.png");
    ImageIcon chaoLimpoIcon = new ImageIcon("chaoLimpo.png");
    Icon controleIcon;
    JLabel[][] ambiente;

    public Tela() throws IOException {
        setTitle("Aspirador");
        setLayout(new BorderLayout());
        espacoPanel = new JPanel(new GridLayout(LINHAS, LINHAS));
        criarEspaco();
        criarControle();
        montaFrame("West", espacoPanel, "Center", controlePanel, "North", banner());
        mostraTela();
    }

    public Component banner(){

        bannerAsp = new JPanel();
        bannerAsp.setLayout(new BorderLayout());
        return bannerAsp.add("North", new JLabel(new ImageIcon("bannerAsp.png")));

    }
    private void criarControle() {
        controlePanel = new JPanel(new BorderLayout());
        JLabel label;
        label = new JLabel(controleIcon = new ImageIcon("controles1.png"));
        controlePanel.add(label);

    }
    public void mudarControle(int controle){
        JLabel label;
        controleIcon = new ImageIcon ( "controles" + controle + ".png");
        label = new JLabel(controleIcon);
        controlePanel.removeAll();
        controlePanel.add(label);
        controlePanel.setBackground(Color.WHITE);
    }

    public void criarEspaco() {
        ambiente = new JLabel[LINHAS][COLUNAS];
        for (int i = 0; i < LINHAS; i++) {
            for (int j = 0; j < COLUNAS; j++) {
                ambiente[i][j] = new JLabel(chaoLimpoIcon);
                ambiente[i][j].setPreferredSize(new Dimension(100, 120));
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

    public void montaFrame(String local1, JPanel panel1, String local2, JPanel panel2, String local3, Component panel3) {
        getContentPane().add(local1, panel1);
        getContentPane().add(local2, panel2);
        getContentPane().add(local3, panel3);
    }

    public void mostraTela() {
        setSize(800, 530);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
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
