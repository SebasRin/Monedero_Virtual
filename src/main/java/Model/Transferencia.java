package Model;

import java.util.Date;

public class Transferencia extends Transaccion {

    public Transferencia(double monto, Monedero destino, Monedero origen) {
        super(monto);
        this.destino = destino;
        this.origen = origen;
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
