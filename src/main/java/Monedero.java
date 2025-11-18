import java.util.ArrayList;
import java.util.List;

public class Monedero {
    private String idMonedero;
    private String nombreMonedero;
    private double saldo;
    private List<Transaccion> historial;
    private Cliente cliente;

    public Monedero(String idMonedero, String nombreMonedero, double saldo, Cliente cliente) {
        this.idMonedero = idMonedero;
        this.nombreMonedero = nombreMonedero;
        this.saldo = saldo;
        this.historial = new ArrayList<>();
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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

    public void agregarTransaccion(Transaccion t) {

        if (t == null) return;

        historial.add(t);
    }


    public void depositar(double monto) {

        if (monto <= 0) {
            System.out.println("Monto inválido.");
            return;
        }

        saldo += monto;
    }


    public boolean retirar(double monto) {

        if (monto <= 0){
            return false;
        }

        if (monto > saldo) {
            System.out.println("Saldo insuficiente.");
            return false;
        }

        saldo -= monto;
        return true;
    }
}
