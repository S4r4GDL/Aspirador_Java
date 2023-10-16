import javax.swing.*;
import java.util.Random;

public class Aspirador {
    private static Aspirador aspirador;
    static ImageIcon anterior;
    ObservaControles obsevador;
    private static Localizacao localizacao;
    private ImageIcon aspiradorIcon;
    private Tela tela;

    private Aspirador() {
        obsevador = new ObservaControles(this);
        localizacao = new Localizacao();
        aspiradorIcon = new ImageIcon("aspiradorSul.png");
    }

    public static Aspirador getAspirador() {
        if (aspirador == null)
            aspirador = new Aspirador();
        return aspirador;
    }

    public Tela getTela() {
        return tela;
    }

    public static class Localizacao{
        int x;
        int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }

    public void mover(int x, int y,JLabel[][] ambiente) throws InterruptedException {

        int direcao = randomizar(1,5);
        obsevador.atualizarAcao(5);
        ImageIcon novo = girar(direcao);
        ambiente[x][y].setIcon(novo);
        Thread.sleep(30);

        switch (direcao){
            case 1:
                x--;
            break;
            case 2:
                y++;
            break;
            case 3:
                y--;
                break;
            default:
                x++;
                break;
        }
        obsevador.atualizarAcao(1);
        if(sensorParede(x, y, ambiente))
        {
            obsevador.atualizarAcao(3);
            anterior = (ImageIcon) ambiente[x][y].getIcon();
            ambiente[x][y].setIcon(novo);
            localizacao.setX(x);
            localizacao.setY(y);

        }

}

    private static int randomizar(int origem, int limite) {
        Random aleatorio = new Random();
        int direcao = aleatorio.nextInt(origem, limite);
        return direcao;
    }

    public ImageIcon girar(int direcao){
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

    public Boolean sensorSujeira(ImageIcon local, ImageIcon sujeira) {

        return local.equals(sujeira);
    }

    public ImageIcon getAspiradorIcon() {
        return aspiradorIcon;
    }

    public Boolean sensorParede(int x, int y, JLabel[][] espaco) {

        try{
            JLabel teste = espaco[x][y];
            return true;
        }catch (ArrayIndexOutOfBoundsException e){
            return false;
        }

    }

    public void ligar(Tela tela) throws InterruptedException {
        ImageIcon limpo = tela.getChaoLimpoIcon();
        ImageIcon sujo = tela.getSujeiraIcon();
        int linhas = tela.getLinhas();
        int colunas = tela.getColunas();
        localizacao.setX(0);
        localizacao.setY(0);
        this.tela = tela;
        limpar(linhas, colunas, limpo, sujo);
    }

    private void limpar(int linhas, int colunas, ImageIcon limpo, ImageIcon sujo) throws InterruptedException {

        JLabel[][] ambiente = tela.getAmbiente();
        anterior = (ImageIcon) ambiente[0][0].getIcon();
        tela.colocar(0, 0, aspiradorIcon);
        while (mapear(linhas, colunas, ambiente, sujo) > 0) {

            int  i = localizacao.getX(), j= localizacao.getY();
            mover(i, j, ambiente);
            if(sensorSujeira(anterior, sujo))
            {
                obsevador.atualizarAcao(2);
                obsevador.atualizarAcao(4);
            }

            tela.colocar(i, j, limpo);
            Thread.sleep(450);
        }
    }


    private int mapear(int x, int y, JLabel[][] ambiente, ImageIcon sujo) {
        int sujeiras = 0;
        JLabel local;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                local = ambiente[i][j];
                if (sensorSujeira((ImageIcon) local.getIcon(), sujo))
                    sujeiras++;
            }
        }
        return sujeiras;
    }
}
