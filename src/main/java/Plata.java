public class Plata extends RangoCliente{

    public Plata(String nombreRango, int puntosMinimos, int puntosMaximos) {
        super(nombreRango, puntosMinimos, puntosMaximos);
        this.nombreRango = "Plata";
        this.puntosMinimos = 501;
        this.puntosMaximos = 1000;
    }
    @Override
    public double descuentoTransferencias() { return 0.05; }

    @Override
    public int bonusPuntos(int p) { return (int)(p * 1.02); }

    @Override
    public boolean retirosGratis() { return false; }
}
