package Model;

public class Plata extends RangoCliente{

    public Plata() {
        super("Plata", 501, 1000);

    }
    @Override
    public double descuentoTransferencias() { return 0.05; }

    @Override
    public int bonusPuntos(int p) { return (int)(p * 1.02); }

    @Override
    public boolean retirosGratis() { return false; }
}
