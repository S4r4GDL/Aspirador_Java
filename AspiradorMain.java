import java.io.IOException;
import java.util.Random;

public class AspiradorMain {



        public static void main(String[] args) throws IOException, InterruptedException {
          Tela tela = new Tela();
          Sujador sujador = new Sujador();
          sujador.sujar(tela);
          Aspirador aspirador = Aspirador.getAspirador();
          aspirador.ligar(tela);
    }

}
