import java.util.Random;

public class Sujador {

    public Sujador() {
    }

    public void sujar(Tela tela){

        Random aleatorio = new Random();

        int x, y, limite = tela.getLimiteDeIndex();
        for (int i = 0; i <= limite ; i++) {
            x = aleatorio.nextInt(limite);
            y = aleatorio.nextInt(limite);
            tela.colocar(x, y, tela.getSujeiraIcon());
        }
    }
}
