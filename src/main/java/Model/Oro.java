package Model;

public class Oro extends RangoCliente{

    public Oro() {
        super("Oro", 1001, 5000);

    }

    @Override
    public double descuentoTransferencias() { return 0.10; }

    @Override
    public int bonusPuntos(int p) { return (int)(p * 1.05); }

    @Override
    public boolean retirosGratis() { return true; }
}
