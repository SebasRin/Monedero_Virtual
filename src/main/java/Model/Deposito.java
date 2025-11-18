package Model;

import java.util.Date;

public class Deposito extends Transaccion{



    public Deposito(double monto, Monedero destino) {
        super(monto);
        this.destino = destino;
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
