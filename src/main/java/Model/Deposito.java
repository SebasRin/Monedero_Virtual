package Model;

import java.util.Date;

public class Deposito extends Transaccion{
    public Deposito(String idTransaccion, Date fecha, double monto, String tipo, Monedero origen, Monedero destino, Cliente clienteInvolucrado) {
        super(idTransaccion, fecha, monto, tipo, origen, destino, clienteInvolucrado);
    }

    @Override
    public void ejecutar() {
        if (destino == null) {
            System.out.println("Error: depósito sin monedero destino.");
            return;
        }

        destino.depositar(monto);

    }
}
