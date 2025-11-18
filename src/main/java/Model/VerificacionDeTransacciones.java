package Model;

import java.util.ArrayList;
import java.util.List;

public class VerificacionDeTransacciones {
    private List<String> erroresDetectados;
    private boolean ultimaVerificacionCorrecta;

    public VerificacionDeTransacciones(boolean ultimaVerificacionCorrecta) {
        this.ultimaVerificacionCorrecta = ultimaVerificacionCorrecta;
        this.erroresDetectados = new ArrayList<>();
    }

    public List<String> getErroresDetectados() {
        return erroresDetectados;
    }

    public void setErroresDetectados(List<String> erroresDetectados) {
        this.erroresDetectados = erroresDetectados;
    }

    public boolean isUltimaVerificacionCorrecta() {
        return ultimaVerificacionCorrecta;
    }

    public void setUltimaVerificacionCorrecta(boolean ultimaVerificacionCorrecta) {
        this.ultimaVerificacionCorrecta = ultimaVerificacionCorrecta;
    }

    public void verificar(Transaccion t) {

        erroresDetectados.clear();

        if (t.getMonto() <= 0)
            erroresDetectados.add("Monto inválido.");

        if (t.getFecha() == null)
            erroresDetectados.add("Fecha no asignada.");

        ultimaVerificacionCorrecta = erroresDetectados.isEmpty();
    }


    public boolean esCorrecta() {
        return ultimaVerificacionCorrecta;
    }

    public void registrarError(String err) {
        erroresDetectados.add(err);
    }
}
