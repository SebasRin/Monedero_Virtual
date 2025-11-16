import java.util.Date;

public class TransaccionProgramada {
    private String idProgramada;
    private Date fechaEjecucion;
    private double monto;
    private String tipoTransaccion;
    private Monedero origen;
    private Monedero destino;
    private boolean recurrente;
    private int cadaCuantosDias;
    private boolean activa;

    public TransaccionProgramada(String idProgramada, Date fechaEjecucion, double monto, String tipoTransaccion, Monedero origen, Monedero destino, boolean recurrente, int cadaCuantosDias, boolean activa) {
        this.idProgramada = idProgramada;
        this.fechaEjecucion = fechaEjecucion;
        this.monto = monto;
        this.tipoTransaccion = tipoTransaccion;
        this.origen = origen;
        this.destino = destino;
        this.recurrente = recurrente;
        this.cadaCuantosDias = cadaCuantosDias;
        this.activa = activa;
    }

    public String getIdProgramada() {
        return idProgramada;
    }

    public void setIdProgramada(String idProgramada) {
        this.idProgramada = idProgramada;
    }

    public Date getFechaEjecucion() {
        return fechaEjecucion;
    }

    public void setFechaEjecucion(Date fechaEjecucion) {
        this.fechaEjecucion = fechaEjecucion;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTipoTransaccion() {
        return tipoTransaccion;
    }

    public void setTipoTransaccion(String tipoTransaccion) {
        this.tipoTransaccion = tipoTransaccion;
    }

    public Monedero getOrigen() {
        return origen;
    }

    public void setOrigen(Monedero origen) {
        this.origen = origen;
    }

    public Monedero getDestino() {
        return destino;
    }

    public void setDestino(Monedero destino) {
        this.destino = destino;
    }

    public boolean isRecurrente() {
        return recurrente;
    }

    public void setRecurrente(boolean recurrente) {
        this.recurrente = recurrente;
    }

    public int getCadaCuantosDias() {
        return cadaCuantosDias;
    }

    public void setCadaCuantosDias(int cadaCuantosDias) {
        this.cadaCuantosDias = cadaCuantosDias;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }
}
