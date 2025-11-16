public class Plata extends RangoCliente{

    public Plata(String nombreRango, int puntosMinimos, int puntosMaximos) {
        super(nombreRango, puntosMinimos, puntosMaximos);
        this.nombreRango = "Plata";
        this.puntosMinimos = 501;
        this.puntosMaximos = 1000;
    }
}
