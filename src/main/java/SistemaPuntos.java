import java.util.ArrayList;
import java.util.List;

public class SistemaPuntos {
    private int puntosPorDeposito;
    private int puntosPorRetiro;
    private int puntosPorTransferencia;
    private List<String> historialPuntos;

    public SistemaPuntos(int puntosPorDeposito, int puntosPorRetiro, int puntosPorTransferencia) {
        this.puntosPorDeposito = puntosPorDeposito;
        this.puntosPorRetiro = puntosPorRetiro;
        this.puntosPorTransferencia = puntosPorTransferencia;
        this.historialPuntos = new ArrayList<>();
    }

    public int getPuntosPorDeposito() {
        return puntosPorDeposito;
    }

    public void setPuntosPorDeposito(int puntosPorDeposito) {
        this.puntosPorDeposito = puntosPorDeposito;
    }

    public int getPuntosPorRetiro() {
        return puntosPorRetiro;
    }

    public void setPuntosPorRetiro(int puntosPorRetiro) {
        this.puntosPorRetiro = puntosPorRetiro;
    }

    public int getPuntosPorTransferencia() {
        return puntosPorTransferencia;
    }

    public void setPuntosPorTransferencia(int puntosPorTransferencia) {
        this.puntosPorTransferencia = puntosPorTransferencia;
    }

    public List<String> getHistorialPuntos() {
        return historialPuntos;
    }

    public void setHistorialPuntos(List<String> historialPuntos) {
        this.historialPuntos = historialPuntos;
    }

    public void registrarPuntos(String descripcion) {
        historialPuntos.add(descripcion);
    }

    public int calcularPuntos(Transaccion t) {
        if (t instanceof Deposito)
            return (int)(t.getMonto() / 100) * puntosPorDeposito;

        if (t instanceof Retiro)
            return (int)(t.getMonto() / 100) * puntosPorRetiro;

        if (t instanceof Transferencia)
            return (int)(t.getMonto() / 100) * puntosPorTransferencia;

        return 0;
    }

    public void asignarPuntos(Transaccion t) {
        int puntos = calcularPuntos(t);
        Cliente c = t.getClienteInvolucrado();

        puntos = c.getRangoActual().bonusPuntos(puntos);

        c.actualizarPuntos(puntos);

        registrarPuntos("Cliente " + c.getNombre() + " ganó " + puntos);
    }
}
