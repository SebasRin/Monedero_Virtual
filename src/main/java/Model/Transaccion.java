package Model;

import java.util.Date;

public abstract class Transaccion {
    protected String idTransaccion;
    protected Date fecha;
    protected double monto;
    protected String tipo;
    protected Monedero origen;
    protected Monedero destino;
    protected Cliente clienteInvolucrado;

    public Transaccion(String idTransaccion, Date fecha, double monto, String tipo, Monedero origen, Monedero destino, Cliente clienteInvolucrado) {
        this.idTransaccion = idTransaccion;
        this.fecha = fecha;
        this.monto = monto;
        this.tipo = tipo;
        this.origen = origen;
        this.destino = destino;
        this.clienteInvolucrado = clienteInvolucrado;
    }

    public String getIdTransaccion() {
        return idTransaccion;
    }

    public void setIdTransaccion(String idTransaccion) {
        this.idTransaccion = idTransaccion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Monedero getOrigen() {
        return origen;
    }

    public void setOrigen(Monedero origen) {
        this.origen = origen;
    }

    public Monedero getDestino() {
        return destino;
    }

    public void setDestino(Monedero destino) {
        this.destino = destino;
    }

    public Cliente getClienteInvolucrado() {
        return clienteInvolucrado;
    }

    public void setClienteInvolucrado(Cliente clienteInvolucrado) {
        this.clienteInvolucrado = clienteInvolucrado;
    }

    public abstract void ejecutar();
}
