import java.util.Objects;
import java.util.Random;

public class Espaco {
    public Espaco()
    {

    }

    public void preencher(){

    }
    public String limpar(String espaco){

        if(Objects.equals(espaco, "x"))
            espaco = "O";

        return espaco;
    }
    public void sujar(int qt, String[][] espacos){
        Random aleatorio = new Random();
        int x, y;
        for (int i = 0; i <= qt; i++) {
            x = aleatorio.nextInt(qt);
            y = aleatorio.nextInt(qt);
            espacos[x][y] = "X";
        }
    }
}
