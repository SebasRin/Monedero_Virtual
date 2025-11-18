package Model;

public class Bronce extends RangoCliente{

    public Bronce() {
        super("Bronce", 0, 500);
    }

    @Override
    public double descuentoTransferencias() { return 0.0; }

    @Override
    public int bonusPuntos(int p) { return p; }

    @Override
    public boolean retirosGratis() { return false; }
}
