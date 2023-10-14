import javax.swing.*;
import java.util.Objects;
import java.util.Random;

public class Aspirador {
    static Aspirador aspirador;
    ImageIcon aspiradorIcon = new ImageIcon("aspiradorSul.png");
    public static Aspirador getAspirador() {
        if(aspirador == null)
            aspirador = new Aspirador();
        return aspirador;
    }

    public Aspirador(){
    }
    public void mover(){

    }
    public ImageIcon girar(){
        Random aleatorio = new Random();
        int direcao = aleatorio.nextInt(1,5);
        switch (direcao){
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
    public Boolean sensorSujeira(JLabel local, ImageIcon sujeira){
        return local.getIcon().equals(sujeira);
    }
    public ImageIcon getAspiradorIcon()
    {
        return aspiradorIcon;
    }
    public Boolean sensorParede(int x, int y, JLabel[][] espaco){
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
        int acao;
        int sujeiras = mapear(linhas, colunas, tela.getAmbiente(), sujo);
        int i =0, j = 0;
        tela.colocar(0, 0, aspiradorIcon);
        while(sujeiras>0) {
            acao = sortearAcao();
            if(acao == 0)

               if(!sensorParede(i, j, tela.getAmbiente()))
               {

                   if (sensorSujeira(tela.ambiente[i][j], sujo)) {

                       tela.colocar(i, j, limpo);


                       sujeiras--;
                   }
                   tela.colocar(i, j++, aspiradorIcon);

               }
           else {
               aspiradorIcon = girar();

           }
        }
    }

    private int sortearAcao() {
        Random aleatorio = new Random();
        return aleatorio.nextInt(2);
    }

    private int mapear(int x, int y , JLabel[][] ambiente, ImageIcon sujo) {
        int sujeiras = 0;
        JLabel local;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                local = ambiente[i][j];
                if(sensorSujeira(local, sujo))
                    sujeiras++;
            }
        }
        return sujeiras;
    }
}
