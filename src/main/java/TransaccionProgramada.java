import java.util.Calendar;
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

    public void activar() {
        activa = true;
    }

    public void desactivar() {
        activa = false;
    }

    public void reprogramar(Date nuevaFecha) {
        fechaEjecucion = nuevaFecha;
    }

    public void ejecutarProgramada() {

        if (!activa) {
            System.out.println("La transacción programada está desactivada.");
            return;
        }


        Date hoy = new Date();


        if (hoy.before(fechaEjecucion)) {
            System.out.println("Aún no es la fecha de ejecución de esta transacción.");
            return;
        }

        System.out.println("Ejecutando transacción programada...");


        Transaccion t = null;

        if (tipoTransaccion.equalsIgnoreCase("deposito")) {
            t = new Deposito(null, null, 0, null, null, null, null);
            t.setDestino(destino);
            t.setMonto(monto);
            t.setFecha(new Date());
            t.setClienteInvolucrado(destino.getCliente());
            t.setTipo("Deposito");
        }
        else if (tipoTransaccion.equalsIgnoreCase("retiro")) {
            t = new Retiro(null, null, 0, null, null, null, null);
            t.setOrigen(origen);
            t.setMonto(monto);
            t.setFecha(new Date());
            t.setClienteInvolucrado(origen.getCliente());
            t.setTipo("Retiro");
        }
        else if (tipoTransaccion.equalsIgnoreCase("transferencia")) {
            t = new Transferencia(null, null, 0, null, null, null, null);
            t.setOrigen(origen);
            t.setDestino(destino);
            t.setMonto(monto);
            t.setFecha(new Date());
            t.setClienteInvolucrado(origen.getCliente());
            t.setTipo("Transferencia");
        }
        else {
            System.out.println("Tipo de transacción programada inválido.");
            return;
        }


        t.ejecutar();


        Cliente c = t.getClienteInvolucrado();
        if (c != null) {
            c.agregarTransaccion(t);
        }


        if (recurrente) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(fechaEjecucion);
            cal.add(Calendar.DAY_OF_MONTH, cadaCuantosDias);

            fechaEjecucion = cal.getTime();

            System.out.println("Transacción recurrente. Próxima ejecución: " + fechaEjecucion);
        }
        else {
            activa = false;
            System.out.println("Transacción ejecutada y desactivada (no recurrente).");
        }
    }
}
