import javax.swing.*;
import java.util.Objects;
import java.util.Random;

public class Aspirador {
    static Aspirador aspirador;
    ImageIcon aspiradorIcon = new ImageIcon("aspirador.png");
    public static Aspirador getAspirador() {
        if(aspirador == null)
            aspirador = new Aspirador();
        return aspirador;
    }

    public Aspirador(){
    }
    public void mover(){

    }
    public void girar(){

    }
    public Boolean sensorSujeira(String[][]espaco){
        return true;
    }
    public Boolean sensorSujeira(){
        return true;
    }
    public ImageIcon getIC()
    {
        return aspiradorIcon;
    }
}
