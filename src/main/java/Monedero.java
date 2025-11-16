import java.util.ArrayList;
import java.util.List;

public class Monedero {
    private String idMonedero;
    private String nombreMonedero;
    private double saldo;
    private List<Transaccion> historial;

    public Monedero(String idMonedero, String nombreMonedero, double saldo) {
        this.idMonedero = idMonedero;
        this.nombreMonedero = nombreMonedero;
        this.saldo = saldo;
        this.historial = new ArrayList<>();
    }

    public String getIdMonedero() {
        return idMonedero;
    }

    public void setIdMonedero(String idMonedero) {
        this.idMonedero = idMonedero;
    }

    public String getNombreMonedero() {
        return nombreMonedero;
    }

    public void setNombreMonedero(String nombreMonedero) {
        this.nombreMonedero = nombreMonedero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public List<Transaccion> getHistorial() {
        return historial;
    }

    public void setHistorial(List<Transaccion> historial) {
        this.historial = historial;
    }
}
