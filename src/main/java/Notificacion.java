public class Notificacion {
    private String mensaje;
    private String correoDestino;
    private String numeroWhatsApp;
    private boolean notificacionEnviada;

    public Notificacion(String mensaje, String correoDestino, String numeroWhatsApp, boolean notificacionEnviada) {
        this.mensaje = mensaje;
        this.correoDestino = correoDestino;
        this.numeroWhatsApp = numeroWhatsApp;
        this.notificacionEnviada = notificacionEnviada;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCorreoDestino() {
        return correoDestino;
    }

    public void setCorreoDestino(String correoDestino) {
        this.correoDestino = correoDestino;
    }

    public String getNumeroWhatsApp() {
        return numeroWhatsApp;
    }

    public void setNumeroWhatsApp(String numeroWhatsApp) {
        this.numeroWhatsApp = numeroWhatsApp;
    }

    public boolean isNotificacionEnviada() {
        return notificacionEnviada;
    }

    public void setNotificacionEnviada(boolean notificacionEnviada) {
        this.notificacionEnviada = notificacionEnviada;
    }
}
