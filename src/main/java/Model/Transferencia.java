package Model;

import java.util.Date;

public class Transferencia extends Transaccion {
    public Transferencia(String idTransaccion, Date fecha, double monto, String tipo, Monedero origen, Monedero destino, Cliente clienteInvolucrado) {
        super(idTransaccion, fecha, monto, tipo, origen, destino, clienteInvolucrado);
    }
    @Override
    public void ejecutar() {
        if (origen == null || destino == null) {
            System.out.println("Error: transferencia incompleta.");
            return;
        }

        if (origen.retirar(monto)) {
            destino.depositar(monto);
        } else {
            System.out.println("No se pudo ejecutar la transferencia.");
        }

    }
}
