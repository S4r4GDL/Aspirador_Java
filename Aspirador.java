import javax.swing.*;
import java.util.Random;

public class Aspirador {
    private static Aspirador aspirador;
    private ImageIcon aspiradorIcon = new ImageIcon("aspiradorSul.png");

    private Aspirador() {
    }

    public static Aspirador getAspirador() {
        if (aspirador == null)
            aspirador = new Aspirador();
        return aspirador;
    }

    public void mover(int x, int y, ImageIcon novo,  JLabel[][] ambiente) {
        ambiente[x][y].setIcon(novo);
    }

    public ImageIcon girar() {
        Random aleatorio = new Random();
        int direcao = aleatorio.nextInt(1, 5);
        switch (direcao) {
            case 1:
                return new ImageIcon("aspiradorNorte.png");
            case 2:
                return new ImageIcon("aspiradorOeste.png");
            case 3:
                return new ImageIcon("aspiradorLeste.png");
            default:
                return new ImageIcon("aspiradorSul.png");
        }
    }

    public Boolean sensorSujeira(JLabel local, ImageIcon sujeira) {
        return local.getIcon().equals(sujeira);
    }

    public ImageIcon getAspiradorIcon() {
        return aspiradorIcon;
    }

    public Boolean sensorParede(int x, int y, JLabel[][] espaco) {
        return !espaco[x][y].isValid();
    }

    public void ligar(Tela tela) {
        ImageIcon limpo = tela.getChaoLimpoIcon();
        ImageIcon sujo = tela.getSujeiraIcon();
        int linhas = tela.getLinhas();
        int colunas = tela.getColunas();
        limpar(tela, linhas, colunas, limpo, sujo);
    }

    private void limpar(Tela tela, int linhas, int colunas, ImageIcon limpo, ImageIcon sujo) {
        JLabel[][] ambiente = tela.getAmbiente();
        int sujeiras = mapear(linhas, colunas, ambiente, sujo);
        int i = 0, j = 0;
        tela.colocar(0, 0, aspiradorIcon);
        while (sujeiras > 0) {
            int movimentar = 0;
            while(movimentar==0)
            {
                if (sensorSujeira(ambiente[i][j], sujo) || sensorSujeira(ambiente[i][j], aspiradorIcon)) {
                    tela.colocar(i, j, limpo);
                    sujeiras--;
                }

                aspiradorIcon = girar();
                if(!sensorParede(i, j+1, ambiente)){
                    j++;
                    movimentar++;
                }
                else if(!sensorParede(i+1, j, ambiente)){
                    i++;
                    movimentar++;

                } else if (!sensorParede(i+1, 0, ambiente)) {
                    j=0;
                    i++;
                    movimentar++;
                }
                else if (!sensorParede(0, j+1, ambiente)) {
                    i=0;
                    j++;
                    movimentar++;
                }
                else{
                    aspiradorIcon = girar();
                }
                if(movimentar > 0){
                    mover(i, j, aspiradorIcon, ambiente);
                }




            }
        }
    }

    private int sortearAcao() {
        Random aleatorio = new Random();
        return aleatorio.nextInt(2);
    }

    private int mapear(int x, int y, JLabel[][] ambiente, ImageIcon sujo) {
        int sujeiras = 0;
        JLabel local;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                local = ambiente[i][j];
                if (sensorSujeira(local, sujo))
                    sujeiras++;
            }
        }
        return sujeiras;
    }
}
