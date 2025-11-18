public class Platino extends RangoCliente{

    public Platino(String nombreRango, int puntosMinimos, int puntosMaximos) {
        super(nombreRango, puntosMinimos, puntosMaximos);

    }
    @Override
    public double descuentoTransferencias() { return 0.20; }

    @Override
    public int bonusPuntos(int p) { return (int)(p * 1.10); }

    @Override
    public boolean retirosGratis() { return true; }
}
