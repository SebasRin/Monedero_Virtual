public class Bronce extends RangoCliente{

    public Bronce(String nombreRango, int puntosMinimos, int puntosMaximos) {
        super(nombreRango, puntosMinimos, puntosMaximos);
        this.nombreRango = "Bronce";
        this.puntosMinimos = 0;
        this.puntosMaximos = 500;
    }
}
