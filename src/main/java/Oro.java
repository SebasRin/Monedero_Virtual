public class Oro extends RangoCliente{

    public Oro(String nombreRango, int puntosMinimos, int puntosMaximos) {
        super(nombreRango, puntosMinimos, puntosMaximos);
        this.nombreRango = "Oro";
        this.puntosMinimos = 1001;
        this.puntosMaximos = 5000;
    }
}
