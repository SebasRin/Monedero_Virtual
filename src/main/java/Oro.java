public class Oro extends RangoCliente{

    public Oro(String nombreRango, int puntosMinimos, int puntosMaximos) {
        super(nombreRango, puntosMinimos, puntosMaximos);

    }

    @Override
    public double descuentoTransferencias() { return 0.10; }

    @Override
    public int bonusPuntos(int p) { return (int)(p * 1.05); }

    @Override
    public boolean retirosGratis() { return true; }
}
