import java.util.Date;

public class Retiro extends Transaccion{
    public Retiro(String idTransaccion, Date fecha, double monto, String tipo, Monedero origen, Monedero destino, Cliente clienteInvolucrado) {
        super(idTransaccion, fecha, monto, tipo, origen, destino, clienteInvolucrado);
    }
    @Override
    public void ejecutar() {

    }
}
