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

    @Override
    public String beneficio() {
        return "Transferencias con descuento del " + (descuentoTransferencias()*100) + "%";
    }

}
