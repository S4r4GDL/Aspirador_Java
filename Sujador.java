import java.util.Random;

public class Sujador {

    public Sujador() {
    }

    public void sujar(Tela tela){

        Random aleatorio = new Random();

        int x, y,
                limite = tela.getLimiteDeIndex(),
                linhas = tela.getLinhas(),
                colunas = tela.getColunas();
        for (int i = 0; i <= limite ; i++) {
            x = aleatorio.nextInt( linhas);
            y = aleatorio.nextInt(colunas);
            tela.colocar(x, y, tela.getSujeiraIcon());
        }
    }
}
