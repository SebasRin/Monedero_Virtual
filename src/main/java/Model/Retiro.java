package Model;

import java.util.Date;

public class Retiro extends Transaccion{


    public Retiro(double monto, Monedero origen) {
        super(monto);
        this.origen = origen;
    }

    @Override
    public void ejecutar() {
        if (origen == null) {
            System.out.println("Error: retiro sin monedero origen.");
            return;
        }

        boolean ok = origen.retirar(monto);

        if (!ok) {
            System.out.println("Retiro rechazado.");
        }

    }
}
