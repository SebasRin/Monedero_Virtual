package Model;

public class Platino extends RangoCliente{

    public Platino() {
        super("Platino", 5001, 999999);

    }
    @Override
    public double descuentoTransferencias() { return 0.20; }

    @Override
    public int bonusPuntos(int p) { return (int)(p * 1.10); }

    @Override
    public boolean retirosGratis() { return true; }

    @Override
    public String beneficio() {
        return "Transferencias con descuento del " + (descuentoTransferencias()*100) + "%";
    }

}
