import java.util.ArrayList;
import java.util.List;

public class BancoVirtual {
    private List<Cliente> clientesRegistrados;
    private SistemaPuntos sistemaPuntos;
    private AnalisisPatrones analizador;
    private VerificacionDeTransacciones verificador;
    private Notificacion notificador;

    public BancoVirtual(SistemaPuntos sistemaPuntos, AnalisisPatrones analizador, VerificacionDeTransacciones verificador, Notificacion notificador) {
        this.clientesRegistrados = new ArrayList<>();
        this.sistemaPuntos = sistemaPuntos;
        this.analizador = analizador;
        this.verificador = verificador;
        this.notificador = notificador;
    }

    public List<Cliente> getClientesRegistrados() {
        return clientesRegistrados;
    }

    public void setClientesRegistrados(List<Cliente> clientesRegistrados) {
        this.clientesRegistrados = clientesRegistrados;
    }

    public SistemaPuntos getSistemaPuntos() {
        return sistemaPuntos;
    }

    public void setSistemaPuntos(SistemaPuntos sistemaPuntos) {
        this.sistemaPuntos = sistemaPuntos;
    }

    public AnalisisPatrones getAnalizador() {
        return analizador;
    }

    public void setAnalizador(AnalisisPatrones analizador) {
        this.analizador = analizador;
    }

    public VerificacionDeTransacciones getVerificador() {
        return verificador;
    }

    public void setVerificador(VerificacionDeTransacciones verificador) {
        this.verificador = verificador;
    }

    public Notificacion getNotificador() {
        return notificador;
    }

    public void setNotificador(Notificacion notificador) {
        this.notificador = notificador;
    }
}
