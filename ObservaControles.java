public class ObservaControles {
    private final Aspirador aspirador;

    public ObservaControles(Aspirador aspirador) {
        this.aspirador = aspirador;

    }

    protected void atualizarAcao(int controle){
        aspirador.getTela().mudarControle(controle);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
