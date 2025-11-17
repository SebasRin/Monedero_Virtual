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

    public void registrarCliente(Cliente c) {


        for (Cliente existente : clientesRegistrados) {
            if (existente.getIdCliente().equals(c.getIdCliente())) {
                System.out.println("ERROR: El cliente ya está registrado.");
                return;
            }
        }

        clientesRegistrados.add(c);
        System.out.println("Cliente registrado correctamente.");
    }

    public Cliente buscarCliente(String id) {

        if (id == null || id.isEmpty()) return null;

        for (Cliente c : clientesRegistrados) {
            if (c.getIdCliente().equals(id)) {
                return c;
            }
        }

        return null;
    }

    public void ejecutarTransaccion(Transaccion t) {

        if (t == null) {
            System.out.println("Transacción inválida.");
            return;
        }

        // Verificar integridad
        verificador.verificar(t);

        if (!verificador.esCorrecta()) {
            System.out.println("Transacción rechazada por el verificador.");
            return;
        }

        // Ejecutar
        t.ejecutar();

        // Asignar puntos
        sistemaPuntos.asignarPuntos(t);

        // Registrar
        Cliente c = t.getClienteInvolucrado();
        c.agregarTransaccion(t);

        System.out.println("Transacción ejecutada y registrada.");
    }

    public void procesarTransaccionesProgramadas() {
        // luego
    }

    public void enviarNotificacion(String msg, Cliente c) {

        if (c == null || msg == null) return;

        notificador.setMensaje(msg);
        notificador.setCorreoDestino(c.getCorreo());

        notificador.enviarCorreo();
    }

}
