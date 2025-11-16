import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String idCliente;
    private String nombre;
    private String correo;
    private String telefono;
    private RangoCliente rangoActual;
    private int puntosAcumulados;
    private List<Monedero> monederos;
    private List<Transaccion> historialGeneral;
    private List<TransaccionProgramada> transaccionesProgramadas;

    public Cliente(String idCliente, String nombre, String correo, String telefono, RangoCliente rangoActual, int puntosAcumulados) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
        this.rangoActual = rangoActual;
        this.puntosAcumulados = puntosAcumulados;
        this.monederos = new ArrayList<>();
        this.historialGeneral = new ArrayList<>();
        this.transaccionesProgramadas = new ArrayList<>();
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public RangoCliente getRangoActual() {
        return rangoActual;
    }

    public void setRangoActual(RangoCliente rangoActual) {
        this.rangoActual = rangoActual;
    }

    public int getPuntosAcumulados() {
        return puntosAcumulados;
    }

    public void setPuntosAcumulados(int puntosAcumulados) {
        this.puntosAcumulados = puntosAcumulados;
    }

    public List<Monedero> getMonederos() {
        return monederos;
    }

    public void setMonederos(List<Monedero> monederos) {
        this.monederos = monederos;
    }

    public List<Transaccion> getHistorialGeneral() {
        return historialGeneral;
    }

    public void setHistorialGeneral(List<Transaccion> historialGeneral) {
        this.historialGeneral = historialGeneral;
    }

    public List<TransaccionProgramada> getTransaccionesProgramadas() {
        return transaccionesProgramadas;
    }

    public void setTransaccionesProgramadas(List<TransaccionProgramada> transaccionesProgramadas) {
        this.transaccionesProgramadas = transaccionesProgramadas;
    }
}
