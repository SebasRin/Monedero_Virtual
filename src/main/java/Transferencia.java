import java.util.Date;

public class Transferencia extends Transaccion {
    public Transferencia(String idTransaccion, Date fecha, double monto, String tipo, Monedero origen, Monedero destino, Cliente clienteInvolucrado) {
        super(idTransaccion, fecha, monto, tipo, origen, destino, clienteInvolucrado);
    }
}
