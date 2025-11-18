package Model;

public abstract class RangoCliente {
    protected String nombreRango;
    protected int puntosMinimos;
    protected int puntosMaximos;

    public RangoCliente(String nombreRango, int puntosMinimos, int puntosMaximos) {
        this.nombreRango = nombreRango;
        this.puntosMinimos = puntosMinimos;
        this.puntosMaximos = puntosMaximos;
    }

    public String getNombreRango() {
        return nombreRango;
    }

    public void setNombreRango(String nombreRango) {
        this.nombreRango = nombreRango;
    }

    public int getPuntosMinimos() {
        return puntosMinimos;
    }

    public void setPuntosMinimos(int puntosMinimos) {
        this.puntosMinimos = puntosMinimos;
    }

    public int getPuntosMaximos() {
        return puntosMaximos;
    }

    public void setPuntosMaximos(int puntosMaximos) {
        this.puntosMaximos = puntosMaximos;
    }
    public abstract double descuentoTransferencias();

    public abstract int bonusPuntos(int puntosOriginales);

    public abstract boolean retirosGratis();
}
