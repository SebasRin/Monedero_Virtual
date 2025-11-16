public class Platino extends RangoCliente{

    public Platino(String nombreRango, int puntosMinimos, int puntosMaximos) {
        super(nombreRango, puntosMinimos, puntosMaximos);
        this.nombreRango = "Platino";
        this.puntosMinimos = 5001;
        this.puntosMaximos = 999999;
    }
}
