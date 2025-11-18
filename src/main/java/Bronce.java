public class Bronce extends RangoCliente{

    public Bronce(String nombreRango, int puntosMinimos, int puntosMaximos) {
        super(nombreRango, puntosMinimos, puntosMaximos);

    }

    @Override
    public double descuentoTransferencias() { return 0.0; }

    @Override
    public int bonusPuntos(int p) { return p; }

    @Override
    public boolean retirosGratis() { return false; }
}
